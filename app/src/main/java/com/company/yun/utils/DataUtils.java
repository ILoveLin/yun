package com.company.yun.utils;

import android.util.Log;

import com.company.yun.bean.function.PersonBean;
import com.company.yun.bean.function.plan.ChannelBean;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/13
 * <p>
 * Describe:格式化以万、亿为单位转换
 */
public class DataUtils {

    protected final String[] mXString = new String[]{
            "办公效率", "生活实用", "丽人母婴", "图像", "运动健康", "生活服务"};


    public static String getStringName(List<ChannelBean.DataEntity> list, float value) {
        for (int i = 0; i < list.size(); i++) {
            float valueff = Float.parseFloat(list.get(i).getValue());
            if (valueff==value) {
                return list.get(i).getName();
            }
        }
        return "百度";
    }


    public static List<String> get6List(List<String> list) {

        ArrayList<String> m6List = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            m6List.add(list.get(i));
        }
        return m6List;
    }

    public static List<String> getEducationName(List<PersonBean.DataEntity.EducationEntity> education) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < education.size(); i++) {
            stringArrayList.add(education.get(i).getName());
        }
        return get6List(stringArrayList);

    }


    public static List<String> getEducationValue(List<PersonBean.DataEntity.EducationEntity> education) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < education.size(); i++) {
            stringArrayList.add(education.get(i).getValue());
        }
        return get6List(stringArrayList);

    }

    public static ArrayList<String> getConsumptionName(List<PersonBean.DataEntity.ConsumptionEntity> consumption) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < consumption.size(); i++) {
            stringArrayList.add(consumption.get(i).getName());
        }
        return stringArrayList;

    }


    public static ArrayList<String> getConsumptionValue(List<PersonBean.DataEntity.ConsumptionEntity> consumption) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < consumption.size(); i++) {
            stringArrayList.add(consumption.get(i).getValue());
        }
        return stringArrayList;

    }

    public static ArrayList<String> getAgeNameList(PersonBean.DataEntity.SocialEntity.Str_ageEntity str_age) {
        ArrayList<String> ageList = new ArrayList<>();
//        年龄 1:0-17,2:18-24,3:25-34,4:35-44,5:45+,
        ageList.add("0-17岁");
        ageList.add("18-24岁");
        ageList.add("25-34岁");
        ageList.add("35-44岁");
        ageList.add("45+岁");
        return ageList;

    }

    public static ArrayList<String> getAgeVauleList(PersonBean.DataEntity.SocialEntity.Str_ageEntity str_age) {
        ArrayList<String> ageList = new ArrayList<>();
//        年龄 1:0-17,2:18-24,3:25-34,4:35-44,5:45+,
        ageList.add(str_age.getNoe());
        ageList.add(str_age.getTow());
        ageList.add(str_age.getThree());
        ageList.add(str_age.getFour());
        ageList.add(str_age.getFive());
        return ageList;

    }

    public static List<String> getCityName(List<PersonBean.DataEntity.RegionEntity.CityEntity.ListEntity> provinceList) {
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < provinceList.size(); i++) {
            nameList.add(provinceList.get(i).getName());
        }
        return get6List(nameList);
    }

    public static List<String> getCityValue(List<PersonBean.DataEntity.RegionEntity.CityEntity.ListEntity> provinceList) {
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < provinceList.size(); i++) {
            nameList.add(provinceList.get(i).getValue());
        }
        return get6List(nameList);
    }


    public static List<String> getProvinceName(List<PersonBean.DataEntity.RegionEntity.ProvincesEntity.ListEntity> provinceList) {
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < provinceList.size(); i++) {
            nameList.add(provinceList.get(i).getName());
        }
        return get6List(nameList);
    }

    public static List<String> getProvinceValue(List<PersonBean.DataEntity.RegionEntity.ProvincesEntity.ListEntity> provinceList) {
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < provinceList.size(); i++) {
            nameList.add(provinceList.get(i).getValue());
        }
        return get6List(nameList);
    }


    public static float[] toFloat(List<String> money) {
        float[] fs = new float[money.size()];
        for (int i = 0; i < money.size(); i++) {
            fs[i] = Float.parseFloat(money.get(i));
        }
        return fs;
    }

    public static String[] toString(List<String> money) {
        String[] fs = new String[money.size()];
        for (int i = 0; i < money.size(); i++) {
            fs[i] = money.get(i);
        }
        return fs;
    }


    public static List<String> toStringList(List<Integer> list) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        if (list == null) {
            new ArrayList<>();
        } else {
            for (int i = 0; i < list.size(); i++) {
                stringArrayList.add(list.get(i) + "");
            }
        }


        return stringArrayList;
    }


}
