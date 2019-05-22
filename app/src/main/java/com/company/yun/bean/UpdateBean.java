package com.company.yun.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lovelin on 2019/5/22
 * <p>
 * Describe:
 */
public class UpdateBean {

    /**
     * data : {"msg":"更新","is_force":"1","downurl":"http://yun2.jxsccm.com/static/app/scy2.apk","size":"5.41 MB","dtime":"1553754799","version_code":"1","version":"1.0"}
     * status : 0
     * info :
     */
    private DataEntity data;
    private String status;
    private String info;


    public void getAllDate(String resopnse){

        try {
            JSONObject object = new JSONObject(resopnse);
            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            DataEntity dataEntity = new DataEntity();
            JSONObject data = object.getJSONObject("data");
            dataEntity.getData(data);
            setData(dataEntity);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataEntity getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public class DataEntity {
        /**
         * msg : 更新
         * is_force : 1
         * downurl : http://yun2.jxsccm.com/static/app/scy2.apk
         * size : 5.41 MB
         * dtime : 1553754799
         * version_code : 1
         * version : 1.0
         */
        private String msg;
        private String is_force;
        private String downurl;
        private String size;
        private String dtime;
        private String version_code;
        private String version;

        public void getData(JSONObject object) {
            try {
                setMsg(object.getString("msg"));
                setIs_force(object.getString("is_force"));
                setDownurl(object.getString("downurl"));
                setSize(object.getString("size"));
                setDtime(object.getString("dtime"));
                setVersion_code(object.getString("version_code"));
                setVersion(object.getString("version"));

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setIs_force(String is_force) {
            this.is_force = is_force;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public void setDtime(String dtime) {
            this.dtime = dtime;
        }

        public void setVersion_code(String version_code) {
            this.version_code = version_code;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getMsg() {
            return msg;
        }

        public String getIs_force() {
            return is_force;
        }

        public String getDownurl() {
            return downurl;
        }

        public String getSize() {
            return size;
        }

        public String getDtime() {
            return dtime;
        }

        public String getVersion_code() {
            return version_code;
        }

        public String getVersion() {
            return version;
        }

    }



}
