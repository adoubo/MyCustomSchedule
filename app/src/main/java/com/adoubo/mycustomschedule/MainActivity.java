package com.adoubo.mycustomschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;


import com.adoubo.customschedule.MyListView;
import com.adoubo.customschedule.MyNewLayoutTitle;
import com.adoubo.customschedule.bean.SelectDayTime;
import com.adoubo.customschedule.bean.SelectWeekTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyNewLayoutTitle layoutTitle = (MyNewLayoutTitle) findViewById(R.id.layout_title);
        MyListView listView = (MyListView) findViewById(R.id.list_view);
        MyNewAdapter adapter = new MyNewAdapter(this, getSupportFragmentManager(), initData());
        listView.setAdapter(adapter);
    }

    private List<SelectWeekTime> initData() {
        List<SelectWeekTime> weekTimeList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            SelectWeekTime weekTime = new SelectWeekTime();
            weekTime.setDayOfWeek(i + 1);
            weekTimeList.add(weekTime);
            List<SelectDayTime> dayTimeList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                SelectDayTime selectDayTime = new SelectDayTime();
                selectDayTime.setStartHour(1);
                selectDayTime.setStartMinute(26);
                selectDayTime.setEndHour(4);
                selectDayTime.setEndMinute(12);
                dayTimeList.add(selectDayTime);
            }

            weekTimeList.get(i).setDayTimeList(dayTimeList);
        }
        return weekTimeList;
    }
}
