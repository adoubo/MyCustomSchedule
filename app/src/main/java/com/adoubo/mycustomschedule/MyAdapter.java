package com.adoubo.mycustomschedule;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.adoubo.customschedule.DayLayout;
import com.adoubo.customschedule.IDayLayout;
import com.adoubo.customtimepicker.MyTimePickerDialog;
import com.adoubo.customtimepicker.RadialPickerLayout;
import com.adoubo.customtimepicker.TimeSection;
import com.adoubo.mycustomschedule.bean.SelectDayTime;
import com.adoubo.mycustomschedule.bean.SelectWeekTime;

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

    public MyAdapter(Context context, FragmentManager fragmentManager, List<SelectWeekTime> list) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mWeekTimeList = list;
    }

    @Override
    public int getCount() {
        return mWeekTimeList.size();
    }

    @Override
    public Object getItem(int i) {
        return mWeekTimeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.dayLayout = (DayLayout) view.findViewById(R.id.day_layout);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        convert(viewHolder, i);
        return view;
    }

    private void convert(ViewHolder viewHolder, final int i) {
        SelectWeekTime selectWeekTime = mWeekTimeList.get(i);
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
                Toast.makeText(mContext, "Tag: " + tag + " Day: " + (i + 1), Toast.LENGTH_SHORT).show();
                TimeSection timeSection = new TimeSection(tag, 0, tag + 1, 0);
                MyTimePickerDialog myTimePickerDialog = MyTimePickerDialog.newInstance(MyAdapter.this, timeSection);
                myTimePickerDialog.show(mFragmentManager, "dialog" + tag);
            }
        });
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int startHour, int startMinute, int endHour, int endMinute, int week) {

    }

    @Override
    public void onCancel() {

    }

    class ViewHolder {
        DayLayout dayLayout;
    }
}
