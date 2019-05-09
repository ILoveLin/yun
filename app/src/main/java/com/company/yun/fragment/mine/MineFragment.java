package com.company.yun.fragment.mine;

import android.view.View;
import android.view.ViewGroup;


import com.company.yun.R;
import com.company.yun.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:我的---5
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_04;
    }

    @Override
    public void init(ViewGroup rootView) {

        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("我的");
        setPageStateView();
        showLoading();

    }


}
