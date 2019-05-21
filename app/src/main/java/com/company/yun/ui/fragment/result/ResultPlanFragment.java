package com.company.yun.ui.fragment.result;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.david.form.core.SmartTable;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.result.PlanBean;
import com.company.yun.bean.result.ResultBean;
import com.company.yun.bean.result.Student;
import com.company.yun.event.ResultEvent;
import com.company.yun.ui.activity.result.ResultActivity;
import com.yun.common.utils.SharePreferenceUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
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
        ResultBean.DataBean data = ResultActivity.data;
        if (data != null) {
            List<ResultBean.DataBean.PlanBean.PlanEntity> plan = data.getPlan().getPlan();
            final List<PlanBean> planBeanList = new ArrayList<>();
            for (int i = 0; i < plan.size(); i++) {
                ResultBean.DataBean.PlanBean.PlanEntity planEntity = plan.get(i);
                String name = planEntity.getName();
                String show = planEntity.getTotal().getAll().getShow();
                String click = planEntity.getTotal().getAll().getClick();
                String charge = planEntity.getTotal().getAll().getCharge();
                DecimalFormat df = new DecimalFormat("0.00");
                String formatPrice = df.format((float) Float.parseFloat(charge) / Float.parseFloat(click));
                String formatclickRatre = df.format((float) Float.parseFloat(show) / Float.parseFloat(click));

//
//                PlanBean planBean = new PlanBean(name, "-", "有效", "-", "不限定", "未撞线",
//                        "1", "2", "3", "4", "5", "账户地域", "未设置", "未设置");
                PlanBean planBean = new PlanBean(name, "-", "有效", "-", "不限定", "未撞线",
                        charge, show, click, formatPrice, formatclickRatre, "账户地域", "未设置", "未设置");
                planBeanList.add(planBean);

            }
            mTabel.setData(planBeanList);
            mTabel.getConfig().setShowTableTitle(true);
            mTabel.getConfig().setShowXSequence(true);
            mTabel.getConfig().setShowYSequence(true);
            mTabel.setZoom(true, 2, 0.2f);
        }

//        final List<Student> students = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            Student student = new Student("张三+李四", "男", "03", "04", "05", "06", "07", "08", "right", "url---baidu");
//            students.add(student);
//        }
//
//        mTabel.setData(students);
//        mTabel.getConfig().setShowTableTitle(true);
//        mTabel.getConfig().setShowXSequence(true);
//        mTabel.getConfig().setShowYSequence(true);
//        mTabel.setZoom(true, 2, 0.2f);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
