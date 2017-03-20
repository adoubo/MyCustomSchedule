package com.adoubo.customschedule.bean;

/**
 * Created by caoweixin
 * 2017/3/17
 * Email: caoweixin@hikvision.com.cn
 */

public class SelectDayTime {

    private int startHour;

    private int startMinute;

    private int endHour;

    private int endMinute;

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }
}
