package com.company.yun.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.app.ActivityCollector;
import com.company.yun.base.BaseActivity;
import com.company.yun.base.HttpConstants;
import com.company.yun.bean.UpdateBean;
import com.company.yun.ui.fragment.account.AccountFragment;
import com.company.yun.ui.fragment.financedata.FinanceDataFragment;
import com.company.yun.ui.fragment.function.FunctionFragment;
import com.company.yun.ui.fragment.mine.MineFragment;
import com.company.yun.ui.fragment.yun.YunFragment;
import com.yun.common.contant.Contants;
import com.yun.common.utils.CommonUtils;
import com.yun.common.utils.CustomToast;
import com.yun.common.utils.SharePreferenceUtil;
import com.yun.common.utils.StatusBarUtil;
import com.yun.common.utils.StatusBarUtils;
import com.yun.common.utils.popupwindow.PopupWindowTwoButton;
import com.yun.common.utils.updateutils.UpdateIntentService;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * MainActivity
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_tab_homepage)
    TextView tvTabFirstPage;   //1
    @BindView(R.id.tv_tab_drug_query)
    TextView tvTabSecondPage;  //2
    @BindView(R.id.tv_tab_yun)
    TextView tvTabMindPage;  //3
    @BindView(R.id.tv_tab_recomment)
    TextView tvTabThirdPage;  //4
    @BindView(R.id.tv_tab_mine)
    TextView tvTabFourthPage;  //5
    @BindView(R.id.iv_tab_mine)
    ImageView ivTabMine;        //我的小红点
    @BindView(R.id.rel_tab_mine)
    RelativeLayout relTabMine;      //整体的我的relative
    @BindView(R.id.layout_bottom_lin)
    LinearLayout layoutBottomLin;
    @BindView(R.id.ll_mymain_bottom)
    LinearLayout linearBottom;
    @BindView(R.id.linear_all)
    LinearLayout linear_all;
    private FragmentManager fragmentManager;
    private Integer valTab;
    private String localVersionCode;
    private String version_code;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        setTitleBarVisibility(View.GONE);
        linearBottom.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();
        valTab = (Integer) SharePreferenceUtil.get(this, SharePreferenceUtil.DYNAMIC_SWITCH_TAB, Contants.TAB_DRUGS_QUERY);
        setChoiceItem(valTab);

        //版本更新
        requestUpdateVersion("Android");


    }


    //    private FinanceDataFragment dataFragment;
    private FinanceDataFragment dataFragment;
    private AccountFragment accountFragment;
    private FunctionFragment functionFragment;
    private MineFragment mineFragment;
    private YunFragment yunFragment;

    private void setChoiceItem(Integer index) {
        if (index < 0) {
            index = Contants.TAB_DRUGS_QUERY;
        }
        SharePreferenceUtil.put(this, SharePreferenceUtil.DYNAMIC_SWITCH_TAB, index);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
        StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
        switch (index) {
            case Contants.TAB_HOME:   //财务数据--0
//                StatusBarUtils.setColor(this, getResources().getColor(R.color.color_transparent), 0);
//                StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
                if (dataFragment == null) {
                    dataFragment = new FinanceDataFragment();
                    transaction.add(R.id.ll_content, dataFragment);
                } else {
                    transaction.show(dataFragment);
                }
                tvTabFirstPage.setSelected(true);
                tvTabSecondPage.setSelected(false);
                tvTabThirdPage.setSelected(false);
                tvTabFourthPage.setSelected(false);
                tvTabMindPage.setSelected(false);
                overAnim(tvTabFirstPage);
                break;
            case Contants.TAB_DRUG_SEACH://账户管理--1
//                StatusBarUtils.setColor(this, getResources().getColor(R.color.result_points), 0);
//                StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
                if (accountFragment == null) {
                    accountFragment = new AccountFragment();
                    transaction.add(R.id.ll_content, accountFragment);
                } else {
                    transaction.show(accountFragment);
                }
                tvTabFirstPage.setSelected(false);
                tvTabSecondPage.setSelected(true);
                tvTabThirdPage.setSelected(false);
                tvTabFourthPage.setSelected(false);
                tvTabMindPage.setSelected(false);

                overAnim(tvTabSecondPage);
                break;
            case Contants.TAB_DRUGS_QUERY:  //尚城云---2
                if (yunFragment == null) {
                    yunFragment = new YunFragment();
                    transaction.add(R.id.ll_content, yunFragment);
                } else {
                    transaction.show(yunFragment);
                }
                tvTabFirstPage.setSelected(false);
                tvTabSecondPage.setSelected(false);
                tvTabMindPage.setSelected(true);
                tvTabThirdPage.setSelected(false);
                tvTabFourthPage.setSelected(false);
                overAnim(tvTabMindPage);
                break;

            case Contants.TAB_NEWS:   //功能--3
//                StatusBarUtils.setColor(this, getResources().getColor(R.color.color_2395ff), 0);
//                StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
                if (functionFragment == null) {
                    functionFragment = new FunctionFragment();
                    transaction.add(R.id.ll_content, functionFragment);
                } else {
                    transaction.show(functionFragment);
                }
                tvTabFirstPage.setSelected(false);
                tvTabSecondPage.setSelected(false);
                tvTabThirdPage.setSelected(true);
                tvTabFourthPage.setSelected(false);
                tvTabMindPage.setSelected(false);
                overAnim(tvTabThirdPage);
                break;

            case Contants.TAB_MINE:   //我的--4
//                StatusBarUtils.setColor(this, getResources().getColor(R.color.possible_result_points), 0);
//                StatusBarUtil.darkMode(this, true);  //设置了状态栏文字的颜色
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.ll_content, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                tvTabFirstPage.setSelected(false);
                tvTabSecondPage.setSelected(false);
                tvTabThirdPage.setSelected(false);
                tvTabFourthPage.setSelected(true);
                tvTabMindPage.setSelected(false);
                overAnim(tvTabFourthPage);
                break;
        }
        transaction.commit();
    }

    @OnClick({R.id.tv_tab_homepage, R.id.tv_tab_drug_query, R.id.tv_tab_yun, R.id.tv_tab_recomment, R.id.rel_tab_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tab_homepage:    //1
                setChoiceItem(Contants.TAB_HOME);
                break;
            case R.id.tv_tab_drug_query:   // 2
                setChoiceItem(Contants.TAB_DRUG_SEACH);
                break;
            case R.id.tv_tab_yun:   // 2
                setChoiceItem(Contants.TAB_DRUGS_QUERY);
                break;
            case R.id.tv_tab_recomment:    //3
                setChoiceItem(Contants.TAB_NEWS);
                break;
            case R.id.rel_tab_mine:   //4
                setChoiceItem(Contants.TAB_MINE);
                break;
            default:
        }
    }

    public static boolean isTabBiyao = false;

    // 隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (dataFragment != null) {
            transaction.hide(dataFragment);
        }
        if (yunFragment != null) {
            transaction.hide(yunFragment);
        }
        if (accountFragment != null) {
            transaction.hide(accountFragment);

        }
        if (functionFragment != null) {
            transaction.hide(functionFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }

    }

    private void overAnim(View view) {
        final ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, 0.8f, 1.0f);
        final ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.8f, 1.0f);
        final ObjectAnimator translationY = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0, 0);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY, translationY);
        set.setDuration(200);
        set.start();
    }


    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                exitTime = System.currentTimeMillis();
                showToast("再按一次退出程序");
            } else {
                SharePreferenceUtil.put(this, SharePreferenceUtil.DYNAMIC_SWITCH_TAB, 2);
                ActivityCollector.removeAll();
                System.exit(0);

            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    private void requestUpdateVersion(String type) {
        localVersionCode = CommonUtils.getVersionName(this);
        showLoading();
        OkHttpUtils.post()
                .url(HttpConstants.Update)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        CustomToast.showToast(getApplicationContext(), "网络请求错误");
                        showError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        UpdateBean updateBean = new UpdateBean();
                        updateBean.getAllDate(response);
                        version_code = updateBean.getData().getVersion_code();
                        Log.e("update==========", "localVersionCode=====" + localVersionCode);
                        Log.e("update==========", "version_code=====" + version_code);
//                        int updateCode = Integer.parseInt(version_code);
//                        int currentCode = Integer.parseInt(localVersionCode);
                        if (2 > 1) {
                            final String downUrl = updateBean.getData().getDownurl();
                            // 如果指定的数与参数相等返回0。
                            //如果指定的数小于参数返回 -1。
                            //如果指定的数大于参数返回 1。
//                            if (localVersionCode.compareTo(version_code) < 0)

                            updateVersion(downUrl);
//                            AllenVersionChecker
//                                    .getInstance()
//                                    .requestVersion()
//                                    .setRequestUrl(downUrl)
//                                    .request(new RequestVersionListener() {
//                                        @Nullable
//                                        @Override
//                                        public UIData onRequestVersionSuccess(String result) {
//                                            //拿到服务器返回的数据，解析，拿到downloadUrl和一些其他的UI数据
//                                            return UIData.create().setDownloadUrl(downUrl);
//                                        }
//
//                                        @Override
//                                        public void onRequestVersionFailure(String message) {
//
//                                        }
//                                    })
//                                    .excuteMission(getApplicationContext());
                        }
                    }
                });

    }

    //我就说一句话，这是坠吼的！
    private void updateVersion(final String url) {
        // 如果指定的数与参数相等返回0。
        //如果指定的数小于参数返回 -1。
        //如果指定的数大于参数返回 1。


        final PopupWindowTwoButton twoButton = new PopupWindowTwoButton((Activity) this);
        twoButton.getTv_content().setText("发现新版本，是否更新?");
        twoButton.getTv_ok().setText("确定");
        twoButton.getTv_cancel().setText("取消");
        twoButton.getTv_ok().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("开始下载,请稍后...");
                beforeUpdateWork();
                twoButton.dismiss();

            }
        });
        twoButton.getTv_cancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //版本更新

                twoButton.dismiss();

            }
        });
        twoButton.showPopupWindow(linear_all, Gravity.CENTER);

    }

    private void beforeUpdateWork() {
        if (!isEnableNotification()) {
            showNotificationAsk();
            return;
        }
        toIntentServiceUpdate();

    }

    private void showNotificationAsk() {
        AlertDialog.Builder dialog =
                new AlertDialog.Builder(this);
        dialog.setTitle("通知权限");
        dialog.setMessage("打开通知权限");
        dialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toSetting();
                    }
                });
        dialog.setNeutralButton("跳过", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toIntentServiceUpdate();
            }
        });
        dialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        dialog.show();
    }

    private boolean isEnableNotification() {
        boolean ret = true;
        try {
            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            ret = manager.areNotificationsEnabled();
        } catch (Exception e) {
            return true;
        }
        return ret;
    }

    public String appName = "update-";
    public String url = "";

    private void toIntentServiceUpdate() {
        Intent updateIntent = new Intent(this, UpdateIntentService.class);
        updateIntent.setAction(UpdateIntentService.ACTION_UPDATE);
        updateIntent.putExtra("appName", appName + version_code);
        //随便一个apk的url进行模拟
        updateIntent.putExtra("downUrl", url);
        this.startService(updateIntent);
    }

    private void toSetting() {
        try {
            Intent localIntent = new Intent();
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", this.getPackageName(), null));
            startActivity(localIntent);
        } catch (Exception e) {

        }
    }


}
