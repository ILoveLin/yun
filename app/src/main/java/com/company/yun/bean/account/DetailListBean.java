package com.company.yun.bean.account;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/27
 * <p>
 * Describe:
 */
public class DetailListBean {

    /**
     * data : {"page":"<ul class=\"pagination\"><li class=\"disabled\"><span>«<\/span><\/li> <li class=\"active\"><span>1<\/span><\/li><li><a href=\"/api/Sems/sems_record_table?page=2\">2<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=3\">3<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=4\">4<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=5\">5<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=6\">6<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=7\">7<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=8\">8<\/a><\/li><li class=\"disabled\"><span>...<\/span><\/li><li><a href=\"/api/Sems/sems_record_table?page=12\">12<\/a><\/li><li><a href=\"/api/Sems/sems_record_table?page=13\">13<\/a><\/li> <li><a href=\"/api/Sems/sems_record_table?page=2\">»<\/a><\/li><\/ul>","table":[{"ddate":"2018-05-31","shows":"67415","click_rate":"3.81","consume":"2581.82","id":"46405","click_price":"1.01","click":"2567"},{"ddate":"2018-05-30","shows":"49536","click_rate":"4.00","consume":"2125.65","id":"46099","click_price":"1.07","click":"1983"},{"ddate":"2018-05-29","shows":"47669","click_rate":"4.50","consume":"2551.05","id":"45548","click_price":"1.19","click":"2145"},{"ddate":"2018-05-28","shows":"30662","click_rate":"5.05","consume":"2019.05","id":"45519","click_price":"1.31","click":"1547"},{"ddate":"2018-05-27","shows":"24366","click_rate":"6.22","consume":"2148.31","id":"44934","click_price":"1.42","click":"1515"},{"ddate":"2018-05-26","shows":"25491","click_rate":"5.26","consume":"2111.75","id":"44641","click_price":"1.57","click":"1341"},{"ddate":"2018-05-25","shows":"9929","click_rate":"4.22","consume":"670.45","id":"44481","click_price":"1.60","click":"419"},{"ddate":"2018-05-24","shows":"7500","click_rate":"3.67","consume":"412.57","id":"44201","click_price":"1.50","click":"275"},{"ddate":"2018-05-23","shows":"406","click_rate":"5.67","consume":"32.84","id":"43985","click_price":"1.43","click":"23"},{"ddate":"2018-05-18","shows":"2739","click_rate":"5.51","consume":"122.04","id":"42392","click_price":"0.81","click":"151"}]}
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
         * page : <ul class="pagination"><li class="disabled"><span>«</span></li> <li class="active"><span>1</span></li><li><a href="/api/Sems/sems_record_table?page=2">2</a></li><li><a href="/api/Sems/sems_record_table?page=3">3</a></li><li><a href="/api/Sems/sems_record_table?page=4">4</a></li><li><a href="/api/Sems/sems_record_table?page=5">5</a></li><li><a href="/api/Sems/sems_record_table?page=6">6</a></li><li><a href="/api/Sems/sems_record_table?page=7">7</a></li><li><a href="/api/Sems/sems_record_table?page=8">8</a></li><li class="disabled"><span>...</span></li><li><a href="/api/Sems/sems_record_table?page=12">12</a></li><li><a href="/api/Sems/sems_record_table?page=13">13</a></li> <li><a href="/api/Sems/sems_record_table?page=2">»</a></li></ul>
         * table : [{"ddate":"2018-05-31","shows":"67415","click_rate":"3.81","consume":"2581.82","id":"46405","click_price":"1.01","click":"2567"},{"ddate":"2018-05-30","shows":"49536","click_rate":"4.00","consume":"2125.65","id":"46099","click_price":"1.07","click":"1983"},{"ddate":"2018-05-29","shows":"47669","click_rate":"4.50","consume":"2551.05","id":"45548","click_price":"1.19","click":"2145"},{"ddate":"2018-05-28","shows":"30662","click_rate":"5.05","consume":"2019.05","id":"45519","click_price":"1.31","click":"1547"},{"ddate":"2018-05-27","shows":"24366","click_rate":"6.22","consume":"2148.31","id":"44934","click_price":"1.42","click":"1515"},{"ddate":"2018-05-26","shows":"25491","click_rate":"5.26","consume":"2111.75","id":"44641","click_price":"1.57","click":"1341"},{"ddate":"2018-05-25","shows":"9929","click_rate":"4.22","consume":"670.45","id":"44481","click_price":"1.60","click":"419"},{"ddate":"2018-05-24","shows":"7500","click_rate":"3.67","consume":"412.57","id":"44201","click_price":"1.50","click":"275"},{"ddate":"2018-05-23","shows":"406","click_rate":"5.67","consume":"32.84","id":"43985","click_price":"1.43","click":"23"},{"ddate":"2018-05-18","shows":"2739","click_rate":"5.51","consume":"122.04","id":"42392","click_price":"0.81","click":"151"}]
         */
        private String page;
        private List<TableEntity> table;

        public void getData(JSONObject object) {
            try {
                setPage(object.getString("page"));
                JSONArray table = object.getJSONArray("table");

                ArrayList<TableEntity> tableEntities = new ArrayList<>();
                for (int i = 0; i < table.length(); i++) {
                    TableEntity tableEntity = new TableEntity();
                    tableEntity.getData((JSONObject) table.get(i));
                    tableEntities.add(tableEntity);
                    setTable(tableEntities);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setTable(List<TableEntity> table) {
            this.table = table;
        }

        public String getPage() {
            return page;
        }

        public List<TableEntity> getTable() {
            return table;
        }


        public class TableEntity {
            /**
             * ddate : 2018-05-31
             * shows : 67415
             * click_rate : 3.81
             * consume : 2581.82
             * id : 46405
             * click_price : 1.01
             * click : 2567
             */
            private String ddate;
            private String shows;
            private String consume;
            private String id;
            private String click_rate;
            private String click_price;
            private String click;

            public void getData(JSONObject object) {
                try {
                    setDdate(object.getString("ddate"));
                    setShows(object.getString("shows"));
                    setConsume(object.getString("consume"));
                    setId(object.getString("id"));
                    setClick_rate(object.getString("click_rate"));
                    setClick_price(object.getString("click_price"));
                    setClick(object.getString("click"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            public void setDdate(String ddate) {
                this.ddate = ddate;
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

            public void setId(String id) {
                this.id = id;
            }

            public void setClick_price(String click_price) {
                this.click_price = click_price;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public String getDdate() {
                return ddate;
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

            public String getId() {
                return id;
            }

            public String getClick_price() {
                return click_price;
            }

            public String getClick() {
                return click;
            }

        }
    }
}
