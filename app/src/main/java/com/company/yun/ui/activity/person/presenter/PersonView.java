package com.company.yun.ui.activity.person.presenter;

import com.company.yun.bean.function.PersonBean;

/**
 * Created by Lovelin on 2019/5/16
 * <p>
 * Describe:
 */
public interface PersonView {
    void showLoadingView();

    void showContentView();

    void showEmptyView();

    void showErrorView();

    void showToast(String string);

    void refreshData(PersonBean mBean);
}
