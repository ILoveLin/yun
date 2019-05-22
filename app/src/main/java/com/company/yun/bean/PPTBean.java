package com.company.yun.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/22
 * <p>
 * Describe:
 */
public class PPTBean {
    /**
     * data : ["http://yun2.jxsccm.com/static/hdp/ppt1.jpg","http://yun2.jxsccm.com/static/hdp/ppt2.jpg","http://yun2.jxsccm.com/static/hdp/ppt3.jpg","http://yun2.jxsccm.com/static/hdp/ppt4.jpg","http://yun2.jxsccm.com/static/hdp/ppt5.jpg","http://yun2.jxsccm.com/static/hdp/ppt6.jpg","http://yun2.jxsccm.com/static/hdp/ppt7.jpg","http://yun2.jxsccm.com/static/hdp/ppt8.jpg","http://yun2.jxsccm.com/static/hdp/ppt9.jpg","http://yun2.jxsccm.com/static/hdp/ppt10.jpg","http://yun2.jxsccm.com/static/hdp/ppt11.jpg","http://yun2.jxsccm.com/static/hdp/ppt12.jpg","http://yun2.jxsccm.com/static/hdp/ppt13.jpg","http://yun2.jxsccm.com/static/hdp/ppt14.jpg","http://yun2.jxsccm.com/static/hdp/ppt15.jpg","http://yun2.jxsccm.com/static/hdp/ppt16.jpg","http://yun2.jxsccm.com/static/hdp/ppt17.jpg","http://yun2.jxsccm.com/static/hdp/ppt18.jpg","http://yun2.jxsccm.com/static/hdp/ppt19.jpg","http://yun2.jxsccm.com/static/hdp/ppt20.jpg","http://yun2.jxsccm.com/static/hdp/ppt21.jpg","http://yun2.jxsccm.com/static/hdp/ppt22.jpg","http://yun2.jxsccm.com/static/hdp/ppt23.jpg","http://yun2.jxsccm.com/static/hdp/ppt24.jpg","http://yun2.jxsccm.com/static/hdp/ppt25.jpg","http://yun2.jxsccm.com/static/hdp/ppt26.jpg","http://yun2.jxsccm.com/static/hdp/ppt27.jpg","http://yun2.jxsccm.com/static/hdp/ppt28.jpg","http://yun2.jxsccm.com/static/hdp/ppt29.jpg","http://yun2.jxsccm.com/static/hdp/ppt30.jpg"]
     * status : 0
     * info :
     */
    private List<String> data;
    private String status;
    private String info;


    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            JSONArray data = object.getJSONArray("data");
            ArrayList<String> stringArrayList = new ArrayList<>();
            for (int i = 0; i < data.length(); i++) {
                stringArrayList.add((String) data.get(i));
                setData(stringArrayList);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<String> getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }
}
