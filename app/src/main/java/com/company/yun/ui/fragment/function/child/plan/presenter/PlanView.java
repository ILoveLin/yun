package com.company.yun.ui.fragment.function.child.plan.presenter;

import com.company.yun.bean.function.PersonBean;
import com.company.yun.bean.function.plan.AreaBean;
import com.company.yun.bean.function.plan.ChannelBean;
import com.company.yun.bean.function.plan.PortBean;

/**
 * Created by Lovelin on 2019/5/16
 * <p>
 * Describe:
 */
public interface PlanView {
    void showLoadingView();

    void showContentView();

    void showEmptyView();

    void showErrorView();

    void showToast(String string);

    void refreshData(PortBean portBean, ChannelBean channelBean, AreaBean areaBean);

}
