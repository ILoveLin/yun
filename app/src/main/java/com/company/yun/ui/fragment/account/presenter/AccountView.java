package com.company.yun.ui.fragment.account.presenter;

import android.widget.TextView;

import com.company.yun.bean.account.AccountBean;
import com.company.yun.bean.financedata.FinanceDataBean;
import com.company.yun.view.widget.SettingBar;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:
 */
public interface AccountView {

    void showLoadingView();

    void showContentView();

    void showEmptyView();

    void showErrorView();

    void showToast(String string);

    void refreshUIData(AccountBean.DataBean  mDataBean ,String requestType);

        TextView getTvAccount01();
        TextView getTvAccount02();
        TextView getTvAccount03();
        TextView getTvAccount04();

}
