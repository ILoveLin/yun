package com.company.yun.ui.activity.person.presenter;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.HttpConstants;
import com.company.yun.bean.function.PersonBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/15
 * <p>
 * Describe:
 */
public class PersonPresenter {

    private PersonView mView;
    private Context mContext;
    private PersonBean mBean;

    public PersonPresenter(PersonView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


    public void sendRequest(String keyword) {
        if ("".equals(keyword)) {
            mView.showToast("关键字不能未空");
            mView.showEmptyView();
            return;
        }
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.Person)
                .addParams("keyword", keyword)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("PersonPresenter======", "response=======" + response);
                        mBean = new PersonBean();
                        mBean.getAllData(response);
                        Log.e("PersonPresenter======", "解析之后=======" + mBean.toString());
                        if (mBean.getStatus().equals("0")) {
                            mView.showContentView();
                            mView.refreshData(mBean);
                        } else {
                            mView.showToast("解析错误");
                            mView.showErrorView();
                        }

                    }
                });
    }


}
