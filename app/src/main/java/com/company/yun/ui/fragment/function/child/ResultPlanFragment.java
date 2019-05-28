package com.company.yun.ui.fragment.function.child;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.function.plan.CheckBean;
import com.company.yun.ui.activity.plan.ResultPlanActivity;
import com.company.yun.view.widget.ClearEditText;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yun.common.utils.KeyBoardUtils;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/24
 * <p>
 * Describe:
 */
public class ResultPlanFragment extends BaseFragment {
    @BindView(R.id.edittext_plan)
    ClearEditText edittextPlan;
    @BindView(R.id.btn_plan_search)
    Button btnPlanSearch;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    Unbinder unbinder;
    private CheckBean checkBean;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(getContext(),"该关键字不支持搜索",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int getContentViewId() {
        return R.layout.fragment_search_plan;

    }

    @Override
    protected void init(ViewGroup rootView) {
        initView();
        responseListener();

    }

    private void initView() {

        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();

    }

    private void responseListener() {
        btnPlanSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCheckRequest(edittextPlan.getText().toString().trim());
            }
        });

        edittextPlan.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    KeyBoardUtils.closeKeybord(edittextPlan, getContext());
                }
            }


        });
    }

    //检查关键字是否可用    0可用  1不可用
    private void sendCheckRequest(final String keyword) {
        if ("".equals(keyword)) {
            showToast("关键字不能未空");
            return;
        }
        showLoading();
        OkHttpUtils.post()
                .url(HttpConstants.Plan_Check)
                .addParams("keyword", keyword)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showError();
                        showToast("数据返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        checkBean = new CheckBean();
                        checkBean.getAllData(response);
                        if (checkBean.getStatus().equals("0")) {
                            showContent();
                            Bundle bundle = new Bundle();
                            bundle.putString("keyword", keyword);
                            KeyBoardUtils.closeKeybord(edittextPlan, getContext());
                            openActivity(ResultPlanActivity.class, bundle);
                        } else {
                            showContent();
                            mHandler.sendEmptyMessageDelayed(1,1000);
                        }

                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
