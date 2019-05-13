package com.company.yun.ui.fragment.financedata.presenter;

import com.company.yun.bean.financedata.FinanceDataBean;
import com.company.yun.view.widget.SettingBar;

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

    void refreshUIData(FinanceDataBean.DataBean mDataBean);


    SettingBar getSettingBar01();

    SettingBar getSettingBar02();

    SettingBar getSettingBar03();
}
