package com.company.yun.ui.fragment.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.david.form.core.SmartTable;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:计划
 */
public class ResultOriginalityFragment extends BaseFragment {
    private SmartTable mTabel;
    private Button mBtn;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_result_originality;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView(rootView);
        setPageStateView();
        showContent();

    }

    private void initView(ViewGroup rootView) {
        mTabel = rootView.findViewById(R.id.table);
        mBtn = rootView.findViewById(R.id.btn2);
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.VISIBLE);
    }


}
