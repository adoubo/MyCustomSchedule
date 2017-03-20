package com.adoubo.customschedule.bean;

import java.util.List;

/**
 * Created by caoweixin
 * 2017/3/17
 * Email: caoweixin@hikvision.com.cn
 */

public class SelectWeekTime {

    private int dayOfWeek;

    private List<SelectDayTime> dayTimeList;

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<SelectDayTime> getDayTimeList() {
        return dayTimeList;
    }

    public void setDayTimeList(List<SelectDayTime> dayTimeList) {
        this.dayTimeList = dayTimeList;
    }
}
