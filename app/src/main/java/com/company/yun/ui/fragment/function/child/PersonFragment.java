package com.company.yun.ui.fragment.function.child;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.base.Constants;
import com.company.yun.bean.function.PersonBean;
import com.company.yun.ui.fragment.function.child.person.PersonPresenter;
import com.company.yun.ui.fragment.function.child.person.PersonView;
import com.company.yun.utils.DataUtils;
import com.company.yun.view.widget.DayAxisValueFormatter;
import com.company.yun.view.widget.DayProvinceAxisValueFormatter;
import com.company.yun.view.widget.XYMarkerView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:人物画像
 */
public class PersonFragment extends BaseFragment implements PersonView {
    @BindView(R.id.pic_chart_sex)
    PieChart picChartSex;
    @BindView(R.id.bar_chart_province)
    BarChart barChartProvince;
    @BindView(R.id.pic_chart_age)
    PieChart picChartAge;
    @BindView(R.id.bar_chart_city)
    BarChart barChartCity;
    @BindView(R.id.pic_chart_xiaofei)
    PieChart picChartXiaofei;
    @BindView(R.id.bar_chart_study)
    BarChart barChartStudy;
    @BindView(R.id.linear_under_age)
    LinearLayout linearUnderAge;
    @BindView(R.id.linear_under_sex)
    LinearLayout linearUnderSex;
    @BindView(R.id.linear_under_city)
    TextView linearUnderCity;
    @BindView(R.id.person_all_tab)
    LinearLayout personAllTab;
    @BindView(R.id.bottom_chart01)
    BarChart bottomChart01;
    @BindView(R.id.bottom_chart02)
    BarChart bottomChart02;
    @BindView(R.id.bottom_chart03)
    BarChart bottomChart03;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private PersonPresenter mPresenter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void init(ViewGroup rootView) {
        mPresenter = new PersonPresenter(this, getActivity());
        initView();
        mPresenter.sendRequest("口红");
    }

    private void initView() {

        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();
        showContent();
        ArrayList<String> xList = new ArrayList<>();
        xList.add("51.34");
        xList.add("48.66");
        ArrayList<String> yList = new ArrayList<>();
        yList.add("女");
        yList.add("男");
        ArrayList<String> barList = new ArrayList<>();
        barList.add("广东");
        barList.add("山东");
        barList.add("河南");
        barList.add("江苏");
        barList.add("浙江");
        barList.add("河北");  //6
        float[] floats = DataUtils.toFloat(xList);
        float myDatyLineY[] = new float[]{8, 6, 14, 6, 4, 14};

        initPicChart(picChartSex, yList, floats, "picSex");
        initBarChart(barChartProvince, barList, myDatyLineY);
        bottomChart03.setVisibility(View.VISIBLE);
//        initThreeBsrChart(bottomChart03, DataUtils.get6List(xList), "6");
    }

    //刷新数据
    @Override
    public void refreshData(PersonBean mBean) {
        //x  文字说明
        List<String> xCityList = mBean.getData().getIndustry().getCity().getX();
        //y 一个柱体  有几个类别组成
        List<String> yCityList = mBean.getData().getIndustry().getCity().getY();
        //z 每个柱体,每种类型的数据
        List<List<String>> zCityList = mBean.getData().getIndustry().getCity().getZ();

        initThreeBsrChart(bottomChart03, DataUtils.get6List(xCityList), "6");


    }

    protected final String[] mXString = new String[]{
            "办公效率", "生活实用", "丽人母婴", "图像", "运动健康", "生活服务"};

    float mYList01[] = new float[]{8, 6, 16, 14, 12, 12, 2, 8, 14, 12, 6, 6, 4, 18, 16, 6, 8, 4, 8, 4, 16};
    float mYList02[] = new float[]{8, 6, 14, 6, 4, 14, 14, 12, 4, 4, 6, 8, 10, 4, 12, 8, 10, 10, 14, 12, 10};
    float mYList03[] = new float[]{8, 6, 14, 6, 4, 14, 14, 12, 4, 4, 6, 8, 10, 4, 12, 8, 10, 10, 14, 12, 10};


    //设置---树状图
    private void initBarChart(BarChart chart, final List<String> data, float[] floats) {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(chart);
        XAxis xAxis = chart.getXAxis();
        DayProvinceAxisValueFormatter dayAxisValueFormatter = new DayProvinceAxisValueFormatter(chart);    //设置底部文字
        xAxis.enableGridDashedLine(10f, 10f, 0f);   //画虚线
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(dayAxisValueFormatter);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return data.get((int) value % data.size());
            }
        });
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        XYMarkerView mv = new XYMarkerView(getContext(), xAxisFormatter);    //点击柱状图显示信息
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart
        setChartBarData(floats, chart);
        Legend l = chart.getLegend();
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        //取消默认顶部值
        chart.invalidate();
    }


    private void setChartBarData(float[] floats, BarChart chart) {
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new BarEntry(i, floats[i]));
        }
        BarDataSet set1;
        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "");
            set1.setDrawIcons(false);
            int startColor1 = ContextCompat.getColor(getContext(), R.color.color_21ac90);
            int endColor1 = ContextCompat.getColor(getContext(), R.color.color_21ac90);
            List<GradientColor> gradientColors = new ArrayList<>();
            gradientColors.add(new GradientColor(startColor1, endColor1));
            set1.setGradientColors(gradientColors);
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            float barWidth = 0.4f; // x2 dataset    //这个是树状图的树桩直径
            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            chart.setData(data);
        }
    }

    //设置---圆形图
    private void initPicChart(PieChart mSexChart, List<String> XList, float[] floats, String type) {
        mSexChart.setUsePercentValues(true);
        mSexChart.getDescription().setEnabled(false);
        mSexChart.setExtraOffsets(5, 10, 5, 5);
        mSexChart.setDragDecelerationFrictionCoef(0.95f);
        mSexChart.setDrawHoleEnabled(true);
        mSexChart.setHoleColor(Color.WHITE);
        mSexChart.setTransparentCircleColor(Color.WHITE);
        mSexChart.setTransparentCircleAlpha(110);
        mSexChart.setHoleRadius(58f);
        mSexChart.setTransparentCircleRadius(61f);
        mSexChart.setDrawCenterText(true);
        mSexChart.setRotationAngle(0);
        mSexChart.setRotationEnabled(true);
        mSexChart.setHighlightPerTapEnabled(true);
        mSexChart.animateY(1400, Easing.EaseInOutQuad);
        Legend l = mSexChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        mSexChart.setEntryLabelColor(Color.WHITE);
        mSexChart.setEntryLabelTextSize(12f);
        setPicData(mSexChart, XList, XList.size(), floats, type);


    }

    private void setPicData(PieChart mSexChart, List<String> parties, int count, float[] floats, String type) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (floats[i]),
                    parties.get(i % parties.size())));
        }
        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);
        ArrayList<Integer> colors = new ArrayList<>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(mSexChart));
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mSexChart.setData(data);
//        if ("sex".equals(type)) {
//            mSexChart.invalidate();
//        } else if (isFirstPicRequest) {
//            time++;
//            if (time == 3) {
//                isFirstPicRequest = false;
//            }
        mSexChart.setDrawEntryLabels(!mSexChart.isDrawEntryLabelsEnabled());
        mSexChart.invalidate();
//        } else {
//            //设置全部园
//            if (mSexChart.isDrawHoleEnabled()) {
//                mSexChart.setDrawHoleEnabled(false);
//            } else {
//                mSexChart.setDrawHoleEnabled(true);
//            }
//            mSexChart.invalidate();
    }


    //设置---三种对比的---树状图


    /**
     * @param chart
     * @param typeNum 一个柱状有一个组成成分
     * @param xList   类型分布
     */
    private void initThreeBsrChart(BarChart chart, List<String> xList, String typeNum) {
        chart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(40);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawGridBackground(false);
        chart.setDrawBarShadow(false);

        chart.setDrawValueAboveBar(false);
        chart.setHighlightFullBarEnabled(false);

        // change the position of the y-labels
        YAxis leftAxis = chart.getAxisLeft();
//        leftAxis.setValueFormatter(new DayAxisValueFormatter(chart));
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        chart.getAxisRight().setEnabled(false);

        DayAxisValueFormatter dayAxisValueFormatter = new DayAxisValueFormatter(chart);    //设置底部文字
//        DayAxisValueFormatter dayAxisValueFormatter = new DayAxisValueFormatter(mChart);
        XAxis xLabels = chart.getXAxis();
        xLabels.setPosition(XAxis.XAxisPosition.BOTTOM);
        xLabels.setValueFormatter(dayAxisValueFormatter);

        // mChart.setDrawXLabels(false);
        // mChart.setDrawYLabels(false);
        // setting data
        setThreeBarData(chart, xList, typeNum);//stacksize  显示几种颜色
        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);
    }

    private void setThreeBarData(BarChart chart, List<String> xList, String typeNum) {  //mXlist===6
        ArrayList<BarEntry> yVals1 = new ArrayList<>();


        switch (typeNum) {
            case "2":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{mYList01[i], mYList03[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "3":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{mYList01[i], mYList03[i], mYList02[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "6":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{mYList01[i], mYList02[i],
                            mYList03[i], mYList01[i], mYList02[i], mYList01[i]});
                    yVals1.add(barEntry);
                }
                break;
        }
        BarDataSet set1;
        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "  测试数据");
            set1.setColors(getColors(typeNum));
            switch (typeNum) {
                case "2":
                    set1.setStackLabels(new String[]{"青少年", "成年人"});

                    break;
                case "3":
                    set1.setStackLabels(new String[]{"青少年", "成年人", "老年人"});

                    break;
                case "6":
                    set1.setStackLabels(new String[]{"未出生", "婴儿", "儿童", "青少年", "成年人", "老年人"});

                    break;
            }
//            set1.setStackLabels(new String[]{"青少年", "成年人", "老年人"});

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
//            data.setValueFormatter(new MyAxisValueFormatter());
            data.setValueTextColor(Color.WHITE);

            float barWidth = 0.5f; // x2 dataset    //这个是树状图的树桩直径
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);


            chart.setData(data);
        }


        chart.setFitBars(true);
        chart.invalidate();
    }

    private int[] getColors(String stacksize) {

        // have as many colors as stack-values per entry
        int[] colors = new int[Integer.parseInt(stacksize)];

        switch (stacksize) {
            case "2":
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Constants.MATERIAL_COLORS_02[i];
                }
                break;
            case "3":
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Constants.MATERIAL_COLORS_03[i];
                }
                break;
            case "6":
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Constants.MATERIAL_COLORS_06[i];
                }
                break;
        }


        return colors;
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
