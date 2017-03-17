package com.adoubo.customschedule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by caoweixin
 * 2017/3/2
 * Email: caoweixin@hikvision.com.cn
 */

public class MyBlockView extends View {

    private int mPaintColor;

    private int mDefaultColor;

    private int mStartPercent;

    private int mEndPercent;

    private Paint mPaint;

    public MyBlockView(Context context) {
        this(context, null);
    }

    public MyBlockView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyBlockView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mPaintColor = context.getResources().getColor(R.color.select_color);
        mDefaultColor = context.getResources().getColor(R.color.white);
        mStartPercent = 0;
        mEndPercent = 0;

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyBlockView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.MyBlockView_paint_color) {
                mPaintColor = a.getColor(attr, Color.RED);
            } else if (attr == R.styleable.MyBlockView_default_color) {
                mDefaultColor = a.getColor(attr, Color.BLACK);
            } else if (attr == R.styleable.MyBlockView_start_percent) {
                mStartPercent = a.getColor(attr, 0);
            } else if (attr == R.styleable.MyBlockView_end_percent) {
                mEndPercent = a.getColor(attr, 50);
            }
        }
        a.recycle();

        mPaint = new Paint();

    }

    public synchronized void setPaintColor(int color) {
        this.mPaintColor = color;
    }

    public synchronized void setDefaultColor(int color) {
        this.mPaintColor = color;
    }

    public synchronized void setStartPercent(int percent) {
        this.mStartPercent = percent;
    }

    public synchronized void setEndPercent(int percent) {
        this.mEndPercent = percent;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(mDefaultColor);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        float left = getWidth() * mStartPercent / 100;
        float top = getHeight() * 20 / 100;
        float bottom = getHeight() * 80 / 100;
        float right = getWidth() * mEndPercent / 100;
        mPaint.setColor(mPaintColor);
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
