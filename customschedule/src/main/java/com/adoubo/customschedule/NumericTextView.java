package com.adoubo.customschedule;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by caoweixin
 * 2017/3/21
 * Email: caoweixin@hikvision.com.cn
 */

public class NumericTextView extends AppCompatTextView {

    /**
     * 布局的左边界，默认为0，如果该值不大于0则采用默认的左边界
     *
     * @see #layout(int, int, int, int)
     * @see #setLayoutLeft(int)
     * @see #getLeft()
     */
    private int layoutLeft;

    public NumericTextView(Context context) {
        super(context);
    }

    public NumericTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NumericTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLayoutLeft(int layoutLeft) {
        this.layoutLeft = layoutLeft;
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        if (layoutLeft > 0) {
            final int width = r - l;
            final int left = layoutLeft;
            final int right = left + width;
            super.layout(left, t, right, b);
        } else {
            super.layout(l, t, r, b);
        }
    }
}
