package com.company.yun.bean.yun;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lovelin on 2019/5/13
 * <p>
 * Describe:
 */
public class TodayBean {
    /**
     * consume_rate : -0.06
     * shows : 8,431,163
     * show_people_rate : 0.17
     * click_rate : -0.44
     * consume : 3,774,882
     * click : 309,686
     * show_people : 5,829,251
     * show_rate : 0.10
     */
    private String consume_rate;
    private String shows;
    private String show_people_rate;
    private String click_rate;
    private String consume;
    private String click;
    private String show_people;
    private String show_rate;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setConsume_rate(object.getString("consume_rate"));
            setShows(object.getString("shows"));
            setShow_people_rate(object.getString("show_people_rate"));
            setClick_rate(object.getString("click_rate"));
            setConsume(object.getString("consume"));
            setClick(object.getString("click"));
            setShow_people(object.getString("show_people"));
            setShow_rate(object.getString("show_rate"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void setConsume_rate(String consume_rate) {
        this.consume_rate = consume_rate;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }

    public void setShow_people_rate(String show_people_rate) {
        this.show_people_rate = show_people_rate;
    }

    public void setClick_rate(String click_rate) {
        this.click_rate = click_rate;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public void setShow_people(String show_people) {
        this.show_people = show_people;
    }

    public void setShow_rate(String show_rate) {
        this.show_rate = show_rate;
    }

    public String getConsume_rate() {
        return consume_rate;
    }

    public String getShows() {
        return shows;
    }

    public String getShow_people_rate() {
        return show_people_rate;
    }

    public String getClick_rate() {
        return click_rate;
    }

    public String getConsume() {
        return consume;
    }

    public String getClick() {
        return click;
    }

    public String getShow_people() {
        return show_people;
    }

    public String getShow_rate() {
        return show_rate;
    }
}
