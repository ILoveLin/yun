package com.company.yun.base;

/**
 * Created by Lovelin on 2019/5/9
 * <p>
 * Describe:API
 */
public class HttpConstants {

    public static final String Common = "http://yun2.jxsccm.com";


    public static final String Login = Common + "/api/Login/login";

//    http://yun2.jxsccm.com/api/index/record

    //财务数据
    public static final String Data = Common + "/api/index/record";

    //尚城云
    public static final String Yun_Daday_Data = Common + "/api/index/get_index.html";
    public static final String Yun_User_Data = Common + "/api/index/get_user_portrait.html";
    public static final String Yun_Chart_Line_Bar = Common + "/api/index/get_real_time";


}
