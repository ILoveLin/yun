package com.company.yun.ui.fragment.yun.presenter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.yun.LineBarBean;
import com.company.yun.bean.yun.PicChartBean;
import com.company.yun.bean.yun.TodayBean;
import com.company.yun.utils.DataUtils;
import com.company.yun.view.dialog.BaseDialog;
import com.company.yun.view.dialog.MenuDialog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/13
 * <p>
 * Describe:
 */
public class YunPresenter {

    private Context mContext;
    private YunView mView;
    private String currentDayNum = "7";    //当前的天数------数值
    private String currentTypeNum = "1";   //当前的展示类型----数值
    private String currentDayStr = "7天";    //当前的天数------说明
    private String currentTypeStr = "展示人数";   //当前的展示类型----说明


    public YunPresenter(Context mContext, YunView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }


    private void showDialog(FragmentActivity activity, List<String> data, final String type) {
        new MenuDialog.Builder(activity)
                .setCancel("取消") // 设置 null 表示不显示取消按钮
                //.setAutoDismiss(false) // 设置点击按钮后不关闭对话框
                .setList(data)
                .setListener(new MenuDialog.OnListener() {

                    @Override
                    public void onSelected(Dialog dialog, int position, String text) {
//                        sendPicChartRequest("7", "1");   //默认给的  7天    1:展现人数
                        if ("type".equals(type)) {     //类型
                            mView.getUnderType().setText("" + text);
                            setCurrentDayStr(text);
                            selectParams(getCurrentDayStr(), getCurrentTypeStr());
                            sendPicChartRequest(currentDayNum, currentTypeNum);   //默认给的  7天    1:展现人数

                        } else {                  //过去天数
                            mView.getUnderDays().setText("" + text);
                            setCurrentDayStr(text);
                            selectParams(getCurrentDayStr(), getCurrentTypeStr());
                            sendPicChartRequest(currentDayNum, currentTypeNum);   //默认给的  7天    1:展现人数
                        }
//                        mView.showToast("位置：" + position + "，文本：" + text);
                    }

                    @Override
                    public void onCancel(Dialog dialog) {
                        mView.showToast("取消了");
                    }
                })
                .setGravity(Gravity.BOTTOM)
                .setAnimStyle(BaseDialog.AnimStyle.BOTTOM)
                .show();
    }

    public void selectParams(String currentDayStr, String currentTypeStr) {
//        0：展现 1：展现人数 2：消费 3：点击 4：点击人数       //currentTypeNum
//        1:昨日,7:7天,14:14天,30:30天                          //currentDayNum
        switch (currentDayStr) {
            case "昨日":
                this.currentDayNum = "1";
                break;
            case "过去7天":
                this.currentDayNum = "7";
                break;
            case "过去14天":
                this.currentDayNum = "14";
                break;
            case "过去30天":
                this.currentDayNum = "30";
                break;
        }
        switch (currentTypeStr) {
            case "展现":
                this.currentTypeNum = "0";
                break;
            case "展现人数":
                this.currentTypeNum = "1";
                break;
            case "消费":
                this.currentTypeNum = "2";
                break;
            case "点击":
                this.currentTypeNum = "3";
                break;
            case "点击人数":
                this.currentTypeNum = "4";
                break;
        }


    }

    public void sendTimeRequest(){
        OkHttpUtils.post()
                .url(HttpConstants.Yun_Daday_Data)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            mView.showContentView();
                            TodayBean todayDataBean = new TodayBean();
                            todayDataBean.getAllData(response);
                            refreshTodayData(todayDataBean);
                            sendChartDataRequest("time");
//                            sendChartDataRequest("time");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
    }


    public void sendRequest() {
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.Yun_Daday_Data)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            mView.showContentView();
                            TodayBean todayDataBean = new TodayBean();
                            todayDataBean.getAllData(response);
                            refreshTodayData(todayDataBean);
                            sendChartDataRequest("alone");
//                            sendChartDataRequest("time");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
    }

    //请求昨日和今日的表格数据    第一和第二个表格
    public void sendChartDataRequest(final String type) {
        OkHttpUtils.post()
                .url(HttpConstants.Yun_Chart_Line_Bar)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            mView.showContentView();
                            LineBarBean lineBarBean = new LineBarBean();
                            lineBarBean.getAllData(response);
                            List<String> xList = lineBarBean.getX();
                            List<List<Integer>> yList = lineBarBean.getY();
                            // y[0]今日数据,y[1]为昨日数据
                            List<Integer> todayDataList = yList.get(0);
                            List<Integer> yesterdayDataList = yList.get(1);
                            mView.refreshLineBarUIData(xList, DataUtils.toStringList(todayDataList),
                                    DataUtils.toStringList(yesterdayDataList));
                            if ("alone".equals(type)) {
                                sendPicChartRequest("7", "1");   //默认给的  7天    1:展现人数
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });

    }

    //请求三个圆形图

    private void sendPicChartRequest(String day, String type) {     //默认给的  7天    1:展现人数
        mView.showLoadingView();
        OkHttpUtils.post()
                .url(HttpConstants.Yun_User_Data)
                .addParams("day", day)
                .addParams("type", type)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求返回错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            mView.showContentView();
                            PicChartBean picChartBean = new PicChartBean();
                            picChartBean.getAllData(response);
                            PicChartBean.SexEntity sex = picChartBean.getSex();
                            PicChartBean.AgeEntity age = picChartBean.getAge();
                            PicChartBean.InterestEntity interest = picChartBean.getInterest();
                            refreshUnderBarData(picChartBean.getTotal());
                            mView.refreshPicChartUIData(sex, age, interest);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
    }


    //刷新under_bar的数据
    private void refreshUnderBarData(String total) {
        String type = mView.getUnderType().getText().toString().trim();
        String days = mView.getUnderDays().getText().toString().trim();
        this.currentDayStr = days;
        this.currentTypeStr = type;
        mView.getUnderPersonCount().setText(total + "");
    }

    private void refreshTodayData(TodayBean bean) {


        mView.getTotal().setText(bean.getClick_rate() + "%");
        setBGDrawable(mView.getTotal(), bean.getClick_rate());
        mView.getTotalRate().setText(bean.getClick() + "次");

        mView.getShow().setText(bean.getShows() + "次");
        setBGDrawable(mView.getDrableIcon01(), bean.getShow_rate());
        mView.getShowRate().setText(bean.getShow_rate() + "%");

        mView.getConsume().setText(bean.getConsume() + "元");
        mView.getConsumeRate().setText(bean.getConsume_rate() + "%");
        setBGDrawable(mView.getDrableIcon02(), bean.getConsume_rate());

        mView.getShowPeople().setText(bean.getShow_people() + "人");
        mView.getShowPeopleRate().setText(bean.getShow_people_rate() + "%");
        setBGDrawable(mView.getDrableIcon03(), bean.getShow_people_rate());
    }

    private void setBGDrawable(TextView mView, String str) {
        float v = Float.parseFloat(str);
        if (v > 0) {
            Drawable drawable = mContext.getResources().getDrawable(R.mipmap.icon_yun_red);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mView.setCompoundDrawables(null, null, drawable, null);
        } else {
            Drawable drawable = mContext.getResources().getDrawable(R.mipmap.icon_yun_yellow);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mView.setCompoundDrawables(null, null, drawable, null);
        }


    }

    public void showPersonDialog(FragmentActivity activity) {
        List<String> data = new ArrayList<>();
        data.add("展现");
        data.add("展现人数");
        data.add("消费");
        data.add("点击");
        data.add("点击人数");
        showDialog(activity, data, "type");
    }


    public void showDaysDialog(FragmentActivity activity) {
        List<String> data = new ArrayList<>();
        data.add("昨天");
        data.add("过去7天");
        data.add("过去14天");
        data.add("过去30天");
        showDialog(activity, data, "days");
    }

    public String getCurrentDayStr() {
        return currentDayStr;
    }

    public void setCurrentDayStr(String currentDayStr) {
        this.currentDayStr = currentDayStr;
    }

    public String getCurrentTypeStr() {
        return currentTypeStr;
    }

    public void setCurrentTypeStr(String currentTypeStr) {
        this.currentTypeStr = currentTypeStr;
    }
}






















