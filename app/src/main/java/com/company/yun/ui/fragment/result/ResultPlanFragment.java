package com.company.yun.ui.fragment.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.david.form.core.SmartTable;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.result.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:计划
 */
public class ResultPlanFragment extends BaseFragment {

//    public ResultPlanFragment(String str) {
//    }


    private SmartTable mTabel;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_result_plan;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView(rootView);

    }

    private void initView(ViewGroup rootView) {
        mTabel = rootView.findViewById(R.id.table);
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.VISIBLE);
        setPageStateView();
        showContent();
        initData();
    }

    private void initData() {
        final List<Student> students = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Student student = new Student("张三+李四", "男", "03", "04", "05", "06", "07", "08", "right", "url---baidu");
            students.add(student);
        }
        mTabel.setData(students);
        mTabel.getConfig().setShowTableTitle(true);
        mTabel.getConfig().setShowXSequence(true);
        mTabel.getConfig().setShowYSequence(true);
        mTabel.setZoom(true, 2, 0.2f);

    }


}
