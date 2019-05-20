package com.company.yun.ui.activity.result;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.company.yun.ui.activity.result.adapter.ResultViewPagerAdapter;
import com.company.yun.view.widget.NoScrollViewPager;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:搜索引擎结果----------渠道分布结果的界面
 */
public class ResultActivity extends BaseActivity {

    public String[] tabString = {"计划", "单元", "关键字", "创意"};
    @BindView(R.id.tab_layout)
    XTabLayout tabLayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    private ResultViewPagerAdapter mAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_result;
    }

    @Override
    public void init() {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        setPageStateView();
        setTitleName("搜索引擎结果");
        showContent();
        mAdapter = new ResultViewPagerAdapter(getSupportFragmentManager(), tabString);
        viewpager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewpager);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
