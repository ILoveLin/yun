package com.company.yun.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lovelin on 2019/5/22
 * <p>
 * Describe:
 */
public class YunMapActivity extends BaseActivity {

    @BindView(R.id.bmapView)
    MapView mMapView;
    private BaiduMap mBaiduMap;

    @Override
    public int getContentViewId() {
        return R.layout.activity_yunmap;
    }

    @Override
    public void init() {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        setTitleBarVisibility(View.GONE);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //开启热力图
        mBaiduMap.setBaiduHeatMapEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }



}
