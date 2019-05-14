package com.company.yun.ui.fragment.yun.presenter;

import android.widget.TextView;

import com.company.yun.bean.yun.PicChartBean;

import java.util.List;

/**
 * Created by Lovelin on 2019/5/13
 * <p>
 * Describe:
 */
public interface YunView {
    void showLoadingView();

    void showContentView();

    void showEmptyView();

    void showErrorView();

    void showToast(String string);


    void refreshLineBarUIData(List<String> xList, List<String> todayDataList, List<String> yesterdayDataList);

    void refreshPicChartUIData(PicChartBean.SexEntity sex, PicChartBean.AgeEntity age, PicChartBean.InterestEntity interest);

    TextView getTotal();

    TextView getTotalRate();

    TextView getShow();

    TextView getShowRate();

    TextView getConsume();

    TextView getConsumeRate();

    TextView getShowPeople();

    TextView getShowPeopleRate();
    TextView getUnderPersonCount();
    TextView getUnderType();   //tv_under_person
    TextView getUnderDays();  //tv_under_before_days


    TextView getDrableIcon01();

    TextView getDrableIcon02();

    TextView getDrableIcon03();


}
