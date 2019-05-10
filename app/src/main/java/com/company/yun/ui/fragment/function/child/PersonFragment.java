package com.company.yun.ui.fragment.function.child;

import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:人物画像
 */
public class PersonFragment extends BaseFragment {


    @Override
    public int getContentViewId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void init(ViewGroup rootView) throws Exception {
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();
    }
}
