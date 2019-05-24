package com.company.yun.ui.fragment.function.child.plan.presenter;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.HttpConstants;
import com.company.yun.bean.function.plan.AreaBean;
import com.company.yun.bean.function.plan.ChannelBean;
import com.company.yun.bean.function.plan.CheckBean;
import com.company.yun.bean.function.plan.PortBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/17
 * <p>
 * Describe:
 */
public class PlanPresenter {

    private PlanView mView;
    private Context mContext;
    private PortBean portBean;
    private ChannelBean channelBean;
    private AreaBean areaBean;
    private CheckBean checkBean;

    public void sendCheckRequest(final String keyword) {
        if ("".equals(keyword)) {
            mView.showToast("关键字不能未空");
            return;
        }
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.Plan_Check)
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
                        mView.showContentView();
                        checkBean = new CheckBean();
                        checkBean.getAllData(response);
                        if (checkBean.getStatus().equals("0")) {
                            sendRequest(keyword);
                        } else {
                            mView.showToast("该关键字不支持搜索");
                        }

                    }
                });
    }


    public void sendRequest(final String keyword) {
        OkHttpUtils.post()
                .url(HttpConstants.Plan_Port)
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
                        mView.showContentView();
                        portBean = new PortBean();
                        portBean.getAllData(response);
                        if (portBean.getStatus().equals("0")) {
                            sendChannelRequest(keyword);
                        } else {
                            mView.showToast("解析错误--端口");
                            mView.showErrorView();
                        }

                    }
                });
    }

    //    渠道分布
    public void sendChannelRequest(final String keyword) {
        OkHttpUtils.post()
                .url(HttpConstants.Plan_Channel)
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
                        channelBean = new ChannelBean();
                        channelBean.getAllData(response);
                        if (channelBean.getStatus().equals("0")) {
                            sendAreaRequest(keyword);
                        } else {
                            mView.showToast("解析错误--渠道分布");
                            mView.showErrorView();
                        }

                    }
                });
    }

    //    区域分布
    public void sendAreaRequest(String keyword) {
        OkHttpUtils.post()
                .url(HttpConstants.Plan_Area)
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
                        areaBean = new AreaBean();
                        areaBean.getAllData(response);
                        if (areaBean.getStatus().equals("0")) {
                            mView.showContentView();
                            mView.refreshData(portBean, channelBean, areaBean);

                        } else {
                            mView.showToast("解析错误---区域分布");
                            mView.showErrorView();
                        }

                    }
                });
    }

    public PlanPresenter(PlanView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }

    public ArrayList<String> getArealNameList(List<AreaBean.DataEntity.ProvincesEntity.ListEntity> areaList) {

        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nameList.add(areaList.get(i).getName());
        }
        return nameList;
    }

    public ArrayList<String> getArealValueList(List<AreaBean.DataEntity.ProvincesEntity.ListEntity> areaList) {

        ArrayList<String> valueList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            valueList.add(areaList.get(i).getValue());
        }
        return valueList;
    }

    public ArrayList<String> getChannelNameList(List<ChannelBean.DataEntity> channelBeanList) {

        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < channelBeanList.size(); i++) {
            nameList.add(channelBeanList.get(i).getName());
        }
        return nameList;
    }

    public ArrayList<String> getChannelValueList(List<ChannelBean.DataEntity> channelBeanList) {

        ArrayList<String> valueList = new ArrayList<>();
        for (int i = 0; i < channelBeanList.size(); i++) {
            valueList.add(channelBeanList.get(i).getValue());
        }
        return valueList;
    }
}



















