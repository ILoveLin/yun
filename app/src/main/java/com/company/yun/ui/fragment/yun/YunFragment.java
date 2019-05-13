package com.company.yun.ui.fragment.yun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.base.BaseFragment;
import com.company.yun.ui.fragment.yun.presenter.YunPresenter;
import com.company.yun.ui.fragment.yun.presenter.YunView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.chart1)
    LineChart mTChart01;
    @BindView(R.id.chart02)
    BarChart mChart02;
    @BindView(R.id.tv_under_person)
    TextView mTvUnderPerson;
    @BindView(R.id.tv_num)
    TextView tv_num;
    @BindView(R.id.tv_drawable_icon_01)
    TextView tv_drawable_icon_01;
    @BindView(R.id.tv_drawable_icon_02)
    TextView tv_drawable_icon_02;
    @BindView(R.id.tv_drawable_icon_03)
    TextView tv_drawable_icon_03;
    @BindView(R.id.linear_under_01)
    LinearLayout mLinearUnder01;
    @BindView(R.id.tv_under_person_count)
    TextView mTvUnderPersonCount;
    @BindView(R.id.linear_under_02)
    LinearLayout mLinearUnder02;
    @BindView(R.id.tv_under_before_days)
    TextView mTvUnderBeforeDays;
    @BindView(R.id.linear_under_03)
    LinearLayout mLinearUnder03;
    Unbinder unbinder;
    private YunPresenter mPresenter;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_02;
    }

    @Override
    public void init(ViewGroup rootView) {
        mPresenter = new YunPresenter(getActivity(), this);
        initView();
        responseListener();
    }

    private void initView() {
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("尚城云");
        setPageStateView();
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
        unbinder.unbind();
    }
}
