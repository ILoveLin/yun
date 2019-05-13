package com.company.yun.bean.financedata;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:
 */
public class FinanceDataBean {

    /**
     * data : {"days_money":"0","recharge_companys_list":[{"companys_id":"13","money":"130923030.42","company_name":"广州森沁优容科技有限公司"},{"companys_id":"14","money":"111433540.38","company_name":"江西贪玩信息技术有限公司"},{"companys_id":"64","money":"76462184.46","company_name":"北京镙丝町传媒技术有限公司"},{"companys_id":"9","money":"72075824.44","company_name":"上海旭力广告有限公司"},{"companys_id":"37","money":"69444431.57","company_name":"江西品炎网络科技有限公司-母公司"},{"companys_id":"23","money":"59636116.33","company_name":"伊犁宏禧聚信广告有限公司"},{"companys_id":"51","money":"55924787.53","company_name":"杭州米趣网络科技有限公司"},{"companys_id":"17","money":"49313458.40","company_name":"合肥市强生医药有限公司"},{"companys_id":"21","money":"40671110.03","company_name":"江西品焱网络科技有限公司"}],"last_month_money":"42539455.22","recharge_list_data":{"ddate":["20190418","20190417","20190416","20190415","20190414","20190413","20190412","20190411","20190410","20190409","20190408","20190407","20190406","20190405","20190404"],"money":["3871478.66","3754564.79","1638157.54","1779465.33","1513825.55","1601977.03","1834869.16","1840601.40","2076415.41","1890184.18","2007849.23","1977624.51","1910717.31","1775058.98","1832363.61"]},"recharge_list":[{"chams_users_id":"3654","ddate":"20190418","companys_id":"44","money":"344.05","company_name":"嵊州盛途网络科技有限公司","id":"195133","status":"1"},{"chams_users_id":"3554","ddate":"20190418","companys_id":"41","money":"1256.20","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195134","status":"1"},{"chams_users_id":"3534","ddate":"20190418","companys_id":"41","money":"618.28","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195135","status":"1"},{"chams_users_id":"3554","ddate":"20190418","companys_id":"41","money":"983.43","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195136","status":"1"},{"chams_users_id":"3534","ddate":"20190418","companys_id":"41","money":"935.03","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195137","status":"1"}],"total_money":"1446203387.49","ratio":{"month":{"ddate":["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"],"money":["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"],"ratio":["-51.21","56.68","-5.42","1019.94","-42.98","-85.07","18.15","3.83","-13.30","48.11","-34.01","44.25"]},"year":{"ddate":["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"],"money":["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"],"ratio":["3.39","17.04","-25.83","-35.01","-76.59","-55.98","180.57","62.58","414.71","157.12","225.72","171.79"]}}}
     * status : 0
     * info :
     */
    private String status;
    private String info;
    private DataBean data;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);

            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            DataBean dataBean = new DataBean();
            dataBean.getData(object.getJSONObject("data"));
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
         * days_money : 0
         * recharge_companys_list : [{"companys_id":"13","money":"130923030.42","company_name":"广州森沁优容科技有限公司"},{"companys_id":"14","money":"111433540.38","company_name":"江西贪玩信息技术有限公司"},{"companys_id":"64","money":"76462184.46","company_name":"北京镙丝町传媒技术有限公司"},{"companys_id":"9","money":"72075824.44","company_name":"上海旭力广告有限公司"},{"companys_id":"37","money":"69444431.57","company_name":"江西品炎网络科技有限公司-母公司"},{"companys_id":"23","money":"59636116.33","company_name":"伊犁宏禧聚信广告有限公司"},{"companys_id":"51","money":"55924787.53","company_name":"杭州米趣网络科技有限公司"},{"companys_id":"17","money":"49313458.40","company_name":"合肥市强生医药有限公司"},{"companys_id":"21","money":"40671110.03","company_name":"江西品焱网络科技有限公司"}]
         * last_month_money : 42539455.22
         * recharge_list_data : {"ddate":["20190418","20190417","20190416","20190415","20190414","20190413","20190412","20190411","20190410","20190409","20190408","20190407","20190406","20190405","20190404"],"money":["3871478.66","3754564.79","1638157.54","1779465.33","1513825.55","1601977.03","1834869.16","1840601.40","2076415.41","1890184.18","2007849.23","1977624.51","1910717.31","1775058.98","1832363.61"]}
         * recharge_list : [{"chams_users_id":"3654","ddate":"20190418","companys_id":"44","money":"344.05","company_name":"嵊州盛途网络科技有限公司","id":"195133","status":"1"},{"chams_users_id":"3554","ddate":"20190418","companys_id":"41","money":"1256.20","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195134","status":"1"},{"chams_users_id":"3534","ddate":"20190418","companys_id":"41","money":"618.28","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195135","status":"1"},{"chams_users_id":"3554","ddate":"20190418","companys_id":"41","money":"983.43","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195136","status":"1"},{"chams_users_id":"3534","ddate":"20190418","companys_id":"41","money":"935.03","company_name":"伊犁宏禧聚信广告有限公司-母公司","id":"195137","status":"1"}]
         * total_money : 1446203387.49
         * ratio : {"month":{"ddate":["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"],"money":["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"],"ratio":["-51.21","56.68","-5.42","1019.94","-42.98","-85.07","18.15","3.83","-13.30","48.11","-34.01","44.25"]},"year":{"ddate":["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"],"money":["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"],"ratio":["3.39","17.04","-25.83","-35.01","-76.59","-55.98","180.57","62.58","414.71","157.12","225.72","171.79"]}}
         */
        private String days_money;
        private String last_month_money;
        private String total_money;
        private RatioEntity ratio;    //对象
        private List<Recharge_companys_listEntity> recharge_companys_list;
        private Recharge_list_dataEntity recharge_list_data;
        private List<Recharge_listEntity> recharge_list;


        public void getData(JSONObject object) {
            try {
                setDays_money(object.getString("days_money"));
                setLast_month_money(object.getString("last_month_money"));
                setTotal_money(object.getString("total_money"));
                JSONObject ratio = object.getJSONObject("ratio");
                RatioEntity ratioEntity = new RatioEntity();
                ratioEntity.getData(ratio);
                setRatio(ratioEntity);

                JSONArray recharge_companys_list = object.getJSONArray("recharge_companys_list");
                ArrayList<Recharge_companys_listEntity> recharge_companys_listEntities = new ArrayList<>();
                for (int i = 0; i < recharge_companys_list.length(); i++) {
                    Recharge_companys_listEntity recharge_companys_listEntity = new Recharge_companys_listEntity();
                    recharge_companys_listEntity.getData((JSONObject) recharge_companys_list.get(i));
                    recharge_companys_listEntities.add(recharge_companys_listEntity);
                    setRecharge_companys_list(recharge_companys_listEntities);
                }


                Recharge_list_dataEntity recharge_list_dataEntity = new Recharge_list_dataEntity();
                recharge_list_dataEntity.getData(object.getJSONObject("recharge_list_data"));
                setRecharge_list_data(recharge_list_dataEntity);


                JSONArray recharge_list = object.getJSONArray("recharge_list");
                ArrayList<Recharge_listEntity> rechargeList = new ArrayList<>();

                for (int i = 0; i < recharge_list.length(); i++) {
                    Recharge_listEntity entity = new Recharge_listEntity();
                    entity.getData((JSONObject) recharge_list.get(i));
                    rechargeList.add(entity);
                    setRecharge_list(rechargeList);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "days_money='" + days_money + '\'' +
                    ", last_month_money='" + last_month_money + '\'' +
                    ", total_money='" + total_money + '\'' +
                    ", ratio=" + ratio +
                    ", recharge_companys_list=" + recharge_companys_list +
                    ", recharge_list_data=" + recharge_list_data +
                    ", recharge_list=" + recharge_list +
                    '}';
        }

        public void setDays_money(String days_money) {
            this.days_money = days_money;
        }

        public void setRecharge_companys_list(List<Recharge_companys_listEntity> recharge_companys_list) {
            this.recharge_companys_list = recharge_companys_list;
        }

        public void setLast_month_money(String last_month_money) {
            this.last_month_money = last_month_money;
        }

        public void setRecharge_list_data(Recharge_list_dataEntity recharge_list_data) {
            this.recharge_list_data = recharge_list_data;
        }

        public void setRecharge_list(List<Recharge_listEntity> recharge_list) {
            this.recharge_list = recharge_list;
        }

        public void setTotal_money(String total_money) {
            this.total_money = total_money;
        }

        public void setRatio(RatioEntity ratio) {
            this.ratio = ratio;
        }

        public String getDays_money() {
            return days_money;
        }

        public List<Recharge_companys_listEntity> getRecharge_companys_list() {
            return recharge_companys_list;
        }

        public String getLast_month_money() {
            return last_month_money;
        }

        public Recharge_list_dataEntity getRecharge_list_data() {
            return recharge_list_data;
        }

        public List<Recharge_listEntity> getRecharge_list() {
            return recharge_list;
        }

        public String getTotal_money() {
            return total_money;
        }

        public RatioEntity getRatio() {
            return ratio;
        }

        public class Recharge_companys_listEntity {
            /**
             * companys_id : 13
             * money : 130923030.42
             * company_name : 广州森沁优容科技有限公司
             */
            private String companys_id;
            private String money;
            private String company_name;

            public void getData(JSONObject object) {
                try {
                    setCompanys_id(object.getString("companys_id"));
                    setMoney(object.getString("money"));
                    setCompany_name(object.getString("company_name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            public void setCompanys_id(String companys_id) {
                this.companys_id = companys_id;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getCompanys_id() {
                return companys_id;
            }

            public String getMoney() {
                return money;
            }

            public String getCompany_name() {
                return company_name;
            }
        }

        public class Recharge_list_dataEntity {
            /**
             * ddate : ["20190418","20190417","20190416","20190415","20190414","20190413","20190412","20190411","20190410","20190409","20190408","20190407","20190406","20190405","20190404"]
             * money : ["3871478.66","3754564.79","1638157.54","1779465.33","1513825.55","1601977.03","1834869.16","1840601.40","2076415.41","1890184.18","2007849.23","1977624.51","1910717.31","1775058.98","1832363.61"]
             */
            private List<String> ddate;
            private List<String> money;

            public void getData(JSONObject object) {
                ArrayList<String> ddateList = new ArrayList<>();
                ArrayList<String> moneyList = new ArrayList<>();

                try {
                    JSONArray ddate = object.getJSONArray("ddate");
                    JSONArray money = object.getJSONArray("money");
                    for (int i = 0; i < ddate.length(); i++) {
                        ddateList.add((String) ddate.get(i));
                        setDdate(ddateList);
                    }
                    for (int i = 0; i < money.length(); i++) {
                        moneyList.add((String) money.get(i));
                        setMyMoney(moneyList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


            public void setDdate(List<String> ddate) {
                this.ddate = ddate;
            }

            public void setMyMoney(List<String> money) {
                this.money = money;
            }

            public List<String> getDdate() {
                return ddate;
            }

            public List<String> getMyMoney() {
                return money;
            }
        }


        public class Recharge_listEntity {
            /**
             * chams_users_id : 3654
             * ddate : 20190418
             * companys_id : 44
             * money : 344.05
             * company_name : 嵊州盛途网络科技有限公司
             * id : 195133
             * status : 1
             */
            private String chams_users_id;
            private String ddate;
            private String companys_id;
            private String money;
            private String company_name;
            private String id;
            private String status;


            public void getData(JSONObject object) {
                try {
                    setChams_users_id(object.getString("chams_users_id"));
                    setDdate(object.getString("ddate"));
                    setCompanys_id(object.getString("companys_id"));
                    setMoney(object.getString("money"));
                    setCompany_name(object.getString("company_name"));
                    setId(object.getString("id"));
                    setStatus(object.getString("status"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void setChams_users_id(String chams_users_id) {
                this.chams_users_id = chams_users_id;
            }

            public void setDdate(String ddate) {
                this.ddate = ddate;
            }

            public void setCompanys_id(String companys_id) {
                this.companys_id = companys_id;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getChams_users_id() {
                return chams_users_id;
            }

            public String getDdate() {
                return ddate;
            }

            public String getCompanys_id() {
                return companys_id;
            }

            public String getMoney() {
                return money;
            }

            public String getCompany_name() {
                return company_name;
            }

            public String getId() {
                return id;
            }

            public String getStatus() {
                return status;
            }
        }

        public class RatioEntity {
            /**
             * month : {"ddate":["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"],"money":["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"],"ratio":["-51.21","56.68","-5.42","1019.94","-42.98","-85.07","18.15","3.83","-13.30","48.11","-34.01","44.25"]}
             * year : {"ddate":["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"],"money":["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"],"ratio":["3.39","17.04","-25.83","-35.01","-76.59","-55.98","180.57","62.58","414.71","157.12","225.72","171.79"]}
             */
            private MonthEntity month;
            private YearEntity year;

            public void getData(JSONObject object) {
                try {
                    JSONObject month = object.getJSONObject("month");
                    JSONObject year = object.getJSONObject("year");
                    MonthEntity monthEntity = new MonthEntity();
                    monthEntity.getData(month);
                    setMonth(monthEntity);
                    YearEntity yearEntity = new YearEntity();
                    yearEntity.getData(year);
                    setYear(yearEntity);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void setMonth(MonthEntity month) {
                this.month = month;
            }

            public void setYear(YearEntity year) {
                this.year = year;
            }

            public MonthEntity getMonth() {
                return month;
            }

            public YearEntity getYear() {
                return year;
            }

            public class MonthEntity {
                /**
                 * ddate : ["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"]
                 * money : ["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"]
                 * ratio : ["-51.21","56.68","-5.42","1019.94","-42.98","-85.07","18.15","3.83","-13.30","48.11","-34.01","44.25"]
                 */
                private List<String> ddate;
                private List<String> money;
                private List<String> ratio;

                public void getData(JSONObject object) {

                    try {
                        JSONArray ddate = object.getJSONArray("ddate");
                        JSONArray money = object.getJSONArray("money");
                        JSONArray ratio = object.getJSONArray("ratio");

                        ArrayList<String> ddateList = new ArrayList<>();
                        ArrayList<String> moneyList = new ArrayList<>();
                        ArrayList<String> ratioList = new ArrayList<>();
                        for (int i = 0; i < ddate.length(); i++) {
                            ddateList.add((String) ddate.get(i));
                            setDdate(ddateList);
                        }
                        for (int i = 0; i < money.length(); i++) {
                            moneyList.add((String) money.get(i));
                            setMoney(moneyList);
                        }
                        for (int i = 0; i < ratio.length(); i++) {
                            ratioList.add((String) ratio.get(i));
                            setRatio(ratioList);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


                public void setDdate(List<String> ddate) {
                    this.ddate = ddate;
                }

                public void setMoney(List<String> money) {
                    this.money = money;
                }

                public void setRatio(List<String> ratio) {
                    this.ratio = ratio;
                }

                public List<String> getDdate() {
                    return ddate;
                }

                public List<String> getMoney() {
                    return money;
                }

                public List<String> getRatio() {
                    return ratio;
                }
            }

            public class YearEntity {
                /**
                 * ddate : ["201904","201903","201902","201901","201812","201811","201810","201809","201808","201807","201806","201805"]
                 * money : ["42539455.22","87183706.58","55642954.05","58832263.23","5253145.67","9213419.53","61698942.59","52221246.99","50294021.93","58010932.00","39166378.68","59352097.46"]
                 * ratio : ["3.39","17.04","-25.83","-35.01","-76.59","-55.98","180.57","62.58","414.71","157.12","225.72","171.79"]
                 */
                private List<String> ddate;
                private List<String> money;
                private List<String> ratio;


                public void getData(JSONObject object) {

                    try {
                        JSONArray ddate = object.getJSONArray("ddate");
                        JSONArray money = object.getJSONArray("money");
                        JSONArray ratio = object.getJSONArray("ratio");

                        ArrayList<String> ddateList = new ArrayList<>();
                        ArrayList<String> moneyList = new ArrayList<>();
                        ArrayList<String> ratioList = new ArrayList<>();
                        for (int i = 0; i < ddate.length(); i++) {
                            ddateList.add((String) ddate.get(i));
                            setDdate(ddateList);
                        }
                        for (int i = 0; i < money.length(); i++) {
                            moneyList.add((String) money.get(i));
                            setMoney(moneyList);
                        }
                        for (int i = 0; i < ratio.length(); i++) {
                            ratioList.add((String) ratio.get(i));
                            setRatio(ratioList);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


                public void setDdate(List<String> ddate) {
                    this.ddate = ddate;
                }

                public void setMoney(List<String> money) {
                    this.money = money;
                }

                public void setRatio(List<String> ratio) {
                    this.ratio = ratio;
                }

                public List<String> getDdate() {
                    return ddate;
                }

                public List<String> getMoney() {
                    return money;
                }

                public List<String> getRatio() {
                    return ratio;
                }
            }
        }
    }
}
