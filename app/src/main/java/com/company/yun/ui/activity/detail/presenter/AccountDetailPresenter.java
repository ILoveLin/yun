package com.company.yun.ui.activity.detail.presenter;

import android.content.Context;
import android.util.Log;

import com.company.yun.base.Constants;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.account.DetailLineBean;
import com.company.yun.bean.account.DetailListBean;
import com.company.yun.bean.account.DetailTotalBean;
import com.company.yun.bean.account.TotalBean;
import com.company.yun.utils.DataUtils;
import com.yun.common.utils.SharePreferenceUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/27
 * <p>
 * Describe:
 */
public class AccountDetailPresenter {

    private Context mContext;
    private AccountDetailView mView;
    private final String id;
    private final DetailTotalBean mBean;

    public AccountDetailPresenter(Context mContext, AccountDetailView mView) {
        id = (String) SharePreferenceUtil.get(mContext, Constants.ID, "");
        this.mContext = mContext;
        this.mView = mView;
        mBean = new DetailTotalBean();
    }


    //
    public void sendTotalRequest(final String type) {
        if ("".equals(id)) {
            mView.showToast("id不能未空");
            return;
        }
        OkHttpUtils.post()
                .url(HttpConstants.Account_Detail_Total)
                .addParams("id", id)
                .addParams("type", type)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mBean.getAllData(response);
                        String status = mBean.getStatus();
                        if ("0".equals(status)) {
                            mView.showContentView();
                            DetailTotalBean.DataEntity data = mBean.getData();
                            ArrayList<TotalBean> stringList = new ArrayList<>();
                            String consume = data.getConsume();
                            String shows = data.getShows();
                            String click = data.getClick();
                            int idx = consume.lastIndexOf(".");//查找小数点的位置
                            String strNum = consume.substring(0, idx);//截取从字符串开始到小数点位置的字符串，就是整数部分
                            int num = Integer.valueOf(strNum);//把整数部分通过Integer.valueof方法转换为数字
                            DecimalFormat df = new DecimalFormat("0.00");
                            String formatClick_price = df.format((float) num / Integer.parseInt(click));
                            String formatClick_rate = DataUtils.division(Integer.parseInt(click), Integer.parseInt(shows));
                            for (int i = 0; i < 5; i++) {
                                TotalBean totalBean = new TotalBean();
                                totalBean.setSelected(false);
                                switch (i) {
                                    case 0:
                                        totalBean.setText("总消费");
                                        totalBean.setData(data.getConsume());
                                        totalBean.setSelected(true);
                                        break;
                                    case 1:
                                        totalBean.setText("总展现");
                                        totalBean.setData(data.getShows());
                                        break;
                                    case 2:
                                        totalBean.setText("总点击");
                                        totalBean.setData(data.getClick());
                                        break;
                                    case 3:
                                        totalBean.setText("总点击率");
                                        totalBean.setData(formatClick_rate);
                                        break;
                                    case 4:
                                        totalBean.setText("总平均点击价格");
                                        totalBean.setData(formatClick_price + "%");
                                        break;

                                }
                                stringList.add(totalBean);
                            }


//                            ArrayList<String> stringList = new ArrayList<>();
//                            stringList.add(data.getConsume());
//                            stringList.add(data.getShows());
//                            stringList.add(data.getClick());
//
//                            //总点击率  ==总点击/总展现    --进二位家百分百号
//                            //平均点击价格 ==总消费/总点击 --直接加百分百号
//                            stringList.add(formatClick_rate);
//                            stringList.add(formatClick_price + "%");


                            mView.refreshTotalUIData(stringList);
                            sendLineRequest(type + "", "click");  //默认是消费
                        } else {
                            mView.showErrorView();
                            mView.showToast("数据解析错误");

                        }

                    }
                });


    }


    //时间类型,1:7日,2:30日,3:半年,4:一年
    //	类型,shows:展现,consume:消费,click:点击量,click_rate:点击率,click_price:点击价格
    public void sendLineRequest(String type, String line_type) {
        //type  时间      line_type   类型       //默认是  最近一年  和 总消费
        if ("".equals(id)) {
            mView.showToast("id不能未空");
            return;
        }
        OkHttpUtils.post()
                .url(HttpConstants.Account_Detail_Line)
                .addParams("id", id)
                .addParams("type", type)
                .addParams("line_type", line_type)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("哈哈哈", "response=====" + response);
                        DetailLineBean detailLineBean = new DetailLineBean();
                        detailLineBean.getAllData(response);
                        String status = detailLineBean.getStatus();
                        DetailLineBean.DataEntity data = detailLineBean.getData();
                        if ("0".equals(status)) {
                            mView.showContentView();
                            mView.refreshLineUIData(data);
                            sendListRequest(4 + "", 1, "refresh");
                        } else {
                            mView.showErrorView();
                            mView.showToast("数据解析错误");

                        }

                    }
                });


    }

    //
    public void sendListRequest(String type, int page, final String requestType) {
        //type  时间类型,1:7日,2:30日,3:半年,4:一年
        if ("".equals(id)) {
            mView.showToast("id不能未空");
            return;
        }
        OkHttpUtils.post()
                .url(HttpConstants.Account_Detail_List)
                .addParams("id", id)
                .addParams("type", type)
                .addParams("page", page + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mView.showErrorView();
                        mView.showToast("请求错误");
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        DetailListBean detailListBean = new DetailListBean();
                        detailListBean.getAllData(response);
                        String status = detailListBean.getStatus();
                        DetailListBean.DataEntity data = detailListBean.getData();
                        List<DetailListBean.DataEntity.TableEntity> table = data.getTable();
                        if ("0".equals(status)) {
                            mView.showContentView();
                            mView.refreshRecycleViewData(table, requestType);
                        } else {
                            mView.showErrorView();
                            mView.showToast("数据解析错误");

                        }

                    }
                });


    }

}
