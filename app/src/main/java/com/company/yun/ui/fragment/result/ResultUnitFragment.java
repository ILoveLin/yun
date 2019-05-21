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
import com.company.yun.bean.result.PlanBean;
import com.company.yun.bean.result.ResultBean;
import com.company.yun.bean.result.Student;
import com.company.yun.bean.result.UnitBean;
import com.company.yun.event.ResultEvent;
import com.company.yun.ui.activity.result.ResultActivity;

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
public class ResultUnitFragment extends BaseFragment {


    private SmartTable mTabel;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_result_unit;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView(rootView);
        setPageStateView();
        showContent();
        initData();
    }

    private void initData() {
        ResultBean.DataBean data = ResultActivity.data;
        if (data != null) {
            List<ResultBean.DataBean.PlanBean.UnitEntity> unit = data.getPlan().getUnit();
            final List<UnitBean> planBeanList = new ArrayList<>();
            for (int i = 0; i < unit.size(); i++) {
                ResultBean.DataBean.PlanBean.UnitEntity unitEntity = unit.get(i);
                String name = unitEntity.getName();
                String show = unitEntity.getTotal().getAll().getShow();
                String click = unitEntity.getTotal().getAll().getClick();
                String charge = unitEntity.getTotal().getAll().getCharge();
                DecimalFormat df = new DecimalFormat("0.00");
                String formatPrice = df.format((float) Float.parseFloat(charge) / Float.parseFloat(click));
                String formatclickRatre = df.format((float) Float.parseFloat(show) / Float.parseFloat(click));

                if (name.contains("-")) {
                    int index = name.indexOf("-");
                    String start = name.substring(0, index);
                    String end = name.substring(index+1, name.length());
                    UnitBean unitBean = new UnitBean(start + "", end, "-", "-",
                            charge, show, click, formatPrice, formatclickRatre, "-", "未设置");
                    planBeanList.add(unitBean);

                } else {
                    UnitBean unitBean = new UnitBean(name, name, "-", "-",
                            charge, show, click, formatPrice, formatclickRatre, "-", "未设置");
                    planBeanList.add(unitBean);
                }


            }
            mTabel.setData(planBeanList);
            mTabel.getConfig().setShowTableTitle(true);
            mTabel.getConfig().setShowXSequence(true);
            mTabel.getConfig().setShowYSequence(true);
            mTabel.setZoom(true, 2, 0.2f);
        }

    }

    private void initView(ViewGroup rootView) {
        mTabel = rootView.findViewById(R.id.table);
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.VISIBLE);
    }

}
