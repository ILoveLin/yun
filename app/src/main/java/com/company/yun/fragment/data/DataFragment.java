package com.company.yun.fragment.data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.fragment.data.presenter.DataPresenter;
import com.company.yun.fragment.data.presenter.DataView;
import com.company.yun.utils.NetworkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:财务数据--01
 */
public class DataFragment extends BaseFragment implements DataView {


    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    Unbinder unbinder;
    private DataPresenter mPresenter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_01;
    }

    @Override
    public void init(ViewGroup rootView) {
        initTitle();
        mPresenter = new DataPresenter(getActivity(), this);
        responseListener();

    }


    @Override
    protected void onClickRetry() {
        super.onClickRetry();
        if (NetworkUtil.CheckConnection(getActivity())) {
            mPresenter.sendRequest();
        }
    }

    private void initTitle() {
        setTitleBarVisibility(View.VISIBLE);
        setTitleName("财务数据");
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();


    }

    private void responseListener() {
        mPresenter.sendRequest();
    }

    @Override
    public void showLoadingView() {
        showLoading();
    }

    @Override
    public void showContentView() {
        showContent();
    }

    @Override
    public void showEmptyView() {
        showEmpty();
    }

    @Override
    public void showErrorView() {
        showError();
    }

    @Override
    public TextView getTextView() {
        return tv01;
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
