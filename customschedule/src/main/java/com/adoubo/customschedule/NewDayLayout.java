package com.adoubo.customschedule;

import android.content.Context;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.adoubo.customschedule.bean.SelectDayTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoweixin
 * 2017/3/20
 * Email: caoweixin@hikvision.com.cn
 */

public class NewDayLayout extends LinearLayout implements INewDayLayout {

    private static final String TAG = NewDayLayout.class.getSimpleName();

    private MyBlockView blockView;

    //总共拥有的多少个区域
    private int sum = 24;

    private int left;


    private INewDayLayout.OnDistrictClickListener listener;

    public NewDayLayout(Context context) {
        this(context, null);
    }

    public NewDayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_day_item, this);
        blockView = (MyBlockView) view.findViewById(R.id.block_view);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        left = l;
        blockView.setOnTouchListener(onBlockTouch);
    }

    private OnTouchListener onBlockTouch = new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i(TAG, "onTouch: ACTION_DOWN");
                    /*for (int i = 0; i < sum; i++) {
                        if (motionEvent.getRawX() > (getWidth() * i / 24) &&
                                motionEvent.getRawX() < (getWidth() * (i + 1)) / 24) {
                            if (listener != null) {
                                listener.onDistrictClick(i);
                            }
                        }
                    }*/
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i(TAG, "onTouch: ACTION_UP");
                    for (int i = 0; i < sum; i++) {
                        if (motionEvent.getRawX() > (left + (getWidth() * i / 24)) &&
                                motionEvent.getRawX() < (left + (getWidth() * (i + 1)) / 24)) {
                            if (listener != null) {
                                listener.onDistrictClick(i);
                            }
                        }
                    }
                    break;
                case MotionEvent.ACTION_CANCEL:
                    break;
            }
            return true;
        }
    };

    @Override
    public void drawView(SelectDayTime dayTime) {
        Map<String, Integer> map = new HashMap<>();
        int start = (dayTime.getStartHour() * 60 + dayTime.getStartMinute()) * 100 / (24 * 60);
        int end = (dayTime.getEndHour() * 60 + dayTime.getEndMinute()) * 100 / (24 * 60);

        map.put("start", start);
        map.put("end", end);
        blockView.setPercent(map);
        blockView.invalidate();
    }

    @Override
    public void setMaxNum(int num) {
        this.sum = num;
    }

    @Override
    public void setOnDestrictClickListener(OnDistrictClickListener listener) {
        this.listener = listener;
    }
}
