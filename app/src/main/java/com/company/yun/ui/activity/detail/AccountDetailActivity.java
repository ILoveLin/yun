package com.company.yun.ui.activity.detail;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.company.yun.bean.account.DetailLineBean;
import com.company.yun.bean.account.DetailListBean;
import com.company.yun.bean.account.TotalBean;
import com.company.yun.ui.activity.detail.adapter.DetailAdapter;
import com.company.yun.ui.activity.detail.adapter.TotalAdapter;
import com.company.yun.ui.activity.detail.presenter.AccountDetailPresenter;
import com.company.yun.ui.activity.detail.presenter.AccountDetailView;
import com.company.yun.utils.DataUtils;
import com.company.yun.view.widget.MyMarkerView;
import com.company.yun.view.widget.MyPersonDayAxisValueFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Lovelin on 2019/5/27
 * <p>
 * Describe:详情
 */
public class AccountDetailActivity extends BaseActivity implements AccountDetailView {

    @BindView(R.id.tv_yesterday)
    TextView tvYesterday;
    @BindView(R.id.tv_weak)
    TextView tvWeak;
    @BindView(R.id.tv_mouth)
    TextView tvMouth;
    @BindView(R.id.tv_half)
    TextView tvHalf;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.chart1)
    LineChart mTChart01;
    @BindView(R.id.underrecycleview)
    RecyclerView mRecycleview;
    @BindView(R.id.toprecycleview)
    RecyclerView mTopcleview;
    @BindView(R.id.smartlayout)
    SmartRefreshLayout mSmartRefresh;
    @BindView(R.id.tv_item_time)
    TextView tvItemTime;
    @BindView(R.id.tv_item_show)
    TextView tvItemShow;
    @BindView(R.id.tv_item_click)
    TextView tvItemClick;
    @BindView(R.id.tv_item_xiaofei)
    TextView tvItemXiaofei;
    @BindView(R.id.tv_item_click_rare)
    TextView tvItemClickRare;
    @BindView(R.id.tv_item_click_price)
    TextView tvItemClickPrice;
    private AccountDetailPresenter mPresenter;
    private ArrayList<DetailListBean.DataEntity.TableEntity> datasList = null;
    private TotalAdapter totalAdapter;
    private int page = 1;
    private DetailAdapter mAdapter;
    private ArrayList<TotalBean> datasTotalList;
    private TotalAdapter mTotalAdapter;


    @Override
    public int getContentViewId() {
        return R.layout.activity_account_detail;
    }

    @Override
    public void init() {
        initView();
        responseListener();
    }

    private void responseListener() {
        mPresenter.sendTotalRequest("4");  //默认给一年的
        mSmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.sendListRequest("4", page, "refresh");
            }
        });
        mSmartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.sendListRequest("4", page, "loadMore");

            }
        });
        mTotalAdapter.setClickCallBack(new TotalAdapter.ItemClickCallBack() {
            @Override
            public void onItemClick(ArrayList<TotalBean> list, int position) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setSelected(false);
                    if(i==position) {
                        list.get(i).setSelected(true);
                    }
                }
                mTotalAdapter.notifyDataSetChanged();
            }
        });

    }

    @OnClick({R.id.tv_yesterday, R.id.tv_weak, R.id.tv_mouth, R.id.tv_half, R.id.tv_year,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_yesterday:
                showToast("暂无数据哦~");
                break;
            case R.id.tv_weak:
                showToast("暂无数据哦~");
                break;
            case R.id.tv_mouth:
                showToast("暂无数据哦~");
                break;
            case R.id.tv_half:
                showToast("暂无数据哦~");
                break;
            case R.id.tv_year:
                changeStutes(tvYear);

                break;
        }


    }

    private void changeStutes(TextView currentView) {
        tvYesterday.setSelected(false);
        tvWeak.setSelected(false);
        tvMouth.setSelected(false);
        tvHalf.setSelected(false);
        tvYear.setSelected(false);
        currentView.setSelected(true);


    }

    private void initView() {
        mPresenter = new AccountDetailPresenter(this, this);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.VISIBLE);
        setTitleName("详情");
        setPageStateView();


        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        linearManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        datasTotalList = new ArrayList<>();
        mTopcleview.setLayoutManager(linearManager);
        mTotalAdapter = new TotalAdapter(datasTotalList, this);
        mTopcleview.setAdapter(mTotalAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        datasList = new ArrayList<>();
        mRecycleview.setLayoutManager(linearLayoutManager);
        mAdapter = new DetailAdapter(datasList, this);
        mRecycleview.setAdapter(mAdapter);

    }

    @Override
    public void refreshRecycleViewData(List<DetailListBean.DataEntity.TableEntity> tableList, String requestType) {
//        datasList.addAll(tableList);
//        mAdapter.notifyDataSetChanged();
        switch (requestType) {
            case "refresh":
//                datasList.clear();
//                datasList.addAll(tableList);
                mSmartRefresh.finishRefresh();
//                mAdapter.notifyDataSetChanged();
                break;
            case "loadMore":
//                datasList.addAll(tableList);
                mSmartRefresh.finishLoadMore();
//                mAdapter.notifyDataSetChanged();
                break;

        }

    }

    @Override
    public void refreshTotalUIData(ArrayList<TotalBean> stringList) {
        datasTotalList.addAll(stringList);
        mTotalAdapter.notifyDataSetChanged();

    }


    //刷新线性图
    @Override
    public void refreshLineUIData(DetailLineBean.DataEntity data) {
        //默认给5个数字
// 参数1 是X  底部标识数据  参数2是Y数据  参数3是x的长度

        List<String> mXDataList = data.getDdate();
        List<String> mYValueList = data.getValue();
        List<String> xList = DataUtils.get6List(mXDataList);
        List<String> yList = DataUtils.get6List(mYValueList);
        initChart01(xList, DataUtils.toFloat(yList), DataUtils.toString(xList));


    }

    private void initChart01(final List<String> data, float[] floats, String[] string) {
        mTChart01.setBackgroundColor(Color.WHITE);
        mTChart01.getDescription().setEnabled(false);
        mTChart01.setTouchEnabled(true);
        mTChart01.setDragEnabled(true);
        mTChart01.setScaleEnabled(true);
        mTChart01.setPinchZoom(true);
        mTChart01.setDrawGridBackground(false);
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        mv.setChartView(mTChart01);
        mTChart01.setMarker(mv);
        MyPersonDayAxisValueFormatter xAxisFormatter = new MyPersonDayAxisValueFormatter(mTChart01, string);
        XAxis xAxis = mTChart01.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(xAxisFormatter);

        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return data.get((int) value % data.size());
            }
        });
        YAxis yAxis;
        yAxis = mTChart01.getAxisLeft();
        mTChart01.getAxisRight().setEnabled(false);
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        yAxis.setDrawLimitLinesBehindData(true);
        setChartLineData(mTChart01, floats);
        Legend l = mTChart01.getLegend();
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        drawNumAndPoint(mTChart01);
        List<ILineDataSet> sets = mTChart01.getData()
                .getDataSets();

        mTChart01.setBackgroundColor(Color.TRANSPARENT);

        yAxis.setTextColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);

//设置网格颜色
        xAxis.setGridColor(Color.WHITE);//设置x线颜色
        yAxis.setGridColor(Color.WHITE);//设置y线颜色
        //画数值
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawValues(false);
            set.setColor(Color.WHITE);
        }

        //画小圆点
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawCircles(false);
        }
        mTChart01.invalidate();
    }

    public void setChartLineData(LineChart chart, float[] floats) {
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new Entry(i, floats[i]));
        }
        LineDataSet set1;
        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);   //更改直线的方式
            set1.notifyDataSetChanged();
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "");
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);   //更改直线的方式
            set1.setDrawIcons(false);
            set1.setColor(getResources().getColor(R.color.white));
            set1.setCircleColor(getResources().getColor(R.color.white));
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);
            set1.setValueTextSize(9f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);   //更改直线的方式
            set1.setLineWidth(1.5f);
            set1.setCircleRadius(4f);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets
            LineData data = new LineData(dataSets);
            chart.setData(data);
        }
    }

    private void drawNumAndPoint(LineChart chart) {
        List<ILineDataSet> sets = chart.getData()
                .getDataSets();
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawValues(!set.isDrawValuesEnabled());
        }
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            if (set.isDrawCirclesEnabled())
                set.setDrawCircles(false);
            else
                set.setDrawCircles(true);
        }
        chart.invalidate();
    }


    /**
     * title 左侧按钮点击事件
     *
     * @param v
     */
    @OnClick(R.id.ib_left)
    public void onClickTitleLeftBtn(View v) {
        this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    @Override
    public void showLoadingView() {
        showLoading();
    }

    @Override
    public void showContentView() {
        showContent();
    }

    @Override
    public void showEmptyView() {
        showEmpty();
    }

    @Override
    public void showErrorView() {
        showError();
    }


}





















































