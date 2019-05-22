package com.company.yun.ui.fragment.yun;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.bean.yun.PicChartBean;
import com.company.yun.ui.activity.ppt.PPTActivity;
import com.company.yun.ui.activity.YunMapActivity;
import com.company.yun.ui.fragment.yun.presenter.YunPresenter;
import com.company.yun.ui.fragment.yun.presenter.YunView;
import com.company.yun.utils.DataUtils;
import com.company.yun.view.widget.MyMarkerView;
import com.company.yun.view.widget.MyPersonDayAxisValueFormatter;
import com.company.yun.view.widget.XYMarkerView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:尚城云---3
 */
public class YunFragment extends BaseFragment implements YunView {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.tv_total_times)
    TextView mTvTotalTimes;
    @BindView(R.id.tv_consume_times)
    TextView mTvConsumeTimes;
    @BindView(R.id.tv_consume_percent_01)
    TextView mTvConsumePercent01;
    @BindView(R.id.tv_consume)
    TextView mTvConsume;
    @BindView(R.id.tv_consume_percent_02)
    TextView mTvConsumePercent02;
    @BindView(R.id.tv_consume_person)
    TextView mTvConsumePerson;
    @BindView(R.id.tv_consume_percent_03)
    TextView mTvConsumePercent03;
    @BindView(R.id.tv_under_person_count)
    TextView tv_under_person_count;
    @BindView(R.id.chart1)
    LineChart mTChart01;
    @BindView(R.id.chart02)
    BarChart mChart02;
    @BindView(R.id.sex_chart)
    PieChart mChart;
    @BindView(R.id.year_chart)
    PieChart mYearChart;
    @BindView(R.id.interest_chart)
    PieChart mInterestChart;
    @BindView(R.id.tv_num)
    TextView tv_num;
    @BindView(R.id.ib_left)
    ImageButton ib_left;
    @BindView(R.id.tv_under_person)
    TextView tv_under_person;
    @BindView(R.id.tv_title_yun)
    TextView tv_title_yun;
    @BindView(R.id.ib_left_yun)
    ImageButton ib_left_yun;
    @BindView(R.id.ib_right_yun)
    ImageButton ib_right_yun;
    @BindView(R.id.tv_under_before_days)
    TextView tv_under_before_days;
    @BindView(R.id.tv_drawable_icon_01)
    TextView tv_drawable_icon_01;
    @BindView(R.id.tv_drawable_icon_02)
    TextView tv_drawable_icon_02;
    @BindView(R.id.tv_drawable_icon_03)
    TextView tv_drawable_icon_03;
    @BindView(R.id.linear_under_01)
    LinearLayout mLinearUnder01;
    @BindView(R.id.linear_under_02)
    LinearLayout mLinearUnder02;
    Unbinder unbinder;
    private YunPresenter mPresenter;
    private final Timer timer = new Timer();
    private TimerTask task;
    public Boolean isFirstPicRequest = true;    // 解决圆形图 显示类型数字bug
    public int time = 1;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mPresenter.sendChartDataRequest("times");
        }
    };

    @Override
    public int getContentViewId() {
        return R.layout.fragment_yun;
    }

    @Override
    public void init(ViewGroup rootView) {
        mPresenter = new YunPresenter(getActivity(), this);
        initView();
        responseListener();
    }

    private void responseListener() {
        ib_left_yun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PPTActivity.class);
            }
        });
        ib_right_yun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("进入地图");
                openActivity(YunMapActivity.class);

            }
        });

        mPresenter.sendRequest();
        task = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };

        timer.schedule(task, 5000, 3000);
    }

    private void initView() {
        setTitleBarVisibility(View.GONE);
        tv_title_yun.setText("尚城云");
        setPageStateView();
    }


    @Override
    public void refreshLineBarUIData(List<String> xList, List<String> todayDataList, List<String> yesterdayDataList) {
        initChart01(xList, DataUtils.toFloat(todayDataList), DataUtils.toString(xList));

        initChart02(xList, DataUtils.toFloat(yesterdayDataList), DataUtils.toString(xList));

    }

    @Override
    public void refreshPicChartUIData(PicChartBean.SexEntity sex, PicChartBean.AgeEntity age, PicChartBean.InterestEntity interest) {
        List<String> sexString = sex.getY();      //Y   都是说明
        List<String> sexRate = sex.getX();        //X  都是数值
        List<String> ageString = age.getY();      //Y   都是说明
        List<String> ageRate = age.getX();
        List<String> interestString = interest.getY();      //Y   都是说明
        List<String> interestRate = interest.getX();

        initPicChart(mChart, sexString, DataUtils.toFloat(sexRate), "sex");
        initPicChart(mYearChart, ageString, DataUtils.toFloat(ageRate), "age");
        initPicChart(mInterestChart, interestString, DataUtils.toFloat(interestRate), "interest");

    }


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
        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
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
        if ("sex".equals(type)) {
            mSexChart.invalidate();
        } else if (isFirstPicRequest) {
            time++;
            if (time == 3) {
                isFirstPicRequest = false;
            }
            mSexChart.setDrawEntryLabels(!mSexChart.isDrawEntryLabelsEnabled());
            mSexChart.invalidate();
        } else {
            //设置全部园
            if (mSexChart.isDrawHoleEnabled()) {
                mSexChart.setDrawHoleEnabled(false);
            } else {
                mSexChart.setDrawHoleEnabled(true);
            }
            mSexChart.invalidate();
        }

    }

    @OnClick({R.id.linear_under_01, R.id.tv_under_before_days})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.linear_under_01:
                mPresenter.showPersonDialog(getActivity());
                break;
            case R.id.tv_under_before_days:
                mPresenter.showDaysDialog(getActivity());
                break;
        }
    }

    //初始化02--树状图
    private void initChart01(final List<String> data, float[] floats, String[] string) {
        mTChart01.setBackgroundColor(Color.WHITE);
        mTChart01.getDescription().setEnabled(false);
        mTChart01.setTouchEnabled(true);
        mTChart01.setDragEnabled(true);
        mTChart01.setScaleEnabled(true);
        mTChart01.setPinchZoom(true);
        mTChart01.setDrawGridBackground(false);
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        mv.setChartView(mTChart01);
        mTChart01.setMarker(mv);
        MyPersonDayAxisValueFormatter xAxisFormatter = new MyPersonDayAxisValueFormatter(mChart02, string);
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
        //画数值
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawValues(!set.isDrawValuesEnabled());
        }
        //画小圆点
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawCircles(false);
        }
        mTChart01.invalidate();
    }

    private void initChart02(final List<String> data, float[] floats, String[] string) {
        mChart02.setDrawBarShadow(false);
        mChart02.setDrawValueAboveBar(true);
        mChart02.getDescription().setEnabled(false);
        mChart02.setPinchZoom(false);
        mChart02.setDrawGridBackground(false);
//        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart02);
        MyPersonDayAxisValueFormatter xAxisFormatter = new MyPersonDayAxisValueFormatter(mChart02, string);

        XAxis xAxis = mChart02.getXAxis();
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
        YAxis leftAxis = mChart02.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = mChart02.getAxisRight();
        rightAxis.setEnabled(false);
        XYMarkerView mv = new XYMarkerView(getContext(), xAxisFormatter);    //点击柱状图显示信息
        mv.setChartView(mChart02); // For bounds control
        mChart02.setMarker(mv); // Set the marker to the chart
        setChart02Data(floats);
        Legend l = mChart02.getLegend();
        l.setForm(Legend.LegendForm.NONE);   //文字前面的  "线的类型标识"
        //取消默认顶部值
        mChart02.invalidate();

    }

    private void setChart02Data(float[] floats) {
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new BarEntry(i, floats[i]));
        }
        BarDataSet set1;
        if (mChart02.getData() != null &&
                mChart02.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart02.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart02.getData().notifyDataChanged();
            mChart02.notifyDataSetChanged();

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
            mChart02.setData(data);
        }
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
            set1.setColor(getResources().getColor(R.color.color_21ac90));
            set1.setCircleColor(getResources().getColor(R.color.color_21ac90));
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
    public TextView getTotal() {
        return mTvTotal;
    }

    @Override
    public TextView getTotalRate() {
        return mTvTotalTimes;
    }

    @Override
    public TextView getShow() {
        return mTvConsumeTimes;
    }

    @Override
    public TextView getShowRate() {
        return mTvConsumePercent01;
    }

    @Override
    public TextView getConsume() {
        return tv_num;
    }

    @Override
    public TextView getConsumeRate() {
        return mTvConsumePercent02;
    }

    @Override
    public TextView getShowPeople() {
        return mTvConsumePerson;
    }

    @Override
    public TextView getShowPeopleRate() {
        return mTvConsumePercent03;
    }

    @Override
    public TextView getUnderPersonCount() {
        return tv_under_person_count;
    }

    @Override
    public TextView getUnderType() {
        return tv_under_person;
    }

    @Override
    public TextView getUnderDays() {
        return tv_under_before_days;
    }

    @Override
    public TextView getDrableIcon01() {
        return tv_drawable_icon_01;
    }

    @Override
    public TextView getDrableIcon02() {
        return tv_drawable_icon_02;
    }

    @Override
    public TextView getDrableIcon03() {
        return tv_drawable_icon_03;
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
        timer.cancel();
        time = 0;
        unbinder.unbind();
    }
}
