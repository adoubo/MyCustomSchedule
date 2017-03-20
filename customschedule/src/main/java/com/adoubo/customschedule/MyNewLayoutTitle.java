package com.adoubo.customschedule;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by caoweixin
 * 2017/3/20
 * Email: caoweixin@hikvision.com.cn
 */

public class MyNewLayoutTitle extends RelativeLayout {

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
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            for (int i = 0; i < (sum + 1); i+=2) {
                addNewView(getContext(), i);
            }
        }
    }

    private void addNewView(Context context, int i) {
        TextView textView = new TextView(context);
        textView.setTextColor(Color.BLACK);
        textView.setText(String.valueOf(i));
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        if(lastWidth ==0) {
            lastWidth = textView.getPaint().measureText("24");
        }
        if(pWidth == 0){
            pWidth = (int) (getWidth()-lastWidth);
        }
        int width = pWidth*i / sum;
        Log.i("cwx", "i: " + i + " width: " + width);
        if(i!=sum) {
            layoutParams.leftMargin = width;
        }else{
            layoutParams.addRule(ALIGN_PARENT_RIGHT);
        }

        addView(textView, layoutParams);
    }

    public void setSum(int num) {
        this.sum = num;
    }

}
