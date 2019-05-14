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
public class LineBarBean {
    /**
     * x : ["9:36:04","9:36:03","9:36:02","9:36:01","9:36:00","9:35:59"]
     * y : [[311,174,193,324,223,313],[324,256,267,132,194,311]]
     */
    private List<String> x;
    private List<List<Integer>> y;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);

            ArrayList<String> xList = new ArrayList<>();
            JSONArray x = object.getJSONArray("x");
            for (int i = 0; i < x.length(); i++) {
                xList.add((String) x.get(i));
                setX(xList);
            }

            JSONArray y = object.getJSONArray("y");
            ArrayList<List<Integer>> yList = new ArrayList<List<Integer>>();
            for (int i = 0; i < y.length(); i++) {

                ArrayList<Integer> stringYList = new ArrayList<>();
                JSONArray array = (JSONArray) y.get(i);

                for (int z = 0; z < array.length(); z++) {
                    stringYList.add((Integer) array.get(z));

                }
                yList.add(stringYList);
                setY(yList);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void setX(List<String> x) {
        this.x = x;
    }

    public void setY(List<List<Integer>> y) {
        this.y = y;
    }

    public List<String> getX() {
        return x;
    }

    public List<List<Integer>> getY() {
        return y;
    }

    @Override
    public String toString() {
        return "LineBarBean{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
