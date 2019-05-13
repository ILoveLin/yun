package com.company.yun.ui.fragment.financedata.presenter;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.Constants;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.financedata.FinanceDataBean;
import com.company.yun.utils.DataUtils;
import com.company.yun.utils.NumberUtils;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.yun.common.utils.SharePreferenceUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:
 */
public class FinanceDataPresenter implements OnChartValueSelectedListener {

    private FinanceDataView mView;
    private Context mContext;
    private final String device;
    private final String token;

    public FinanceDataPresenter(Context mContext, FinanceDataView mView) {
        this.mView = mView;
        this.mContext = mContext;
        device = (String) SharePreferenceUtil.get(mContext, Constants.Device, "");
        token = (String) SharePreferenceUtil.get(mContext, Constants.Token, "");

    }

    public void sendRequest() {
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.Data)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            FinanceDataBean bean = new FinanceDataBean();
                            bean.getAllData(response);
                            if ("".equals(bean.getStatus())) {
                                mView.showEmptyView();
                            } else {
                                mView.showContentView();
                                FinanceDataBean.DataBean mDataBean = bean.getData();
                                refreshSettingBarData(mDataBean);
                                mView.refreshUIData(mDataBean);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
    }


    //刷新	平台总充值---上个月总充值-----近七日总充值---数据
    private void refreshSettingBarData(FinanceDataBean.DataBean mDataBean) {
        mView.getSettingBar01().setRightText("平台总充值");
        mView.getSettingBar01().setLeftText(NumberUtils.amountConversion(Double.parseDouble(mDataBean.getTotal_money() + "")));
        mView.getSettingBar02().setRightText("上个月总充值");
        mView.getSettingBar02().setLeftText(NumberUtils.amountConversion(Double.parseDouble(mDataBean.getLast_month_money() + "")));
        mView.getSettingBar03().setRightText("近七日总充值");
        mView.getSettingBar03().setLeftText(NumberUtils.amountConversion(Double.parseDouble(mDataBean.getDays_money() + "")));
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
