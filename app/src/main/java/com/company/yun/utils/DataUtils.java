package com.company.yun.utils;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/13
 * <p>
 * Describe:格式化以万、亿为单位转换
 */
public class DataUtils {

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


}
