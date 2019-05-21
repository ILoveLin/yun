package com.company.yun.ui.fragment.account.presenter;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.Constants;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.account.AccountBean;
import com.company.yun.utils.NumberUtils;
import com.yun.common.utils.SharePreferenceUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/15
 * <p>
 * Describe:
 */
public class AccountPresenter {

    private AccountView mView;
    private Context mContext;
    private AccountBean mBean;
    private final String id;

    public AccountPresenter(AccountView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
        id = (String) SharePreferenceUtil.get(mContext, Constants.ID, "");
    }

    public void sendTopRequest(String pager) {
        mView.showLoadingView();
//        type时间类型,1:7日,2:30日,3:半年,4:一年
        OkHttpUtils.post()
                .url(HttpConstants.Account)
                .addParams("page", pager + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        AccountBean mBean = new AccountBean();
                        mBean.getAllData(response);
                        if ("0".equals(mBean.getStatus())) {
                            mView.showContentView();
                            AccountBean.DataBean dataBean = mBean.getData();
                            refreshTopData(dataBean.getTotal_data());
                            sendRequest(1, "refresh");
                        } else {
                            mView.showErrorView();
                            mView.showToast("数据解析错误");

                        }

                    }
                });

    }

    public void sendRequest(int pager, final String requestType) {
        OkHttpUtils.post()
                .url(HttpConstants.Account)
                .addParams("page", pager + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("Account======", "response=======" + response);
                        mBean = new AccountBean();
                        mBean.getAllData(response);
                        if ("0".equals(mBean.getStatus())) {
                            mView.showContentView();
                            AccountBean.DataBean dataBean = mBean.getData();
                            mView.refreshUIData(dataBean, requestType);

                        } else {
                            mView.showErrorView();
                            mView.showToast("数据解析错误");

                        }

                    }
                });
    }

    private void refreshTopData(AccountBean.DataBean.Total_dataEntity totalBean) {
        mView.getTvAccount01().setText(NumberUtils.amountConversion(Double.parseDouble(totalBean.getUser() + "")));
        mView.getTvAccount02().setText(NumberUtils.amountConversion(Double.parseDouble(totalBean.getShows() + "")));
        mView.getTvAccount03().setText(NumberUtils.amountConversion(Double.parseDouble(totalBean.getClick() + "")));
        mView.getTvAccount04().setText(NumberUtils.amountConversion(Double.parseDouble(totalBean.getConsume() + "")));
    }


}
