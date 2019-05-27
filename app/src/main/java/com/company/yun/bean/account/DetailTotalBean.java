package com.company.yun.bean.account;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lovelin on 2019/5/27
 * <p>
 * Describe:
 */
public class DetailTotalBean {
    /**
     * data : {"shows":"48215164","click_rate":"5.60","consume":"1654744.01","click_price":"0.61","click":"2698738"}
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
         * shows : 48215164
         * click_rate : 5.60
         * consume : 1654744.01
         * click_price : 0.61
         * click : 2698738
         */
        private String shows;
        private String click_rate;
        private String consume;
        private String click_price;
        private String click;
        private String type;

        public void getData(JSONObject data) {

            try {
                setShows(data.getString("shows"));
                setClick_rate(data.getString("click_rate"));
                setConsume(data.getString("consume"));
                setClick_price(data.getString("click_price"));
                setClick(data.getString("click"));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setShows(String shows) {
            this.shows = shows;
        }

        public void setClick_rate(String click_rate) {
            this.click_rate = click_rate;
        }

        public void setConsume(String consume) {
            this.consume = consume;
        }

        public void setClick_price(String click_price) {
            this.click_price = click_price;
        }

        public void setClick(String click) {
            this.click = click;
        }

        public String getShows() {
            return shows;
        }

        public String getClick_rate() {
            return click_rate;
        }

        public String getConsume() {
            return consume;
        }

        public String getClick_price() {
            return click_price;
        }

        public String getClick() {
            return click;
        }

    }
}
