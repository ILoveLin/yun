package com.company.yun.bean.function.plan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/17
 * <p>
 * Describe:区域
 */
public class AreaBean {
    /**
     * data : {"provinces":{"total":"8273","list":[{"name":"广东","value":"12.09"},{"name":"山东","value":"7.59"},{"name":"浙江","value":"7.18"},{"name":"江苏","value":"7.10"},{"name":"河南","value":"5.55"},{"name":"四川","value":"5.40"},{"name":"河北","value":"5.29"},{"name":"北京","value":"4.67"},{"name":"辽宁","value":"4.27"},{"name":"湖北","value":"3.48"},{"name":"福建","value":"3.14"},{"name":"湖南","value":"3.09"},{"name":"山西","value":"2.84"},{"name":"上海","value":"2.71"},{"name":"安徽","value":"2.64"},{"name":"广西","value":"2.38"},{"name":"陕西","value":"2.30"},{"name":"云南","value":"2.30"},{"name":"江西","value":"2.28"},{"name":"重庆","value":"2.21"},{"name":"黑龙江","value":"1.98"},{"name":"贵州","value":"1.81"},{"name":"吉林","value":"1.80"},{"name":"天津","value":"1.61"},{"name":"内蒙古","value":"1.26"},{"name":"甘肃","value":"1.10"},{"name":"新疆","value":"0.69"},{"name":"海南","value":"0.60"},{"name":"宁夏","value":"0.22"},{"name":"青海","value":"0.21"},{"name":"西藏","value":"0.08"},{"name":"香港","value":"0.08"},{"name":"澳门","value":"0.02"},{"name":"台湾","value":"0.02"}]}}
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
            JSONObject data = object.getJSONObject("data");
            DataEntity dataEntity = new DataEntity();
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
         * provinces : {"total":"8273","list":[{"name":"广东","value":"12.09"},{"name":"山东","value":"7.59"},{"name":"浙江","value":"7.18"},{"name":"江苏","value":"7.10"},{"name":"河南","value":"5.55"},{"name":"四川","value":"5.40"},{"name":"河北","value":"5.29"},{"name":"北京","value":"4.67"},{"name":"辽宁","value":"4.27"},{"name":"湖北","value":"3.48"},{"name":"福建","value":"3.14"},{"name":"湖南","value":"3.09"},{"name":"山西","value":"2.84"},{"name":"上海","value":"2.71"},{"name":"安徽","value":"2.64"},{"name":"广西","value":"2.38"},{"name":"陕西","value":"2.30"},{"name":"云南","value":"2.30"},{"name":"江西","value":"2.28"},{"name":"重庆","value":"2.21"},{"name":"黑龙江","value":"1.98"},{"name":"贵州","value":"1.81"},{"name":"吉林","value":"1.80"},{"name":"天津","value":"1.61"},{"name":"内蒙古","value":"1.26"},{"name":"甘肃","value":"1.10"},{"name":"新疆","value":"0.69"},{"name":"海南","value":"0.60"},{"name":"宁夏","value":"0.22"},{"name":"青海","value":"0.21"},{"name":"西藏","value":"0.08"},{"name":"香港","value":"0.08"},{"name":"澳门","value":"0.02"},{"name":"台湾","value":"0.02"}]}
         */
        private ProvincesEntity provinces;


        public void getData(JSONObject object) {
            try {
                ProvincesEntity provincesEntity = new ProvincesEntity();
                provincesEntity.getData(object.getJSONObject("provinces"));
                setProvinces(provincesEntity);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        public void setProvinces(ProvincesEntity provinces) {
            this.provinces = provinces;
        }

        public ProvincesEntity getProvinces() {
            return provinces;
        }


        public class ProvincesEntity {
            /**
             * total : 8273
             * list : [{"name":"广东","value":"12.09"},{"name":"山东","value":"7.59"},{"name":"浙江","value":"7.18"},{"name":"江苏","value":"7.10"},{"name":"河南","value":"5.55"},{"name":"四川","value":"5.40"},{"name":"河北","value":"5.29"},{"name":"北京","value":"4.67"},{"name":"辽宁","value":"4.27"},{"name":"湖北","value":"3.48"},{"name":"福建","value":"3.14"},{"name":"湖南","value":"3.09"},{"name":"山西","value":"2.84"},{"name":"上海","value":"2.71"},{"name":"安徽","value":"2.64"},{"name":"广西","value":"2.38"},{"name":"陕西","value":"2.30"},{"name":"云南","value":"2.30"},{"name":"江西","value":"2.28"},{"name":"重庆","value":"2.21"},{"name":"黑龙江","value":"1.98"},{"name":"贵州","value":"1.81"},{"name":"吉林","value":"1.80"},{"name":"天津","value":"1.61"},{"name":"内蒙古","value":"1.26"},{"name":"甘肃","value":"1.10"},{"name":"新疆","value":"0.69"},{"name":"海南","value":"0.60"},{"name":"宁夏","value":"0.22"},{"name":"青海","value":"0.21"},{"name":"西藏","value":"0.08"},{"name":"香港","value":"0.08"},{"name":"澳门","value":"0.02"},{"name":"台湾","value":"0.02"}]
             */
            private String total;
            private List<ListEntity> list;

            public void getData(JSONObject object) {

                try {
                    setTotal(object.getString("total"));
                    JSONArray list = object.getJSONArray("list");
                    ArrayList<ListEntity> listEntities = new ArrayList<>();
                    for (int i = 0; i < list.length(); i++) {
                        ListEntity listEntity = new ListEntity();
                        listEntity.getData((JSONObject) list.get(i));
                        listEntities.add(listEntity);
                        setList(listEntities);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


            public void setTotal(String total) {
                this.total = total;
            }

            public void setList(List<ListEntity> list) {
                this.list = list;
            }

            public String getTotal() {
                return total;
            }

            public List<ListEntity> getList() {
                return list;
            }


            public class ListEntity {
                /**
                 * name : 广东
                 * value : 12.09
                 */
                private String name;
                private String value;

                public void getData(JSONObject object) {
                    try {
                        setName(object.getString("name"));
                        setValue(object.getString("value"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getName() {
                    return name;
                }

                public String getValue() {
                    return value;
                }


            }
        }
    }

}
