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
import com.company.yun.ui.fragment.financedata.adapter.TopAdapter;
import com.company.yun.ui.fragment.financedata.adapter.UnderAdapter;
import com.company.yun.ui.fragment.financedata.presenter.FinanceDataPresenter;
import com.company.yun.ui.fragment.financedata.presenter.FinanceDataView;
import com.company.yun.utils.NetworkUtil;
import com.company.yun.view.widget.DayAxisValueFormatter;
import com.company.yun.view.widget.MyMarkerView;
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
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.model.GradientColor;

import java.util.ArrayList;
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
    float myDateY[] = new float[]{8, 6, 16, 14, 12, 12, 2, 8, 14, 12, 6, 6, 4, 18, 16, 6, 8, 4, 8, 4, 16};
    float myDateLineY[] = new float[]{8, 6, 14, 6, 4, 14, 14, 12, 4, 4, 6, 8, 10, 4, 12, 8, 10, 10, 14, 12, 10};

    protected final String[] mXDate = new String[]{
            "9:44:54", "9:44:53", "9:44:52", "9:44:51", "9:44:50", "9:44:49", "9:44:48", "9:44:47",
            "9:44:46", "9:44:45", "9:44:44", "9:44:43", "9:44:42", "9:44:41", "9:44:40", "9:44:39",
            "9:44:38", "9:44:37", "9:44:36", "9:44:35", "9:44:34"};

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

    @Override
    public int getContentViewId() {
        return R.layout.fragment_01;
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
        setPageStateView();
        responseListener();
        initChart01();
        initChart02();
        initChart03();
        initChart04();
        initRecycleView();
    }

    private void initRecycleView() {
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringList.add("政通有限公司" + "==" + i);
        }

        topLinearLayoutManager = new LinearLayoutManager(getContext());
        topLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTopRecycleView.setLayoutManager(topLinearLayoutManager);
        mTopAdapter = new TopAdapter(stringList, getActivity());
        mTopRecycleView.setAdapter(mTopAdapter);

        underlinearLayoutManager = new LinearLayoutManager(getContext());
        underlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mUnderRecycleView.setLayoutManager(underlinearLayoutManager);
        mUnderAdapter = new UnderAdapter(stringList, getActivity());
        mUnderRecycleView.setAdapter(mUnderAdapter);


    }
    //初始化04-同比-曲线图

    private void initChart04() {
        // background color
        chart04.setBackgroundColor(Color.WHITE);
        // disable description text
        chart04.getDescription().setEnabled(false);
        // enable touch gestures
        chart04.setTouchEnabled(true);
        // set listeners
        chart04.setDrawGridBackground(false);
        // create marker to display box when values are selected
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        // Set the marker to the chart
        mv.setChartView(chart04);
        chart04.setMarker(mv);
        // enable scaling and dragging
        chart04.setDragEnabled(false);
        chart04.setScaleEnabled(true);
        chart04.setPinchZoom(true);
        XAxis xAxis = chart04.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return mXDate[(int) value % mXDate.length];
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
        // add data
//        setChart01Data();
        setChartLineData(chart04, myDateLineY);
        // draw points over time
//        chart.animateX(1500);
        // get the legend (only possible after setting data)
        Legend l = chart04.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"

    }
    //初始化03-环比-曲线图

    private void initChart03() {
        // background color
        chart03.setBackgroundColor(Color.WHITE);
        // disable description text
        chart03.getDescription().setEnabled(false);
        // enable touch gestures
        chart03.setTouchEnabled(true);
        // set listeners
        chart03.setDrawGridBackground(false);
        // create marker to display box when values are selected
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        // Set the marker to the chart
        mv.setChartView(chart03);
        chart03.setMarker(mv);
        // enable scaling and dragging
        chart03.setDragEnabled(false);
        chart03.setScaleEnabled(true);
        chart03.setPinchZoom(true);
        XAxis xAxis = chart03.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return mXDate[(int) value % mXDate.length];
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
        // add data
        setChartLineData(chart03, myDateLineY);
        // draw points over time
//        chart.animateX(1500);
        // get the legend (only possible after setting data)
        Legend l = chart03.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"

    }

    //初始化02--柱状图

    private void initChart02() {

        chart02.setDrawBarShadow(false);
        chart02.setDrawValueAboveBar(true);

        chart02.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart02.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart02.setPinchZoom(false);

        chart02.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(chart02);

        XAxis xAxis = chart02.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);   //画虚线
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return mXDate[(int) value % mXDate.length];
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
        setChart02Data();
        Legend l = chart02.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        // chart.setDrawLegend(false);
    }

    private void setChart02Data() {

        float start = 1f;
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new BarEntry(i, myDateY[i]));

        }

        BarDataSet set1;
        if (chart02.getData() != null &&
                chart02.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart02.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart02.getData().notifyDataChanged();
            chart02.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "柱状图");
            set1.setDrawIcons(false);
            int startColor1 = ContextCompat.getColor(getContext(), R.color.color_50b3ff);
            int endColor1 = ContextCompat.getColor(getContext(), R.color.color_50b3ff);
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
    private void initChart01() {
        // background color
        chart01.setBackgroundColor(Color.WHITE);
        // disable description text
        chart01.getDescription().setEnabled(false);
        // enable touch gestures
        chart01.setTouchEnabled(true);
        // set listeners
        chart01.setDrawGridBackground(false);
        // create marker to display box when values are selected
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        // Set the marker to the chart
        mv.setChartView(chart01);
        chart01.setMarker(mv);
        // enable scaling and dragging
        chart01.setDragEnabled(false);
        chart01.setScaleEnabled(true);
        chart01.setPinchZoom(true);
        XAxis xAxis = chart01.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return mXDate[(int) value % mXDate.length];
            }
        });
        YAxis yAxis;
        yAxis = chart01.getAxisLeft();
        // disable dual axis (only use LEFT axis)
        chart01.getAxisRight().setEnabled(false);
        // horizontal grid lines
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        // draw limit lines behind data instead of on top
        yAxis.setDrawLimitLinesBehindData(true);
        // add data
//        setChart01Data();
        setChartLineData(chart01, myDateLineY);
        // draw points over time
//        chart.animateX(1500);
        // get the legend (only possible after setting data)
        Legend l = chart01.getLegend();
        // draw legend entries as lines
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
    }


    public void setChartLineData(LineChart chart, float myDateLineY[]) {
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new Entry(i, myDateLineY[i]));
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
            set1 = new LineDataSet(values, "曲线图");
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);   //更改直线的方式
            set1.setDrawIcons(false);

            // draw dashed line     //链接线
//            set1.enableDashedLine(10f, 5f, 0f);

            // black lines and points
            set1.setColor(getResources().getColor(R.color.color_50b3ff));
            set1.setCircleColor(getResources().getColor(R.color.color_50b3ff));

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
