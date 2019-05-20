package com.company.yun.ui.activity.result.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.company.yun.ui.fragment.result.ResultKeywordFragment;
import com.company.yun.ui.fragment.result.ResultOriginalityFragment;
import com.company.yun.ui.fragment.result.ResultPlanFragment;
import com.company.yun.ui.fragment.result.ResultUnitFragment;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:搜索结果
 */
public class ResultViewPagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitle;

    public ResultViewPagerAdapter(FragmentManager fm, String[] tabString) {
        super(fm);
        this.tabTitle = tabString;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return tabTitle[0];
            case 1:
                return tabTitle[1];
            case 2:
                return tabTitle[2];
            case 3:
                return tabTitle[3];
        }
        return null;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:         //计划
                return new ResultPlanFragment();
            case 1:         //单元
                return new ResultUnitFragment();
            case 2:         //关键字
                return new ResultKeywordFragment();
            case 3:         //创意
                return new ResultOriginalityFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }
}
