package com.company.yun.ui.fragment.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.company.yun.R;
import com.company.yun.ui.activity.LoginActivity;
import com.company.yun.base.BaseFragment;
import com.company.yun.base.Constants;
import com.company.yun.utils.CacheUtil;
import com.company.yun.view.widget.SettingBar;
import com.yun.common.utils.SharePreferenceUtil;
import com.yun.common.utils.popupwindow.PopupWindowTwoButton;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:我的---5
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;
    @BindView(R.id.linear_04)
    LinearLayout linear_04;
    @BindView(R.id.bar_current_name)
    SettingBar barCurrentName;
    @BindView(R.id.sb_person_data_address)
    SettingBar sbPersonDataAddress;
    @BindView(R.id.btn_exit)
    Button btnExit;
    Unbinder unbinder;
    private String name;
    private String formatSize;
    private long folderSize = 0;

    //v_setting_bar_line
    @Override
    public int getContentViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void init(ViewGroup rootView) throws Exception {
        initView();
    }


    private void initView() {
        setTitleBarVisibility(View.VISIBLE);
        setTitleLeftBtnVisibility(View.GONE);
        setTitleName("我的");
        setPageStateView();
        showContent();
        barCurrentName.setLineVisible(true);
        sbPersonDataAddress.setLineVisible(false);
        name = (String) SharePreferenceUtil.get(getActivity(), Constants.UserName, "张三");
        try {
            File cacheDir = getActivity().getCacheDir();
            folderSize = CacheUtil.getFolderSize(cacheDir);
            formatSize = CacheUtil.getFormatSize(folderSize);
            sbPersonDataAddress.setRightText("" + formatSize);
            barCurrentName.setRightText(name + "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnClick({R.id.btn_exit, R.id.sb_person_data_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_exit:
                showExitDialog();
                break;
            case R.id.sb_person_data_address:
                showCleanClashDataDialog();
                break;
        }
    }

    private void showCleanClashDataDialog() {

        final PopupWindowTwoButton twoButton = new PopupWindowTwoButton((Activity) getActivity());
        twoButton.getTv_content().setText("是否清除缓存?");
        twoButton.getTv_ok().setText("确定");
        twoButton.getTv_cancel().setText("取消");
        twoButton.getTv_ok().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File cacheDir = getActivity().getCacheDir();
                    folderSize = CacheUtil.getFolderSize(cacheDir);
                    formatSize = CacheUtil.getFormatSize(folderSize);
                    sbPersonDataAddress.setRightText(0 + "MB");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                showToast("清除成功");
                twoButton.dismiss();

            }
        });
        twoButton.getTv_cancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoButton.dismiss();

            }
        });
        twoButton.showPopupWindow(linear_04, Gravity.CENTER);

    }

    private void showExitDialog() {
        final PopupWindowTwoButton twoButton = new PopupWindowTwoButton((Activity) getActivity());
        twoButton.getTv_content().setText("您确定退出吗？");
        twoButton.getTv_ok().setText("确定");
        twoButton.getTv_cancel().setText("取消");
        twoButton.getTv_ok().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePreferenceUtil.put(getActivity(), Constants.Is_Logined, false);
                SharePreferenceUtil.put(getActivity(), Constants.Token, "");
                SharePreferenceUtil.put(getActivity(), Constants.Device, "");
                SharePreferenceUtil.put(getActivity(), Constants.UserName, "");
                showToast("退出成功");
                openActivity(LoginActivity.class);
                twoButton.dismiss();
            }
        });
        twoButton.getTv_cancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoButton.dismiss();
            }
        });
        twoButton.showPopupWindow(linear_04, Gravity.CENTER);
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
