package com.company.yun.bean.result;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

/**
 * Created by Lovelin on 2019/5/21
 * <p>
 * Describe:
 */
@SmartTable(name = "关键字-信息列表", count = false)
public class KeyWorldBean {
    @SmartColumn(id = 1, name = "关键字", autoCount = true)
    private String keyword;
    @SmartColumn(id = 2, name = "数据分析", autoCount = true)   // -
    private String dataFenxi;
    @SmartColumn(id = 3, name = "状态", autoCount = true)      //有效
    private String statue;
    @SmartColumn(id = 4, name = "推广计划", autoCount = true)  //-
    private String tuiguagnPlan;
    @SmartColumn(id = 5, name = "推广单元", autoCount = true)    //不限定
    private String tuiguagnUnit;
    @SmartColumn(id = 6, name = "出价", autoCount = true) //
    private String price;
    @SmartColumn(id = 7, name = "消费")
    private String charge;
    @SmartColumn(id = 8, name = "点击", autoCount = true)
    private String click;
    @SmartColumn(id = 9, name = "平均点击价格", autoCount = true)
    private String clickPrice;
    @SmartColumn(id = 10, name = "点击率", autoCount = true)
    private String clickRate;
    @SmartColumn(id = 11, name = "匹配模式", autoCount = true)
    private String mode;
    @SmartColumn(id = 11, name = "计算机质量", autoCount = true)
    private String calputer;
    @SmartColumn(id = 11, name = "移动质量", autoCount = true)
    private String move;
    @SmartColumn(id = 11, name = "出价系数计算器", autoCount = true)
    private String outPrice;

    public KeyWorldBean(String keyword, String dataFenxi, String statue, String tuiguagnPlan, String tuiguagnUnit, String price, String charge,
                        String click, String clickPrice, String clickRate, String mode, String calputer, String move, String outPrice) {
        this.keyword = keyword;
        this.dataFenxi = dataFenxi;
        this.statue = statue;
        this.tuiguagnPlan = tuiguagnPlan;
        this.tuiguagnUnit = tuiguagnUnit;
        this.price = price;
        this.charge = charge;
        this.click = click;
        this.clickPrice = clickPrice;
        this.clickRate = clickRate;
        this.mode = mode;
        this.calputer = calputer;
        this.move = move;
        this.outPrice = outPrice;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDataFenxi() {
        return dataFenxi;
    }

    public void setDataFenxi(String dataFenxi) {
        this.dataFenxi = dataFenxi;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getTuiguagnPlan() {
        return tuiguagnPlan;
    }

    public void setTuiguagnPlan(String tuiguagnPlan) {
        this.tuiguagnPlan = tuiguagnPlan;
    }

    public String getTuiguagnUnit() {
        return tuiguagnUnit;
    }

    public void setTuiguagnUnit(String tuiguagnUnit) {
        this.tuiguagnUnit = tuiguagnUnit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getClickPrice() {
        return clickPrice;
    }

    public void setClickPrice(String clickPrice) {
        this.clickPrice = clickPrice;
    }

    public String getClickRate() {
        return clickRate;
    }

    public void setClickRate(String clickRate) {
        this.clickRate = clickRate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCalputer() {
        return calputer;
    }

    public void setCalputer(String calputer) {
        this.calputer = calputer;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(String outPrice) {
        this.outPrice = outPrice;
    }
}
