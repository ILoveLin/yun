package com.company.yun.app;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.Constants;
import com.yun.common.utils.SharePreferenceUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:拦截器  添加header
 */
public class MyInterceptor implements Interceptor {
    private Context mContext;

    public MyInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String device = (String) SharePreferenceUtil.get(mContext, Constants.Device, "");
        String token = (String) SharePreferenceUtil.get(mContext, Constants.Token, "");
        Log.e("Net", "data==1==Interceptor===" + device);
        Log.e("Net", "data==1==Interceptor===" + token);

        Request request = chain.request().newBuilder()
                .addHeader("device", device)
                .addHeader("token", token)
                .build();

        return chain.proceed(request);

    }
}
