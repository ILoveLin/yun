package com.company.yun.fragment.account;

import android.view.View;
import android.view.ViewGroup;


import com.company.yun.R;
import com.company.yun.base.BaseFragment;

import butterknife.BindView;

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
public class AccountFragment extends BaseFragment {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_02;
    }

    @Override
    public void init(ViewGroup rootView) {

        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("账户管理");
        setPageStateView();
        showEmpty();


    }

}
