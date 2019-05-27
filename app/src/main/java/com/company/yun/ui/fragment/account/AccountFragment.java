package com.company.yun.ui.fragment.account;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.account.AccountBean;
import com.company.yun.ui.activity.detail.AccountDetailActivity;
import com.company.yun.ui.fragment.account.adapter.AccountAdapter;
import com.company.yun.ui.fragment.account.presenter.AccountPresenter;
import com.company.yun.ui.fragment.account.presenter.AccountView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:账户管理---02
 * <p>
 * setTitleBarVisibility(View.VISIBLE);         //titlebar
 * setTitleLeftBtnVisibility(View.GONE);
 * setPageStateView();                          //设置状态view
 * showEmpty();                                 //显示empty布局
 */
public class AccountFragment extends BaseFragment implements AccountView {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    @BindView(R.id.tv_account_01)
    TextView tv_account_01;
    @BindView(R.id.tv_account_02)
    TextView tv_account_02;
    @BindView(R.id.tv_account_03)
    TextView tv_account_03;
    @BindView(R.id.tv_account_04)
    TextView tv_account_04;
    @BindView(R.id.recyclerView_account)
    RecyclerView mRecyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout mSmartRefresh;
    Unbinder unbinder;
    private int page = 1;
    private AccountPresenter mPresenter;
    private ArrayList<AccountBean.DataBean.Chams_usersEntity> mDataList;
    private AccountAdapter mAdapter;
    //    private

    @Override
    public int getContentViewId() {
        return R.layout.fragment_account;
    }

    @Override
    public void init(ViewGroup rootView) {
        mPresenter = new AccountPresenter(this, getActivity());
        initView();
        responseListener();
    }

    private void responseListener() {
//        mPresenter.sendRequest(page, "refresh");
        mPresenter.sendTopRequest(4 + "");   //全年的
        mSmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.sendRequest(page, "refresh");
            }
        });

        mSmartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.sendRequest(page, "loadMore");

            }
        });

        mAdapter.setClickCallBack(new AccountAdapter.ItemClickCallBack() {
            @Override
            public void onItemClick(AccountBean.DataBean.Chams_usersEntity bean) {
                openActivity(AccountDetailActivity.class);
            }
        });

    }

    @Override
    public void refreshUIData(AccountBean.DataBean mDataBean, String requestType) {
        List<AccountBean.DataBean.Chams_usersEntity> userList = mDataBean.getChams_users();
        switch (requestType) {
            case "refresh":
                mDataList.clear();
                mDataList.addAll(userList);
                mSmartRefresh.finishRefresh();
                mAdapter.notifyDataSetChanged();
                break;
            case "loadMore":
                mDataList.addAll(userList);
                mSmartRefresh.finishLoadMore();
                mAdapter.notifyDataSetChanged();
                break;

        }


    }

    private void initView() {
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("账户管理");
        setPageStateView();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mDataList = new ArrayList<>();
        mAdapter = new AccountAdapter(mDataList, getActivity());
        mRecyclerView.setAdapter(mAdapter);
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
    public TextView getTvAccount01() {
        return tv_account_01;
    }

    @Override
    public TextView getTvAccount02() {
        return tv_account_02;
    }

    @Override
    public TextView getTvAccount03() {
        return tv_account_03;
    }

    @Override
    public TextView getTvAccount04() {
        return tv_account_04;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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





















