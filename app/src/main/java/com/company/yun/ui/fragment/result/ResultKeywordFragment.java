package com.company.yun.ui.fragment.result;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.david.form.core.SmartTable;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.result.ResultBean;
import com.company.yun.bean.result.Student;
import com.company.yun.event.ResultEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
public class ResultKeywordFragment extends BaseFragment {


    private SmartTable mTabel;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_result_keyword;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView(rootView);
        setPageStateView();
        showContent();
        initData();

    }

    private void initView(ViewGroup rootView) {
        mTabel = rootView.findViewById(R.id.table);
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.VISIBLE);
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
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initResultData(ResultEvent resultEvent) {
        ResultBean.DataBean data = resultEvent.getData();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

}
