package com.company.yun.ui.fragment.function.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.function.plan.CheckBean;
import com.company.yun.ui.activity.person.ResultPersonActivity;
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
public class ResultPersonFragment extends BaseFragment {

    @BindView(R.id.edittext_person)
    ClearEditText edittextPerson;
    @BindView(R.id.btn_person_search)
    Button btnPersonSearch;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    Unbinder unbinder;
    private CheckBean checkBean;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_search_person;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView();
        responseListener();

    }

    private void responseListener() {
        btnPersonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCheckRequest(edittextPerson.getText().toString().trim());
            }
        });


        edittextPerson.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    KeyBoardUtils.closeKeybord(edittextPerson,getContext());

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
                        showContent();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        checkBean = new CheckBean();
                        checkBean.getAllData(response);
                        if (checkBean.getStatus().equals("0")) {
                            showContent();
                            Bundle bundle = new Bundle();
                            bundle.putString("keyword", keyword);
                            KeyBoardUtils.closeKeybord(edittextPerson,getContext());
                            openActivity(ResultPersonActivity.class, bundle);
                        } else {
                            showContent();
                            Toast.makeText(getContext(),"该关键字不支持搜索",Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                });
    }

    private void initView() {
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();

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
