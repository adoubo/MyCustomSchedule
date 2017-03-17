package com.adoubo.mycustomschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.adoubo.mycustomschedule.bean.SelectDayTime;
import com.adoubo.mycustomschedule.bean.SelectWeekTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), initData());
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
                selectDayTime.setStartHour(0);
                selectDayTime.setStartMinute(35);
                selectDayTime.setEndHour(7);
                selectDayTime.setEndMinute(0);
                dayTimeList.add(selectDayTime);
            }

            weekTimeList.get(i).setDayTimeList(dayTimeList);
        }
        return weekTimeList;
    }
}
