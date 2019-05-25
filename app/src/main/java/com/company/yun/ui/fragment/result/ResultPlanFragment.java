package com.company.yun.ui.fragment.result;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.david.form.component.XSequence;
import com.bin.david.form.component.YSequence;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
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
            ICellBackgroundFormat<Column> background = new BaseCellBackgroundFormat<Column>() {
                @Override
                public int getBackGroundColor(Column column) {
                    return ContextCompat.getColor(getActivity(), R.color.white);
                }

                @Override
                public int getTextColor(Column column) {
                    if ("展现".equals(column.getColumnName())) {
                        return ContextCompat.getColor(getActivity(), R.color.white);
                    }
                    return TableConfig.INVALID_COLOR;
                }
            };
////设置列标题背景和颜色
//            table.getConfig().setColumnCellBackgroundFormat(background);
////设置统计行背景和颜色
//            table.getConfig().setCountBgCellFormat(background);


//            1.  设置内容文字样式  setContentStyle
//            2.  设置左边序列文字样式 setYSequenceStyle
//            3.  设置顶部序列文字样式 setXSequenceStyle
//            4.  设置列标题文字样式 setColumnTitleStyle
//            5.  设置表格标题文字样式 setTableTitleStyle
//            6.  设置统计行样式  setCountStyle
//            7.  设置列标题网格样式 setColumnTitleGridStyle
//            8.  设置内容网格样式 setGridStyle       //
//            14. 设置内容背景 setContentBackgroundColor
//            mTabel.getConfig().setContentStyle(new FontStyle(50, Color.WHITE));
//            table.getConfig().setContentStyle(new FontStyle(50, Color.BLUE));

            mTabel.getConfig().setYSequenceStyle(new FontStyle(40, Color.WHITE));     //ABC
            mTabel.getConfig().setXSequenceStyle(new FontStyle(40, Color.WHITE));     //123
            mTabel.getConfig().setColumnTitleStyle(new FontStyle(40, Color.WHITE));   //列标题
            mTabel.getConfig().setTableTitleStyle(new FontStyle(40, Color.WHITE));    //表格标题
            mTabel.getConfig().setContentStyle(new FontStyle(40, Color.WHITE));       //内容
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
