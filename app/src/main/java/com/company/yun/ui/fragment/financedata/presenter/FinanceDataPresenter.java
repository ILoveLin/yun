package com.company.yun.ui.fragment.financedata.presenter;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.Constants;
import com.company.yun.base.HttpConstants;
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
        Log.e("Net", "data==token===");
        device = (String) SharePreferenceUtil.get(mContext, Constants.Device, "");
        token = (String) SharePreferenceUtil.get(mContext, Constants.Token, "");
        Log.e("Net", "data==token===" + token);

    }

    public void sendRequest() {
        mView.showLoadingView();
        Log.e("Net", "data==1==token===" + token);
        OkHttpUtils.post()
                .url(HttpConstants.Data)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                        Log.e("Net", "data==Exception===");

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            Log.e("Net", "data==response===" + response);
                            mView.showContentView();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
