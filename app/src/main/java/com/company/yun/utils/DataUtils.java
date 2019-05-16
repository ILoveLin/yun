package com.company.yun.utils;

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

    public static List<String> get6List(List<String> list) {

        ArrayList<String> m6List = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            m6List.add(list.get(i));
        }
        return m6List;
    }


    public static float[] toFloat(List<String> money) {
        float[] fs = new float[money.size()];
        for (int i = 0; i < money.size(); i++) {
            fs[i] = Float.parseFloat(money.get(i));
        }
//        Arrays.sort(fs);
//        for (int i = 0; i < fs.length; i++) {
//            Log.e("fs======","排序====="+fs[i]);
//        }
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
