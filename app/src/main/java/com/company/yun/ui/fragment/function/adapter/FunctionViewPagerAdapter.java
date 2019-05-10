package com.company.yun.ui.fragment.function.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.company.yun.ui.fragment.function.child.PersonFragment;
import com.company.yun.ui.fragment.function.child.PlanFragment;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:viewpager  ----adapter
 */
public class FunctionViewPagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitle;

    public FunctionViewPagerAdapter(FragmentManager fm, String[] tabString) {
        super(fm);
        this.tabTitle = tabString;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:   //足球-即时
                return tabTitle[0];
            case 1:   //足球-完场
                return tabTitle[1];

        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:   //人物画像
                return new PersonFragment();
            case 1:   //推广方案
                return new PlanFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }
}
