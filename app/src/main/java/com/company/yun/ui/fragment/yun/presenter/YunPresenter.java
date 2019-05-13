package com.company.yun.ui.fragment.yun.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.yun.TodayDataBean;
import com.yun.common.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/13
 * <p>
 * Describe:
 */
public class YunPresenter {

    private Context mContext;
    private YunView mView;

    public YunPresenter(Context mContext, YunView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }


    public void sendRequest() {
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.Yun_Daday_Data)
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
                            mView.showContentView();
                            TodayDataBean todayDataBean = new TodayDataBean();
                            todayDataBean.getAllData(response);
                            LogUtils.e("response========" + response);
                            refreshTodayData(todayDataBean);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
    }

    private void refreshTodayData(TodayDataBean bean) {
        mView.getTotal().setText(bean.getClick_rate() + "%");
//        setBGDrawable(mView.getTotal(), bean.getClick_rate());

        mView.getShow().setText(bean.getShows() + "%");
//        setBGDrawable(mView.getDrableIcon01(), bean.getShow_rate());

        mView.getConsume().setText(bean.getConsume() + "%");
//        setBGDrawable(mView.getDrableIcon02(), bean.getConsume_rate());

        mView.getShowPeople().setText(bean.getShow_people() + "%");
//        setBGDrawable(mView.getDrableIcon03(), bean.getShow_people_rate());
    }

    private void setBGDrawable(TextView mView, String str) {
        int i = Integer.parseInt(str);
        if (i > 0) {
            Drawable drawable = mContext.getResources().getDrawable(R.mipmap.icon_yun_red);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mView.setCompoundDrawables(null, null, drawable, null);
        } else {
            Drawable drawable = mContext.getResources().getDrawable(R.mipmap.icon_yun_yellow);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mView.setCompoundDrawables(null, null, drawable, null);
        }
    }


}






















