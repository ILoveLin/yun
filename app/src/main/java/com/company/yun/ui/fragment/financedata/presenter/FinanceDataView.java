package com.company.yun.ui.fragment.financedata.presenter;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:
 */
public interface FinanceDataView {

    void showLoadingView();
    void showContentView();
    void showEmptyView();
    void showErrorView();
    void showToast(String string);


}
