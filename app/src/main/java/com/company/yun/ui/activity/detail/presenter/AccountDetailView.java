package com.company.yun.ui.activity.detail.presenter;

import com.company.yun.bean.account.DetailLineBean;
import com.company.yun.bean.account.DetailListBean;
import com.company.yun.bean.account.TotalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:
 */
public interface AccountDetailView {

    void showLoadingView();

    void showContentView();

    void showEmptyView();

    void showErrorView();

    void showToast(String string);

    void refreshRecycleViewData(List<DetailListBean.DataEntity.TableEntity> table, String requestType);
    void refreshTotalUIData( ArrayList<TotalBean> stringList);
    void refreshLineUIData(DetailLineBean.DataEntity data);

}
