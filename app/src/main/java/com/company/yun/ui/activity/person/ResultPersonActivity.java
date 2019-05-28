package com.company.yun.ui.activity.person;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.company.yun.base.Constants;
import com.company.yun.bean.function.PersonBean;
import com.company.yun.ui.activity.person.presenter.PersonPresenter;
import com.company.yun.ui.activity.person.presenter.PersonView;
import com.company.yun.utils.DataUtils;
import com.company.yun.view.widget.DayProvinceAxisValueFormatter;
import com.company.yun.view.widget.MyPersonDayAxisValueFormatter;
import com.company.yun.view.widget.XYMarkerView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:人物画像
 */
public class ResultPersonActivity extends BaseActivity implements PersonView {
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
    @BindView(R.id.linear_under_city_city)
    LinearLayout linear_under_city_city;
    @BindView(R.id.person_all_tab)
    LinearLayout personAllTab;
    @BindView(R.id.bottom_chart01)
    BarChart bottomChartAge;
    @BindView(R.id.bottom_chart02)
    BarChart bottomChartSex;
    @BindView(R.id.bottom_chart03)
    BarChart bottomChartCity;
    @BindView(R.id.tv_bottom_age)
    TextView tv_bottom_age;
    @BindView(R.id.tv_bottom_sex)
    TextView tv_bottom_sex;
    @BindView(R.id.tv_bottom_city)
    TextView tv_bottom_city;
    @BindView(R.id.linear_under_city)
    TextView linear_under_city;
    @BindView(R.id.tv_text_sex)
    TextView tv_text_sex;
    @BindView(R.id.tv_text_age)
    TextView tv_text_age;
    @BindView(R.id.person_bottom_cardview_01)
    LinearLayout person_bottom_cardview_01;
    @BindView(R.id.person_bottom_cardview_02)
    LinearLayout person_bottom_cardview_02;
    @BindView(R.id.person_bottom_cardview_03)
    LinearLayout person_bottom_cardview_03;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private PersonPresenter mPresenter;
    private List<String> xCityList;
    private List<String> yCityList;
    private List<List<String>> zCityList;
    private List<String> xAgeList;
    private List<String> yAgeList;
    private List<List<String>> zAgeList;
    private List<String> xSexList;
    private List<String> ySexList;
    private List<List<String>> zSexList;
    private String keyword;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_person;
    }

    @Override
    public void init() {
        mPresenter = new PersonPresenter(this, getActivity());
        initView();
        keyword = getIntent().getStringExtra("keyword");
        mPresenter.sendRequest(keyword);
    }


    private void initView() {
        StatusBarUtils.setColor(getActivity(), getResources().getColor(R.color.statue_bar), 0);
        StatusBarUtil.darkMode(getActivity(), false);  //设置了状态栏文字的颜色
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.VISIBLE);
        setTitleName("搜索结果");
        setPageStateView();


    }

    //刷新数据
    @Override
    public void refreshData(PersonBean mBean) {
        //性别占比---- M是男 F是女
        ArrayList<String> sexDataList = new ArrayList<>();
        sexDataList.add(mBean.getData().getSocial().getStr_sex().getM());
        sexDataList.add(mBean.getData().getSocial().getStr_sex().getF());
        List<String> sexList = new ArrayList<>();
        sexList.add("男");
        sexList.add("女");
        initPicChart(picChartSex, sexList, DataUtils.toFloat(sexDataList), "picSex");
        //省份分布
        List<PersonBean.DataEntity.RegionEntity.ProvincesEntity.ListEntity> provinceList = mBean.getData().getRegion().getProvinces().getList();
        initBarChart(barChartProvince, DataUtils.getProvinceName(provinceList),
                DataUtils.toFloat(DataUtils.getProvinceValue(provinceList))
                , DataUtils.toString(DataUtils.getProvinceName(provinceList)));
//        initBarChart(barChartProvince, DataUtils.getProvinceName(provinceList), DataUtils.toFloat(DataUtils.getProvinceValue(provinceList)));

        //年龄结构
        PersonBean.DataEntity.SocialEntity.Str_ageEntity str_age = mBean.getData().getSocial().getStr_age();
        initPicChart(picChartAge, DataUtils.getAgeNameList(str_age),
                DataUtils.toFloat(DataUtils.getAgeVauleList(str_age)), "picAge");

        //城市分布
        List<PersonBean.DataEntity.RegionEntity.CityEntity.ListEntity> cityList = mBean.getData().getRegion().getCity().getList();
        initBarChart(barChartCity, DataUtils.getCityName(cityList), DataUtils.toFloat(DataUtils.getCityValue(cityList))
                , DataUtils.toString(DataUtils.getCityName(cityList)));

        //消费水平
        List<PersonBean.DataEntity.ConsumptionEntity> consumption = mBean.getData().getConsumption();
        initPicChart(picChartXiaofei, DataUtils.getConsumptionName(consumption), DataUtils.toFloat(DataUtils.getConsumptionValue(consumption)), "picChartXiaofei");

        //学历分布
        List<PersonBean.DataEntity.EducationEntity> education = mBean.getData().getEducation();
        initBarChart(barChartStudy, DataUtils.getEducationName(education), DataUtils.toFloat(DataUtils.getEducationValue(education)),
                DataUtils.toString(DataUtils.getEducationName(education)));

        //偏好分布
        //城市
        //x  文字说明
        xCityList = mBean.getData().getIndustry().getCity().getX();
        //y 一个柱体  有几个类别组成
        yCityList = mBean.getData().getIndustry().getCity().getY();
        //z 每个柱体,每种类型的数据
        zCityList = mBean.getData().getIndustry().getCity().getZ();

        //年纪
        xAgeList = mBean.getData().getIndustry().getAge().getX();
        yAgeList = mBean.getData().getIndustry().getAge().getY();
        zAgeList = mBean.getData().getIndustry().getAge().getZ();
        //性别
        xSexList = mBean.getData().getIndustry().getSex().getX();
        ySexList = mBean.getData().getIndustry().getSex().getY();
        zSexList = mBean.getData().getIndustry().getSex().getZ();


        //年纪    tv_bottom_age    默认显示年纪的柱状图
        changeBottomLinesStatues(tv_text_age, tv_bottom_age, person_bottom_cardview_01);
        initThreeBsrChart(bottomChartAge, DataUtils.get6List(xAgeList), zAgeList, yAgeList, DataUtils.toString(DataUtils.get6List(xAgeList)));

//
//        changeBottomLinesStatues(tv_bottom_sex, bottomChartSex);
//        initThreeBsrChart(bottomChartSex, DataUtils.get6List(xSexList), zSexList, ySexList);

//        changeBottomLinesStatues(tv_bottom_city, bottomChartCity);
//        initThreeBsrChart(bottomChartCity, DataUtils.get6List(xCityList), zCityList, yCityList);

    }

    @OnClick({R.id.linear_under_age, R.id.linear_under_sex, R.id.linear_under_city_city})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.linear_under_sex:
                changeBottomLinesStatues(tv_text_sex, tv_bottom_sex, person_bottom_cardview_02);
                initThreeBsrChart(bottomChartSex, DataUtils.get6List(xSexList), zSexList, ySexList, DataUtils.toString(DataUtils.get6List(xAgeList)));
                break;
            case R.id.linear_under_city_city:
                changeBottomLinesStatues(tv_bottom_age, tv_bottom_city, person_bottom_cardview_03);
                initThreeBsrChart(bottomChartCity, DataUtils.get6List(xCityList), zCityList, yCityList, DataUtils.toString(DataUtils.get6List(xAgeList)));
                break;
            case R.id.linear_under_age:
                changeBottomLinesStatues(tv_bottom_age, tv_bottom_age, person_bottom_cardview_01);
                initThreeBsrChart(bottomChartAge, DataUtils.get6List(xAgeList), zAgeList, yAgeList, DataUtils.toString(DataUtils.get6List(xAgeList)));
                break;
        }
    }

    private void changeBottomLinesStatues(TextView textView, TextView currentView, LinearLayout currentThreeBar) {
        tv_bottom_age.setVisibility(View.INVISIBLE);
        tv_bottom_sex.setVisibility(View.INVISIBLE);
        tv_bottom_city.setVisibility(View.INVISIBLE);
        tv_text_age.setTextColor(getResources().getColor(R.color.white));
        tv_text_sex.setTextColor(getResources().getColor(R.color.white));
        linear_under_city.setTextColor(getResources().getColor(R.color.white));
        person_bottom_cardview_01.setVisibility(View.INVISIBLE);
        person_bottom_cardview_02.setVisibility(View.INVISIBLE);
        person_bottom_cardview_03.setVisibility(View.INVISIBLE);
        textView.setTextColor(getResources().getColor(R.color.white));
        currentView.setVisibility(View.VISIBLE);
        currentThreeBar.setVisibility(View.VISIBLE);
    }

    /**
     * 设置---树状图
     *
     * @param chart  当前的chartView
     * @param data   文字说明
     * @param floats 值
     */
    private void initBarChart(BarChart chart, final List<String> data, float[] floats, String[] strings) {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        MyPersonDayAxisValueFormatter xAxisFormatter = new MyPersonDayAxisValueFormatter(chart, strings);
        XAxis xAxis = chart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);   //画虚线
        DayProvinceAxisValueFormatter dayAxisValueFormatter = new DayProvinceAxisValueFormatter(chart);    //设置底部文字
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
        XYMarkerView mv = new XYMarkerView(this, xAxisFormatter);    //点击柱状图显示信息
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart
        setChartBarData(floats, chart);
        Legend l = chart.getLegend();
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        chart.animateXY(1000, 1000);        //执行动画

        //柱状图
        chart.setBackgroundColor(Color.TRANSPARENT);
        leftAxis.setTextColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);
        //设置网格颜色
        xAxis.setGridColor(Color.WHITE);//设置x线颜色
        leftAxis.setGridColor(Color.WHITE);//设置y线颜色


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
            set1.setValueTextColor(Color.WHITE);

            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "");
            set1.setDrawIcons(false);
            int startColor1 = ContextCompat.getColor(this, R.color.zise);
            int endColor1 = ContextCompat.getColor(this, R.color.zise);
            List<GradientColor> gradientColors = new ArrayList<>();
            set1.setValueTextColor(Color.WHITE);
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


    /**
     * 设置---圆形图
     *
     * @param mSexChart 当前的chartView
     * @param XList     文字说明
     * @param floats    占比数组
     * @param type
     */
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
        l.setTextColor(Color.WHITE);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        mSexChart.setEntryLabelColor(Color.WHITE);
        mSexChart.setEntryLabelTextSize(12f);
        setPicData(mSexChart, XList, XList.size(), floats, type);


    }

    private void setPicData(PieChart mSexChart, List<String> XList, int count, float[] floats, String type) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (floats[i]),
                    XList.get(i % XList.size())));
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
        //设置全部园
        if (mSexChart.isDrawHoleEnabled()) {
            mSexChart.setDrawHoleEnabled(false);
        } else {
            mSexChart.setDrawHoleEnabled(true);
        }
        mSexChart.invalidate();
    }


    //设置---三种对比的---树状图


    /**
     * @param
     * @param chart
     * @param xList     类型分布
     * @param zCityList 一个柱状有一个组成成分
     * @param yCityList
     * @param strings
     */
    private void initThreeBsrChart(BarChart chart, List<String> xList, List<List<String>> zCityList, List<String> yCityList, String[] strings) {
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

        MyPersonDayAxisValueFormatter dayAxisValueFormatter = new MyPersonDayAxisValueFormatter(chart, strings);    //设置底部文字
//        DayAxisValueFormatter dayAxisValueFormatter = new DayAxisValueFormatter(mChart);
        XAxis xLabels = chart.getXAxis();
        xLabels.setPosition(XAxis.XAxisPosition.BOTTOM);
        xLabels.setValueFormatter(dayAxisValueFormatter);

        // mChart.setDrawXLabels(false);
        // mChart.setDrawYLabels(false);
        // setting data
        setThreeBarData(chart, xList, zCityList, yCityList);//stacksize  显示几种颜色
        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);
        l.setTextColor(Color.WHITE);

        //柱状图

        chart.setBackgroundColor(Color.TRANSPARENT);

        leftAxis.setTextColor(Color.WHITE);
        xLabels.setTextColor(Color.WHITE);
        //设置网格颜色
        xLabels.setGridColor(Color.WHITE);//设置x线颜色
        leftAxis.setGridColor(Color.WHITE);//设置y线颜色


    }

    private void setThreeBarData(BarChart chart, List<String> xList, List<List<String>> zCityList, List<String> yCityList) {  //mXlist===6
        ArrayList<BarEntry> yVals1 = new ArrayList<>();
        String strType = yCityList.size() + "";
        switch (strType) {     //这里是给  一个柱状图中不同颜色设置当前数值的
            case "1":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{DataUtils.toFloat(zCityList.get(0))[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "2":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{DataUtils.toFloat(zCityList.get(0))[i], DataUtils.toFloat(zCityList.get(1))[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "3":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{DataUtils.toFloat(zCityList.get(0))[i], DataUtils.toFloat(zCityList.get(1))[i],
                            DataUtils.toFloat(zCityList.get(2))[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "4":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{DataUtils.toFloat(zCityList.get(0))[i], DataUtils.toFloat(zCityList.get(1))[i],
                            DataUtils.toFloat(zCityList.get(2))[i], DataUtils.toFloat(zCityList.get(3))[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "5":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{DataUtils.toFloat(zCityList.get(0))[i], DataUtils.toFloat(zCityList.get(1))[i],
                            DataUtils.toFloat(zCityList.get(2))[i], DataUtils.toFloat(zCityList.get(3))[i], DataUtils.toFloat(zCityList.get(4))[i]});
                    yVals1.add(barEntry);
                }
                break;
            case "6":
                for (int i = 0; i < xList.size(); i++) {
                    BarEntry barEntry = new BarEntry(i, new float[]{DataUtils.toFloat(zCityList.get(0))[i], DataUtils.toFloat(zCityList.get(1))[i],
                            DataUtils.toFloat(zCityList.get(2))[i], DataUtils.toFloat(zCityList.get(3))[i], DataUtils.toFloat(zCityList.get(4))[i],
                            DataUtils.toFloat(zCityList.get(5))[i]});
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
            set1.setColors(getColors(strType));
            String[] strings = DataUtils.toString(yCityList);
            switch (strType) {      //这里是添加  颜色属于那个类型的
                case "1":
                    set1.setStackLabels(strings);
                    break;
                case "2":
                    set1.setStackLabels(strings);
                    break;
                case "3":
                    set1.setStackLabels(strings);
                    break;
                case "4":
                    set1.setStackLabels(strings);
                    break;
                case "5":
                    set1.setStackLabels(strings);
                    break;
                case "6":
                    set1.setStackLabels(strings);
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

        chart.animateXY(1000, 1000);        //执行动画
        chart.setFitBars(true);
        chart.invalidate();
    }

    private int[] getColors(String stacksize) {

        // have as many colors as stack-values per entry
        int[] colors = new int[Integer.parseInt(stacksize)];

        switch (stacksize) {
            case "1":
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Constants.MATERIAL_COLORS_01[i];
                }
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
            case "4":
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Constants.MATERIAL_COLORS_04[i];
                }
                break;
            case "5":
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Constants.MATERIAL_COLORS_05[i];
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

    @OnClick(R.id.ib_left)
    public void onClickTitleLeftBtn(View v) {
        this.finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }
}
