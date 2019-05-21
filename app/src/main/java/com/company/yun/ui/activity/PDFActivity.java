package com.company.yun.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.company.yun.R;
import com.company.yun.base.BaseActivity;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lovelin on 2019/5/21
 * <p>
 * Describe:pdf在线观看
 */
public class PDFActivity extends BaseActivity {


    @BindView(R.id.pdfview)
    PDFView pdfview;

    @Override
    public int getContentViewId() {
        return R.layout.activity_pdf;
    }

    @Override
    public void init() {
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.VISIBLE);
        setTitleName("尚城云PDF");

        StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        // 这个测试例子中，assets目录下sample.pdf
        // 缺省把该pdf定位到第一页。
        pdfview.fromAsset("2019BP.pdf")
                .defaultPage(1)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        // 当用户在翻页时候将回调。
                        Toast.makeText(getApplicationContext(), page + " / " + pageCount, Toast.LENGTH_SHORT).show();
                    }
                }).load();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
