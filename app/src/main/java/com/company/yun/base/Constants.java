package com.company.yun.base;

import android.graphics.Color;

/**
 * Created by Lovelin on 2019/5/9
 * <p>
 * Describe:
 */
public class Constants {


    public static final String SP_IS_FIRST_IN = "sp_is_first_in";


    public static final String Is_Logined = "is_logined";

    public static final String Token = "token";
    public static final String Device = "android";
    public static final String UserName = "username";

    public static final int[] MATERIAL_COLORS_01 = {
            rgb("#2ecc71")
    };
    public static final int[] MATERIAL_COLORS_02 = {
            rgb("#2ecc71"), rgb("#f1c40f")

    };
    public static final int[] MATERIAL_COLORS_03 = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c")

    };
    public static final int[] MATERIAL_COLORS_04 = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")


    };
    public static final int[] MATERIAL_COLORS_05 = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db"), rgb("#f23030")

    };
    public static final int[] MATERIAL_COLORS_06 = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db"), rgb("#f23030"), rgb("#1765bd"),

    };

    public static int rgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }
}
