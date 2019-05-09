package com.company.yun.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lovelin on 2019/5/9
 * <p>
 * Describe:
 */
public class LoginBean {


    /**
     * data : {"id":"2","username":"test","token":"uJkQhsql"}
     * status : 0
     * info : 登陆成功
     */
    private DataBean data;
    private String status;
    private String info;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            DataBean dataBean = new DataBean();
            JSONObject data = object.getJSONObject("data");
            dataBean.getData(data);
            setData(dataBean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public class DataBean {
        /**
         * id : 2
         * username : test
         * token : uJkQhsql
         */
        private String id;
        private String username;
        private String token;

        public void getData(JSONObject obj) {
            try {
                setId(obj.getString("id"));
                setUsername(obj.getString("username"));
                setToken(obj.getString("token"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getToken() {
            return token;
        }
    }
}
