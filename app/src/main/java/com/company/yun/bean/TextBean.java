package com.company.yun.bean;

/**
 * Created by Lovelin on 2019/5/28
 * <p>
 * Describe:
 */
public class TextBean {


    /**
     * status : 0
     * info :
     * data : {"consume":"1654744.01","click":"2698738","shows":"48215164","click_rate":"5.60","click_price":"0.61"}
     */

    private int status;
    private String info;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * consume : 1654744.01
         * click : 2698738
         * shows : 48215164
         * click_rate : 5.60
         * click_price : 0.61
         */

        private String consume;
        private String click;
        private String shows;
        private String click_rate;
        private String click_price;

        public String getConsume() {
            return consume;
        }

        public void setConsume(String consume) {
            this.consume = consume;
        }

        public String getClick() {
            return click;
        }

        public void setClick(String click) {
            this.click = click;
        }

        public String getShows() {
            return shows;
        }

        public void setShows(String shows) {
            this.shows = shows;
        }

        public String getClick_rate() {
            return click_rate;
        }

        public void setClick_rate(String click_rate) {
            this.click_rate = click_rate;
        }

        public String getClick_price() {
            return click_price;
        }

        public void setClick_price(String click_price) {
            this.click_price = click_price;
        }
    }
}
