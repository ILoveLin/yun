package com.company.yun.fragment;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.company.yun.R;
import com.company.yun.TextAdapter;
import com.company.yun.base.BaseFragment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by Lovelin on 2019/5/6
 * <p>
 * Describe:
 */
public class TestFragment extends BaseFragment {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;
    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;
    private static boolean isFirstEnter = true;
    private List<String> mListData;
    private TextAdapter mAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_text;
    }

    @Override
    protected void init(ViewGroup rootView) {
        initView(rootView);
        responseListener();
    }

    private int refreshTime = 0;
    private int times = 0;
    final int itemLimit = 8;

    private void responseListener() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                refreshTime++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        mListData.clear();
//                        for (int i = 0; i < itemLimit; i++) {
//                            mListData.add("item  " + i + "--第-- " + refreshTime + "--次-刷新");
//                        }
                        mAdapter.notifyDataSetChanged();
                        refreshlayout.finishRefresh(1000/*,false*/);//传入false表示刷新失败


                    }
                }, 1000);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(final RefreshLayout refreshlayout) {

                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < itemLimit; i++) {
                                mListData.add("item  " + (1 + mListData.size()));
                            }
                            mAdapter.notifyDataSetChanged();
                            refreshlayout.finishLoadMore(1000/*,false*/);//传入false表示加载失败

                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < itemLimit; i++) {
                                mListData.add("item  " + (1 + mListData.size()));
                            }
                            refreshlayout.finishLoadMoreWithNoMoreData();//设置之后，将不会再触发加载事件
                        }
                    }, 1000);
                }
                times++;


//                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

    }

    private void initView(ViewGroup rootView) {
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("我的测试界面");
        mRefreshLayout = rootView.findViewById(R.id.refreshLayout);

//        int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
//        mClassicsHeader = (ClassicsHeader) mRefreshLayout.getRefreshHeader();
//        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis() - delta));
//        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));

        View view = rootView.findViewById(R.id.recyclerView);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            mListData = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                mListData.add(i + "  item  ");
            }
            mAdapter = new TextAdapter((ArrayList<String>) mListData, getActivity());
            recyclerView.setAdapter(mAdapter);
            mRecyclerView = recyclerView;
        }
        //设置 Header 为 贝塞尔雷达 样式
//        mRefreshLayout.setRefreshHeader(new BezierRadarHeader(getActivity()).setEnableHorizontalDrag(true));
//        设置 Footer 为 球脉冲 样式
//        mRefreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));

//        if (isFirstEnter) {
//            isFirstEnter = false;
//            //触发自动刷新
//            mRefreshLayout.autoRefresh();
//        }
    }
}
