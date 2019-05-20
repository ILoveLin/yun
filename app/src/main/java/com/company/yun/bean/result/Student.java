package com.company.yun.bean.result;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

/**
 * Created by huang on 2017/11/1.
 */
@SmartTable(name = "计划信息列表", count = true)
public class Student {
    @SmartColumn(id = 1, name = "姓名", autoCount = true)
    private String name;
    @SmartColumn(id = 2, name = "性别", autoCount = true)
    private String sex;

    @SmartColumn(id = 3, name = "爱好", autoCount = true)
    private String three;
    @SmartColumn(id = 4, name = "身高", autoCount = true)
    private String four;
    @SmartColumn(id = 5, name = "体重", autoCount = true)
    private String five;
    @SmartColumn(id = 6, name = "胖瘦", autoCount = true)
    private String six;
    @SmartColumn(id = 7, name = "更新时间")
    private String time;
    @SmartColumn(id = 8, name = "年龄", autoCount = true)
    private String age;
    @SmartColumn(id = 9, name = "哈哈", autoCount = true)
    private String right;
    //    @SmartColumn(id=8,name="测试Double",autoCount = true)
//    private double data =5;
    private String url;
//    @SmartColumn(type = ColumnType.ArrayChild)
//    private List<Lesson> lessons;


    public Student(String name, String sex, String three, String four, String five, String six, String time, String age, String right, String url) {
        this.name = name;
        this.sex = sex;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.time = time;
        this.age = age;
        this.right = right;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
