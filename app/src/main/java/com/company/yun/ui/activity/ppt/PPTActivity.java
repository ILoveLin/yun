package com.company.yun.ui.activity.ppt;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.company.yun.bean.PPTBean;
import com.company.yun.ui.activity.ppt.adapter.PPTAdapter;
import com.company.yun.ui.activity.ppt.presenter.PPTPresenter;
import com.company.yun.ui.activity.ppt.presenter.PPTView;
import com.company.yun.ui.fragment.account.adapter.AccountAdapter;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lovelin on 2019/5/21
 * <p>
 * Describe:pdf在线观看
 */
public class PPTActivity extends BaseActivity implements PPTView {


    @BindView(R.id.recycleview)
    RecyclerView mRecyclerView;
    private ArrayList<String> mDataList;
    private PPTAdapter mAdapter;
    private PPTPresenter mPresenter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_pdf;
    }

    @Override
    public void init() {
        mPresenter = new PPTPresenter(this, this);
        initView();
        responseListener();

    }

    private void responseListener() {
        mPresenter.sendRequest();
    }

    private void initView() {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.VISIBLE);
        setPageStateView();
        setTitleName("计划书");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mDataList = new ArrayList<>();
        mAdapter = new PPTAdapter(mDataList, getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void refreshData(PPTBean pptBean) {
        List<String> dataList = pptBean.getData();
        mDataList.clear();
        mDataList.addAll(dataList);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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


}
