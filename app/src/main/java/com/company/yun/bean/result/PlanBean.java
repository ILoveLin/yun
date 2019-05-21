package com.company.yun.bean.result;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

/**
 * Created by Lovelin on 2019/5/21
 * <p>
 * Describe:
 */
@SmartTable(name = "计划信息列表", count = false)
public class PlanBean {
    @SmartColumn(id = 1, name = "计划名称", autoCount = true)
    private String name;
    @SmartColumn(id = 2, name = "数据分析", autoCount = true)   // -
    private String datafenxi;
    @SmartColumn(id = 3, name = "状态", autoCount = true)      //有效
    private String statue;
    @SmartColumn(id = 4, name = "推广业务", autoCount = true)  //-
    private String yewu;
    @SmartColumn(id = 5, name = "预算", autoCount = true)    //不限定
    private String yusuan;
    @SmartColumn(id = 6, name = "最新撞线", autoCount = true) //未撞线
    private String zhuangxian;
    @SmartColumn(id = 7, name = "消费")
    private String charge;
    @SmartColumn(id = 8, name = "展现", autoCount = true)
    private String show;
    @SmartColumn(id = 9, name = "点击", autoCount = true)
    private String click;
    @SmartColumn(id = 10, name = "平均点击价格", autoCount = true)
    private String price;
    @SmartColumn(id = 11, name = "点击率", autoCount = true)
    private String click_rate;
    @SmartColumn(id = 12, name = "时段", autoCount = true)  //账户地域
    private String shiduan;
    @SmartColumn(id = 13, name = "地域", autoCount = true)  //未设置
    private String area;
    @SmartColumn(id = 13, name = "是否关键字", autoCount = true)//未设置
    private String keyword;


    public PlanBean(String name, String sex, String statue, String yewu, String yusuan, String zhuangxian, String charge, String show, String click, String price, String click_rate, String shiduan, String area, String keyword) {
        this.name = name;
        this.datafenxi = sex;
        this.statue = statue;
        this.yewu = yewu;
        this.yusuan = yusuan;
        this.zhuangxian = zhuangxian;
        this.charge = charge;
        this.show = show;
        this.click = click;
        this.price = price;
        this.click_rate = click_rate;
        this.shiduan = shiduan;
        this.area = area;
        this.keyword = keyword;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getYewu() {
        return yewu;
    }

    public void setYewu(String yewu) {
        this.yewu = yewu;
    }

    public String getYusuan() {
        return yusuan;
    }

    public void setYusuan(String yusuan) {
        this.yusuan = yusuan;
    }

    public String getZhuangxian() {
        return zhuangxian;
    }

    public void setZhuangxian(String zhuangxian) {
        this.zhuangxian = zhuangxian;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
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

    public String getShiduan() {
        return shiduan;
    }

    public void setShiduan(String shiduan) {
        this.shiduan = shiduan;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
