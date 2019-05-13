package com.company.yun.ui.fragment.yun.presenter;

import android.widget.TextView;

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


    TextView getTotal();

    TextView getTotalRate();

    TextView getShow();

    TextView getShowRate();

    TextView getConsume();

    TextView getConsumeRate();

    TextView getShowPeople();

    TextView getShowPeopleRate();


    TextView getDrableIcon01();
    TextView getDrableIcon02();
    TextView getDrableIcon03();


}
