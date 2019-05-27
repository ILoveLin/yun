package com.company.yun.ui.fragment.financedata;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.financedata.FinanceDataBean;
import com.company.yun.ui.fragment.financedata.adapter.TopAdapter;
import com.company.yun.ui.fragment.financedata.adapter.UnderAdapter;
import com.company.yun.ui.fragment.financedata.presenter.FinanceDataPresenter;
import com.company.yun.ui.fragment.financedata.presenter.FinanceDataView;
import com.company.yun.utils.DataUtils;
import com.company.yun.utils.NetworkUtil;
import com.company.yun.view.widget.DayAxisValueFormatter;
import com.company.yun.view.widget.MyMarkerView;
import com.company.yun.view.widget.MyPersonDayAxisValueFormatter;
import com.company.yun.view.widget.SettingBar;
import com.company.yun.view.widget.XYMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.model.GradientColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:财务数据--01
 */
public class FinanceDataFragment extends BaseFragment implements FinanceDataView {
    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    @BindView(R.id.chart1)
    LineChart chart01;
    @BindView(R.id.chart02)
    BarChart chart02;
    @BindView(R.id.chart3)
    LineChart chart03;
    @BindView(R.id.chart4)
    LineChart chart04;
    @BindView(R.id.setting_bar_01)
    SettingBar mSettingBar01;
    @BindView(R.id.setting_bar_02)
    SettingBar mSettingBar02;
    @BindView(R.id.setting_bar_03)
    SettingBar mSettingBar03;
    @BindView(R.id.recycleview_top)
    RecyclerView mTopRecycleView;
    @BindView(R.id.recycleview_under)
    RecyclerView mUnderRecycleView;
    Unbinder unbinder;
    private FinanceDataPresenter mPresenter;
    protected Typeface tfLight;
    private TopAdapter mTopAdapter;
    private LinearLayoutManager topLinearLayoutManager;
    private LinearLayoutManager underlinearLayoutManager;
    private UnderAdapter mUnderAdapter;
    private List<FinanceDataBean.DataBean.Recharge_companys_listEntity> rechargeCompanysList;
    private List<FinanceDataBean.DataBean.Recharge_listEntity> rechargeList;
    private ArrayList<FinanceDataBean.DataBean.Recharge_companys_listEntity> mTopDataList;
    private ArrayList<FinanceDataBean.DataBean.Recharge_listEntity> mUnderDataList;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_finance;
    }

    @Override
    public void init(ViewGroup rootView) {
        mPresenter = new FinanceDataPresenter(getActivity(), this);
        initView();
    }

    @Override
    protected void onClickRetry() {
        super.onClickRetry();
        if (NetworkUtil.CheckConnection(getActivity())) {
            mPresenter.sendRequest();
        }
    }

    private void initView() {
        setTitleBarVisibility(View.VISIBLE);
        setTitleName("财务数据");
        setTitleLeftBtnVisibility(View.GONE);
        mSettingBar01.setLineVisible(false);
        mSettingBar02.setLineVisible(false);
        mSettingBar03.setLineVisible(false);
        setPageStateView();
        responseListener();
    }

    //请求成功之后刷新UI数据
    @Override
    public void refreshUIData(FinanceDataBean.DataBean mDataBean) {
        //Top客户充值数据
        //recharge_companys_list
        rechargeCompanysList = mDataBean.getRecharge_companys_list();

        //充值数据
        //recharge_list
        rechargeList = mDataBean.getRecharge_list();
        initRecycleView(rechargeCompanysList, rechargeList);


        //Log.e("Net", "data==refreshRecycleViewData===" + mDataBean.toString());
        FinanceDataBean.DataBean.Recharge_list_dataEntity bean = mDataBean.getRecharge_list_data();
        List<String> data = bean.getDdate();
        List<String> money = bean.getMyMoney();
        //充值图表
        Collections.sort(data);
        initChart01(data, DataUtils.toFloat(money));
        FinanceDataBean.DataBean.RatioEntity.MonthEntity month = mDataBean.getRatio().getMonth();


        //充值柱状图
        //ratio---month---(x---data   y-----money)
        List<String> ddate = month.getDdate();
        List<String> money1 = month.getMoney();
        List<String> ratio = month.getRatio();
        initChart02(ddate, DataUtils.toFloat(money1), DataUtils.toString(data));
        //环比
        //ratio---month---(x---data   y-----ratio)
        Collections.sort(ddate);

        initChart03(ddate, DataUtils.toFloat(ratio));
        //同比
        //ratio---year---(x---data   y-----ratio)
        FinanceDataBean.DataBean.RatioEntity.YearEntity year = mDataBean.getRatio().getYear();
        List<String> ddate1 = year.getDdate();
        List<String> ratio1 = year.getRatio();
        Collections.sort(ddate1);
        initChart04(ddate1, DataUtils.toFloat(ratio1));

    }

    @Override
    public SettingBar getSettingBar01() {
        return mSettingBar01;
    }

    @Override
    public SettingBar getSettingBar02() {
        return mSettingBar02;
    }

    @Override
    public SettingBar getSettingBar03() {
        return mSettingBar03;
    }

    private void initRecycleView(List<FinanceDataBean.DataBean.Recharge_companys_listEntity> rechargeCompanysList,
                                 List<FinanceDataBean.DataBean.Recharge_listEntity> rechargeList) {
        mTopDataList = new ArrayList<>();
        mUnderDataList = new ArrayList<>();
        mTopDataList.addAll(rechargeCompanysList);
        mUnderDataList.addAll(rechargeList);

        topLinearLayoutManager = new LinearLayoutManager(getContext());
        topLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTopRecycleView.setLayoutManager(topLinearLayoutManager);
        mTopAdapter = new TopAdapter(mTopDataList, getActivity());
        mTopRecycleView.setAdapter(mTopAdapter);
        mTopRecycleView.setBackgroundColor(getResources().getColor(R.color.white_85));
        underlinearLayoutManager = new LinearLayoutManager(getContext());
        underlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mUnderRecycleView.setLayoutManager(underlinearLayoutManager);
        mUnderAdapter = new UnderAdapter(mUnderDataList, getActivity());
        mUnderRecycleView.setAdapter(mUnderAdapter);
        mUnderRecycleView.setBackgroundColor(getResources().getColor(R.color.white_85));



    }
    //初始化04-同比-曲线图

    private void initChart04(final List<String> data, float[] floats) {
        // background color
        chart04.setBackgroundColor(Color.WHITE);
        // disable description text
        chart04.getDescription().setEnabled(false);
        // enable touch gestures
        chart04.setTouchEnabled(true);
        // set listeners
        chart04.setDrawGridBackground(false);
        chart04.setTouchEnabled(true);
        chart04.setDragEnabled(true);
        chart04.setScaleEnabled(true);
        chart04.setPinchZoom(true);
        // create marker to display box when values are selected
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        // Set the marker to the chart
        mv.setChartView(chart04);
        chart04.setMarker(mv);
        // enable scaling and dragging

        XAxis xAxis = chart04.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return data.get((int) value % data.size());
            }
        });
        YAxis yAxis;
        yAxis = chart04.getAxisLeft();
        // disable dual axis (only use LEFT axis)
        chart04.getAxisRight().setEnabled(false);
        // horizontal grid lines
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        // draw limit lines behind data instead of on top
        yAxis.setDrawLimitLinesBehindData(true);

        chart04.setBackgroundColor(Color.TRANSPARENT);

        yAxis.setTextColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);

        //设置网格颜色
        xAxis.setGridColor(Color.WHITE);//设置x线颜色
        yAxis.setGridColor(Color.WHITE);//设置y线颜色

        // add data
//        setChart01Data();
        setChartLineData(chart04, floats);
        // draw points over time
//        chart.animateX(1500);
        // get the legend (only possible after setting data)
        Legend l = chart04.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        drawNumAndPoint(chart04);

    }
    //初始化03-环比-曲线图

    private void initChart03(final List<String> data, float[] floats) {
        // background color
        chart03.setBackgroundColor(Color.WHITE);
        // disable description text
        chart03.getDescription().setEnabled(false);
        // enable touch gestures
        chart03.setTouchEnabled(true);
        // set listeners
        chart03.setDrawGridBackground(false);
        // enable scaling and dragging
        chart03.setTouchEnabled(true);
        chart03.setDragEnabled(true);
        chart03.setScaleEnabled(true);
        chart03.setPinchZoom(true);
        // create marker to display box when values are selected
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        // Set the marker to the chart
        mv.setChartView(chart03);
        chart03.setMarker(mv);

        XAxis xAxis = chart03.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return data.get((int) value % data.size());
            }
        });

        YAxis yAxis;
        yAxis = chart03.getAxisLeft();
        // disable dual axis (only use LEFT axis)
        chart03.getAxisRight().setEnabled(false);
        // horizontal grid lines
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        // draw limit lines behind data instead of on top
        yAxis.setDrawLimitLinesBehindData(true);

        chart03.setBackgroundColor(Color.TRANSPARENT);

        yAxis.setTextColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);

        //设置网格颜色
        xAxis.setGridColor(Color.WHITE);//设置x线颜色
        yAxis.setGridColor(Color.WHITE);//设置y线颜色


        // add data
        setChartLineData(chart03, floats);
        // draw points over time
//        chart.animateX(1500);
        // get the legend (only possible after setting data)
        Legend l = chart03.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        drawNumAndPoint(chart03);

    }

    //初始化02--柱状图

    private void initChart02(final List<String> data, float[] floats, String[] string) {

        chart02.setDrawBarShadow(false);
        chart02.setDrawValueAboveBar(true);

        chart02.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
//        chart02.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        chart02.setPinchZoom(false);

        chart02.setDrawGridBackground(false);
        chart02.setBackgroundColor(Color.TRANSPARENT);
        // chart.setDrawYLabels(false);

        MyPersonDayAxisValueFormatter xAxisFormatter = new MyPersonDayAxisValueFormatter(chart02, string);

        XAxis xAxis = chart02.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);   //画虚线

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return data.get((int) value % data.size());
            }
        });

//        ValueFormatter custom = new MyValueFormatter("");    设置自定义文字   Y轴上

        YAxis leftAxis = chart02.getAxisLeft();
//        leftAxis.setTypeface(tfLight);
        leftAxis.setLabelCount(8, false);
//        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = chart02.getAxisRight();
        rightAxis.setEnabled(false);
        XYMarkerView mv = new XYMarkerView(getContext(), xAxisFormatter);    //点击柱状图显示信息
        mv.setChartView(chart02); // For bounds control
        chart02.setMarker(mv); // Set the marker to the chart
        setChart02Data(floats);
        Legend l = chart02.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        // chart.setDrawLegend(false);


        leftAxis.setTextColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);
        //设置网格颜色
        xAxis.setGridColor(Color.WHITE);//设置x线颜色
        leftAxis.setGridColor(Color.WHITE);//设置y线颜色
        //取消默认顶部值
        for (IDataSet set : chart02.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());

        chart02.invalidate();

    }

    private void setChart02Data(float[] floats) {

        float start = 1f;
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < floats.length; i++) {
            values.add(new BarEntry(i, floats[i]));

        }

        BarDataSet set1;
        if (chart02.getData() != null &&
                chart02.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart02.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart02.getData().notifyDataChanged();
            chart02.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "");
            set1.setDrawIcons(false);
            int startColor1 = ContextCompat.getColor(getContext(), R.color.zise);
            int endColor1 = ContextCompat.getColor(getContext(), R.color.zise);
//            int startColor1 = ContextCompat.getColor(getContext(), android.R.color.holo_orange_light);
//            int endColor1 = ContextCompat.getColor(getContext(), android.R.color.holo_orange_light);
            List<GradientColor> gradientColors = new ArrayList<>();
            gradientColors.add(new GradientColor(startColor1, endColor1));
            set1.setGradientColors(gradientColors);
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            float barWidth = 0.4f; // x2 dataset    //这个是树状图的树桩直径
            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            chart02.setData(data);
        }
    }

    //初始化02--充值图表
    private void initChart01(final List<String> data, float[] floats) {
        // background color
        // disable description text
        chart01.getDescription().setEnabled(false);
        // enable touch gestures
        chart01.setTouchEnabled(true);
        chart01.setDragEnabled(true);
        chart01.setScaleEnabled(true);
        chart01.setPinchZoom(true);

        // set listeners

        // create marker to display box when values are selected
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        // Set the marker to the chart
        mv.setChartView(chart01);
        chart01.setMarker(mv);
        // enable scaling and dragging
        XAxis xAxis = chart01.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setGridColor(Color.WHITE);//设置竖线颜色
//        xAxis.setAxisLineColor(Color.RED);//设置x轴线颜色
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return data.get((int) value % data.size());
            }
        });
        xAxis.setTextColor(Color.WHITE);
        YAxis yAxis;
        yAxis = chart01.getAxisLeft();
        chart01.setBackgroundColor(Color.TRANSPARENT);
        // disable dual axis (only use LEFT axis)
        chart01.getAxisRight().setEnabled(false);
        // horizontal grid lines
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        // draw limit lines behind data instead of on top
        yAxis.setDrawLimitLinesBehindData(true);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setGridColor(Color.WHITE);//设置竖线颜色
        chart01.setDrawGridBackground(false);

        // add data
//        setChart01Data();
        setChartLineData(chart01, floats);
        // draw points over time
//        chart.animateX(1500);
        // get the legend (only possible after setting data)
        Legend l = chart01.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        drawNumAndPoint(chart01);


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


    public void setChartLineData(LineChart chart, float[] floats) {
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < floats.length; i++) {
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
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "");
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);   //更改直线的方式
            set1.setDrawIcons(false);

            // draw dashed line     //链接线
//            set1.enableDashedLine(10f, 5f, 0f);

            // black lines and points
            set1.setColor(Color.WHITE);
            set1.setCircleColor(Color.WHITE);

            // line thickness and point size
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);

            // draw points as solid circles
            set1.setDrawCircleHole(false);

            // customize legend entry
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            // text size of values
            set1.setValueTextSize(9f);

            // draw selection line as dashed
            set1.enableDashedHighlightLine(10f, 5f, 0f);


            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);   //更改直线的方式
            set1.setLineWidth(1.5f);
            set1.setCircleRadius(4f);


            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets

            // create a data object with the data sets
            LineData data = new LineData(dataSets);

            // set data
            chart.setData(data);
        }
    }


    private void responseListener() {
        mPresenter.sendRequest();
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
