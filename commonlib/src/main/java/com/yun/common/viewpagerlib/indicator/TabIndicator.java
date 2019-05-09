package com.yun.common.viewpagerlib.indicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;


import com.yun.common.R;
import com.yun.common.viewpagerlib.ViewPagerHelperUtils;
import com.yun.common.viewpagerlib.view.ColorTextView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 */

public class TabIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {
    private static final String TAG = "zsr";
    /**
     * const
     */
    private static final int NORMAL_TEXT = 0;
    private static final int COLOR_TEXT = 1;
    private static final int TRI_TAB = 0;
    private static final int RECT_TAB = 1;
    /**
     * attr
     */
    private int mTabWidth;
    private int mTabHeight;
    private int mTriColor;
    private int mCount ;
    private int mHeight;
    private int mWidth;
    private int mDefaultColor = 0xff000000;
    private int mChangeColor = 0xffff0000;
    private int mTextSize;
    private int mTabtyle;
    private int mLineTransX = 0; //移动的位置
    private int mTextType = 0;
    private boolean isShowTab = false;
    private boolean isCanScroll = true; //是否能移动，默认为true
    /**
     * others
     */
    private Path mPath;
    private Paint mPaint;
    private Scroller mScroller;
    private float mSnap;
    private float mDownX,mMoveX;
    private float mLastMoveX;
    private boolean isColorMove;

    public TabIndicator(Context context) {
        this(context,null);
    }

    public TabIndicator(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TabIndicator);
        mCount = ta.getInt(R.styleable.TabIndicator_visiabel_size,4);
        mTabWidth = ta.getDimensionPixelSize(R.styleable.TabIndicator_tab_width,30);
        mTabHeight = ta.getDimensionPixelSize(R.styleable.TabIndicator_tab_height,10);
        mTriColor = ta.getResourceId(R.styleable.TabIndicator_tab_color,R.color.page_white);
        mDefaultColor = ta.getColor(R.styleable.TabIndicator_tab_text_default_color,mDefaultColor);
        mChangeColor = ta.getColor(R.styleable.TabIndicator_tab_text_change_color,mChangeColor);
        mTextSize = ta.getDimensionPixelSize(R.styleable.TabIndicator_tab_textsize,
                getResources().getDimensionPixelSize(R.dimen.tabsize));
        mTabtyle = ta.getInteger(R.styleable.TabIndicator_tap_type,1);

        mTextType = ta.getInteger(R.styleable.TabIndicator_tab_text_type,1);
        isShowTab = ta.getBoolean(R.styleable.TabIndicator_tab_show,isShowTab);
        isCanScroll = ta.getBoolean(R.styleable.TabIndicator_tab_iscanscroll,true);
        ta.recycle();
        initData();

    }

    private void initData() {
        setClickable(true);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(mTriColor));

        //实例一个 scroller
        mScroller = new Scroller(getContext());
        mSnap = ViewConfiguration.get(getContext()).getScaledTouchSlop();

    }

    /**
     * 重绘三角形或者圆条
     * @param canvas
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        //偏移 canvas 的起始位置
        if (isShowTab) {
            canvas.save();
            canvas.translate(mLineTransX, 0);
            canvas.drawPath(mPath, mPaint);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int count = getChildCount() ;
        mRightBorder = getChildAt(count -1).getRight();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (isCanScroll) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mDownX = event.getRawX();
                    mLastMoveX = mDownX;
                    break;
                case MotionEvent.ACTION_MOVE:
                    mMoveX = event.getRawX();
                    float dx = Math.abs(mMoveX - mDownX);
                    mLastMoveX = mMoveX;
                    if (dx > mSnap) {
                        //可以移动了，屏蔽子控件，接着在 ontouchEvent 中去处理移动
                        return true;
                    }
                    break;
                default:
                    break;

            }
        }
        return super.onInterceptTouchEvent(event);
    }

    private int mRightBorder ;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isCanScroll) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    mMoveX = event.getRawX();
                    int scrolledX = (int) (mLastMoveX - mMoveX);
                    //边界判断
                    if (getScrollX() + scrolledX < 0) {
                        scrollTo(0, 0);
                        return true;
                    } else if (getScrollX() + getWidth() + scrolledX > mRightBorder) {
                        scrollTo(mRightBorder - getWidth(), 0);
                        return true;
                    }
                    scrollBy(scrolledX, 0);
                    isColorMove = true;
                    mLastMoveX = mMoveX;
                    break;
                case MotionEvent.ACTION_UP :
                    invalidate();
                    break;
                default:
                    break;

            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        //开始移动
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),0);
            invalidate();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        mWidth = wm.getDefaultDisplay().getWidth();
    }

    /**
     * 设置viewpager的切换速度
     * @param viewPager
     * @param time
     */
    public void setViewPagerSwitchSpeed(ViewPager viewPager, int time){
        ViewPagerHelperUtils.initSwitchTime(getContext(),viewPager,time);
    }




    /**
     * 顶部点击事件的监听
     */
    public interface TabClickListener{
        void onClick(int position);
    }

    /**
     * 这个函数，则表示使用在 TabIndicator xml 的控件
     */
    public void setTabData(ViewPager viewPager, TabClickListener listener){
        setTabData(viewPager,null,listener);
    }

    /**
     * 如果使用这个函数，则在xml里面的子控件将被清除，
     * @param viewPager
     * @param titles textview 的内容
     */
    public void setTabData(final ViewPager viewPager, final List<String> titles,
                           final TabClickListener listener){
        if (titles != null && titles.size() > 0){
            removeAllViews();
            for (int i = 0; i < titles.size(); i++) {
                String title = titles.get(i);

                if (mTextType == COLOR_TEXT) {
                    ColorTextView textView = new ColorTextView(getContext());
                    LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                            LayoutParams.MATCH_PARENT);
                    params.width = mWidth / mCount;

                    textView.setText(title);
                    textView.setLayoutParams(params);
                    textView.setCusTextColor(mDefaultColor, mChangeColor, mTextSize);
                    addView(textView);
                }else{
                    TextView textView = new TextView(getContext());
                    LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                            LayoutParams.MATCH_PARENT);
                    params.width = mWidth / mCount;
                    textView.setText(title);
                    textView.setGravity(Gravity.CENTER);
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTextSize);
                    if (i == 0) {
                        textView.setTextColor(mChangeColor);
                    }else{
                        textView.setTextColor(mDefaultColor);
                    }
                    textView.setLayoutParams(params);
                    addView(textView);
                }
            }

        }

        for (int i = 0; i < getChildCount(); i++) {
            final int finalI = i;
            getChildAt(i).setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View view) {
                   listener.onClick(finalI);
                   //在点击的时候，我们需要做一些处理
                   int moveX = getScrollX();
                   if (moveX < 1920) {
                       mScroller.startScroll(0, 0,  0, 0);
                       invalidate();
                   }

               }
           });
        }

        if (viewPager != null){
            viewPager.addOnPageChangeListener(this);
        }

    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;

        mPath = new Path();
        int width = mWidth/mCount;
        if (mTabtyle == TRI_TAB){
            //画三角形
            mPaint.setPathEffect(new CornerPathEffect(2)); //使三角形更加圆润
            mPath.moveTo((width - mTabWidth) / 2, mHeight);
            mPath.lineTo((width + mTabWidth) / 2, mHeight);
            mPath.lineTo(width / 2, mHeight - mTabHeight);

        }else {
            mPath.close();
            //画条状
            mPath.moveTo((width - mTabWidth)/2 ,mHeight);
            mPath.lineTo((width + mTabWidth)/2 ,mHeight);
            mPath.lineTo((width + mTabWidth)/2 ,mHeight - mTabHeight);
            mPath.lineTo((width - mTabWidth)/2 ,mHeight - mTabHeight);
            mPath.close();
        }


    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        onScroll(position,positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        if (mTextType == NORMAL_TEXT) {
            for (int i = 0; i < getChildCount(); i++) {
                if (i == position) {
                    TextView currentView = (TextView) getChildAt(position);
                    if (currentView != null) {
                        currentView.setTextColor(mChangeColor);
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(currentView, "alpha", 0.2f, 1);
                        alpha.setDuration(1000);
                        alpha.setInterpolator(new AccelerateDecelerateInterpolator());

                    }
                } else {
                    TextView lastview = (TextView) getChildAt(i);
                    lastview.setTextColor(mDefaultColor);
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void onScroll(int position, float offset) {
        int tabWidth = getWidth()/mCount;
        mLineTransX = (int) (tabWidth*position + tabWidth*offset);
        if (position >= (mCount - 1) && offset >0 ){
            scrollTo(
                    (position - (mCount - 1))*tabWidth+(int)(tabWidth*offset),
                    0 );
        }
        if (mTextType == COLOR_TEXT) {
            if (offset >= 0) {
                try {
                    //避免移动之后，颜色不对问题
                    if (isColorMove){
                        int count = getChildCount();
                        for (int i = 0; i < count; i++) {
                            ColorTextView textView = (ColorTextView) getChildAt(i);
                            textView.setTextColor(mDefaultColor);
                        }
                        ColorTextView textView = (ColorTextView) getChildAt(position);
                        textView.setTextColor(mChangeColor);
                        isColorMove = false;
                    }
                    ColorTextView leftView = (ColorTextView) getChildAt(position);
                    ColorTextView rightView = (ColorTextView) getChildAt(position + 1);
                    leftView.setprogress(1 - offset, ColorTextView.DEC_RIGHT);
                    rightView.setprogress(offset, ColorTextView.DEC_LEFT);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        invalidate();
    }


}
