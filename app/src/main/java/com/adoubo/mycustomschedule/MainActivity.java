package com.adoubo.mycustomschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.adoubo.customschedule.MyNewLayoutTitle;
import com.adoubo.customschedule.bean.SelectDayTime;
import com.adoubo.customschedule.bean.SelectWeekTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnSelectTimeSaveListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyNewLayoutTitle layoutTitle = (MyNewLayoutTitle) findViewById(R.id.layout_title);
        ListView listView = (ListView) findViewById(R.id.list_view);
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
                selectDayTime.setStartHour(0);
                selectDayTime.setStartMinute(0);
                selectDayTime.setEndHour(7);
                selectDayTime.setEndMinute(0);
                dayTimeList.add(selectDayTime);
            }

            weekTimeList.get(i).setDayTimeList(dayTimeList);
        }
        return weekTimeList;
    }

    @Override
    public void onSelectTimeSave(List<SelectWeekTime> selectWeekTimeList) {

    }
}
