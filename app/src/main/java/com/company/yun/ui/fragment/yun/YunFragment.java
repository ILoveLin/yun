package com.company.yun.ui.fragment.yun;

import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:尚城云---3
 */
public class YunFragment extends BaseFragment {

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
        setTitleName("尚城云");
        setPageStateView();
        showEmpty();


    }

}
