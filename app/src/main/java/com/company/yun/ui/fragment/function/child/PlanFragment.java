package com.company.yun.ui.fragment.function.child;

import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:推广方案
 */
public class PlanFragment extends BaseFragment {


    @Override
    public int getContentViewId() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void init(ViewGroup rootView) throws Exception {
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();
    }
}
