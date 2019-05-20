package com.company.yun.bean.result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:结果Bean
 */
public class ResultBean {

    /**
     * data : {"channel":"baidu","channel_str":"百度","keyword":"白酒","plan":{"unit":[{"total":{"all":{"charge":"6576.00","show":"40300.00","click":"10550.00"},"pc":{"charge":"207.00","show":"1900.00","click":"551.00"},"mobile":{"charge":"6369.00","show":"38400.00","click":"9999.00"}},"name":"白酒推广计划-同义","plan_id":"0"},{"total":{"all":{"charge":"11976.00","show":"108100.00","click":"13523.00"},"pc":{"charge":"1592.00","show":"12600.00","click":"2497.00"},"mobile":{"charge":"10384.00","show":"95500.00","click":"11026.00"}},"name":"白酒推广计划-精确","plan_id":"0"},{"total":{"all":{"charge":"66673.00","show":"618300.00","click":"116157.00"},"pc":{"charge":"5094.00","show":"8000.00","click":"2279.00"},"mobile":{"charge":"61579.00","show":"610300.00","click":"113879.00"}},"name":"白酒推广计划-核心","plan_id":"0"}],"total":{"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}},"originality":[{"reason":[],"total":{"all":{"charge":"13.00","show":"100.00","click":"26.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"13.00","show":"100.00","click":"26.00"}},"originality":"喝了这么多年的酒，你知道窖龄酒、年份酒、陈年老酒有哪些区别？","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"目标用户点击热词为什么有钱人都爱喝这个白酒，尝过后，知道真相的我惊呆了！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"15.00"},"pc":{"charge":"4.00","show":"100.00","click":"15.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"爆料：爱喝白酒的人注意了，目标用户点击热词商家不外泄这些真相！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"8134.00","show":"26200.00","click":"2858.00"},"pc":{"charge":"4588.00","show":"5400.00","click":"1539.00"},"mobile":{"charge":"3546.00","show":"20800.00","click":"1319.00"}},"originality":"剑南春等名贵白酒放家里怎么办？目标用户点击热词合肥都知道，这里现款高价回收","unit_id":"2","point":"-","plan_id":"0"},{"reason":["↑17%","热"],"total":{"all":{"charge":"4.00","show":"100.00","click":"8.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"4.00","show":"100.00","click":"8.00"}},"originality":"还在喝勾兑酒吗!地域窖藏老酒,看得见的粮食酒!","unit_id":"2","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"208.00","show":"1600.00","click":"49.00"},"pc":{"charge":"179.00","show":"1300.00","click":"37.00"},"mobile":{"charge":"29.00","show":"300.00","click":"12.00"}},"originality":"茅台镇〔您的品牌〕酒厂直供,目标用户点击热词珍藏老酒整箱特价包邮,只卖精品纯粮酒!","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"66.00","show":"600.00","click":"137.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"66.00","show":"600.00","click":"137.00"}},"originality":"酱香与浓香竟有这么大差异！茅台、五粮液原来是\u201c勾兑\u201d酒？目标用户点击热词年轻人别错过！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5.00","show":"100.00","click":"5.00"},"pc":{"charge":"5.00","show":"100.00","click":"5.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"鹿茸-天然男士滋补必备，白酒泡鹿茸，快乐大半宿，目标用户点击热词#{地域}订购3折","unit_id":"2","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1256.00","show":"11100.00","click":"3110.00"},"pc":{"charge":"28.00","show":"500.00","click":"69.00"},"mobile":{"charge":"1228.00","show":"10600.00","click":"3041.00"}},"originality":"白酒巨擘赖永初续写白酒传奇，70年坚持古法酿造，目标用户点击热词酱香醇厚！","unit_id":"0","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"7.00","show":"100.00","click":"28.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"7.00","show":"100.00","click":"28.00"}},"originality":"茅台镇陈年酒,双节钜惠199,免费试饮,目标用户点击热词免费包邮!","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"34.00","show":"600.00","click":"106.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"34.00","show":"600.00","click":"106.00"}},"originality":"茅台镇正宗酱香型白酒，目标用户点击热词限时买一送一","unit_id":"0","point":"便宜;食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"6905.00","show":"73500.00","click":"6339.00"},"pc":{"charge":"287.00","show":"1100.00","click":"463.00"},"mobile":{"charge":"6618.00","show":"72400.00","click":"5877.00"}},"originality":"好消息！这是某短视频火的目标用户点击热词一款酱香白酒","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"46256.00","show":"473000.00","click":"100912.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"46256.00","show":"473000.00","click":"100912.00"}},"originality":"每天一小杯白酒，身体目标用户点击热词竟有明显变化！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"75.00","show":"900.00","click":"104.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"75.00","show":"900.00","click":"104.00"}},"originality":"农村养猪+酿酒，教全套技术，指导建厂，白酒需求大，目标用户点击热词销路广","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"15.00"},"pc":{"charge":"4.00","show":"100.00","click":"15.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"为什么那么多人喜欢这款白酒？看目标用户点击热词过之后你就明白了","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"16.00","show":"200.00","click":"44.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"16.00","show":"200.00","click":"44.00"}},"originality":"好消息！五粮液公司突然推出8斤装超大坛特价珍藏酒 2大坛只要几百元。","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"23.00","show":"300.00","click":"89.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"23.00","show":"300.00","click":"89.00"}},"originality":"通知：爱喝酒的同志们，目标用户点击热词白酒泡鹿鞭，逍遥每一天了，抢购请点击!","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"118.00","show":"800.00","click":"98.00"},"pc":{"charge":"73.00","show":"300.00","click":"60.00"},"mobile":{"charge":"45.00","show":"500.00","click":"38.00"}},"originality":"目标用户点击热词我们只卖品质粮食酒！窖藏年份酒","unit_id":"1","point":"美食推荐;食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"8.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"4.00","show":"100.00","click":"8.00"}},"originality":"年份原浆和普通白酒的区别?会喝酒的目标用户点击热词人才知道！","unit_id":"2","point":"食品质量保障","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"48.00","show":"600.00","click":"73.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"48.00","show":"600.00","click":"73.00"}},"originality":"爱喝酒的你这酒不能错过!地域纯粮老酒 现买三送三 数量有限!","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"34.00","show":"600.00","click":"106.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"34.00","show":"600.00","click":"106.00"}},"originality":"闯王酒业 酒厂直批原浆酒 白酒批发 诚信相邀 共谋发展 目标用户点击热词浓香型白酒批发加盟","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"3492.00","show":"13800.00","click":"3873.00"},"pc":{"charge":"23.00","show":"200.00","click":"77.00"},"mobile":{"charge":"3469.00","show":"13600.00","click":"3796.00"}},"originality":"茅台镇特制3斤豪华原浆酒紧急抢购！99元 只剩一天!","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"385.00","show":"4200.00","click":"582.00"},"pc":{"charge":"254.00","show":"2700.00","click":"407.00"},"mobile":{"charge":"131.00","show":"1500.00","click":"175.00"}},"originality":"几十目标用户点击热词元的白酒和几百元的白酒差距到底在哪里？看完长知识了！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"15.00","show":"100.00","click":"16.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"15.00","show":"100.00","click":"16.00"}},"originality":"地域特卖,汾酒清香型白酒,今日特价!目标用户点击热词错过等一年!","unit_id":"0","point":"美食推荐","plan_id":"0"},{"reason":["↑27%","热"],"total":{"all":{"charge":"168.00","show":"1200.00","click":"402.00"},"pc":{"charge":"115.00","show":"800.00","click":"280.00"},"mobile":{"charge":"53.00","show":"400.00","click":"122.00"}},"originality":"茅台镇酒厂三十年酒师酿的酒，让你品尝到原滋原味的酱香甘醇！","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑46%"],"total":{"all":{"charge":"5.00","show":"100.00","click":"5.00"},"pc":{"charge":"5.00","show":"100.00","click":"5.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"囤酒季、底价买名酒！699元4箱珍藏汾酒 只限日期!","unit_id":"2","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"143.00","show":"800.00","click":"96.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"143.00","show":"800.00","click":"96.00"}},"originality":"茅台集团52度原浆酒，纯粮酿造！自饮放心，送礼有面！日期能省600元！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"129.00","show":"1000.00","click":"142.00"},"pc":{"charge":"95.00","show":"500.00","click":"99.00"},"mobile":{"charge":"34.00","show":"500.00","click":"43.00"}},"originality":"日产白酒200斤酿酒设备！目标用户点击热词仅售3000元！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"27.00","show":"200.00","click":"38.00"},"pc":{"charge":"20.00","show":"100.00","click":"22.00"},"mobile":{"charge":"7.00","show":"100.00","click":"16.00"}},"originality":"五粮液、洋河、老白干酒、青青稞酒、伊力特前三季度成绩单出炉！","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"385.00","show":"4200.00","click":"582.00"},"pc":{"charge":"254.00","show":"2700.00","click":"407.00"},"mobile":{"charge":"131.00","show":"1500.00","click":"175.00"}},"originality":"几十块和几百块的白酒有目标用户点击热词啥不一样？原来是这样","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"19.00","show":"200.00","click":"43.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"19.00","show":"200.00","click":"43.00"}},"originality":"好酒献给懂酒的你!地域传承经典 53度酱香老酒 速来 其他人都不知道!","unit_id":"0","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"42.00","show":"400.00","click":"119.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"42.00","show":"400.00","click":"119.00"}},"originality":"正宗〔您的品牌〕原浆酒，目标用户点击热词一箱只要199！","unit_id":"2","point":"-","plan_id":"0"},{"name":"白酒推广计划"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"别犹豫，真的值，酱香型白酒，目标用户点击热词卖完为止","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"27.00","show":"200.00","click":"38.00"},"pc":{"charge":"20.00","show":"100.00","click":"22.00"},"mobile":{"charge":"7.00","show":"100.00","click":"16.00"}},"originality":"震惊！你还给好友喝勾兑白酒？这款纯粮白酒，目标用户点击热词正宗！","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"15.00","show":"100.00","click":"37.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"15.00","show":"100.00","click":"37.00"}},"originality":"想存几箱白酒,几年后再喝，目标用户点击热词什么酒值得收藏？","unit_id":"1","point":"美食推荐","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"295.00","show":"2200.00","click":"755.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"295.00","show":"2200.00","click":"755.00"}},"originality":"目标用户点击热词好喝的茅台镇酒竟不贵？酒姑娘揭秘酿酒六大细节","unit_id":"1","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"168.00","show":"1200.00","click":"402.00"},"pc":{"charge":"115.00","show":"800.00","click":"280.00"},"mobile":{"charge":"53.00","show":"400.00","click":"122.00"}},"originality":"窖龄酒、年份酒、陈年老酒等等看上去都是老酒，到底啥区别？","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"谁说百元内喝不到好酒，这些酒可以媲美那些上千元的酒！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"48.00","show":"600.00","click":"73.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"48.00","show":"600.00","click":"73.00"}},"originality":"酱香白酒一直很贵，仅限日期特价，目标用户点击热词卖完为止！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1256.00","show":"11100.00","click":"3110.00"},"pc":{"charge":"28.00","show":"500.00","click":"69.00"},"mobile":{"charge":"1228.00","show":"10600.00","click":"3041.00"}},"originality":"年份酒、窖龄酒、新酒与老酒、陈年老酒有什么区别？","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑111%","热"],"total":{"all":{"charge":"3079.00","show":"29400.00","click":"4863.00"},"pc":{"charge":"467.00","show":"5000.00","click":"965.00"},"mobile":{"charge":"2612.00","show":"24400.00","click":"3898.00"}},"originality":"杜康名酒酒厂直供迎端午低至38元！限日期!","unit_id":"1","point":"-","plan_id":"0"},{"reason":["↑24%"],"total":{"all":{"charge":"19.00","show":"200.00","click":"43.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"19.00","show":"200.00","click":"43.00"}},"originality":"[今天福利]不敢相信、正宗汾酒集团收藏酒居然只要这个价！还包邮","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑58%","热"],"total":{"all":{"charge":"11.00","show":"100.00","click":"16.00"},"pc":{"charge":"11.00","show":"100.00","click":"16.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"最后一波！五粮液地域酒厂生产:一瓶低至47元,就要喝有档次的酒","unit_id":"0","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1479.00","show":"12100.00","click":"2842.00"},"pc":{"charge":"10.00","show":"200.00","click":"87.00"},"mobile":{"charge":"1469.00","show":"11900.00","click":"2755.00"}},"originality":"如果经济允许，建议喝目标用户点击热词这款白酒，纯粮食酿造，不伤身体！假一罚万","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"7.00","show":"100.00","click":"28.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"7.00","show":"100.00","click":"28.00"}},"originality":"\u201c便宜\u201d等不了，抢购要趁早！目标用户点击热词窖藏酒白酒","unit_id":"2","point":"便宜;美食推荐","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"7433.00","show":"66300.00","click":"6541.00"},"pc":{"charge":"436.00","show":"2000.00","click":"783.00"},"mobile":{"charge":"6997.00","show":"64300.00","click":"5758.00"}},"originality":"汾酒白酒,给你厂价！好喝！目标用户点击热词货到付款！","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"118.00","show":"800.00","click":"98.00"},"pc":{"charge":"73.00","show":"300.00","click":"60.00"},"mobile":{"charge":"45.00","show":"500.00","click":"38.00"}},"originality":"多年陈酿 只为一瓶好酒!地域窖藏原浆酒!保真,点此了解详情!","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"207.00","show":"1700.00","click":"261.00"},"pc":{"charge":"179.00","show":"1200.00","click":"230.00"},"mobile":{"charge":"28.00","show":"500.00","click":"31.00"}},"originality":"目标用户点击热词如果说白酒哪款好，建议经典酱香百年大福！纯粮无勾兑!","unit_id":"1","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"207.00","show":"1700.00","click":"261.00"},"pc":{"charge":"179.00","show":"1200.00","click":"230.00"},"mobile":{"charge":"28.00","show":"500.00","click":"31.00"}},"originality":"一瓶酒卖了好几千，是以前家里的留的老酒，庆哥酒水专业收酒！","unit_id":"1","point":"-","plan_id":"0"}],"keyword":[{"all":{"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"46","cpc":"1.49","recBid":"1.56","show":"800","rank":"1","click":"96.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.56","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"44","cpc":"1.49","recBid":"1.52","show":"800","rank":"1","click":"96.00"},"competition":"8","bid":"7.71","word":"白酒批发市场","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.03","showRate":"0.8","charge":"208.00","pv":"27","cpc":"4.26","recBid":"1.22","show":"1600","rank":"1","click":"49.00"},"pc":{"ctr":"0.03","showRate":"0.86","charge":"179.00","pv":"7","cpc":"4.85","recBid":"0.81","show":"1300","rank":"1","click":"37.00"},"matchType":"4","mobile":{"ctr":"0.04","showRate":"0.6","charge":"29.00","pv":"20","cpc":"2.44","recBid":"1.22","show":"300","rank":"1","click":"12.00"},"competition":"8","bid":"6.36","word":"品牌白酒代理加盟","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.09","showRate":"0.89","charge":"6905.00","pv":"1183","cpc":"1.09","recBid":"7.67","show":"73500","rank":"1","click":"6339.00"},"pc":{"ctr":"0.42","showRate":"1","charge":"287.00","pv":"18","cpc":"0.62","recBid":"7.67","show":"1100","rank":"1","click":"463.00"},"matchType":"5","mobile":{"ctr":"0.08","showRate":"0.89","charge":"6618.00","pv":"1164","cpc":"1.13","recBid":"1.37","show":"72400","rank":"1","click":"5877.00"},"competition":"18","bid":"2.84","word":"酿酒设备白酒","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.24","showRate":"1","charge":"1479.00","pv":"446","cpc":"0.52","recBid":"1.17","show":"12100","rank":"1","click":"2842.00"},"pc":{"ctr":"0.43","showRate":"1","charge":"10.0","pv":"23","cpc":"0.12","recBid":"0.58","show":"200","rank":"1","click":"87.00"},"matchType":"3","mobile":{"ctr":"0.24","showRate":"1","charge":"1469.00","pv":"423","cpc":"0.53","recBid":"1.17","show":"11900","rank":"1","click":"2755.00"},"competition":"9","bid":"4.45","word":"中国白酒排名","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.23","showRate":"0.75","charge":"66.00","pv":"72","cpc":"0.48","recBid":"1.65","show":"600","rank":"1","click":"137.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.94","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.23","showRate":"0.75","charge":"66.00","pv":"70","cpc":"0.48","recBid":"1.65","show":"600","rank":"1","click":"137.00"},"competition":"9","bid":"1.4","word":"山东名酒白酒排行榜","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.15","showRate":"1","charge":"4.00","pv":"15","cpc":"0.27","recBid":"0.86","show":"100","rank":"1","click":"15.00"},"pc":{"ctr":"0.15","showRate":"1","charge":"4.00","pv":"2","cpc":"0.27","recBid":"0.73","show":"100","rank":"1","click":"15.00"},"matchType":"4","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"13","cpc":"0","recBid":"0.86","show":"0","rank":"0","click":"0"},"competition":"9","bid":"2.17","word":"收藏白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"0.81","charge":"75.00","pv":"58","cpc":"0.72","recBid":"0.97","show":"900","rank":"1","click":"104.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.63","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.12","showRate":"0.81","charge":"75.00","pv":"56","cpc":"0.72","recBid":"0.97","show":"900","rank":"1","click":"104.00"},"competition":"8","bid":"3.69","word":"白酒厂","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.27","showRate":"1","charge":"7.00","pv":"39","cpc":"0.25","recBid":"1.41","show":"100","rank":"2","click":"28.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"0.66","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.27","showRate":"1","charge":"7.00","pv":"38","cpc":"0.25","recBid":"1.41","show":"100","rank":"2","click":"28.00"},"competition":"7","bid":"2.07","word":"山东白酒排名","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"0.75","charge":"48.00","pv":"18","cpc":"0.66","recBid":"1.49","show":"600","rank":"1","click":"73.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.49","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.12","showRate":"0.75","charge":"48.00","pv":"17","cpc":"0.66","recBid":"1.12","show":"600","rank":"1","click":"73.00"},"competition":"8","bid":"1.51","word":"白酒酱香型","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"1","charge":"19.00","pv":"36","cpc":"0.44","recBid":"0.9","show":"200","rank":"1","click":"43.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"3","cpc":"0","recBid":"0.51","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.22","showRate":"1","charge":"19.00","pv":"33","cpc":"0.44","recBid":"0.9","show":"200","rank":"1","click":"43.00"},"competition":"9","bid":"9.66","word":"白酒分酒器","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"1","charge":"16.00","pv":"36","cpc":"0.36","recBid":"2.39","show":"200","rank":"1","click":"44.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"2.39","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.22","showRate":"1","charge":"16.00","pv":"33","cpc":"0.36","recBid":"1.3","show":"200","rank":"1","click":"44.00"},"competition":"10","bid":"2.72","word":"白酒回收价格表","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.16","showRate":"1","charge":"15.00","pv":"80","cpc":"0.93","recBid":"1.66","show":"100","rank":"1","click":"16.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"6","cpc":"0","recBid":"0.46","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.16","showRate":"1","charge":"15.00","pv":"74","cpc":"0.93","recBid":"1.66","show":"100","rank":"1","click":"16.00"},"competition":"7","bid":"4.22","word":"白酒瓶盖","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.17","showRate":"1","charge":"11.00","pv":"1","cpc":"0.67","recBid":"1.48","show":"100","rank":"1","click":"16.00"},"pc":{"ctr":"0.17","showRate":"1","charge":"11.00","pv":"0","cpc":"0.67","recBid":"0.78","show":"100","rank":"1","click":"16.00"},"matchType":"3","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"1.48","show":"0","rank":"0","click":"0"},"competition":"11","bid":"2.43","word":"白酒哪家好","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.29","showRate":"1","charge":"42.00","pv":"23","cpc":"0.35","recBid":"2.39","show":"400","rank":"1","click":"119.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"2.39","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.29","showRate":"1","charge":"42.00","pv":"21","cpc":"0.35","recBid":"1.33","show":"400","rank":"1","click":"119.00"},"competition":"10","bid":"1.1","word":"十大酱香型白酒排名","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.26","showRate":"1","charge":"13.00","pv":"30","cpc":"0.49","recBid":"1","show":"100","rank":"1","click":"26.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.35","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.26","showRate":"1","charge":"13.00","pv":"28","cpc":"0.49","recBid":"1","show":"100","rank":"1","click":"26.00"},"competition":"9","bid":"1.72","word":"浓香型白酒有哪些","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.1","showRate":"0.91","charge":"7433.00","pv":"1890","cpc":"1.14","recBid":"1.47","show":"66300","rank":"1","click":"6541.00"},"pc":{"ctr":"0.39","showRate":"1","charge":"436.00","pv":"29","cpc":"0.56","recBid":"1.47","show":"2000","rank":"1","click":"783.00"},"matchType":"4","mobile":{"ctr":"0.09","showRate":"0.91","charge":"6997.00","pv":"1861","cpc":"1.22","recBid":"1.47","show":"64300","rank":"1","click":"5758.00"},"competition":"18","bid":"2.61","word":"酿酒白酒设备","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.28","showRate":"1","charge":"1256.00","pv":"372","cpc":"0.4","recBid":"1.46","show":"11100","rank":"1","click":"3110.0"},"pc":{"ctr":"0.14","showRate":"1","charge":"28.00","pv":"36","cpc":"0.4","recBid":"0.7","show":"500","rank":"1","click":"69.00"},"matchType":"3","mobile":{"ctr":"0.28","showRate":"1","charge":"1228.00","pv":"336","cpc":"0.4","recBid":"1.46","show":"10600","rank":"1","click":"3041.00"},"competition":"9","bid":"3.19","word":"白酒排名","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.06","showRate":"1","charge":"5.00","pv":"43","cpc":"0.92","recBid":"0.79","show":"100","rank":"1","click":"5.00"},"pc":{"ctr":"0.06","showRate":"1","charge":"5.00","pv":"17","cpc":"0.92","recBid":"0.3","show":"100","rank":"1","click":"5.00"},"matchType":"5","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"25","cpc":"0","recBid":"0.79","show":"0","rank":"0","click":"0"},"competition":"7","bid":"10.44","word":"白酒吧","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.29","showRate":"1","charge":"23.00","pv":"21","cpc":"0.26","recBid":"0.93","show":"300","rank":"1","click":"89.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.29","showRate":"1","charge":"23.00","pv":"21","cpc":"0.26","recBid":"0.93","show":"300","rank":"1","click":"89.00"},"competition":"8","bid":"1.15","word":"佳裕高粱白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.13","showRate":"0.91","charge":"5114.00","pv":"1054","cpc":"0.91","recBid":"2.06","show":"43000","rank":"1","click":"5603.00"},"pc":{"ctr":"0.2","showRate":"0.81","charge":"119.00","pv":"54","cpc":"0.69","recBid":"0.82","show":"900","rank":"1","click":"173.00"},"matchType":"5","mobile":{"ctr":"0.13","showRate":"0.91","charge":"4995.00","pv":"1000","cpc":"0.92","recBid":"2.06","show":"42100","rank":"1","click":"5430.0"},"competition":"11","bid":"2.93","word":"白酒品牌","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.2","showRate":"1","charge":"27.00","pv":"58","cpc":"0.7","recBid":"0.92","show":"200","rank":"1","click":"38.00"},"pc":{"ctr":"0.22","showRate":"1","charge":"20.0","pv":"6","cpc":"0.91","recBid":"0.41","show":"100","rank":"1","click":"22.00"},"matchType":"3","mobile":{"ctr":"0.17","showRate":"1","charge":"7.00","pv":"52","cpc":"0.43","recBid":"0.92","show":"100","rank":"1","click":"16.00"},"competition":"9","bid":"2.79","word":"山东白酒","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"0.97","charge":"46256.00","pv":"6","cpc":"0.46","recBid":"1.51","show":"473000","rank":"1","click":"100912.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.65","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.22","showRate":"0.97","charge":"46256.00","pv":"3","cpc":"0.46","recBid":"1.51","show":"473000","rank":"1","click":"100912.00"},"competition":"5","bid":"1.82","word":"酒类价格","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"1","charge":"118.00","pv":"155","cpc":"1.21","recBid":"1.57","show":"800","rank":"1","click":"98.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"73.00","pv":"15","cpc":"1.22","recBid":"0.92","show":"300","rank":"1","click":"60.0"},"matchType":"4","mobile":{"ctr":"0.08","showRate":"1","charge":"45.00","pv":"140","cpc":"1.19","recBid":"1.57","show":"500","rank":"1","click":"38.00"},"competition":"8","bid":"6.94","word":"白酒价格","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.33","showRate":"1","charge":"168.00","pv":"1958","cpc":"0.42","recBid":"2.1","show":"1200","rank":"1","click":"402.00"},"pc":{"ctr":"0.35","showRate":"1","charge":"115.00","pv":"19","cpc":"0.41","recBid":"0.98","show":"800","rank":"1","click":"280.0"},"matchType":"3","mobile":{"ctr":"0.3","showRate":"1","charge":"53.00","pv":"1939","cpc":"0.43","recBid":"2.1","show":"400","rank":"1","click":"122.00"},"competition":"3","bid":"3.45","word":"酱香型白酒有哪些","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.17","showRate":"0.93","charge":"3079.00","pv":"1366","cpc":"0.63","recBid":"1.36","show":"29400","rank":"1","click":"4863.00"},"pc":{"ctr":"0.2","showRate":"0.96","charge":"467.00","pv":"136","cpc":"0.48","recBid":"0.58","show":"5000","rank":"1","click":"965.00"},"matchType":"4","mobile":{"ctr":"0.16","showRate":"0.92","charge":"2612.00","pv":"1230","cpc":"0.67","recBid":"1.36","show":"24400","rank":"1","click":"3898.00"},"competition":"9","bid":"2.4","word":"酱香型白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.34","showRate":"0.96","charge":"295.00","pv":"76","cpc":"0.39","recBid":"2.25","show":"2200","rank":"1","click":"755.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.34","showRate":"0.96","charge":"295.00","pv":"76","cpc":"0.39","recBid":"2.25","show":"2200","rank":"1","click":"755.00"},"competition":"10","bid":"1.43","word":"仁酒53度酱香型白酒价格","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.18","showRate":"0.75","charge":"34.00","pv":"40","cpc":"0.32","recBid":"1.79","show":"600","rank":"1","click":"106.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.18","showRate":"0.75","charge":"34.00","pv":"39","cpc":"0.32","recBid":"1.79","show":"600","rank":"1","click":"106.00"},"competition":"10","bid":"0.89","word":"河北名酒白酒排行榜","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.09","showRate":"1","charge":"4.00","pv":"4","cpc":"0.48","recBid":"1.38","show":"100","rank":"1","click":"8.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.9","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.09","showRate":"1","charge":"4.00","pv":"3","cpc":"0.48","recBid":"1.38","show":"100","rank":"1","click":"8.00"},"competition":"8","bid":"6.99","word":"什么白酒比较好","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.28","showRate":"1","charge":"3492.00","pv":"219","cpc":"0.9","recBid":"2.38","show":"13800","rank":"1","click":"3873.00"},"pc":{"ctr":"0.38","showRate":"1","charge":"23.00","pv":"4","cpc":"0.3","recBid":"0.3","show":"200","rank":"1","click":"77.00"},"matchType":"3","mobile":{"ctr":"0.27","showRate":"1","charge":"3469.00","pv":"214","cpc":"0.91","recBid":"2.38","show":"13600","rank":"1","click":"3796.00"},"competition":"7","bid":"5.78","word":"酱香白酒有哪些","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.16","showRate":"0.74","charge":"207.00","pv":"104","cpc":"0.79","recBid":"1.39","show":"1700","rank":"1","click":"261.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"179.00","pv":"23","cpc":"0.78","recBid":"1.27","show":"1200","rank":"1","click":"230.0"},"matchType":"4","mobile":{"ctr":"0.06","showRate":"0.45","charge":"28.00","pv":"80","cpc":"0.91","recBid":"1.39","show":"500","rank":"1","click":"31.00"},"competition":"10","bid":"2.58","word":"白酒厂家","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.37","showRate":"1","charge":"15.00","pv":"42","cpc":"0.4","recBid":"0.92","show":"100","rank":"1","click":"37.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"0.31","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.37","showRate":"1","charge":"15.00","pv":"41","cpc":"0.4","recBid":"0.92","show":"100","rank":"1","click":"37.00"},"competition":"9","bid":"1.42","word":"清香型白酒排名","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.15","showRate":"0.76","charge":"129.00","pv":"73","cpc":"0.91","recBid":"1.16","show":"1000","rank":"1","click":"142.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"95.00","pv":"7","cpc":"0.96","recBid":"0.3","show":"500","rank":"1","click":"99.00"},"matchType":"5","mobile":{"ctr":"0.09","showRate":"0.63","charge":"34.00","pv":"65","cpc":"0.78","recBid":"1.16","show":"500","rank":"1","click":"43.00"},"competition":"9","bid":"2.27","word":"四川白酒","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.11","showRate":"0.94","charge":"8134.00","pv":"831","cpc":"2.85","recBid":"2.28","show":"26200","rank":"1","click":"2858.00"},"pc":{"ctr":"0.28","showRate":"0.93","charge":"4588.00","pv":"59","cpc":"2.98","recBid":"2.28","show":"5400","rank":"1","click":"1539.00"},"matchType":"5","mobile":{"ctr":"0.06","showRate":"0.94","charge":"3546.00","pv":"772","cpc":"2.69","recBid":"1.78","show":"20800","rank":"1","click":"1319.00"},"competition":"8","bid":"14.24","word":"白酒招商","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.14","showRate":"0.91","charge":"385.00","pv":"1093","cpc":"0.66","recBid":"0.99","show":"4200","rank":"1","click":"582.00"},"pc":{"ctr":"0.15","showRate":"0.96","charge":"254.00","pv":"51","cpc":"0.62","recBid":"0.79","show":"2700","rank":"1","click":"407.00"},"matchType":"4","mobile":{"ctr":"0.12","showRate":"0.83","charge":"131.00","pv":"1042","cpc":"0.75","recBid":"0.99","show":"1500","rank":"1","click":"175.00"},"competition":"7","bid":"2.92","word":"酒厂","unit_id":"1","plan_id":"0"}],"plan":[{"total":{"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}},"name":"白酒推广计划"}]}}
     * status : 0
     * info :
     */
    private DataBean data;
    private String status;
    private String info;


    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);

            setStatus(object.getString("object"));
            setInfo(object.getString("info"));
            DataBean dataBean = new DataBean();
            JSONObject data = object.getJSONObject("data");
            dataBean.getData(data);
            setData(dataBean);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public class DataBean {
        /**
         * channel : baidu
         * channel_str : 百度
         * keyword : 白酒
         * plan : {"unit":[{"total":{"all":{"charge":"6576.00","show":"40300.00","click":"10550.00"},"pc":{"charge":"207.00","show":"1900.00","click":"551.00"},"mobile":{"charge":"6369.00","show":"38400.00","click":"9999.00"}},"name":"白酒推广计划-同义","plan_id":"0"},{"total":{"all":{"charge":"11976.00","show":"108100.00","click":"13523.00"},"pc":{"charge":"1592.00","show":"12600.00","click":"2497.00"},"mobile":{"charge":"10384.00","show":"95500.00","click":"11026.00"}},"name":"白酒推广计划-精确","plan_id":"0"},{"total":{"all":{"charge":"66673.00","show":"618300.00","click":"116157.00"},"pc":{"charge":"5094.00","show":"8000.00","click":"2279.00"},"mobile":{"charge":"61579.00","show":"610300.00","click":"113879.00"}},"name":"白酒推广计划-核心","plan_id":"0"}],"total":{"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}},"originality":[{"reason":[],"total":{"all":{"charge":"13.00","show":"100.00","click":"26.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"13.00","show":"100.00","click":"26.00"}},"originality":"喝了这么多年的酒，你知道窖龄酒、年份酒、陈年老酒有哪些区别？","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"目标用户点击热词为什么有钱人都爱喝这个白酒，尝过后，知道真相的我惊呆了！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"15.00"},"pc":{"charge":"4.00","show":"100.00","click":"15.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"爆料：爱喝白酒的人注意了，目标用户点击热词商家不外泄这些真相！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"8134.00","show":"26200.00","click":"2858.00"},"pc":{"charge":"4588.00","show":"5400.00","click":"1539.00"},"mobile":{"charge":"3546.00","show":"20800.00","click":"1319.00"}},"originality":"剑南春等名贵白酒放家里怎么办？目标用户点击热词合肥都知道，这里现款高价回收","unit_id":"2","point":"-","plan_id":"0"},{"reason":["↑17%","热"],"total":{"all":{"charge":"4.00","show":"100.00","click":"8.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"4.00","show":"100.00","click":"8.00"}},"originality":"还在喝勾兑酒吗!地域窖藏老酒,看得见的粮食酒!","unit_id":"2","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"208.00","show":"1600.00","click":"49.00"},"pc":{"charge":"179.00","show":"1300.00","click":"37.00"},"mobile":{"charge":"29.00","show":"300.00","click":"12.00"}},"originality":"茅台镇〔您的品牌〕酒厂直供,目标用户点击热词珍藏老酒整箱特价包邮,只卖精品纯粮酒!","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"66.00","show":"600.00","click":"137.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"66.00","show":"600.00","click":"137.00"}},"originality":"酱香与浓香竟有这么大差异！茅台、五粮液原来是\u201c勾兑\u201d酒？目标用户点击热词年轻人别错过！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5.00","show":"100.00","click":"5.00"},"pc":{"charge":"5.00","show":"100.00","click":"5.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"鹿茸-天然男士滋补必备，白酒泡鹿茸，快乐大半宿，目标用户点击热词#{地域}订购3折","unit_id":"2","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1256.00","show":"11100.00","click":"3110.00"},"pc":{"charge":"28.00","show":"500.00","click":"69.00"},"mobile":{"charge":"1228.00","show":"10600.00","click":"3041.00"}},"originality":"白酒巨擘赖永初续写白酒传奇，70年坚持古法酿造，目标用户点击热词酱香醇厚！","unit_id":"0","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"7.00","show":"100.00","click":"28.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"7.00","show":"100.00","click":"28.00"}},"originality":"茅台镇陈年酒,双节钜惠199,免费试饮,目标用户点击热词免费包邮!","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"34.00","show":"600.00","click":"106.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"34.00","show":"600.00","click":"106.00"}},"originality":"茅台镇正宗酱香型白酒，目标用户点击热词限时买一送一","unit_id":"0","point":"便宜;食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"6905.00","show":"73500.00","click":"6339.00"},"pc":{"charge":"287.00","show":"1100.00","click":"463.00"},"mobile":{"charge":"6618.00","show":"72400.00","click":"5877.00"}},"originality":"好消息！这是某短视频火的目标用户点击热词一款酱香白酒","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"46256.00","show":"473000.00","click":"100912.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"46256.00","show":"473000.00","click":"100912.00"}},"originality":"每天一小杯白酒，身体目标用户点击热词竟有明显变化！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"75.00","show":"900.00","click":"104.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"75.00","show":"900.00","click":"104.00"}},"originality":"农村养猪+酿酒，教全套技术，指导建厂，白酒需求大，目标用户点击热词销路广","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"15.00"},"pc":{"charge":"4.00","show":"100.00","click":"15.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"为什么那么多人喜欢这款白酒？看目标用户点击热词过之后你就明白了","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"16.00","show":"200.00","click":"44.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"16.00","show":"200.00","click":"44.00"}},"originality":"好消息！五粮液公司突然推出8斤装超大坛特价珍藏酒 2大坛只要几百元。","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"23.00","show":"300.00","click":"89.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"23.00","show":"300.00","click":"89.00"}},"originality":"通知：爱喝酒的同志们，目标用户点击热词白酒泡鹿鞭，逍遥每一天了，抢购请点击!","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"118.00","show":"800.00","click":"98.00"},"pc":{"charge":"73.00","show":"300.00","click":"60.00"},"mobile":{"charge":"45.00","show":"500.00","click":"38.00"}},"originality":"目标用户点击热词我们只卖品质粮食酒！窖藏年份酒","unit_id":"1","point":"美食推荐;食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"8.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"4.00","show":"100.00","click":"8.00"}},"originality":"年份原浆和普通白酒的区别?会喝酒的目标用户点击热词人才知道！","unit_id":"2","point":"食品质量保障","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"48.00","show":"600.00","click":"73.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"48.00","show":"600.00","click":"73.00"}},"originality":"爱喝酒的你这酒不能错过!地域纯粮老酒 现买三送三 数量有限!","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"34.00","show":"600.00","click":"106.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"34.00","show":"600.00","click":"106.00"}},"originality":"闯王酒业 酒厂直批原浆酒 白酒批发 诚信相邀 共谋发展 目标用户点击热词浓香型白酒批发加盟","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"3492.00","show":"13800.00","click":"3873.00"},"pc":{"charge":"23.00","show":"200.00","click":"77.00"},"mobile":{"charge":"3469.00","show":"13600.00","click":"3796.00"}},"originality":"茅台镇特制3斤豪华原浆酒紧急抢购！99元 只剩一天!","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"385.00","show":"4200.00","click":"582.00"},"pc":{"charge":"254.00","show":"2700.00","click":"407.00"},"mobile":{"charge":"131.00","show":"1500.00","click":"175.00"}},"originality":"几十目标用户点击热词元的白酒和几百元的白酒差距到底在哪里？看完长知识了！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"15.00","show":"100.00","click":"16.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"15.00","show":"100.00","click":"16.00"}},"originality":"地域特卖,汾酒清香型白酒,今日特价!目标用户点击热词错过等一年!","unit_id":"0","point":"美食推荐","plan_id":"0"},{"reason":["↑27%","热"],"total":{"all":{"charge":"168.00","show":"1200.00","click":"402.00"},"pc":{"charge":"115.00","show":"800.00","click":"280.00"},"mobile":{"charge":"53.00","show":"400.00","click":"122.00"}},"originality":"茅台镇酒厂三十年酒师酿的酒，让你品尝到原滋原味的酱香甘醇！","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑46%"],"total":{"all":{"charge":"5.00","show":"100.00","click":"5.00"},"pc":{"charge":"5.00","show":"100.00","click":"5.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"囤酒季、底价买名酒！699元4箱珍藏汾酒 只限日期!","unit_id":"2","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"143.00","show":"800.00","click":"96.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"143.00","show":"800.00","click":"96.00"}},"originality":"茅台集团52度原浆酒，纯粮酿造！自饮放心，送礼有面！日期能省600元！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"129.00","show":"1000.00","click":"142.00"},"pc":{"charge":"95.00","show":"500.00","click":"99.00"},"mobile":{"charge":"34.00","show":"500.00","click":"43.00"}},"originality":"日产白酒200斤酿酒设备！目标用户点击热词仅售3000元！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"27.00","show":"200.00","click":"38.00"},"pc":{"charge":"20.00","show":"100.00","click":"22.00"},"mobile":{"charge":"7.00","show":"100.00","click":"16.00"}},"originality":"五粮液、洋河、老白干酒、青青稞酒、伊力特前三季度成绩单出炉！","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"385.00","show":"4200.00","click":"582.00"},"pc":{"charge":"254.00","show":"2700.00","click":"407.00"},"mobile":{"charge":"131.00","show":"1500.00","click":"175.00"}},"originality":"几十块和几百块的白酒有目标用户点击热词啥不一样？原来是这样","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"19.00","show":"200.00","click":"43.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"19.00","show":"200.00","click":"43.00"}},"originality":"好酒献给懂酒的你!地域传承经典 53度酱香老酒 速来 其他人都不知道!","unit_id":"0","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"42.00","show":"400.00","click":"119.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"42.00","show":"400.00","click":"119.00"}},"originality":"正宗〔您的品牌〕原浆酒，目标用户点击热词一箱只要199！","unit_id":"2","point":"-","plan_id":"0"},{"name":"白酒推广计划"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"别犹豫，真的值，酱香型白酒，目标用户点击热词卖完为止","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"27.00","show":"200.00","click":"38.00"},"pc":{"charge":"20.00","show":"100.00","click":"22.00"},"mobile":{"charge":"7.00","show":"100.00","click":"16.00"}},"originality":"震惊！你还给好友喝勾兑白酒？这款纯粮白酒，目标用户点击热词正宗！","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"15.00","show":"100.00","click":"37.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"15.00","show":"100.00","click":"37.00"}},"originality":"想存几箱白酒,几年后再喝，目标用户点击热词什么酒值得收藏？","unit_id":"1","point":"美食推荐","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"295.00","show":"2200.00","click":"755.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"295.00","show":"2200.00","click":"755.00"}},"originality":"目标用户点击热词好喝的茅台镇酒竟不贵？酒姑娘揭秘酿酒六大细节","unit_id":"1","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"168.00","show":"1200.00","click":"402.00"},"pc":{"charge":"115.00","show":"800.00","click":"280.00"},"mobile":{"charge":"53.00","show":"400.00","click":"122.00"}},"originality":"窖龄酒、年份酒、陈年老酒等等看上去都是老酒，到底啥区别？","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"谁说百元内喝不到好酒，这些酒可以媲美那些上千元的酒！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"48.00","show":"600.00","click":"73.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"48.00","show":"600.00","click":"73.00"}},"originality":"酱香白酒一直很贵，仅限日期特价，目标用户点击热词卖完为止！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1256.00","show":"11100.00","click":"3110.00"},"pc":{"charge":"28.00","show":"500.00","click":"69.00"},"mobile":{"charge":"1228.00","show":"10600.00","click":"3041.00"}},"originality":"年份酒、窖龄酒、新酒与老酒、陈年老酒有什么区别？","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑111%","热"],"total":{"all":{"charge":"3079.00","show":"29400.00","click":"4863.00"},"pc":{"charge":"467.00","show":"5000.00","click":"965.00"},"mobile":{"charge":"2612.00","show":"24400.00","click":"3898.00"}},"originality":"杜康名酒酒厂直供迎端午低至38元！限日期!","unit_id":"1","point":"-","plan_id":"0"},{"reason":["↑24%"],"total":{"all":{"charge":"19.00","show":"200.00","click":"43.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"19.00","show":"200.00","click":"43.00"}},"originality":"[今天福利]不敢相信、正宗汾酒集团收藏酒居然只要这个价！还包邮","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑58%","热"],"total":{"all":{"charge":"11.00","show":"100.00","click":"16.00"},"pc":{"charge":"11.00","show":"100.00","click":"16.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"最后一波！五粮液地域酒厂生产:一瓶低至47元,就要喝有档次的酒","unit_id":"0","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1479.00","show":"12100.00","click":"2842.00"},"pc":{"charge":"10.00","show":"200.00","click":"87.00"},"mobile":{"charge":"1469.00","show":"11900.00","click":"2755.00"}},"originality":"如果经济允许，建议喝目标用户点击热词这款白酒，纯粮食酿造，不伤身体！假一罚万","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"7.00","show":"100.00","click":"28.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"7.00","show":"100.00","click":"28.00"}},"originality":"\u201c便宜\u201d等不了，抢购要趁早！目标用户点击热词窖藏酒白酒","unit_id":"2","point":"便宜;美食推荐","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"7433.00","show":"66300.00","click":"6541.00"},"pc":{"charge":"436.00","show":"2000.00","click":"783.00"},"mobile":{"charge":"6997.00","show":"64300.00","click":"5758.00"}},"originality":"汾酒白酒,给你厂价！好喝！目标用户点击热词货到付款！","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"118.00","show":"800.00","click":"98.00"},"pc":{"charge":"73.00","show":"300.00","click":"60.00"},"mobile":{"charge":"45.00","show":"500.00","click":"38.00"}},"originality":"多年陈酿 只为一瓶好酒!地域窖藏原浆酒!保真,点此了解详情!","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"207.00","show":"1700.00","click":"261.00"},"pc":{"charge":"179.00","show":"1200.00","click":"230.00"},"mobile":{"charge":"28.00","show":"500.00","click":"31.00"}},"originality":"目标用户点击热词如果说白酒哪款好，建议经典酱香百年大福！纯粮无勾兑!","unit_id":"1","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"207.00","show":"1700.00","click":"261.00"},"pc":{"charge":"179.00","show":"1200.00","click":"230.00"},"mobile":{"charge":"28.00","show":"500.00","click":"31.00"}},"originality":"一瓶酒卖了好几千，是以前家里的留的老酒，庆哥酒水专业收酒！","unit_id":"1","point":"-","plan_id":"0"}],"keyword":[{"all":{"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"46","cpc":"1.49","recBid":"1.56","show":"800","rank":"1","click":"96.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.56","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"44","cpc":"1.49","recBid":"1.52","show":"800","rank":"1","click":"96.00"},"competition":"8","bid":"7.71","word":"白酒批发市场","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.03","showRate":"0.8","charge":"208.00","pv":"27","cpc":"4.26","recBid":"1.22","show":"1600","rank":"1","click":"49.00"},"pc":{"ctr":"0.03","showRate":"0.86","charge":"179.00","pv":"7","cpc":"4.85","recBid":"0.81","show":"1300","rank":"1","click":"37.00"},"matchType":"4","mobile":{"ctr":"0.04","showRate":"0.6","charge":"29.00","pv":"20","cpc":"2.44","recBid":"1.22","show":"300","rank":"1","click":"12.00"},"competition":"8","bid":"6.36","word":"品牌白酒代理加盟","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.09","showRate":"0.89","charge":"6905.00","pv":"1183","cpc":"1.09","recBid":"7.67","show":"73500","rank":"1","click":"6339.00"},"pc":{"ctr":"0.42","showRate":"1","charge":"287.00","pv":"18","cpc":"0.62","recBid":"7.67","show":"1100","rank":"1","click":"463.00"},"matchType":"5","mobile":{"ctr":"0.08","showRate":"0.89","charge":"6618.00","pv":"1164","cpc":"1.13","recBid":"1.37","show":"72400","rank":"1","click":"5877.00"},"competition":"18","bid":"2.84","word":"酿酒设备白酒","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.24","showRate":"1","charge":"1479.00","pv":"446","cpc":"0.52","recBid":"1.17","show":"12100","rank":"1","click":"2842.00"},"pc":{"ctr":"0.43","showRate":"1","charge":"10.0","pv":"23","cpc":"0.12","recBid":"0.58","show":"200","rank":"1","click":"87.00"},"matchType":"3","mobile":{"ctr":"0.24","showRate":"1","charge":"1469.00","pv":"423","cpc":"0.53","recBid":"1.17","show":"11900","rank":"1","click":"2755.00"},"competition":"9","bid":"4.45","word":"中国白酒排名","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.23","showRate":"0.75","charge":"66.00","pv":"72","cpc":"0.48","recBid":"1.65","show":"600","rank":"1","click":"137.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.94","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.23","showRate":"0.75","charge":"66.00","pv":"70","cpc":"0.48","recBid":"1.65","show":"600","rank":"1","click":"137.00"},"competition":"9","bid":"1.4","word":"山东名酒白酒排行榜","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.15","showRate":"1","charge":"4.00","pv":"15","cpc":"0.27","recBid":"0.86","show":"100","rank":"1","click":"15.00"},"pc":{"ctr":"0.15","showRate":"1","charge":"4.00","pv":"2","cpc":"0.27","recBid":"0.73","show":"100","rank":"1","click":"15.00"},"matchType":"4","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"13","cpc":"0","recBid":"0.86","show":"0","rank":"0","click":"0"},"competition":"9","bid":"2.17","word":"收藏白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"0.81","charge":"75.00","pv":"58","cpc":"0.72","recBid":"0.97","show":"900","rank":"1","click":"104.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.63","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.12","showRate":"0.81","charge":"75.00","pv":"56","cpc":"0.72","recBid":"0.97","show":"900","rank":"1","click":"104.00"},"competition":"8","bid":"3.69","word":"白酒厂","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.27","showRate":"1","charge":"7.00","pv":"39","cpc":"0.25","recBid":"1.41","show":"100","rank":"2","click":"28.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"0.66","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.27","showRate":"1","charge":"7.00","pv":"38","cpc":"0.25","recBid":"1.41","show":"100","rank":"2","click":"28.00"},"competition":"7","bid":"2.07","word":"山东白酒排名","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"0.75","charge":"48.00","pv":"18","cpc":"0.66","recBid":"1.49","show":"600","rank":"1","click":"73.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.49","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.12","showRate":"0.75","charge":"48.00","pv":"17","cpc":"0.66","recBid":"1.12","show":"600","rank":"1","click":"73.00"},"competition":"8","bid":"1.51","word":"白酒酱香型","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"1","charge":"19.00","pv":"36","cpc":"0.44","recBid":"0.9","show":"200","rank":"1","click":"43.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"3","cpc":"0","recBid":"0.51","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.22","showRate":"1","charge":"19.00","pv":"33","cpc":"0.44","recBid":"0.9","show":"200","rank":"1","click":"43.00"},"competition":"9","bid":"9.66","word":"白酒分酒器","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"1","charge":"16.00","pv":"36","cpc":"0.36","recBid":"2.39","show":"200","rank":"1","click":"44.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"2.39","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.22","showRate":"1","charge":"16.00","pv":"33","cpc":"0.36","recBid":"1.3","show":"200","rank":"1","click":"44.00"},"competition":"10","bid":"2.72","word":"白酒回收价格表","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.16","showRate":"1","charge":"15.00","pv":"80","cpc":"0.93","recBid":"1.66","show":"100","rank":"1","click":"16.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"6","cpc":"0","recBid":"0.46","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.16","showRate":"1","charge":"15.00","pv":"74","cpc":"0.93","recBid":"1.66","show":"100","rank":"1","click":"16.00"},"competition":"7","bid":"4.22","word":"白酒瓶盖","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.17","showRate":"1","charge":"11.00","pv":"1","cpc":"0.67","recBid":"1.48","show":"100","rank":"1","click":"16.00"},"pc":{"ctr":"0.17","showRate":"1","charge":"11.00","pv":"0","cpc":"0.67","recBid":"0.78","show":"100","rank":"1","click":"16.00"},"matchType":"3","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"1.48","show":"0","rank":"0","click":"0"},"competition":"11","bid":"2.43","word":"白酒哪家好","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.29","showRate":"1","charge":"42.00","pv":"23","cpc":"0.35","recBid":"2.39","show":"400","rank":"1","click":"119.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"2.39","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.29","showRate":"1","charge":"42.00","pv":"21","cpc":"0.35","recBid":"1.33","show":"400","rank":"1","click":"119.00"},"competition":"10","bid":"1.1","word":"十大酱香型白酒排名","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.26","showRate":"1","charge":"13.00","pv":"30","cpc":"0.49","recBid":"1","show":"100","rank":"1","click":"26.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.35","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.26","showRate":"1","charge":"13.00","pv":"28","cpc":"0.49","recBid":"1","show":"100","rank":"1","click":"26.00"},"competition":"9","bid":"1.72","word":"浓香型白酒有哪些","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.1","showRate":"0.91","charge":"7433.00","pv":"1890","cpc":"1.14","recBid":"1.47","show":"66300","rank":"1","click":"6541.00"},"pc":{"ctr":"0.39","showRate":"1","charge":"436.00","pv":"29","cpc":"0.56","recBid":"1.47","show":"2000","rank":"1","click":"783.00"},"matchType":"4","mobile":{"ctr":"0.09","showRate":"0.91","charge":"6997.00","pv":"1861","cpc":"1.22","recBid":"1.47","show":"64300","rank":"1","click":"5758.00"},"competition":"18","bid":"2.61","word":"酿酒白酒设备","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.28","showRate":"1","charge":"1256.00","pv":"372","cpc":"0.4","recBid":"1.46","show":"11100","rank":"1","click":"3110.0"},"pc":{"ctr":"0.14","showRate":"1","charge":"28.00","pv":"36","cpc":"0.4","recBid":"0.7","show":"500","rank":"1","click":"69.00"},"matchType":"3","mobile":{"ctr":"0.28","showRate":"1","charge":"1228.00","pv":"336","cpc":"0.4","recBid":"1.46","show":"10600","rank":"1","click":"3041.00"},"competition":"9","bid":"3.19","word":"白酒排名","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.06","showRate":"1","charge":"5.00","pv":"43","cpc":"0.92","recBid":"0.79","show":"100","rank":"1","click":"5.00"},"pc":{"ctr":"0.06","showRate":"1","charge":"5.00","pv":"17","cpc":"0.92","recBid":"0.3","show":"100","rank":"1","click":"5.00"},"matchType":"5","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"25","cpc":"0","recBid":"0.79","show":"0","rank":"0","click":"0"},"competition":"7","bid":"10.44","word":"白酒吧","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.29","showRate":"1","charge":"23.00","pv":"21","cpc":"0.26","recBid":"0.93","show":"300","rank":"1","click":"89.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.29","showRate":"1","charge":"23.00","pv":"21","cpc":"0.26","recBid":"0.93","show":"300","rank":"1","click":"89.00"},"competition":"8","bid":"1.15","word":"佳裕高粱白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.13","showRate":"0.91","charge":"5114.00","pv":"1054","cpc":"0.91","recBid":"2.06","show":"43000","rank":"1","click":"5603.00"},"pc":{"ctr":"0.2","showRate":"0.81","charge":"119.00","pv":"54","cpc":"0.69","recBid":"0.82","show":"900","rank":"1","click":"173.00"},"matchType":"5","mobile":{"ctr":"0.13","showRate":"0.91","charge":"4995.00","pv":"1000","cpc":"0.92","recBid":"2.06","show":"42100","rank":"1","click":"5430.0"},"competition":"11","bid":"2.93","word":"白酒品牌","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.2","showRate":"1","charge":"27.00","pv":"58","cpc":"0.7","recBid":"0.92","show":"200","rank":"1","click":"38.00"},"pc":{"ctr":"0.22","showRate":"1","charge":"20.0","pv":"6","cpc":"0.91","recBid":"0.41","show":"100","rank":"1","click":"22.00"},"matchType":"3","mobile":{"ctr":"0.17","showRate":"1","charge":"7.00","pv":"52","cpc":"0.43","recBid":"0.92","show":"100","rank":"1","click":"16.00"},"competition":"9","bid":"2.79","word":"山东白酒","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"0.97","charge":"46256.00","pv":"6","cpc":"0.46","recBid":"1.51","show":"473000","rank":"1","click":"100912.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.65","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.22","showRate":"0.97","charge":"46256.00","pv":"3","cpc":"0.46","recBid":"1.51","show":"473000","rank":"1","click":"100912.00"},"competition":"5","bid":"1.82","word":"酒类价格","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"1","charge":"118.00","pv":"155","cpc":"1.21","recBid":"1.57","show":"800","rank":"1","click":"98.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"73.00","pv":"15","cpc":"1.22","recBid":"0.92","show":"300","rank":"1","click":"60.0"},"matchType":"4","mobile":{"ctr":"0.08","showRate":"1","charge":"45.00","pv":"140","cpc":"1.19","recBid":"1.57","show":"500","rank":"1","click":"38.00"},"competition":"8","bid":"6.94","word":"白酒价格","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.33","showRate":"1","charge":"168.00","pv":"1958","cpc":"0.42","recBid":"2.1","show":"1200","rank":"1","click":"402.00"},"pc":{"ctr":"0.35","showRate":"1","charge":"115.00","pv":"19","cpc":"0.41","recBid":"0.98","show":"800","rank":"1","click":"280.0"},"matchType":"3","mobile":{"ctr":"0.3","showRate":"1","charge":"53.00","pv":"1939","cpc":"0.43","recBid":"2.1","show":"400","rank":"1","click":"122.00"},"competition":"3","bid":"3.45","word":"酱香型白酒有哪些","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.17","showRate":"0.93","charge":"3079.00","pv":"1366","cpc":"0.63","recBid":"1.36","show":"29400","rank":"1","click":"4863.00"},"pc":{"ctr":"0.2","showRate":"0.96","charge":"467.00","pv":"136","cpc":"0.48","recBid":"0.58","show":"5000","rank":"1","click":"965.00"},"matchType":"4","mobile":{"ctr":"0.16","showRate":"0.92","charge":"2612.00","pv":"1230","cpc":"0.67","recBid":"1.36","show":"24400","rank":"1","click":"3898.00"},"competition":"9","bid":"2.4","word":"酱香型白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.34","showRate":"0.96","charge":"295.00","pv":"76","cpc":"0.39","recBid":"2.25","show":"2200","rank":"1","click":"755.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.34","showRate":"0.96","charge":"295.00","pv":"76","cpc":"0.39","recBid":"2.25","show":"2200","rank":"1","click":"755.00"},"competition":"10","bid":"1.43","word":"仁酒53度酱香型白酒价格","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.18","showRate":"0.75","charge":"34.00","pv":"40","cpc":"0.32","recBid":"1.79","show":"600","rank":"1","click":"106.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.18","showRate":"0.75","charge":"34.00","pv":"39","cpc":"0.32","recBid":"1.79","show":"600","rank":"1","click":"106.00"},"competition":"10","bid":"0.89","word":"河北名酒白酒排行榜","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.09","showRate":"1","charge":"4.00","pv":"4","cpc":"0.48","recBid":"1.38","show":"100","rank":"1","click":"8.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.9","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.09","showRate":"1","charge":"4.00","pv":"3","cpc":"0.48","recBid":"1.38","show":"100","rank":"1","click":"8.00"},"competition":"8","bid":"6.99","word":"什么白酒比较好","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.28","showRate":"1","charge":"3492.00","pv":"219","cpc":"0.9","recBid":"2.38","show":"13800","rank":"1","click":"3873.00"},"pc":{"ctr":"0.38","showRate":"1","charge":"23.00","pv":"4","cpc":"0.3","recBid":"0.3","show":"200","rank":"1","click":"77.00"},"matchType":"3","mobile":{"ctr":"0.27","showRate":"1","charge":"3469.00","pv":"214","cpc":"0.91","recBid":"2.38","show":"13600","rank":"1","click":"3796.00"},"competition":"7","bid":"5.78","word":"酱香白酒有哪些","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.16","showRate":"0.74","charge":"207.00","pv":"104","cpc":"0.79","recBid":"1.39","show":"1700","rank":"1","click":"261.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"179.00","pv":"23","cpc":"0.78","recBid":"1.27","show":"1200","rank":"1","click":"230.0"},"matchType":"4","mobile":{"ctr":"0.06","showRate":"0.45","charge":"28.00","pv":"80","cpc":"0.91","recBid":"1.39","show":"500","rank":"1","click":"31.00"},"competition":"10","bid":"2.58","word":"白酒厂家","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.37","showRate":"1","charge":"15.00","pv":"42","cpc":"0.4","recBid":"0.92","show":"100","rank":"1","click":"37.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"0.31","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.37","showRate":"1","charge":"15.00","pv":"41","cpc":"0.4","recBid":"0.92","show":"100","rank":"1","click":"37.00"},"competition":"9","bid":"1.42","word":"清香型白酒排名","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.15","showRate":"0.76","charge":"129.00","pv":"73","cpc":"0.91","recBid":"1.16","show":"1000","rank":"1","click":"142.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"95.00","pv":"7","cpc":"0.96","recBid":"0.3","show":"500","rank":"1","click":"99.00"},"matchType":"5","mobile":{"ctr":"0.09","showRate":"0.63","charge":"34.00","pv":"65","cpc":"0.78","recBid":"1.16","show":"500","rank":"1","click":"43.00"},"competition":"9","bid":"2.27","word":"四川白酒","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.11","showRate":"0.94","charge":"8134.00","pv":"831","cpc":"2.85","recBid":"2.28","show":"26200","rank":"1","click":"2858.00"},"pc":{"ctr":"0.28","showRate":"0.93","charge":"4588.00","pv":"59","cpc":"2.98","recBid":"2.28","show":"5400","rank":"1","click":"1539.00"},"matchType":"5","mobile":{"ctr":"0.06","showRate":"0.94","charge":"3546.00","pv":"772","cpc":"2.69","recBid":"1.78","show":"20800","rank":"1","click":"1319.00"},"competition":"8","bid":"14.24","word":"白酒招商","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.14","showRate":"0.91","charge":"385.00","pv":"1093","cpc":"0.66","recBid":"0.99","show":"4200","rank":"1","click":"582.00"},"pc":{"ctr":"0.15","showRate":"0.96","charge":"254.00","pv":"51","cpc":"0.62","recBid":"0.79","show":"2700","rank":"1","click":"407.00"},"matchType":"4","mobile":{"ctr":"0.12","showRate":"0.83","charge":"131.00","pv":"1042","cpc":"0.75","recBid":"0.99","show":"1500","rank":"1","click":"175.00"},"competition":"7","bid":"2.92","word":"酒厂","unit_id":"1","plan_id":"0"}],"plan":[{"total":{"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}},"name":"白酒推广计划"}]}
         */
        private String channel;
        private String channel_str;
        private String keyword;
        private PlanBean plan;

        public void getData(JSONObject object) {

            try {
                setChannel(object.getString("channel"));
                setChannel_str(object.getString("channel_str"));
                setKeyword(object.getString("keyword"));
                JSONObject plan = object.getJSONObject("plan");
                PlanBean planBean = new PlanBean();
                planBean.getData(plan);
                setPlan(planBean);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        public void setChannel(String channel) {
            this.channel = channel;
        }

        public void setChannel_str(String channel_str) {
            this.channel_str = channel_str;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public void setPlan(PlanBean plan) {
            this.plan = plan;
        }

        public String getChannel() {
            return channel;
        }

        public String getChannel_str() {
            return channel_str;
        }

        public String getKeyword() {
            return keyword;
        }

        public PlanBean getPlan() {
            return plan;
        }


        public class PlanBean {
            /**
             * unit : [{"total":{"all":{"charge":"6576.00","show":"40300.00","click":"10550.00"},"pc":{"charge":"207.00","show":"1900.00","click":"551.00"},"mobile":{"charge":"6369.00","show":"38400.00","click":"9999.00"}},"name":"白酒推广计划-同义","plan_id":"0"},{"total":{"all":{"charge":"11976.00","show":"108100.00","click":"13523.00"},"pc":{"charge":"1592.00","show":"12600.00","click":"2497.00"},"mobile":{"charge":"10384.00","show":"95500.00","click":"11026.00"}},"name":"白酒推广计划-精确","plan_id":"0"},{"total":{"all":{"charge":"66673.00","show":"618300.00","click":"116157.00"},"pc":{"charge":"5094.00","show":"8000.00","click":"2279.00"},"mobile":{"charge":"61579.00","show":"610300.00","click":"113879.00"}},"name":"白酒推广计划-核心","plan_id":"0"}]
             * total : {"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}}
             * originality : [{"reason":[],"total":{"all":{"charge":"13.00","show":"100.00","click":"26.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"13.00","show":"100.00","click":"26.00"}},"originality":"喝了这么多年的酒，你知道窖龄酒、年份酒、陈年老酒有哪些区别？","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"目标用户点击热词为什么有钱人都爱喝这个白酒，尝过后，知道真相的我惊呆了！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"15.00"},"pc":{"charge":"4.00","show":"100.00","click":"15.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"爆料：爱喝白酒的人注意了，目标用户点击热词商家不外泄这些真相！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"8134.00","show":"26200.00","click":"2858.00"},"pc":{"charge":"4588.00","show":"5400.00","click":"1539.00"},"mobile":{"charge":"3546.00","show":"20800.00","click":"1319.00"}},"originality":"剑南春等名贵白酒放家里怎么办？目标用户点击热词合肥都知道，这里现款高价回收","unit_id":"2","point":"-","plan_id":"0"},{"reason":["↑17%","热"],"total":{"all":{"charge":"4.00","show":"100.00","click":"8.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"4.00","show":"100.00","click":"8.00"}},"originality":"还在喝勾兑酒吗!地域窖藏老酒,看得见的粮食酒!","unit_id":"2","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"208.00","show":"1600.00","click":"49.00"},"pc":{"charge":"179.00","show":"1300.00","click":"37.00"},"mobile":{"charge":"29.00","show":"300.00","click":"12.00"}},"originality":"茅台镇〔您的品牌〕酒厂直供,目标用户点击热词珍藏老酒整箱特价包邮,只卖精品纯粮酒!","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"66.00","show":"600.00","click":"137.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"66.00","show":"600.00","click":"137.00"}},"originality":"酱香与浓香竟有这么大差异！茅台、五粮液原来是\u201c勾兑\u201d酒？目标用户点击热词年轻人别错过！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5.00","show":"100.00","click":"5.00"},"pc":{"charge":"5.00","show":"100.00","click":"5.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"鹿茸-天然男士滋补必备，白酒泡鹿茸，快乐大半宿，目标用户点击热词#{地域}订购3折","unit_id":"2","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1256.00","show":"11100.00","click":"3110.00"},"pc":{"charge":"28.00","show":"500.00","click":"69.00"},"mobile":{"charge":"1228.00","show":"10600.00","click":"3041.00"}},"originality":"白酒巨擘赖永初续写白酒传奇，70年坚持古法酿造，目标用户点击热词酱香醇厚！","unit_id":"0","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"7.00","show":"100.00","click":"28.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"7.00","show":"100.00","click":"28.00"}},"originality":"茅台镇陈年酒,双节钜惠199,免费试饮,目标用户点击热词免费包邮!","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"34.00","show":"600.00","click":"106.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"34.00","show":"600.00","click":"106.00"}},"originality":"茅台镇正宗酱香型白酒，目标用户点击热词限时买一送一","unit_id":"0","point":"便宜;食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"6905.00","show":"73500.00","click":"6339.00"},"pc":{"charge":"287.00","show":"1100.00","click":"463.00"},"mobile":{"charge":"6618.00","show":"72400.00","click":"5877.00"}},"originality":"好消息！这是某短视频火的目标用户点击热词一款酱香白酒","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"46256.00","show":"473000.00","click":"100912.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"46256.00","show":"473000.00","click":"100912.00"}},"originality":"每天一小杯白酒，身体目标用户点击热词竟有明显变化！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"75.00","show":"900.00","click":"104.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"75.00","show":"900.00","click":"104.00"}},"originality":"农村养猪+酿酒，教全套技术，指导建厂，白酒需求大，目标用户点击热词销路广","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"15.00"},"pc":{"charge":"4.00","show":"100.00","click":"15.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"为什么那么多人喜欢这款白酒？看目标用户点击热词过之后你就明白了","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"16.00","show":"200.00","click":"44.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"16.00","show":"200.00","click":"44.00"}},"originality":"好消息！五粮液公司突然推出8斤装超大坛特价珍藏酒 2大坛只要几百元。","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"23.00","show":"300.00","click":"89.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"23.00","show":"300.00","click":"89.00"}},"originality":"通知：爱喝酒的同志们，目标用户点击热词白酒泡鹿鞭，逍遥每一天了，抢购请点击!","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"118.00","show":"800.00","click":"98.00"},"pc":{"charge":"73.00","show":"300.00","click":"60.00"},"mobile":{"charge":"45.00","show":"500.00","click":"38.00"}},"originality":"目标用户点击热词我们只卖品质粮食酒！窖藏年份酒","unit_id":"1","point":"美食推荐;食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"4.00","show":"100.00","click":"8.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"4.00","show":"100.00","click":"8.00"}},"originality":"年份原浆和普通白酒的区别?会喝酒的目标用户点击热词人才知道！","unit_id":"2","point":"食品质量保障","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"48.00","show":"600.00","click":"73.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"48.00","show":"600.00","click":"73.00"}},"originality":"爱喝酒的你这酒不能错过!地域纯粮老酒 现买三送三 数量有限!","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"34.00","show":"600.00","click":"106.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"34.00","show":"600.00","click":"106.00"}},"originality":"闯王酒业 酒厂直批原浆酒 白酒批发 诚信相邀 共谋发展 目标用户点击热词浓香型白酒批发加盟","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"3492.00","show":"13800.00","click":"3873.00"},"pc":{"charge":"23.00","show":"200.00","click":"77.00"},"mobile":{"charge":"3469.00","show":"13600.00","click":"3796.00"}},"originality":"茅台镇特制3斤豪华原浆酒紧急抢购！99元 只剩一天!","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"385.00","show":"4200.00","click":"582.00"},"pc":{"charge":"254.00","show":"2700.00","click":"407.00"},"mobile":{"charge":"131.00","show":"1500.00","click":"175.00"}},"originality":"几十目标用户点击热词元的白酒和几百元的白酒差距到底在哪里？看完长知识了！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"15.00","show":"100.00","click":"16.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"15.00","show":"100.00","click":"16.00"}},"originality":"地域特卖,汾酒清香型白酒,今日特价!目标用户点击热词错过等一年!","unit_id":"0","point":"美食推荐","plan_id":"0"},{"reason":["↑27%","热"],"total":{"all":{"charge":"168.00","show":"1200.00","click":"402.00"},"pc":{"charge":"115.00","show":"800.00","click":"280.00"},"mobile":{"charge":"53.00","show":"400.00","click":"122.00"}},"originality":"茅台镇酒厂三十年酒师酿的酒，让你品尝到原滋原味的酱香甘醇！","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑46%"],"total":{"all":{"charge":"5.00","show":"100.00","click":"5.00"},"pc":{"charge":"5.00","show":"100.00","click":"5.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"囤酒季、底价买名酒！699元4箱珍藏汾酒 只限日期!","unit_id":"2","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"143.00","show":"800.00","click":"96.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"143.00","show":"800.00","click":"96.00"}},"originality":"茅台集团52度原浆酒，纯粮酿造！自饮放心，送礼有面！日期能省600元！","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"129.00","show":"1000.00","click":"142.00"},"pc":{"charge":"95.00","show":"500.00","click":"99.00"},"mobile":{"charge":"34.00","show":"500.00","click":"43.00"}},"originality":"日产白酒200斤酿酒设备！目标用户点击热词仅售3000元！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"27.00","show":"200.00","click":"38.00"},"pc":{"charge":"20.00","show":"100.00","click":"22.00"},"mobile":{"charge":"7.00","show":"100.00","click":"16.00"}},"originality":"五粮液、洋河、老白干酒、青青稞酒、伊力特前三季度成绩单出炉！","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"385.00","show":"4200.00","click":"582.00"},"pc":{"charge":"254.00","show":"2700.00","click":"407.00"},"mobile":{"charge":"131.00","show":"1500.00","click":"175.00"}},"originality":"几十块和几百块的白酒有目标用户点击热词啥不一样？原来是这样","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"19.00","show":"200.00","click":"43.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"19.00","show":"200.00","click":"43.00"}},"originality":"好酒献给懂酒的你!地域传承经典 53度酱香老酒 速来 其他人都不知道!","unit_id":"0","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"42.00","show":"400.00","click":"119.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"42.00","show":"400.00","click":"119.00"}},"originality":"正宗〔您的品牌〕原浆酒，目标用户点击热词一箱只要199！","unit_id":"2","point":"-","plan_id":"0"},{"name":"白酒推广计划"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"别犹豫，真的值，酱香型白酒，目标用户点击热词卖完为止","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"27.00","show":"200.00","click":"38.00"},"pc":{"charge":"20.00","show":"100.00","click":"22.00"},"mobile":{"charge":"7.00","show":"100.00","click":"16.00"}},"originality":"震惊！你还给好友喝勾兑白酒？这款纯粮白酒，目标用户点击热词正宗！","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"15.00","show":"100.00","click":"37.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"15.00","show":"100.00","click":"37.00"}},"originality":"想存几箱白酒,几年后再喝，目标用户点击热词什么酒值得收藏？","unit_id":"1","point":"美食推荐","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"295.00","show":"2200.00","click":"755.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"295.00","show":"2200.00","click":"755.00"}},"originality":"目标用户点击热词好喝的茅台镇酒竟不贵？酒姑娘揭秘酿酒六大细节","unit_id":"1","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"168.00","show":"1200.00","click":"402.00"},"pc":{"charge":"115.00","show":"800.00","click":"280.00"},"mobile":{"charge":"53.00","show":"400.00","click":"122.00"}},"originality":"窖龄酒、年份酒、陈年老酒等等看上去都是老酒，到底啥区别？","unit_id":"0","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"5114.00","show":"43000.00","click":"5603.00"},"pc":{"charge":"119.00","show":"900.00","click":"173.00"},"mobile":{"charge":"4995.00","show":"42100.00","click":"5430.00"}},"originality":"谁说百元内喝不到好酒，这些酒可以媲美那些上千元的酒！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"48.00","show":"600.00","click":"73.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"48.00","show":"600.00","click":"73.00"}},"originality":"酱香白酒一直很贵，仅限日期特价，目标用户点击热词卖完为止！","unit_id":"2","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1256.00","show":"11100.00","click":"3110.00"},"pc":{"charge":"28.00","show":"500.00","click":"69.00"},"mobile":{"charge":"1228.00","show":"10600.00","click":"3041.00"}},"originality":"年份酒、窖龄酒、新酒与老酒、陈年老酒有什么区别？","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑111%","热"],"total":{"all":{"charge":"3079.00","show":"29400.00","click":"4863.00"},"pc":{"charge":"467.00","show":"5000.00","click":"965.00"},"mobile":{"charge":"2612.00","show":"24400.00","click":"3898.00"}},"originality":"杜康名酒酒厂直供迎端午低至38元！限日期!","unit_id":"1","point":"-","plan_id":"0"},{"reason":["↑24%"],"total":{"all":{"charge":"19.00","show":"200.00","click":"43.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"19.00","show":"200.00","click":"43.00"}},"originality":"[今天福利]不敢相信、正宗汾酒集团收藏酒居然只要这个价！还包邮","unit_id":"0","point":"-","plan_id":"0"},{"reason":["↑58%","热"],"total":{"all":{"charge":"11.00","show":"100.00","click":"16.00"},"pc":{"charge":"11.00","show":"100.00","click":"16.00"},"mobile":{"charge":"0.00","show":"0.00","click":"0.00"}},"originality":"最后一波！五粮液地域酒厂生产:一瓶低至47元,就要喝有档次的酒","unit_id":"0","point":"便宜","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"1479.00","show":"12100.00","click":"2842.00"},"pc":{"charge":"10.00","show":"200.00","click":"87.00"},"mobile":{"charge":"1469.00","show":"11900.00","click":"2755.00"}},"originality":"如果经济允许，建议喝目标用户点击热词这款白酒，纯粮食酿造，不伤身体！假一罚万","unit_id":"0","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"7.00","show":"100.00","click":"28.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"7.00","show":"100.00","click":"28.00"}},"originality":"\u201c便宜\u201d等不了，抢购要趁早！目标用户点击热词窖藏酒白酒","unit_id":"2","point":"便宜;美食推荐","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"7433.00","show":"66300.00","click":"6541.00"},"pc":{"charge":"436.00","show":"2000.00","click":"783.00"},"mobile":{"charge":"6997.00","show":"64300.00","click":"5758.00"}},"originality":"汾酒白酒,给你厂价！好喝！目标用户点击热词货到付款！","unit_id":"1","point":"-","plan_id":"0"},{"reason":["热"],"total":{"all":{"charge":"118.00","show":"800.00","click":"98.00"},"pc":{"charge":"73.00","show":"300.00","click":"60.00"},"mobile":{"charge":"45.00","show":"500.00","click":"38.00"}},"originality":"多年陈酿 只为一瓶好酒!地域窖藏原浆酒!保真,点此了解详情!","unit_id":"1","point":"-","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"207.00","show":"1700.00","click":"261.00"},"pc":{"charge":"179.00","show":"1200.00","click":"230.00"},"mobile":{"charge":"28.00","show":"500.00","click":"31.00"}},"originality":"目标用户点击热词如果说白酒哪款好，建议经典酱香百年大福！纯粮无勾兑!","unit_id":"1","point":"食品质量保障","plan_id":"0"},{"reason":[],"total":{"all":{"charge":"207.00","show":"1700.00","click":"261.00"},"pc":{"charge":"179.00","show":"1200.00","click":"230.00"},"mobile":{"charge":"28.00","show":"500.00","click":"31.00"}},"originality":"一瓶酒卖了好几千，是以前家里的留的老酒，庆哥酒水专业收酒！","unit_id":"1","point":"-","plan_id":"0"}]
             * keyword : [{"all":{"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"46","cpc":"1.49","recBid":"1.56","show":"800","rank":"1","click":"96.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.56","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"44","cpc":"1.49","recBid":"1.52","show":"800","rank":"1","click":"96.00"},"competition":"8","bid":"7.71","word":"白酒批发市场","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.03","showRate":"0.8","charge":"208.00","pv":"27","cpc":"4.26","recBid":"1.22","show":"1600","rank":"1","click":"49.00"},"pc":{"ctr":"0.03","showRate":"0.86","charge":"179.00","pv":"7","cpc":"4.85","recBid":"0.81","show":"1300","rank":"1","click":"37.00"},"matchType":"4","mobile":{"ctr":"0.04","showRate":"0.6","charge":"29.00","pv":"20","cpc":"2.44","recBid":"1.22","show":"300","rank":"1","click":"12.00"},"competition":"8","bid":"6.36","word":"品牌白酒代理加盟","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.09","showRate":"0.89","charge":"6905.00","pv":"1183","cpc":"1.09","recBid":"7.67","show":"73500","rank":"1","click":"6339.00"},"pc":{"ctr":"0.42","showRate":"1","charge":"287.00","pv":"18","cpc":"0.62","recBid":"7.67","show":"1100","rank":"1","click":"463.00"},"matchType":"5","mobile":{"ctr":"0.08","showRate":"0.89","charge":"6618.00","pv":"1164","cpc":"1.13","recBid":"1.37","show":"72400","rank":"1","click":"5877.00"},"competition":"18","bid":"2.84","word":"酿酒设备白酒","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.24","showRate":"1","charge":"1479.00","pv":"446","cpc":"0.52","recBid":"1.17","show":"12100","rank":"1","click":"2842.00"},"pc":{"ctr":"0.43","showRate":"1","charge":"10.0","pv":"23","cpc":"0.12","recBid":"0.58","show":"200","rank":"1","click":"87.00"},"matchType":"3","mobile":{"ctr":"0.24","showRate":"1","charge":"1469.00","pv":"423","cpc":"0.53","recBid":"1.17","show":"11900","rank":"1","click":"2755.00"},"competition":"9","bid":"4.45","word":"中国白酒排名","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.23","showRate":"0.75","charge":"66.00","pv":"72","cpc":"0.48","recBid":"1.65","show":"600","rank":"1","click":"137.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.94","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.23","showRate":"0.75","charge":"66.00","pv":"70","cpc":"0.48","recBid":"1.65","show":"600","rank":"1","click":"137.00"},"competition":"9","bid":"1.4","word":"山东名酒白酒排行榜","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.15","showRate":"1","charge":"4.00","pv":"15","cpc":"0.27","recBid":"0.86","show":"100","rank":"1","click":"15.00"},"pc":{"ctr":"0.15","showRate":"1","charge":"4.00","pv":"2","cpc":"0.27","recBid":"0.73","show":"100","rank":"1","click":"15.00"},"matchType":"4","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"13","cpc":"0","recBid":"0.86","show":"0","rank":"0","click":"0"},"competition":"9","bid":"2.17","word":"收藏白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"0.81","charge":"75.00","pv":"58","cpc":"0.72","recBid":"0.97","show":"900","rank":"1","click":"104.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.63","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.12","showRate":"0.81","charge":"75.00","pv":"56","cpc":"0.72","recBid":"0.97","show":"900","rank":"1","click":"104.00"},"competition":"8","bid":"3.69","word":"白酒厂","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.27","showRate":"1","charge":"7.00","pv":"39","cpc":"0.25","recBid":"1.41","show":"100","rank":"2","click":"28.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"0.66","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.27","showRate":"1","charge":"7.00","pv":"38","cpc":"0.25","recBid":"1.41","show":"100","rank":"2","click":"28.00"},"competition":"7","bid":"2.07","word":"山东白酒排名","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"0.75","charge":"48.00","pv":"18","cpc":"0.66","recBid":"1.49","show":"600","rank":"1","click":"73.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.49","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.12","showRate":"0.75","charge":"48.00","pv":"17","cpc":"0.66","recBid":"1.12","show":"600","rank":"1","click":"73.00"},"competition":"8","bid":"1.51","word":"白酒酱香型","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"1","charge":"19.00","pv":"36","cpc":"0.44","recBid":"0.9","show":"200","rank":"1","click":"43.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"3","cpc":"0","recBid":"0.51","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.22","showRate":"1","charge":"19.00","pv":"33","cpc":"0.44","recBid":"0.9","show":"200","rank":"1","click":"43.00"},"competition":"9","bid":"9.66","word":"白酒分酒器","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"1","charge":"16.00","pv":"36","cpc":"0.36","recBid":"2.39","show":"200","rank":"1","click":"44.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"2.39","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.22","showRate":"1","charge":"16.00","pv":"33","cpc":"0.36","recBid":"1.3","show":"200","rank":"1","click":"44.00"},"competition":"10","bid":"2.72","word":"白酒回收价格表","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.16","showRate":"1","charge":"15.00","pv":"80","cpc":"0.93","recBid":"1.66","show":"100","rank":"1","click":"16.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"6","cpc":"0","recBid":"0.46","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.16","showRate":"1","charge":"15.00","pv":"74","cpc":"0.93","recBid":"1.66","show":"100","rank":"1","click":"16.00"},"competition":"7","bid":"4.22","word":"白酒瓶盖","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.17","showRate":"1","charge":"11.00","pv":"1","cpc":"0.67","recBid":"1.48","show":"100","rank":"1","click":"16.00"},"pc":{"ctr":"0.17","showRate":"1","charge":"11.00","pv":"0","cpc":"0.67","recBid":"0.78","show":"100","rank":"1","click":"16.00"},"matchType":"3","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"1.48","show":"0","rank":"0","click":"0"},"competition":"11","bid":"2.43","word":"白酒哪家好","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.29","showRate":"1","charge":"42.00","pv":"23","cpc":"0.35","recBid":"2.39","show":"400","rank":"1","click":"119.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"2.39","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.29","showRate":"1","charge":"42.00","pv":"21","cpc":"0.35","recBid":"1.33","show":"400","rank":"1","click":"119.00"},"competition":"10","bid":"1.1","word":"十大酱香型白酒排名","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.26","showRate":"1","charge":"13.00","pv":"30","cpc":"0.49","recBid":"1","show":"100","rank":"1","click":"26.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.35","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.26","showRate":"1","charge":"13.00","pv":"28","cpc":"0.49","recBid":"1","show":"100","rank":"1","click":"26.00"},"competition":"9","bid":"1.72","word":"浓香型白酒有哪些","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.1","showRate":"0.91","charge":"7433.00","pv":"1890","cpc":"1.14","recBid":"1.47","show":"66300","rank":"1","click":"6541.00"},"pc":{"ctr":"0.39","showRate":"1","charge":"436.00","pv":"29","cpc":"0.56","recBid":"1.47","show":"2000","rank":"1","click":"783.00"},"matchType":"4","mobile":{"ctr":"0.09","showRate":"0.91","charge":"6997.00","pv":"1861","cpc":"1.22","recBid":"1.47","show":"64300","rank":"1","click":"5758.00"},"competition":"18","bid":"2.61","word":"酿酒白酒设备","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.28","showRate":"1","charge":"1256.00","pv":"372","cpc":"0.4","recBid":"1.46","show":"11100","rank":"1","click":"3110.0"},"pc":{"ctr":"0.14","showRate":"1","charge":"28.00","pv":"36","cpc":"0.4","recBid":"0.7","show":"500","rank":"1","click":"69.00"},"matchType":"3","mobile":{"ctr":"0.28","showRate":"1","charge":"1228.00","pv":"336","cpc":"0.4","recBid":"1.46","show":"10600","rank":"1","click":"3041.00"},"competition":"9","bid":"3.19","word":"白酒排名","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.06","showRate":"1","charge":"5.00","pv":"43","cpc":"0.92","recBid":"0.79","show":"100","rank":"1","click":"5.00"},"pc":{"ctr":"0.06","showRate":"1","charge":"5.00","pv":"17","cpc":"0.92","recBid":"0.3","show":"100","rank":"1","click":"5.00"},"matchType":"5","mobile":{"ctr":"0","showRate":"0","charge":"0","pv":"25","cpc":"0","recBid":"0.79","show":"0","rank":"0","click":"0"},"competition":"7","bid":"10.44","word":"白酒吧","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.29","showRate":"1","charge":"23.00","pv":"21","cpc":"0.26","recBid":"0.93","show":"300","rank":"1","click":"89.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.29","showRate":"1","charge":"23.00","pv":"21","cpc":"0.26","recBid":"0.93","show":"300","rank":"1","click":"89.00"},"competition":"8","bid":"1.15","word":"佳裕高粱白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.13","showRate":"0.91","charge":"5114.00","pv":"1054","cpc":"0.91","recBid":"2.06","show":"43000","rank":"1","click":"5603.00"},"pc":{"ctr":"0.2","showRate":"0.81","charge":"119.00","pv":"54","cpc":"0.69","recBid":"0.82","show":"900","rank":"1","click":"173.00"},"matchType":"5","mobile":{"ctr":"0.13","showRate":"0.91","charge":"4995.00","pv":"1000","cpc":"0.92","recBid":"2.06","show":"42100","rank":"1","click":"5430.0"},"competition":"11","bid":"2.93","word":"白酒品牌","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.2","showRate":"1","charge":"27.00","pv":"58","cpc":"0.7","recBid":"0.92","show":"200","rank":"1","click":"38.00"},"pc":{"ctr":"0.22","showRate":"1","charge":"20.0","pv":"6","cpc":"0.91","recBid":"0.41","show":"100","rank":"1","click":"22.00"},"matchType":"3","mobile":{"ctr":"0.17","showRate":"1","charge":"7.00","pv":"52","cpc":"0.43","recBid":"0.92","show":"100","rank":"1","click":"16.00"},"competition":"9","bid":"2.79","word":"山东白酒","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.22","showRate":"0.97","charge":"46256.00","pv":"6","cpc":"0.46","recBid":"1.51","show":"473000","rank":"1","click":"100912.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"2","cpc":"0","recBid":"0.65","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.22","showRate":"0.97","charge":"46256.00","pv":"3","cpc":"0.46","recBid":"1.51","show":"473000","rank":"1","click":"100912.00"},"competition":"5","bid":"1.82","word":"酒类价格","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.12","showRate":"1","charge":"118.00","pv":"155","cpc":"1.21","recBid":"1.57","show":"800","rank":"1","click":"98.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"73.00","pv":"15","cpc":"1.22","recBid":"0.92","show":"300","rank":"1","click":"60.0"},"matchType":"4","mobile":{"ctr":"0.08","showRate":"1","charge":"45.00","pv":"140","cpc":"1.19","recBid":"1.57","show":"500","rank":"1","click":"38.00"},"competition":"8","bid":"6.94","word":"白酒价格","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.33","showRate":"1","charge":"168.00","pv":"1958","cpc":"0.42","recBid":"2.1","show":"1200","rank":"1","click":"402.00"},"pc":{"ctr":"0.35","showRate":"1","charge":"115.00","pv":"19","cpc":"0.41","recBid":"0.98","show":"800","rank":"1","click":"280.0"},"matchType":"3","mobile":{"ctr":"0.3","showRate":"1","charge":"53.00","pv":"1939","cpc":"0.43","recBid":"2.1","show":"400","rank":"1","click":"122.00"},"competition":"3","bid":"3.45","word":"酱香型白酒有哪些","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.17","showRate":"0.93","charge":"3079.00","pv":"1366","cpc":"0.63","recBid":"1.36","show":"29400","rank":"1","click":"4863.00"},"pc":{"ctr":"0.2","showRate":"0.96","charge":"467.00","pv":"136","cpc":"0.48","recBid":"0.58","show":"5000","rank":"1","click":"965.00"},"matchType":"4","mobile":{"ctr":"0.16","showRate":"0.92","charge":"2612.00","pv":"1230","cpc":"0.67","recBid":"1.36","show":"24400","rank":"1","click":"3898.00"},"competition":"9","bid":"2.4","word":"酱香型白酒","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.34","showRate":"0.96","charge":"295.00","pv":"76","cpc":"0.39","recBid":"2.25","show":"2200","rank":"1","click":"755.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.34","showRate":"0.96","charge":"295.00","pv":"76","cpc":"0.39","recBid":"2.25","show":"2200","rank":"1","click":"755.00"},"competition":"10","bid":"1.43","word":"仁酒53度酱香型白酒价格","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.18","showRate":"0.75","charge":"34.00","pv":"40","cpc":"0.32","recBid":"1.79","show":"600","rank":"1","click":"106.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.3","show":"0","rank":"0","click":"0"},"matchType":"3","mobile":{"ctr":"0.18","showRate":"0.75","charge":"34.00","pv":"39","cpc":"0.32","recBid":"1.79","show":"600","rank":"1","click":"106.00"},"competition":"10","bid":"0.89","word":"河北名酒白酒排行榜","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.09","showRate":"1","charge":"4.00","pv":"4","cpc":"0.48","recBid":"1.38","show":"100","rank":"1","click":"8.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"0","cpc":"0","recBid":"0.9","show":"0","rank":"0","click":"0"},"matchType":"5","mobile":{"ctr":"0.09","showRate":"1","charge":"4.00","pv":"3","cpc":"0.48","recBid":"1.38","show":"100","rank":"1","click":"8.00"},"competition":"8","bid":"6.99","word":"什么白酒比较好","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.28","showRate":"1","charge":"3492.00","pv":"219","cpc":"0.9","recBid":"2.38","show":"13800","rank":"1","click":"3873.00"},"pc":{"ctr":"0.38","showRate":"1","charge":"23.00","pv":"4","cpc":"0.3","recBid":"0.3","show":"200","rank":"1","click":"77.00"},"matchType":"3","mobile":{"ctr":"0.27","showRate":"1","charge":"3469.00","pv":"214","cpc":"0.91","recBid":"2.38","show":"13600","rank":"1","click":"3796.00"},"competition":"7","bid":"5.78","word":"酱香白酒有哪些","unit_id":"0","plan_id":"0"},{"all":{"ctr":"0.16","showRate":"0.74","charge":"207.00","pv":"104","cpc":"0.79","recBid":"1.39","show":"1700","rank":"1","click":"261.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"179.00","pv":"23","cpc":"0.78","recBid":"1.27","show":"1200","rank":"1","click":"230.0"},"matchType":"4","mobile":{"ctr":"0.06","showRate":"0.45","charge":"28.00","pv":"80","cpc":"0.91","recBid":"1.39","show":"500","rank":"1","click":"31.00"},"competition":"10","bid":"2.58","word":"白酒厂家","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.37","showRate":"1","charge":"15.00","pv":"42","cpc":"0.4","recBid":"0.92","show":"100","rank":"1","click":"37.00"},"pc":{"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"0.31","show":"0","rank":"0","click":"0"},"matchType":"4","mobile":{"ctr":"0.37","showRate":"1","charge":"15.00","pv":"41","cpc":"0.4","recBid":"0.92","show":"100","rank":"1","click":"37.00"},"competition":"9","bid":"1.42","word":"清香型白酒排名","unit_id":"1","plan_id":"0"},{"all":{"ctr":"0.15","showRate":"0.76","charge":"129.00","pv":"73","cpc":"0.91","recBid":"1.16","show":"1000","rank":"1","click":"142.00"},"pc":{"ctr":"0.2","showRate":"1","charge":"95.00","pv":"7","cpc":"0.96","recBid":"0.3","show":"500","rank":"1","click":"99.00"},"matchType":"5","mobile":{"ctr":"0.09","showRate":"0.63","charge":"34.00","pv":"65","cpc":"0.78","recBid":"1.16","show":"500","rank":"1","click":"43.00"},"competition":"9","bid":"2.27","word":"四川白酒","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.11","showRate":"0.94","charge":"8134.00","pv":"831","cpc":"2.85","recBid":"2.28","show":"26200","rank":"1","click":"2858.00"},"pc":{"ctr":"0.28","showRate":"0.93","charge":"4588.00","pv":"59","cpc":"2.98","recBid":"2.28","show":"5400","rank":"1","click":"1539.00"},"matchType":"5","mobile":{"ctr":"0.06","showRate":"0.94","charge":"3546.00","pv":"772","cpc":"2.69","recBid":"1.78","show":"20800","rank":"1","click":"1319.00"},"competition":"8","bid":"14.24","word":"白酒招商","unit_id":"2","plan_id":"0"},{"all":{"ctr":"0.14","showRate":"0.91","charge":"385.00","pv":"1093","cpc":"0.66","recBid":"0.99","show":"4200","rank":"1","click":"582.00"},"pc":{"ctr":"0.15","showRate":"0.96","charge":"254.00","pv":"51","cpc":"0.62","recBid":"0.79","show":"2700","rank":"1","click":"407.00"},"matchType":"4","mobile":{"ctr":"0.12","showRate":"0.83","charge":"131.00","pv":"1042","cpc":"0.75","recBid":"0.99","show":"1500","rank":"1","click":"175.00"},"competition":"7","bid":"2.92","word":"酒厂","unit_id":"1","plan_id":"0"}]
             * plan : [{"total":{"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}},"name":"白酒推广计划"}]
             */
            private TotalEntity total;
            private List<UnitEntity> unit;
            private List<OriginalityEntity> originality;
            private List<KeywordEntity> keyword;
            private List<PlanEntity> plan;


            public void getData(JSONObject object) {

                try {
                    JSONObject total = object.getJSONObject("total");
                    TotalEntity totalEntity = new TotalEntity();
                    totalEntity.getData(total);
                    setTotal(totalEntity);

                    JSONArray unit = object.getJSONArray("unit");
                    ArrayList<UnitEntity> unitList = new ArrayList<>();
                    for (int i = 0; i < unit.length(); i++) {
                        UnitEntity unitEntity = new UnitEntity();
                        unitEntity.getData((JSONObject) unit.get(i));
                        unitList.add(unitEntity);
                        setUnit(unitList);

                    }

                    JSONArray originality = object.getJSONArray("originality");
                    ArrayList<OriginalityEntity> originalityList = new ArrayList<>();
                    for (int i = 0; i < originality.length(); i++) {
                        OriginalityEntity originalityEntity = new OriginalityEntity();
                        originalityEntity.getData((JSONObject) originality.get(i));
                        originalityList.add(originalityEntity);
                        setOriginality(originalityList);

                    }

                    JSONArray keyword = object.getJSONArray("keyword");
                    ArrayList<KeywordEntity> keywordList = new ArrayList<>();
                    for (int i = 0; i < keyword.length(); i++) {
                        KeywordEntity keywordEntity = new KeywordEntity();
                        keywordEntity.getData((JSONObject) keyword.get(i));
                        keywordList.add(keywordEntity);
                        setKeyword(keywordList);

                    }


                    JSONArray plan = object.getJSONArray("plan");
                    ArrayList<PlanEntity> planList = new ArrayList<>();
                    for (int i = 0; i < plan.length(); i++) {
                        PlanEntity planEntity = new PlanEntity();
                        planEntity.getData((JSONObject) plan.get(i));
                        planList.add(planEntity);
                        setPlan(planList);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            public void setUnit(List<UnitEntity> unit) {
                this.unit = unit;
            }

            public void setTotal(TotalEntity total) {
                this.total = total;
            }

            public void setOriginality(List<OriginalityEntity> originality) {
                this.originality = originality;
            }

            public void setKeyword(List<KeywordEntity> keyword) {
                this.keyword = keyword;
            }

            public void setPlan(List<PlanEntity> plan) {
                this.plan = plan;
            }

            public List<UnitEntity> getUnit() {
                return unit;
            }

            public TotalEntity getTotal() {
                return total;
            }

            public List<OriginalityEntity> getOriginality() {
                return originality;
            }

            public List<KeywordEntity> getKeyword() {
                return keyword;
            }

            public List<PlanEntity> getPlan() {
                return plan;
            }

            public class UnitEntity {
                /**
                 * total : {"all":{"charge":"6576.00","show":"40300.00","click":"10550.00"},"pc":{"charge":"207.00","show":"1900.00","click":"551.00"},"mobile":{"charge":"6369.00","show":"38400.00","click":"9999.00"}}
                 * name : 白酒推广计划-同义
                 * plan_id : 0
                 */
                private TotalEntity total;
                private String name;
                private String plan_id;

                public void getData(JSONObject object) {

                    try {
                        setName(object.getString("name"));
                        setPlan_id(object.getString("plan_id"));
                        TotalEntity totalEntity = new TotalEntity();
                        JSONObject total = object.getJSONObject("total");
                        totalEntity.getData(total);
                        setTotal(totalEntity);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                public void setTotal(TotalEntity total) {
                    this.total = total;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setPlan_id(String plan_id) {
                    this.plan_id = plan_id;
                }

                public TotalEntity getTotal() {
                    return total;
                }

                public String getName() {
                    return name;
                }

                public String getPlan_id() {
                    return plan_id;
                }


                public class TotalEntity {
                    /**
                     * all : {"charge":"6576.00","show":"40300.00","click":"10550.00"}
                     * pc : {"charge":"207.00","show":"1900.00","click":"551.00"}
                     * mobile : {"charge":"6369.00","show":"38400.00","click":"9999.00"}
                     */
                    private AllEntity all;
                    private PcEntity pc;
                    private MobileEntity mobile;

                    public void getData(JSONObject object) {
                        try {
                            JSONObject all = object.getJSONObject("all");
                            AllEntity allEntity = new AllEntity();
                            allEntity.getData(all);
                            setAll(allEntity);

                            JSONObject pc = object.getJSONObject("pc");
                            PcEntity pcEntity = new PcEntity();
                            pcEntity.getData(pc);
                            setPc(pcEntity);

                            JSONObject mobile = object.getJSONObject("mobile");
                            MobileEntity mobileEntity = new MobileEntity();
                            mobileEntity.getData(mobile);
                            setMobile(mobileEntity);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setAll(AllEntity all) {
                        this.all = all;
                    }

                    public void setPc(PcEntity pc) {
                        this.pc = pc;
                    }

                    public void setMobile(MobileEntity mobile) {
                        this.mobile = mobile;
                    }

                    public AllEntity getAll() {
                        return all;
                    }

                    public PcEntity getPc() {
                        return pc;
                    }

                    public MobileEntity getMobile() {
                        return mobile;
                    }


                    public class AllEntity {
                        /**
                         * charge : 6576.00
                         * show : 40300.00
                         * click : 10550.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }


                    }

                    public class PcEntity {
                        /**
                         * charge : 207.00
                         * show : 1900.00
                         * click : 551.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }

                    public class MobileEntity {
                        /**
                         * charge : 6369.00
                         * show : 38400.00
                         * click : 9999.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }
                }
            }

            public class TotalEntity {
                /**
                 * all : {"charge":"85225.00","show":"766700.00","click":"140230.00"}
                 * pc : {"charge":"6893.00","show":"22500.00","click":"5327.00"}
                 * mobile : {"charge":"78332.00","show":"744200.00","click":"134904.00"}
                 */
                private AllEntity all;
                private PcEntity pc;
                private MobileEntity mobile;

                public void getData(JSONObject object) {
                    try {
                        JSONObject all = object.getJSONObject("all");
                        AllEntity allEntity = new AllEntity();
                        allEntity.getData(all);
                        setAll(allEntity);

                        JSONObject pc = object.getJSONObject("pc");
                        PcEntity pcEntity = new PcEntity();
                        pcEntity.getData(pc);
                        setPc(pcEntity);

                        JSONObject mobile = object.getJSONObject("mobile");
                        MobileEntity mobileEntity = new MobileEntity();
                        mobileEntity.getData(mobile);
                        setMobile(mobileEntity);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                public void setAll(AllEntity all) {
                    this.all = all;
                }

                public void setPc(PcEntity pc) {
                    this.pc = pc;
                }

                public void setMobile(MobileEntity mobile) {
                    this.mobile = mobile;
                }

                public AllEntity getAll() {
                    return all;
                }

                public PcEntity getPc() {
                    return pc;
                }

                public MobileEntity getMobile() {
                    return mobile;
                }


                public class AllEntity {
                    /**
                     * charge : 85225.00
                     * show : 766700.00
                     * click : 140230.00
                     */
                    private String charge;
                    private String show;
                    private String click;


                    public void getData(JSONObject object) {
                        try {
                            setCharge(object.getString("charge"));
                            setShow(object.getString("show"));
                            setClick(object.getString("click"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setCharge(String charge) {
                        this.charge = charge;
                    }

                    public void setShow(String show) {
                        this.show = show;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public String getCharge() {
                        return charge;
                    }

                    public String getShow() {
                        return show;
                    }

                    public String getClick() {
                        return click;
                    }

                }

                public class PcEntity {
                    /**
                     * charge : 6893.00
                     * show : 22500.00
                     * click : 5327.00
                     */
                    private String charge;
                    private String show;
                    private String click;

                    public void getData(JSONObject object) {
                        try {
                            setCharge(object.getString("charge"));
                            setShow(object.getString("show"));
                            setClick(object.getString("click"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setCharge(String charge) {
                        this.charge = charge;
                    }

                    public void setShow(String show) {
                        this.show = show;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public String getCharge() {
                        return charge;
                    }

                    public String getShow() {
                        return show;
                    }

                    public String getClick() {
                        return click;
                    }


                }

                public class MobileEntity {
                    /**
                     * charge : 78332.00
                     * show : 744200.00
                     * click : 134904.00
                     */
                    private String charge;
                    private String show;
                    private String click;

                    public void getData(JSONObject object) {
                        try {
                            setCharge(object.getString("charge"));
                            setShow(object.getString("show"));
                            setClick(object.getString("click"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setCharge(String charge) {
                        this.charge = charge;
                    }

                    public void setShow(String show) {
                        this.show = show;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public String getCharge() {
                        return charge;
                    }

                    public String getShow() {
                        return show;
                    }

                    public String getClick() {
                        return click;
                    }
                }
            }

            public class OriginalityEntity {
                /**
                 * reason : []
                 * total : {"all":{"charge":"13.00","show":"100.00","click":"26.00"},"pc":{"charge":"0.00","show":"0.00","click":"0.00"},"mobile":{"charge":"13.00","show":"100.00","click":"26.00"}}
                 * originality : 喝了这么多年的酒，你知道窖龄酒、年份酒、陈年老酒有哪些区别？
                 * unit_id : 2
                 * point : -
                 * plan_id : 0
                 */
                private TotalEntity total;
                private String originality;
                private String unit_id;
                private String point;
                private String plan_id;
                private List<String> reason;

                public void getData(JSONObject object) {
                    try {
                        TotalEntity totalEntity = new TotalEntity();
                        totalEntity.getData(object.getJSONObject("total"));
                        setTotal(totalEntity);
                        setOriginality(object.getString("originality"));
                        setUnit_id(object.getString("unit_id"));
                        setPoint(object.getString("point"));
                        setPlan_id(object.getString("plan_id"));

                        JSONArray reason = object.getJSONArray("reason");
                        int length = reason.length();
                        ArrayList<String> reasonList = new ArrayList<>();
                        if (length > 0) {  //有数据
                            for (int i = 0; i < length; i++) {
                                reasonList.add((String) reason.get(i));
                            }
                            setReason(reasonList);
                        } else {  //无数据
                            reasonList.add("empty");
                            setReason(reasonList);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                public void setReason(List<String> reason) {
                    this.reason = reason;
                }

                public void setTotal(TotalEntity total) {
                    this.total = total;
                }

                public void setOriginality(String originality) {
                    this.originality = originality;
                }

                public void setUnit_id(String unit_id) {
                    this.unit_id = unit_id;
                }

                public void setPoint(String point) {
                    this.point = point;
                }

                public void setPlan_id(String plan_id) {
                    this.plan_id = plan_id;
                }

                public List<String> getReason() {
                    return reason;
                }

                public TotalEntity getTotal() {
                    return total;
                }

                public String getOriginality() {
                    return originality;
                }

                public String getUnit_id() {
                    return unit_id;
                }

                public String getPoint() {
                    return point;
                }

                public String getPlan_id() {
                    return plan_id;
                }


                public class TotalEntity {
                    /**
                     * all : {"charge":"13.00","show":"100.00","click":"26.00"}
                     * pc : {"charge":"0.00","show":"0.00","click":"0.00"}
                     * mobile : {"charge":"13.00","show":"100.00","click":"26.00"}
                     */
                    private AllEntity all;
                    private PcEntity pc;
                    private MobileEntity mobile;

                    public void getData(JSONObject object) {
                        try {
                            JSONObject all = object.getJSONObject("all");
                            AllEntity allEntity = new AllEntity();
                            allEntity.getData(all);
                            setAll(allEntity);

                            JSONObject pc = object.getJSONObject("pc");
                            PcEntity pcEntity = new PcEntity();
                            pcEntity.getData(pc);
                            setPc(pcEntity);

                            JSONObject mobile = object.getJSONObject("mobile");
                            MobileEntity mobileEntity = new MobileEntity();
                            mobileEntity.getData(mobile);
                            setMobile(mobileEntity);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setAll(AllEntity all) {
                        this.all = all;
                    }

                    public void setPc(PcEntity pc) {
                        this.pc = pc;
                    }

                    public void setMobile(MobileEntity mobile) {
                        this.mobile = mobile;
                    }

                    public AllEntity getAll() {
                        return all;
                    }

                    public PcEntity getPc() {
                        return pc;
                    }

                    public MobileEntity getMobile() {
                        return mobile;
                    }

                    public class AllEntity {
                        /**
                         * charge : 13.00
                         * show : 100.00
                         * click : 26.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }
                    }

                    public class PcEntity {
                        /**
                         * charge : 0.00
                         * show : 0.00
                         * click : 0.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }
                    }

                    public class MobileEntity {
                        /**
                         * charge : 13.00
                         * show : 100.00
                         * click : 26.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }
                    }
                }
            }

            public class KeywordEntity {
                /**
                 * all : {"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"46","cpc":"1.49","recBid":"1.56","show":"800","rank":"1","click":"96.00"}
                 * pc : {"ctr":"0","showRate":"0","charge":"0","pv":"1","cpc":"0","recBid":"1.56","show":"0","rank":"0","click":"0"}
                 * matchType : 4
                 * mobile : {"ctr":"0.12","showRate":"0.89","charge":"143.00","pv":"44","cpc":"1.49","recBid":"1.52","show":"800","rank":"1","click":"96.00"}
                 * competition : 8
                 * bid : 7.71
                 * word : 白酒批发市场
                 * unit_id : 1
                 * plan_id : 0
                 */


                private String matchType;
                private String competition;
                private String bid;
                private String word;
                private String unit_id;
                private String plan_id;
                private AllEntity all;
                private PcEntity pc;
                private MobileEntity mobile;

                public void getData(JSONObject object) {
                    try {
                        setMatchType(object.getString("matchType"));
                        setCompetition(object.getString("competition"));
                        setBid(object.getString("bid"));
                        setWord(object.getString("word"));
                        setUnit_id(object.getString("unit_id"));
                        setPlan_id(object.getString("plan_id"));

                        JSONObject all = object.getJSONObject("all");
                        AllEntity allEntity = new AllEntity();
                        allEntity.getData(all);
                        setAll(allEntity);


                        JSONObject pc = object.getJSONObject("pc");
                        PcEntity pcEntity = new PcEntity();
                        pcEntity.getData(pc);
                        setPc(pcEntity);

                        JSONObject mobile = object.getJSONObject("mobile");
                        MobileEntity mobileEntity = new MobileEntity();
                        mobileEntity.getData(mobile);
                        setMobile(mobileEntity);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                public void setAll(AllEntity all) {
                    this.all = all;
                }

                public void setPc(PcEntity pc) {
                    this.pc = pc;
                }

                public void setMatchType(String matchType) {
                    this.matchType = matchType;
                }

                public void setMobile(MobileEntity mobile) {
                    this.mobile = mobile;
                }

                public void setCompetition(String competition) {
                    this.competition = competition;
                }

                public void setBid(String bid) {
                    this.bid = bid;
                }

                public void setWord(String word) {
                    this.word = word;
                }

                public void setUnit_id(String unit_id) {
                    this.unit_id = unit_id;
                }

                public void setPlan_id(String plan_id) {
                    this.plan_id = plan_id;
                }

                public AllEntity getAll() {
                    return all;
                }

                public PcEntity getPc() {
                    return pc;
                }

                public String getMatchType() {
                    return matchType;
                }

                public MobileEntity getMobile() {
                    return mobile;
                }

                public String getCompetition() {
                    return competition;
                }

                public String getBid() {
                    return bid;
                }

                public String getWord() {
                    return word;
                }

                public String getUnit_id() {
                    return unit_id;
                }

                public String getPlan_id() {
                    return plan_id;
                }


                public class AllEntity {
                    /**
                     * ctr : 0.12
                     * showRate : 0.89
                     * charge : 143.00
                     * pv : 46
                     * cpc : 1.49
                     * recBid : 1.56
                     * show : 800
                     * rank : 1
                     * click : 96.00
                     */
                    private String ctr;
                    private String showRate;
                    private String charge;
                    private String pv;
                    private String cpc;
                    private String recBid;
                    private String show;
                    private String rank;
                    private String click;

                    public void getData(JSONObject object) {
                        try {
                            setCtr(object.getString("ctr"));
                            setShowRate(object.getString("showRate"));
                            setCharge(object.getString("charge"));
                            setPv(object.getString("pv"));
                            setCpc(object.getString("cpc"));
                            setRecBid(object.getString("recBid"));
                            setShow(object.getString("show"));
                            setRank(object.getString("rank"));
                            setClick(object.getString("click"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setCtr(String ctr) {
                        this.ctr = ctr;
                    }

                    public void setShowRate(String showRate) {
                        this.showRate = showRate;
                    }

                    public void setCharge(String charge) {
                        this.charge = charge;
                    }

                    public void setPv(String pv) {
                        this.pv = pv;
                    }

                    public void setCpc(String cpc) {
                        this.cpc = cpc;
                    }

                    public void setRecBid(String recBid) {
                        this.recBid = recBid;
                    }

                    public void setShow(String show) {
                        this.show = show;
                    }

                    public void setRank(String rank) {
                        this.rank = rank;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public String getCtr() {
                        return ctr;
                    }

                    public String getShowRate() {
                        return showRate;
                    }

                    public String getCharge() {
                        return charge;
                    }

                    public String getPv() {
                        return pv;
                    }

                    public String getCpc() {
                        return cpc;
                    }

                    public String getRecBid() {
                        return recBid;
                    }

                    public String getShow() {
                        return show;
                    }

                    public String getRank() {
                        return rank;
                    }

                    public String getClick() {
                        return click;
                    }

                }

                public class PcEntity {
                    /**
                     * ctr : 0
                     * showRate : 0
                     * charge : 0
                     * pv : 1
                     * cpc : 0
                     * recBid : 1.56
                     * show : 0
                     * rank : 0
                     * click : 0
                     */
                    private String ctr;
                    private String showRate;
                    private String charge;
                    private String pv;
                    private String cpc;
                    private String recBid;
                    private String show;
                    private String rank;
                    private String click;

                    public void getData(JSONObject object) {
                        try {
                            setCtr(object.getString("ctr"));
                            setShowRate(object.getString("showRate"));
                            setCharge(object.getString("charge"));
                            setPv(object.getString("pv"));
                            setCpc(object.getString("cpc"));
                            setRecBid(object.getString("recBid"));
                            setShow(object.getString("show"));
                            setRank(object.getString("rank"));
                            setClick(object.getString("click"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setCtr(String ctr) {
                        this.ctr = ctr;
                    }

                    public void setShowRate(String showRate) {
                        this.showRate = showRate;
                    }

                    public void setCharge(String charge) {
                        this.charge = charge;
                    }

                    public void setPv(String pv) {
                        this.pv = pv;
                    }

                    public void setCpc(String cpc) {
                        this.cpc = cpc;
                    }

                    public void setRecBid(String recBid) {
                        this.recBid = recBid;
                    }

                    public void setShow(String show) {
                        this.show = show;
                    }

                    public void setRank(String rank) {
                        this.rank = rank;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public String getCtr() {
                        return ctr;
                    }

                    public String getShowRate() {
                        return showRate;
                    }

                    public String getCharge() {
                        return charge;
                    }

                    public String getPv() {
                        return pv;
                    }

                    public String getCpc() {
                        return cpc;
                    }

                    public String getRecBid() {
                        return recBid;
                    }

                    public String getShow() {
                        return show;
                    }

                    public String getRank() {
                        return rank;
                    }

                    public String getClick() {
                        return click;
                    }


                }

                public class MobileEntity {
                    /**
                     * ctr : 0.12
                     * showRate : 0.89
                     * charge : 143.00
                     * pv : 44
                     * cpc : 1.49
                     * recBid : 1.52
                     * show : 800
                     * rank : 1
                     * click : 96.00
                     */
                    private String ctr;
                    private String showRate;
                    private String charge;
                    private String pv;
                    private String cpc;
                    private String recBid;
                    private String show;
                    private String rank;
                    private String click;

                    public void getData(JSONObject object) {
                        try {
                            setCtr(object.getString("ctr"));
                            setShowRate(object.getString("showRate"));
                            setCharge(object.getString("charge"));
                            setPv(object.getString("pv"));
                            setCpc(object.getString("cpc"));
                            setRecBid(object.getString("recBid"));
                            setShow(object.getString("show"));
                            setRank(object.getString("rank"));
                            setClick(object.getString("click"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setCtr(String ctr) {
                        this.ctr = ctr;
                    }

                    public void setShowRate(String showRate) {
                        this.showRate = showRate;
                    }

                    public void setCharge(String charge) {
                        this.charge = charge;
                    }

                    public void setPv(String pv) {
                        this.pv = pv;
                    }

                    public void setCpc(String cpc) {
                        this.cpc = cpc;
                    }

                    public void setRecBid(String recBid) {
                        this.recBid = recBid;
                    }

                    public void setShow(String show) {
                        this.show = show;
                    }

                    public void setRank(String rank) {
                        this.rank = rank;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public String getCtr() {
                        return ctr;
                    }

                    public String getShowRate() {
                        return showRate;
                    }

                    public String getCharge() {
                        return charge;
                    }

                    public String getPv() {
                        return pv;
                    }

                    public String getCpc() {
                        return cpc;
                    }

                    public String getRecBid() {
                        return recBid;
                    }

                    public String getShow() {
                        return show;
                    }

                    public String getRank() {
                        return rank;
                    }

                    public String getClick() {
                        return click;
                    }

                }
            }

            public class PlanEntity {
                /**
                 * total : {"all":{"charge":"85225.00","show":"766700.00","click":"140230.00"},"pc":{"charge":"6893.00","show":"22500.00","click":"5327.00"},"mobile":{"charge":"78332.00","show":"744200.00","click":"134904.00"}}
                 * name : 白酒推广计划
                 */
                private TotalEntity total;
                private String name;


                public void getData(JSONObject object) {
                    try {
                        setName(object.getString("name"));
                        JSONObject total = object.getJSONObject("total");
                        TotalEntity totalEntity = new TotalEntity();
                        totalEntity.getData(total);
                        setTotal(totalEntity);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                public void setTotal(TotalEntity total) {
                    this.total = total;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public TotalEntity getTotal() {
                    return total;
                }

                public String getName() {
                    return name;
                }


                public class TotalEntity {
                    /**
                     * all : {"charge":"85225.00","show":"766700.00","click":"140230.00"}
                     * pc : {"charge":"6893.00","show":"22500.00","click":"5327.00"}
                     * mobile : {"charge":"78332.00","show":"744200.00","click":"134904.00"}
                     */
                    private AllEntity all;
                    private PcEntity pc;
                    private MobileEntity mobile;

                    public void getData(JSONObject object) {
                        try {
                            JSONObject all = object.getJSONObject("all");
                            AllEntity allEntity = new AllEntity();
                            allEntity.getData(all);
                            setAll(allEntity);

                            JSONObject pc = object.getJSONObject("pc");
                            PcEntity pcEntity = new PcEntity();
                            pcEntity.getData(pc);
                            setPc(pcEntity);

                            JSONObject mobile = object.getJSONObject("mobile");
                            MobileEntity mobileEntity = new MobileEntity();
                            mobileEntity.getData(mobile);
                            setMobile(mobileEntity);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    public void setAll(AllEntity all) {
                        this.all = all;
                    }

                    public void setPc(PcEntity pc) {
                        this.pc = pc;
                    }

                    public void setMobile(MobileEntity mobile) {
                        this.mobile = mobile;
                    }

                    public AllEntity getAll() {
                        return all;
                    }

                    public PcEntity getPc() {
                        return pc;
                    }

                    public MobileEntity getMobile() {
                        return mobile;
                    }


                    public class AllEntity {
                        /**
                         * charge : 85225.00
                         * show : 766700.00
                         * click : 140230.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }
                    }

                    public class PcEntity {
                        /**
                         * charge : 6893.00
                         * show : 22500.00
                         * click : 5327.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }
                    }

                    public class MobileEntity {
                        /**
                         * charge : 78332.00
                         * show : 744200.00
                         * click : 134904.00
                         */
                        private String charge;
                        private String show;
                        private String click;

                        public void getData(JSONObject object) {
                            try {
                                setCharge(object.getString("charge"));
                                setShow(object.getString("show"));
                                setClick(object.getString("click"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        public void setCharge(String charge) {
                            this.charge = charge;
                        }

                        public void setShow(String show) {
                            this.show = show;
                        }

                        public void setClick(String click) {
                            this.click = click;
                        }

                        public String getCharge() {
                            return charge;
                        }

                        public String getShow() {
                            return show;
                        }

                        public String getClick() {
                            return click;
                        }
                    }
                }
            }
        }
    }
}
