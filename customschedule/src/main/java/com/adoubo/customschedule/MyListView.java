package com.adoubo.customschedule;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by yexiaokang on 2017/3/21.
 */

public class MyListView extends ListView {

    private static final String TAG = "MyListView";
    private static final boolean LOG_DEBUG = false;

    private int lastX;
    private int lastY;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - lastX;
                int deltaY = y - lastY;
                if (Math.abs(deltaY) > Math.abs(deltaX)) {
                    intercepted = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        if (LOG_DEBUG) {
            Log.i(TAG, "onInterceptTouchEvent: intercepted = " + intercepted);
        }
        return intercepted || super.onInterceptTouchEvent(ev);
    }
}
