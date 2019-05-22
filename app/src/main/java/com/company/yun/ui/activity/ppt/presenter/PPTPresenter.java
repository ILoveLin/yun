package com.company.yun.ui.activity.ppt.presenter;

import android.content.Context;

import com.company.yun.base.HttpConstants;
import com.company.yun.bean.PPTBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/22
 * <p>
 * Describe:
 */
public class PPTPresenter {
    private Context mContext;
    private PPTView mView;

    public PPTPresenter(Context mContext, PPTView mPPTView) {
        this.mContext = mContext;
        this.mView = mPPTView;
    }


    public void sendRequest() {
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.PPT)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        PPTBean pptBean = new PPTBean();
                        pptBean.getAllData(response);
                        String status = pptBean.getStatus();
                        if ("0".equals(status)) {
                            mView.showContentView();
                            mView.refreshData(pptBean);
                        } else {
                            mView.showErrorView();

                        }

                    }
                });

    }


}
