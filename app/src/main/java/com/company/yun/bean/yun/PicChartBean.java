package com.company.yun.bean.yun;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/14
 * <p>
 * Describe:
 */
public class PicChartBean {
    /**
     * total : 137582009人
     * interest : {"x":["16.63","14.82","14.36","12.72","11.19","11.78","9.55","8.95"],"y":["资讯","软件应用","医疗健康","影视音乐","教育培训","游戏","求职创业","餐饮美食"]}
     * sex : {"x":["51.34","48.66"],"y":["女","男"]}
     * age : {"x":["3.04","20.12","32.80","27.82","14.46","0.58","1.18"],"y":["18岁","18-24","25-34","35-44","45-54","55-64","65以上"]}
     */
    private String total;
    private SexEntity sex;
    private AgeEntity age;
    private InterestEntity interest;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setTotal(object.getString("total"));
            JSONObject sex = object.getJSONObject("sex");
            SexEntity sexEntity = new SexEntity();
            sexEntity.getData(sex);
            setSex(sexEntity);
            JSONObject age = object.getJSONObject("age");
            AgeEntity ageEntity = new AgeEntity();
            ageEntity.getData(age);
            setAge(ageEntity);
            JSONObject interest = object.getJSONObject("interest");
            InterestEntity interestEntity = new InterestEntity();
            interestEntity.getData(interest);
            setInterest(interestEntity);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void setTotal(String total) {
        this.total = total;
    }

    public void setInterest(InterestEntity interest) {
        this.interest = interest;
    }

    public void setSex(SexEntity sex) {
        this.sex = sex;
    }

    public void setAge(AgeEntity age) {
        this.age = age;
    }

    public String getTotal() {
        return total;
    }

    public InterestEntity getInterest() {
        return interest;
    }

    public SexEntity getSex() {
        return sex;
    }

    public AgeEntity getAge() {
        return age;
    }

    public class InterestEntity {
        /**
         * x : ["16.63","14.82","14.36","12.72","11.19","11.78","9.55","8.95"]
         * y : ["资讯","软件应用","医疗健康","影视音乐","教育培训","游戏","求职创业","餐饮美食"]
         */
        private List<String> x;
        private List<String> y;

        public void getData(JSONObject object) {
            try {
                JSONArray xArray = object.getJSONArray("x");
                ArrayList<String> xArrayList = new ArrayList<>();
                for (int i = 0; i < xArray.length(); i++) {
                    xArrayList.add((String) xArray.get(i));
                    setX(xArrayList);
                }
                JSONArray yArray = object.getJSONArray("y");
                ArrayList<String> yArrayList = new ArrayList<>();
                for (int i = 0; i < yArray.length(); i++) {
                    yArrayList.add((String) yArray.get(i));
                    setY(yArrayList);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void setX(List<String> x) {
            this.x = x;
        }

        public void setY(List<String> y) {
            this.y = y;
        }

        public List<String> getX() {
            return x;
        }

        public List<String> getY() {
            return y;
        }
    }

    public class SexEntity {
        /**
         * x : ["51.34","48.66"]
         * y : ["女","男"]
         */
        private List<String> x;
        private List<String> y;

        public void getData(JSONObject object) {
            try {
                JSONArray xArray = object.getJSONArray("x");
                ArrayList<String> xArrayList = new ArrayList<>();
                for (int i = 0; i < xArray.length(); i++) {
                    xArrayList.add((String) xArray.get(i));
                    setX(xArrayList);
                }
                JSONArray yArray = object.getJSONArray("y");
                ArrayList<String> yArrayList = new ArrayList<>();
                for (int i = 0; i < yArray.length(); i++) {
                    yArrayList.add((String) yArray.get(i));
                    setY(yArrayList);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        public void setX(List<String> x) {
            this.x = x;
        }

        public void setY(List<String> y) {
            this.y = y;
        }

        public List<String> getX() {
            return x;
        }

        public List<String> getY() {
            return y;
        }
    }

    public class AgeEntity {
        /**
         * x : ["3.04","20.12","32.80","27.82","14.46","0.58","1.18"]
         * y : ["18岁","18-24","25-34","35-44","45-54","55-64","65以上"]
         */
        private List<String> x;
        private List<String> y;

        public void getData(JSONObject object) {
            try {
                JSONArray xArray = object.getJSONArray("x");
                ArrayList<String> xArrayList = new ArrayList<>();
                for (int i = 0; i < xArray.length(); i++) {
                    xArrayList.add((String) xArray.get(i));
                    setX(xArrayList);
                }
                JSONArray yArray = object.getJSONArray("y");
                ArrayList<String> yArrayList = new ArrayList<>();
                for (int i = 0; i < yArray.length(); i++) {
                    yArrayList.add((String) yArray.get(i));
                    setY(yArrayList);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void setX(List<String> x) {
            this.x = x;
        }

        public void setY(List<String> y) {
            this.y = y;
        }

        public List<String> getX() {
            return x;
        }

        public List<String> getY() {
            return y;
        }
    }
}
