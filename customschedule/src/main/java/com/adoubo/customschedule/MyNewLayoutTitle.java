package com.adoubo.customschedule;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by caoweixin
 * 2017/3/20
 * Email: caoweixin@hikvision.com.cn
 */

public class MyNewLayoutTitle extends RelativeLayout {

    private static final String TAG = MyNewLayoutTitle.class.getSimpleName();
    private static final boolean LOG_DEBUG = false;

    private int sum = 24;

    private float lastWidth;
    private int pWidth;

    public MyNewLayoutTitle(Context context) {
        this(context, null);
    }

    public MyNewLayoutTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addAllViewsInLayout();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // 下面的代码必须在super.onLayout(...)之前调用，设置布局左边界

        final int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                float localLastWidth = lastWidth;
                // 视图大小发生变化时一定要重新计算宽度
                if ((localLastWidth == 0 || changed) && child instanceof NumericTextView) {
                    localLastWidth = ((NumericTextView) child).getPaint().measureText("24");
                    lastWidth = localLastWidth;
                    if (LOG_DEBUG) {
                        Log.i(TAG, "onLayout: localLastWidth = " + localLastWidth);
                    }
                }
                int localPWidth = pWidth;
                // 视图大小发生变化时一定要重新计算宽度
                if (localPWidth == 0 || changed) {
                    if (LOG_DEBUG) {
                        Log.i(TAG, "onLayout: getWidth = " + getWidth());
                    }
                    localPWidth = (int) (getWidth() - localLastWidth);
                    pWidth = localPWidth;
                    if (LOG_DEBUG) {
                        Log.i(TAG, "onLayout: localPWidth = " + localPWidth);
                    }
                }
                if (child instanceof NumericTextView) {
                    final int localSum = sum + sum % 2;
                    int width = localPWidth * i * 2 / localSum;
                    if (LOG_DEBUG) {
                        Log.i(TAG, "i: " + i + " width: " + width);
                    }
                    ((NumericTextView) child).setLayoutLeft(width);
                }
            }
        }

        super.onLayout(changed, l, t, r, b);
    }

    private void addAllViewsInLayout() {
        final int count = sum + sum % 2;
        for (int i = 0; i <= count; i += 2) {
            addNewView(getContext(), i);
        }
    }

    private void addNewView(Context context, int i) {
        NumericTextView textView = new NumericTextView(context);
        textView.setTextColor(Color.BLACK);
        textView.setText(String.valueOf(i));
        // ViewGroup添加View的时候会为子View添加一个默认的LayoutParams
        // 如需修改默认的LayoutParams，请重载ViewGroup.generateDefaultLayoutParams()
        addView(textView);
    }

    public void setSum(int num) {
        if (this.sum != num) {
            this.sum = num;
            removeAllViewsInLayout();
            addAllViewsInLayout();
            requestLayout();
        }
    }

}
