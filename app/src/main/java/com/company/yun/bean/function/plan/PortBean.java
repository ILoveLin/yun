package com.company.yun.bean.function.plan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/17
 * <p>
 * Describe:端口分布
 */
public class PortBean {
    /**
     * data : {"barData":["5.87","60.87","33.26"],"category":["Pc端口","Android端","IOS端"]}
     * status : 0
     * info :
     */
    private DataEntity data;
    private String status;
    private String info;


    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);

            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            DataEntity dataEntity = new DataEntity();
            dataEntity.getData(object.getJSONObject("data"));
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
         * barData : ["5.87","60.87","33.26"]
         * category : ["Pc端口","Android端","IOS端"]
         */
        private List<String> barData;
        private List<String> category;

        public void getData(JSONObject data) {

            try {
                JSONArray barData = data.getJSONArray("barData");
                ArrayList<String> barDataList = new ArrayList<>();
                for (int i = 0; i < barData.length(); i++) {
                    barDataList.add((String) barData.get(i));
                    setBarData(barDataList);
                }
                JSONArray category = data.getJSONArray("category");
                ArrayList<String> categoryList = new ArrayList<>();
                for (int i = 0; i < barData.length(); i++) {
                    categoryList.add((String) category.get(i));
                    setCategory(categoryList);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        public void setBarData(List<String> barData) {
            this.barData = barData;
        }

        public void setCategory(List<String> category) {
            this.category = category;
        }

        public List<String> getBarData() {
            return barData;
        }

        public List<String> getCategory() {
            return category;
        }


    }
}
