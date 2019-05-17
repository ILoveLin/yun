package com.company.yun.bean.function.plan;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/17
 * <p>
 * Describe:渠道分布
 */
public class ChannelBean {
    /**
     * data : [[{"name":"百度","channel":"baidu","value":"43.34"},{"name":"搜狗","channel":"sogou","value":"21.08"},{"name":"360","channel":"360","value":"21.42"},{"name":"神马","channel":"sm","value":"14.16"}],[{"name":"搜索","value":"100"},{"name":"资讯","value":""},{"name":"社交","value":"0"}]]
     * status : 0
     * info :
     */
    private List<List<DataEntity>> data;
    private String status;
    private String info;


    public void getAllData(String resource){
        try {
            JSONObject object = new JSONObject(resource);
            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            JSONArray data = object.getJSONArray("data");
            ArrayList<List<DataEntity>> dataList = new ArrayList<>();

            for (int i = 0; i < data.length(); i++) {
                ArrayList<DataEntity> dataEntities = new ArrayList<>();
                JSONArray array = (JSONArray) data.get(i);
                for (int i1 = 0; i1 < array.length(); i1++) {
                    DataEntity dataEntity = new DataEntity();
                    dataEntity.getData((JSONObject)array.get(i1));

                    dataEntities.add(dataEntity);
                }
                dataList.add(dataEntities);
                setData(dataList);
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setData(List<List<DataEntity>> data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<List<DataEntity>> getData() {
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
         * name : 百度
         * channel : baidu
         * value : 43.34
         */
        private String name;
        private String channel;
        private String value;
        public void getData(JSONObject object) {

            try {
                setName(object.getString("name"));
                setChannel(object.getString("channel"));
                setValue(object.getString("value"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        public void setName(String name) {
            this.name = name;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getChannel() {
            return channel;
        }

        public String getValue() {
            return value;
        }


    }
}
