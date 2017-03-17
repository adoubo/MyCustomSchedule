package com.adoubo.customschedule;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoweixin
 * 2017/3/15
 * Email: caoweixin@hikvision.com.cn
 */

public class DayLayout extends LinearLayout implements IDayLayout, View.OnClickListener {

    private int dayOfWeek;

    private OnBlockClickListener mBlockClickListener;

    private TextView weekTitle;

    private MyBlockView block0;
    private MyBlockView block1;
    private MyBlockView block2;
    private MyBlockView block3;
    private MyBlockView block4;
    private MyBlockView block5;
    private MyBlockView block6;
    private MyBlockView block7;
    private MyBlockView block8;
    private MyBlockView block9;
    private MyBlockView block10;
    private MyBlockView block11;
    private MyBlockView block12;
    private MyBlockView block13;
    private MyBlockView block14;
    private MyBlockView block15;
    private MyBlockView block16;
    private MyBlockView block17;
    private MyBlockView block18;
    private MyBlockView block19;
    private MyBlockView block20;
    private MyBlockView block21;
    private MyBlockView block22;
    private MyBlockView block23;

    private List<MyBlockView> blockViewLists;

    public DayLayout(Context context) {
        this(context, null);
    }

    public DayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_day_item, this);
        weekTitle = (TextView) view.findViewById(R.id.week_title);
        block0 = (MyBlockView) view.findViewById(R.id.view_0);
        block1 = (MyBlockView) view.findViewById(R.id.view_1);
        block2 = (MyBlockView) view.findViewById(R.id.view_2);
        block3 = (MyBlockView) view.findViewById(R.id.view_3);
        block4 = (MyBlockView) view.findViewById(R.id.view_4);
        block5 = (MyBlockView) view.findViewById(R.id.view_5);
        block6 = (MyBlockView) view.findViewById(R.id.view_6);
        block7 = (MyBlockView) view.findViewById(R.id.view_7);
        block8 = (MyBlockView) view.findViewById(R.id.view_8);
        block9 = (MyBlockView) view.findViewById(R.id.view_9);
        block10 = (MyBlockView) view.findViewById(R.id.view_10);
        block11 = (MyBlockView) view.findViewById(R.id.view_11);
        block12 = (MyBlockView) view.findViewById(R.id.view_12);
        block13 = (MyBlockView) view.findViewById(R.id.view_13);
        block14 = (MyBlockView) view.findViewById(R.id.view_14);
        block15 = (MyBlockView) view.findViewById(R.id.view_15);
        block16 = (MyBlockView) view.findViewById(R.id.view_16);
        block17 = (MyBlockView) view.findViewById(R.id.view_17);
        block18 = (MyBlockView) view.findViewById(R.id.view_18);
        block19 = (MyBlockView) view.findViewById(R.id.view_19);
        block20 = (MyBlockView) view.findViewById(R.id.view_20);
        block21 = (MyBlockView) view.findViewById(R.id.view_21);
        block22 = (MyBlockView) view.findViewById(R.id.view_22);
        block23 = (MyBlockView) view.findViewById(R.id.view_23);
        initClick();
        initBlockViewLists();
    }

    private void  initClick() {
        block0.setOnClickListener(this);
        block1.setOnClickListener(this);
        block2.setOnClickListener(this);
        block3.setOnClickListener(this);
        block4.setOnClickListener(this);
        block5.setOnClickListener(this);
        block6.setOnClickListener(this);
        block7.setOnClickListener(this);
        block8.setOnClickListener(this);
        block9.setOnClickListener(this);
        block10.setOnClickListener(this);
        block11.setOnClickListener(this);
        block12.setOnClickListener(this);
        block13.setOnClickListener(this);
        block14.setOnClickListener(this);
        block15.setOnClickListener(this);
        block16.setOnClickListener(this);
        block17.setOnClickListener(this);
        block18.setOnClickListener(this);
        block19.setOnClickListener(this);
        block20.setOnClickListener(this);
        block21.setOnClickListener(this);
        block22.setOnClickListener(this);
        block23.setOnClickListener(this);
    }

    private void initBlockViewLists() {
        blockViewLists = new ArrayList<>();
        blockViewLists.add(block0);
        blockViewLists.add(block1);
        blockViewLists.add(block2);
        blockViewLists.add(block3);
        blockViewLists.add(block4);
        blockViewLists.add(block5);
        blockViewLists.add(block6);
        blockViewLists.add(block7);
        blockViewLists.add(block8);
        blockViewLists.add(block9);
        blockViewLists.add(block10);
        blockViewLists.add(block11);
        blockViewLists.add(block12);
        blockViewLists.add(block13);
        blockViewLists.add(block14);
        blockViewLists.add(block15);
        blockViewLists.add(block16);
        blockViewLists.add(block17);
        blockViewLists.add(block18);
        blockViewLists.add(block19);
        blockViewLists.add(block20);
        blockViewLists.add(block21);
        blockViewLists.add(block22);
        blockViewLists.add(block23);
    }

    @Override
    public void setOnBlockClickListener(OnBlockClickListener listener) {
        this.mBlockClickListener = listener;
    }

    @Override
    public void setWeekTitle(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        switch (dayOfWeek) {
            case 1:
                weekTitle.setText("星期一");
                break;
            case 2:
                weekTitle.setText("星期二");
                break;
            case 3:
                weekTitle.setText("星期三");
                break;
            case 4:
                weekTitle.setText("星期四");
                break;
            case 5:
                weekTitle.setText("星期五");
                break;
            case 6:
                weekTitle.setText("星期六");
                break;
            case 7:
                weekTitle.setText("星期日");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.view_0) {
            mBlockClickListener.onBlockClick(0);
        } else if (v.getId() == R.id.view_1) {
            mBlockClickListener.onBlockClick(1);
        } else if (v.getId() == R.id.view_2) {
            mBlockClickListener.onBlockClick(2);
        } else if (v.getId() == R.id.view_3) {
            mBlockClickListener.onBlockClick(3);
        } else if (v.getId() == R.id.view_4) {
            mBlockClickListener.onBlockClick(4);
        } else if (v.getId() == R.id.view_5) {
            mBlockClickListener.onBlockClick(5);
        } else if (v.getId() == R.id.view_6) {
            mBlockClickListener.onBlockClick(6);
        } else if (v.getId() == R.id.view_7) {
            mBlockClickListener.onBlockClick(7);
        } else if (v.getId() == R.id.view_8) {
            mBlockClickListener.onBlockClick(8);
        } else if (v.getId() == R.id.view_9) {
            mBlockClickListener.onBlockClick(9);
        } else if (v.getId() == R.id.view_10) {
            mBlockClickListener.onBlockClick(10);
        } else if (v.getId() == R.id.view_11) {
            mBlockClickListener.onBlockClick(11);
        } else if (v.getId() == R.id.view_12) {
            mBlockClickListener.onBlockClick(12);
        } else if (v.getId() == R.id.view_13) {
            mBlockClickListener.onBlockClick(13);
        } else if (v.getId() == R.id.view_14) {
            mBlockClickListener.onBlockClick(14);
        } else if (v.getId() == R.id.view_15) {
            mBlockClickListener.onBlockClick(15);
        } else if (v.getId() == R.id.view_16) {
            mBlockClickListener.onBlockClick(16);
        } else if (v.getId() == R.id.view_17) {
            mBlockClickListener.onBlockClick(17);
        } else if (v.getId() == R.id.view_18) {
            mBlockClickListener.onBlockClick(18);
        } else if (v.getId() == R.id.view_19) {
            mBlockClickListener.onBlockClick(19);
        } else if (v.getId() == R.id.view_20) {
            mBlockClickListener.onBlockClick(20);
        } else if (v.getId() == R.id.view_21) {
            mBlockClickListener.onBlockClick(21);
        } else if (v.getId() == R.id.view_22) {
            mBlockClickListener.onBlockClick(22);
        } else if (v.getId() == R.id.view_23) {
            mBlockClickListener.onBlockClick(23);
        }
    }

    @Override
    public void drawColor(int startHour, int startMinute, int endHour, int endMinute) {
        Log.i("cwx", "sh: " + startHour + " sm: " + startMinute + " eh: " + endHour + " em: " + endMinute);
        int startPercent = startMinute * 100 / 60;
        int endPercent = endMinute * 100 / 60;
        if (startHour == endHour) {
            blockViewLists.get(startHour).setStartPercent(startPercent);
            blockViewLists.get(startHour).setEndPercent(endPercent);
        } else if (startHour + 1 == endHour) {
            blockViewLists.get(startHour).setStartPercent(startPercent);
            blockViewLists.get(startHour).setEndPercent(100);
            blockViewLists.get(endHour).setStartPercent(0);
            blockViewLists.get(endHour).setEndPercent(endPercent);
        } else if (startHour + 1 < endHour) {
            fillInterBlock(startHour, endHour);
        }
    }

    private void fillInterBlock(int startHour, int endHour) {
        Log.i("cwx", "fillInterBlock");
        for (int i = startHour + 1; i < endHour; i++) {
            blockViewLists.get(i).setStartPercent(0);
            blockViewLists.get(i).setEndPercent(100);
        }
    }
}
