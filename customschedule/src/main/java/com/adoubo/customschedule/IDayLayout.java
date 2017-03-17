package com.adoubo.customschedule;

/**
 * Created by caoweixin
 * 2017/3/15
 * Email: caoweixin@hikvision.com.cn
 */

public interface IDayLayout {

    interface OnBlockClickListener {
        void onBlockClick(int tag);
    }

    void setOnBlockClickListener(OnBlockClickListener listener);

    void setWeekTitle(int dayOfWeek);

    void drawColor(int startHour, int startMinute, int endHour, int endMinute);
}
