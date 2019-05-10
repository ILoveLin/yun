package com.company.yun.ui.fragment.function;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.xtablayout.XTabLayout;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.ui.fragment.function.adapter.FunctionViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:功能---4
 */
public class FunctionFragment extends BaseFragment {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    @BindView(R.id.tab_layout)
    XTabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    Unbinder unbinder;

    private String[] tabString = {"人物画像", "推广方案"};
    private FunctionViewPagerAdapter mViewPagerAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_03;
    }

    @Override
    public void init(ViewGroup rootView) {
        initView();

    }

    private void initView() {
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();
        mViewPagerAdapter = new FunctionViewPagerAdapter(getChildFragmentManager(), tabString);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
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
