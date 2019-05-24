package com.company.yun.ui.fragment.function.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.function.plan.CheckBean;
import com.company.yun.ui.fragment.function.child.plan.ResultPlanActivity;
import com.company.yun.view.widget.ClearEditText;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yun.common.utils.KeyBoardUtils;
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
        OkHttpUtils.post()
                .url(HttpConstants.Plan_Check)
                .addParams("keyword", keyword)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showError();
                        showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        showContent();
                        checkBean = new CheckBean();
                        checkBean.getAllData(response);
                        if (checkBean.getStatus().equals("0")) {
                            Bundle bundle = new Bundle();
                            bundle.putString("keyword", keyword);
                            KeyBoardUtils.closeKeybord(edittextPlan, getContext());
                            openActivity(ResultPlanActivity.class, bundle);
                        } else {
                            showToast("该关键字不支持搜索");
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
