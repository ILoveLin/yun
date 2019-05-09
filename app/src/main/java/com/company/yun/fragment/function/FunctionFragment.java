package com.company.yun.fragment.function;

import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:功能---4
 */
public class FunctionFragment extends BaseFragment {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    @Override
    public int getContentViewId() {
        return R.layout.fragment_03;
    }

    @Override
    public void init(ViewGroup rootView) {
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("功能");
        setPageStateView();
        showError();

    }


}
