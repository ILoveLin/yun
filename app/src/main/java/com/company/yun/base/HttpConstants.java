package com.company.yun.base;

/**
 * Created by Lovelin on 2019/5/9
 * <p>
 * Describe:API
 */
public class HttpConstants {
    /**
     * Common
     */
    public static final String Common = "http://yun2.jxsccm.com";
    /**
     * 登入
     */
    public static final String Login = Common + "/api/Login/login";


    /**
     * 财务数据
     */
    public static final String Data = Common + "/api/index/record";

    /**
     * 尚城云
     */
    public static final String Yun_Daday_Data = Common + "/api/index/get_index.html";
    public static final String Yun_User_Data = Common + "/api/index/get_user_portrait.html";
    public static final String Yun_Chart_Line_Bar = Common + "/api/index/get_real_time";

    /**
     * 账户管理
     */

    public static final String Account = Common + "/api/index/sems";
    public static final String Account_total = Common + "/api/Sems/sems_record_total";


    /**
     * 功能
     */
    //人物画像
    public static final String Person = Common + "/api/index/portrait_results";
    //功能 --  关键字--检查校验
    public static final String Plan_Check = Common + "/api/index/is_keyword";
    //功能 -- 投放方案-投放端口
    public static final String Plan_Port = Common + "/api/Promotion/get_duankou";
    //功能 -- 投放方案-渠道分布
    public static final String Plan_Channel = Common + "/api/Promotion/get_qudao";
    //功能 -- 投放方案-地域分布
    public static final String Plan_Area = Common + "/api/Promotion/get_china";


    /**
     * 投放方案   -----搜索结果中--渠道分布点击进去,更具不同的渠道进入界面
     */
    public static final String Channel_Result = Common + "/api/Index/promotion";


}
