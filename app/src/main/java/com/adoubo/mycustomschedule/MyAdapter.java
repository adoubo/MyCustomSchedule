package com.adoubo.mycustomschedule;

import android.content.Context;
import android.support.annotation.Px;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.adoubo.customschedule.DayLayout;
import com.adoubo.customschedule.IDayLayout;
import com.adoubo.customschedule.bean.SelectDayTime;
import com.adoubo.customschedule.bean.SelectWeekTime;
import com.adoubo.customtimepicker.MyTimePickerDialog;
import com.adoubo.customtimepicker.RadialPickerLayout;
import com.adoubo.customtimepicker.TimeSection;

import java.util.List;

/**
 * Created by caoweixin
 * 2017/3/17
 * Email: caoweixin@hikvision.com.cn
 */

public class MyAdapter extends BaseAdapter implements MyTimePickerDialog.OnTimeSetListener {

    private Context mContext;

    private FragmentManager mFragmentManager;

    private List<SelectWeekTime> mWeekTimeList;

    private OnSelectTimeSaveListener mCallback;

    // 用于将保存好的时间回传
    interface OnSelectTimeSaveListener {

        void onSelectTimeSave(List<SelectWeekTime> selectWeekTimeList);
    }

    public MyAdapter(Context context, FragmentManager fragmentManager, OnSelectTimeSaveListener callback, List<SelectWeekTime> list) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mCallback = callback;
        this.mWeekTimeList = list;
    }

    @Override
    public int getCount() {
        return mWeekTimeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mWeekTimeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.dayLayout = (DayLayout) convertView.findViewById(R.id.day_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convert(viewHolder, position);
        return convertView;
    }

    private void convert(ViewHolder viewHolder, final int position) {
        final SelectWeekTime selectWeekTime = mWeekTimeList.get(position);
        viewHolder.dayLayout.setWeekTitle(selectWeekTime.getDayOfWeek());
        for (int j = 0; j <selectWeekTime.getDayTimeList().size(); j++) {
            viewHolder.dayLayout.drawColor(selectWeekTime.getDayTimeList().get(j).getStartHour(),
                    selectWeekTime.getDayTimeList().get(j).getStartMinute(),
                    selectWeekTime.getDayTimeList().get(j).getEndHour(),
                    selectWeekTime.getDayTimeList().get(j).getEndMinute());
        }
        viewHolder.dayLayout.setOnBlockClickListener(new IDayLayout.OnBlockClickListener() {
            @Override
            public void onBlockClick(int tag) {
                Toast.makeText(mContext, "Tag: " + tag + " Day: " + (position + 1), Toast.LENGTH_SHORT).show();
                if (enableModify(tag, selectWeekTime.getDayTimeList()) == -1) {
                    TimeSection timeSection = new TimeSection(tag, 0, tag + 1, 0);
                    MyTimePickerDialog myTimePickerDialog = MyTimePickerDialog.newInstance(MyAdapter.this, timeSection);
                    myTimePickerDialog.show(mFragmentManager, "dialog" + tag);
                } else {
                    int item = enableModify(tag, selectWeekTime.getDayTimeList());
                    TimeSection timeSection = new TimeSection(
                            selectWeekTime.getDayTimeList().get(item).getStartHour(),
                            selectWeekTime.getDayTimeList().get(item).getStartMinute(),
                            selectWeekTime.getDayTimeList().get(item).getEndHour(),
                            selectWeekTime.getDayTimeList().get(item).getEndMinute());
                    MyTimePickerDialog myTimePickerDialog = MyTimePickerDialog.newInstance(MyAdapter.this, timeSection);
                    myTimePickerDialog.show(mFragmentManager, "dialog" + tag);
                }

            }
        });
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, TimeSection timeSection, int week) {
        SelectDayTime dayTime = new SelectDayTime();
        dayTime.setStartHour(timeSection.getStartHour());
        dayTime.setStartMinute(timeSection.getStartMinute());
        dayTime.setEndHour(timeSection.getEndHour());
        dayTime.setEndMinute(timeSection.getEndMinute());

        //mCallback.onSelectTimeSave();
    }

    @Override
    public void onCancel() {

    }

    private class ViewHolder {
        DayLayout dayLayout;
    }

    /**
     * 判断当前点击的块是否在已经设置好的时间段内
     * @return 0：表示点击处是第一块时间，1：表示点击处是第二块时间
     */

    private int enableModify(int tag, List<SelectDayTime> dayTimeList) {
        for (int i = 0; i < dayTimeList.size(); i++) {
            if (tag >= dayTimeList.get(i).getStartHour() && tag <= dayTimeList.get(i).getEndHour()) {
               return i;
            }
        }
        return -1;
    }
}
