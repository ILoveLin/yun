package com.company.yun.ui.activity.result;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.result.ResultBean;
import com.company.yun.event.ResultEvent;
import com.company.yun.ui.activity.result.adapter.ResultViewPagerAdapter;
import com.company.yun.view.widget.NoScrollViewPager;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by Lovelin on 2019/5/20
 * <p>
 * Describe:搜索引擎结果----------渠道分布结果的界面
 */
public class ResultActivity extends BaseActivity {

    public String[] tabString = {"计划", "单元", "关键字", "创意"};
    @BindView(R.id.tab_layout)
    XTabLayout tabLayout;
    @BindView(R.id.iv_baidu)
    ImageView iv_baidu;
    @BindView(R.id.iv_360)
    ImageView iv_360;
    @BindView(R.id.iv_dog)
    ImageView iv_dog;
    @BindView(R.id.iv_shenma)
    ImageView iv_shenma;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    private ResultViewPagerAdapter mAdapter;
    private String name;
    private String keyword;
    public static  ResultBean.DataBean data;

    @Override
    public int getContentViewId() {
        return R.layout.activity_result;
    }

    @Override
    public void init() {
        initView();
        responseListener(keyword);
    }

    private void responseListener(final String keyword) {
        showLoading();
        OkHttpUtils.post()
                .url(HttpConstants.Channel_Result)
                .addParams("keyword", keyword)
                .addParams("channel", name)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        showContent();
                        ResultBean resultBean = new ResultBean();
                        resultBean.getAllData(response);
                        data = resultBean.getData();
                        EventBus.getDefault().post(new ResultEvent(data));


                    }
                });


    }

    private void initView() {
        StatusBarUtils.setColor(getActivity(), getResources().getColor(R.color.statue_bar), 0);
        StatusBarUtil.darkMode(getActivity(), false);  //设置了状态栏文字的颜色
        setPageStateView();
        mAdapter = new ResultViewPagerAdapter(getSupportFragmentManager(), tabString);
        viewpager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewpager);
        setTitleName("搜索引擎结果");
        name = getIntent().getStringExtra("name");
        keyword = getIntent().getStringExtra("keyword");
        switchType();
    }

    private void switchType() {
        iv_baidu.setVisibility(View.GONE);
        iv_360.setVisibility(View.GONE);
        iv_dog.setVisibility(View.GONE);
        iv_shenma.setVisibility(View.GONE);
        switch (name) {
            case "百度":
                iv_baidu.setVisibility(View.VISIBLE);
                break;
            case "360":
                iv_360.setVisibility(View.VISIBLE);
                break;
            case "搜狗":
                iv_dog.setVisibility(View.VISIBLE);
                break;
            case "神马":
                iv_shenma.setVisibility(View.VISIBLE);
                break;
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
