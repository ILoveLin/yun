package com.company.yun.ui.fragment.result;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.style.FontStyle;
import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.result.KeyWorldBean;
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
        ResultBean.DataBean data = ResultActivity.data;
        if (data != null) {
            List<ResultBean.DataBean.PlanBean.KeywordEntity> keyword = data.getPlan().getKeyword();

            List<ResultBean.DataBean.PlanBean.PlanEntity> plan = data.getPlan().getPlan();
            List<ResultBean.DataBean.PlanBean.UnitEntity> unit = data.getPlan().getUnit();


            final List<KeyWorldBean> keyWorldBeanList = new ArrayList<>();
            for (int i = 0; i < keyword.size(); i++) {
                ResultBean.DataBean.PlanBean.KeywordEntity keywordEntity = keyword.get(i);
                String word = keywordEntity.getWord();

                String charge = keywordEntity.getAll().getCharge();
                String click = keywordEntity.getAll().getClick();
                String show = keywordEntity.getAll().getShow();
                String recbid = keywordEntity.getAll().getRecBid();
                String matchType = keywordEntity.getMatchType();
                String plan_id = keywordEntity.getPlan_id();
                String namePlan = plan.get(Integer.parseInt(plan_id)).getName();
                String unit_id = keywordEntity.getUnit_id();
                String nameUnit = unit.get(Integer.parseInt(unit_id)).getName();


//                recBid  出价
//   formatclickRatre  点击率
//                matchType   编写

                DecimalFormat df = new DecimalFormat("0.00");
                String formatPrice = df.format((float) Float.parseFloat(charge) / Float.parseFloat(click));
                String formatclickRatre = df.format((float) Float.parseFloat(show) / Float.parseFloat(click));
                String currentMatchtype = getMatchType(matchType);
                KeyWorldBean keyWorldBean = new KeyWorldBean(word, "-", "-", namePlan, nameUnit,
                        recbid, charge, click, formatPrice, formatclickRatre, currentMatchtype, "-", "-", "-");


                keyWorldBeanList.add(keyWorldBean);
            }

            mTabel.getConfig().setYSequenceStyle(new FontStyle(40, Color.WHITE));     //ABC
            mTabel.getConfig().setXSequenceStyle(new FontStyle(40, Color.WHITE));     //123
            mTabel.getConfig().setColumnTitleStyle(new FontStyle(40, Color.WHITE));   //列标题
            mTabel.getConfig().setTableTitleStyle(new FontStyle(40, Color.WHITE));    //表格标题
            mTabel.getConfig().setContentStyle(new FontStyle(40, Color.WHITE));       //内容
            mTabel.setData(keyWorldBeanList);
            mTabel.getConfig().setShowTableTitle(true);
            mTabel.getConfig().setShowXSequence(true);
            mTabel.getConfig().setShowYSequence(true);
            mTabel.setZoom(true, 2, 0.2f);
        }


    }

    private String getMatchType(String matchType) {
        switch (matchType) {
            case "2":
                return "广泛匹配";
            case "3":
                return "短语-同义包含";
            case "4":
                return "短语-精确包含";
            case "5":
                return "短语-核心包含";

        }
        return "短语-同义包含";
    }
}
