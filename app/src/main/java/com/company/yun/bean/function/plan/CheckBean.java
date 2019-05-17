package com.company.yun.bean.function.plan;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Lovelin on 2019/5/17
 * <p>
 * Describe:检查 关键字是否可用
 */
public class CheckBean {
    /**
     * data : []
     * status : 1
     * info :
     */
    private List<?> data;
    private String status;
    private String info;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setStatus(object.getString("status"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<?> getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }
}
