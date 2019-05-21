package com.company.yun.ui.fragment.result;

import android.view.View;
import android.view.ViewGroup;

import com.bin.david.form.core.SmartTable;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.result.OriginalityBean;
import com.company.yun.bean.result.ResultBean;
import com.company.yun.ui.activity.result.ResultActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:计划
 */
public class ResultOriginalityFragment extends BaseFragment {
    private SmartTable mTabel;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_result_originality;
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
        ResultBean.DataBean data = ResultActivity.data;
        if (data != null) {
            List<ResultBean.DataBean.PlanBean.OriginalityEntity> originality = data.getPlan().getOriginality();
            final List<OriginalityBean> originalityBeanList = new ArrayList<>();
            for (int i = 0; i < originality.size(); i++) {
                ResultBean.DataBean.PlanBean.OriginalityEntity originalityEntity = originality.get(i);
                String originality1 = originalityEntity.getOriginality();
                String show = originalityEntity.getTotal().getAll().getShow();
                String click = originalityEntity.getTotal().getAll().getClick();
                String charge = originalityEntity.getTotal().getAll().getCharge();

                List<ResultBean.DataBean.PlanBean.PlanEntity> plan = data.getPlan().getPlan();
                List<ResultBean.DataBean.PlanBean.UnitEntity> unit = data.getPlan().getUnit();
                String plan_id = originalityEntity.getPlan_id();
                String namePlan = plan.get(Integer.parseInt(plan_id)).getName();
                String unit_id = originalityEntity.getUnit_id();
                String nameUnit = unit.get(Integer.parseInt(unit_id)).getName();

                DecimalFormat df = new DecimalFormat("0.00");
                String formatPrice = df.format((float) Float.parseFloat(charge) / Float.parseFloat(click));
                String formatclickRatre = df.format((float) Float.parseFloat(show) / Float.parseFloat(click));

                OriginalityBean originalityBean = new OriginalityBean(originality1, "-", "-", "-", namePlan,
                        nameUnit, charge, show, click, formatPrice, formatclickRatre);


                originalityBeanList.add(originalityBean);

            }
            mTabel.setData(originalityBeanList);
            mTabel.getConfig().setShowTableTitle(true);
            mTabel.getConfig().setShowXSequence(true);
            mTabel.getConfig().setShowYSequence(true);
            mTabel.setZoom(true, 2, 0.2f);
        }

    }
}
