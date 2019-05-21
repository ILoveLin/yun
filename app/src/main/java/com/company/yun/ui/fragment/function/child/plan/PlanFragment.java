package com.company.yun.ui.fragment.function.child.plan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.function.plan.AreaBean;
import com.company.yun.bean.function.plan.ChannelBean;
import com.company.yun.bean.function.plan.PortBean;
import com.company.yun.ui.activity.result.ResultActivity;
import com.company.yun.ui.fragment.function.child.plan.presenter.PlanPresenter;
import com.company.yun.ui.fragment.function.child.plan.presenter.PlanView;
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
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/5/10
 * <p>
 * Describe:推广方案
 */
public class PlanFragment extends BaseFragment implements PlanView {

    @BindView(R.id.bar_chart_port)
    BarChart barChartPort;
    @BindView(R.id.cardview_bar_chart_port)
    CardView cardviewBarChartPort;
    @BindView(R.id.pic_chart_channel)
    PieChart picChartChannel;
    @BindView(R.id.cardview_pic_chart_channel)
    CardView cardviewPicChartChannel;
    @BindView(R.id.bar_chart_area)
    BarChart bar_chart_area;
    @BindView(R.id.cardview_bar_chart_area)
    CardView cardview_bar_chart_area;

    Unbinder unbinder;
    private PlanPresenter mPresenter;
    private ArrayList<PieEntry> entries;
    private List<ChannelBean.DataEntity> channelBeanList;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView();
    }

    private void initView() {

        mPresenter = new PlanPresenter(this, getActivity());
        setTitleBarVisibility(View.GONE);
        setTitleLeftBtnVisibility(View.GONE);
        setPageStateView();
        responseListener("口红");

    }

    private void responseListener(final String keyword) {
//        mPresenter.sendRequest("口红");
        mPresenter.sendCheckRequest(keyword);

        picChartChannel.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight h) {
                if (entry == null) return;
                //此时e.getY()等于数据 由此判断点击了哪一个扇区
                if (entry.getY() == entry.getY()) {
                    //获取到当前对应的  名称
                    Log.e("result====", ""+entry.getY());

                    String stringName = DataUtils.getStringName(channelBeanList, entry.getY());
                    showToast(stringName);
                    Bundle bundle = new Bundle();


                    bundle.putString("name", stringName);
                    bundle.putString("keyword", keyword);
                    openActivity(ResultActivity.class, bundle);
                }
            }

            @Override
            public void onNothingSelected() {
                //图表外部点击事件 也是（上一个方法为点击一次放大） 本方法为二次点击事件
            }
        });
    }

    @Override
    public void refreshData(PortBean portBean, ChannelBean channelBean, AreaBean areaBean) {
        List<String> data = portBean.getData().getCategory();
        List<String> Ydata = portBean.getData().getBarData();
        channelBeanList = channelBean.getData().get(0);

        ArrayList<String> nameList = mPresenter.getChannelNameList(channelBeanList);
        ArrayList<String> valueList = mPresenter.getChannelValueList(channelBeanList);
        List<AreaBean.DataEntity.ProvincesEntity.ListEntity> areaList = areaBean.getData().getProvinces().getList();

        ArrayList<String> area06NameList = mPresenter.getArealNameList(areaList);
        ArrayList<String> area06ValueList = mPresenter.getArealValueList(areaList);

        //初始化  端口
        initBarChart(barChartPort, data, DataUtils.toFloat(Ydata), DataUtils.toString(data));
        //初始化 渠道
        initPicChart(picChartChannel, nameList, DataUtils.toFloat(valueList), "picChartChannel");
        //初始化  区域
        initBarChart(bar_chart_area, area06NameList, DataUtils.toFloat(area06ValueList), DataUtils.toString(area06NameList));

    }


    /**
     * 设置---树状图
     *
     * @param chart   当前的chartView
     * @param data    文字说明
     * @param floats  值
     * @param strings 点击柱状图显示X的值
     */
    private void initBarChart(BarChart chart, final List<String> data, float[] floats, String[] strings) {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        MyPersonDayAxisValueFormatter xAxisFormatter = new MyPersonDayAxisValueFormatter(chart, strings);
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
        chart.animateXY(1000, 1000);        //执行动画


        //取消默认顶部值
        chart.invalidate();
    }


    private void setChartBarData(float[] floats, BarChart chart) {
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < floats.length; i++) {
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
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        mSexChart.setEntryLabelColor(Color.WHITE);
        mSexChart.setEntryLabelTextSize(12f);
        setPicData(mSexChart, XList, XList.size(), floats, type);


    }

    private void setPicData(PieChart mSexChart, List<String> XList, int count, float[] floats, String type) {
        entries = new ArrayList<>();
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

        //显示 男
        for (IDataSet<?> set : mSexChart.getData().getDataSets())
            set.setDrawValues(set.isDrawValuesEnabled());
        //显示百分百
        mSexChart.setDrawEntryLabels(mSexChart.isDrawEntryLabelsEnabled());
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
