package com.company.yun.ui.activity.ppt.presenter;

import com.company.yun.bean.PPTBean;

/**
 * Created by Lovelin on 2019/5/22
 * <p>
 * Describe:
 */
public interface PPTView {
    void showLoadingView();

    void showContentView();

    void showEmptyView();

    void showErrorView();

    void showToast(String string);

    void refreshData(PPTBean pptBean);

}
