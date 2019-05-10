package com.company.yun.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.company.yun.base.Constants;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.LoginBean;
import com.company.yun.utils.NetworkUtil;
import com.company.yun.view.widget.ClearEditText;
import com.company.yun.view.widget.SquareImageView;
import com.yun.common.utils.SharePreferenceUtil;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/9
 * <p>
 * Describe:登入界面
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.iv_login_logo)
    SquareImageView ivLoginLogo;
    @BindView(R.id.et_login_phone)
    ClearEditText etLoginPhone;
    @BindView(R.id.et_login_password)
    ClearEditText etLoginPassword;
    @BindView(R.id.tv_login_forget)
    TextView tvLoginForget;
    @BindView(R.id.btn_login_commit)
    Button btnLoginCommit;
    private String username;
    private String password;
    private LoginBean mBean;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        initView();
        etLoginPhone.setText("test");
        etLoginPassword.setText("123456");
        responseListener();

    }

    private void initView() {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();
        setTitleName("登入");
    }


    /**
     * 无网络的时候 刷新数据
     */
    @Override
    protected void onClickRetry() {
        super.onClickRetry();
        if (NetworkUtil.CheckConnection(getActivity())) {
            sendRequest();
        }
    }

    private void sendRequest() {
        showLoading();
        OkHttpUtils.post()
                .url(HttpConstants.Login)
                .addParams("username", username)
                .addParams("password", password)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showError();
                        showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mBean = new LoginBean();
                        mBean.getAllData(response);
                        String status = mBean.getStatus();  //0 成功   1失败
                        if ("0".equals(status)) {
                            showContent();
                            Log.e("Net", "login==response===" + response);
                            Log.e("Net", "login==response===" + mBean.getData().getToken());
                            Log.e("Net", "login==response===" + "android");
                            SharePreferenceUtil.put(LoginActivity.this, Constants.Is_Logined, true);
                            SharePreferenceUtil.put(LoginActivity.this, Constants.Token, mBean.getData().getToken());
                            SharePreferenceUtil.put(LoginActivity.this, Constants.Device, "android");
                            SharePreferenceUtil.put(LoginActivity.this, Constants.UserName, mBean.getData().getUsername());
                            showToast("登入成功");
                            openActivity(MainActivity.class);
                        } else {
                            showError();

                        }

                    }
                });

    }

    private void responseListener() {

        btnLoginCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
            }
        });


    }

    private void checkData() {
        username = etLoginPhone.getText().toString().trim();
        password = etLoginPassword.getText().toString().trim();
        if ("".equals(username) && TextUtils.isEmpty(username)) {
            showToast("用户名--不能为空哦~");
        } else if ("".equals(password) && TextUtils.isEmpty(password)) {
            showToast("密码--不能为空哦~");
        } else {
            sendRequest();
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
