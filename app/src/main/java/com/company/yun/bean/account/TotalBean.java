package com.company.yun.bean.account;

/**
 * Created by Lovelin on 2019/5/27
 * <p>
 * Describe:
 */
public class TotalBean {
    private boolean isSelected;
    private String data;
    private String text;
    private String textid;

    public String getTextid() {
        return textid;
    }

    public void setTextid(String textid) {
        this.textid = textid;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
