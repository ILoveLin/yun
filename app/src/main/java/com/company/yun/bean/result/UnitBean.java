package com.company.yun.bean.result;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

/**
 * Created by Lovelin on 2019/5/21
 * <p>
 * Describe:
 */
@SmartTable(name = "单元-信息列表", count = false)
public class UnitBean {
    @SmartColumn(id = 1, name = "推广计划", autoCount = true)
    private String plan;
    @SmartColumn(id = 2, name = "单元名称", autoCount = true)   // -
    private String unitname;
    @SmartColumn(id = 3, name = "数据分析", autoCount = true)      //有效
    private String datafenxi;
    @SmartColumn(id = 4, name = "状态", autoCount = true)  //-
    private String statue;
    @SmartColumn(id = 5, name = "消费", autoCount = true)    //不限定
    private String charge;
    @SmartColumn(id = 6, name = "展现", autoCount = true) //未撞线
    private String zhuangxian;
    @SmartColumn(id = 7, name = "点击")
    private String click;
    @SmartColumn(id = 8, name = "平均点击价格", autoCount = true)
    private String price;
    @SmartColumn(id = 9, name = "点击率", autoCount = true)
    private String click_rate;
    @SmartColumn(id = 10, name = "单元出价", autoCount = true)
    private String unitPrice;
    @SmartColumn(id = 11, name = "是否关键字", autoCount = true)
    private String isKeyword;

    public UnitBean(String plan, String unitname, String datafenxi, String statue, String charge,
                    String zhuangxian, String click, String price, String click_rate, String unitPrice, String isKeyword) {
        this.plan = plan;
        this.unitname = unitname;
        this.datafenxi = datafenxi;
        this.statue = statue;
        this.charge = charge;
        this.zhuangxian = zhuangxian;
        this.click = click;
        this.price = price;
        this.click_rate = click_rate;
        this.unitPrice = unitPrice;
        this.isKeyword = isKeyword;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getDatafenxi() {
        return datafenxi;
    }

    public void setDatafenxi(String datafenxi) {
        this.datafenxi = datafenxi;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getZhuangxian() {
        return zhuangxian;
    }

    public void setZhuangxian(String zhuangxian) {
        this.zhuangxian = zhuangxian;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getClick_rate() {
        return click_rate;
    }

    public void setClick_rate(String click_rate) {
        this.click_rate = click_rate;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getIsKeyword() {
        return isKeyword;
    }

    public void setIsKeyword(String isKeyword) {
        this.isKeyword = isKeyword;
    }
}
