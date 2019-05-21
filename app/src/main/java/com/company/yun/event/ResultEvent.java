package com.company.yun.event;

import com.company.yun.bean.result.ResultBean;

/**
 * Created by Lovelin on 2019/5/21
 * <p>
 * Describe:
 */
public class ResultEvent {
    private ResultBean.DataBean data;

    public ResultBean.DataBean getData() {
        return data;
    }

    public void setData(ResultBean.DataBean data) {
        this.data = data;
    }

    public ResultEvent(ResultBean.DataBean data) {
        this.data = data;
    }
}
