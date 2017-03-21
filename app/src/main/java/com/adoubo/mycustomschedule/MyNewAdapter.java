package com.adoubo.mycustomschedule;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.adoubo.customschedule.INewDayLayout;
import com.adoubo.customschedule.NewDayLayout;
import com.adoubo.customschedule.bean.SelectDayTime;
import com.adoubo.customschedule.bean.SelectWeekTime;
import com.adoubo.customtimepicker.MyTimePickerDialog;
import com.adoubo.customtimepicker.RadialPickerLayout;
import com.adoubo.customtimepicker.TimeSection;

import java.util.List;

/**
 * Created by caoweixin
 * 2017/3/20
 * Email: caoweixin@hikvision.com.cn
 */

public class MyNewAdapter extends BaseAdapter implements MyTimePickerDialog.OnTimeSetListener {

    private Context mContext;

    private FragmentManager mFragmentManager;

    private List<SelectWeekTime> mWeekTimes;

    public MyNewAdapter(Context context, FragmentManager fragmentManager, List<SelectWeekTime> weekTimes) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mWeekTimes = weekTimes;
    }

    @Override
    public int getCount() {
        return mWeekTimes.size();
    }

    @Override
    public Object getItem(int position) {
        return mWeekTimes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.new_list_item, parent, false);
            viewHolder.newDayLeft = (TextView) convertView.findViewById(R.id.new_day_left);
            if (position == 0) {
                viewHolder.newDayLeft.setText("星期一");
            } else if (position == 1) {
                viewHolder.newDayLeft.setText("星期二");
            } else if (position == 2) {
                viewHolder.newDayLeft.setText("星期三");
            } else if (position == 3) {
                viewHolder.newDayLeft.setText("星期四");
            } else if (position == 4) {
                viewHolder.newDayLeft.setText("星期五");
            } else if (position == 5) {
                viewHolder.newDayLeft.setText("星期六");
            } else if (position == 6) {
                viewHolder.newDayLeft.setText("星期日");
            }
            viewHolder.newDayLayout = (NewDayLayout) convertView.findViewById(R.id.new_day_layout);
            viewHolder.newDayLayout.setMaxNum(24);
            viewHolder.newDayLayout.setOnDestrictClickListener(new INewDayLayout.OnDistrictClickListener() {
                @Override
                public void onDistrictClick(int item) {
                    List<SelectDayTime> dayTimeList = mWeekTimes.get(position).getDayTimeList();
                    if (enableModify(item, dayTimeList) != -1) {
                        int col = enableModify(item, dayTimeList);
                        TimeSection timeSection = new TimeSection(
                                dayTimeList.get(col).getStartHour(), dayTimeList.get(col).getStartMinute(),
                                dayTimeList.get(col).getEndHour(), dayTimeList.get(col).getEndMinute());
                        MyTimePickerDialog myTimePickerDialog = MyTimePickerDialog.newInstance(MyNewAdapter.this, timeSection);
                        myTimePickerDialog.show(mFragmentManager, "dialog" + item);
                    } else {
                        TimeSection timeSection = new TimeSection(item, 0, item + 1, 0);
                        MyTimePickerDialog myTimePickerDialog = MyTimePickerDialog.newInstance(MyNewAdapter.this, timeSection);
                        myTimePickerDialog.show(mFragmentManager, "dialog" + item);
                    }
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convert(viewHolder, position);
        return convertView;
    }

    private void convert(ViewHolder viewHolder, int position) {
        SelectWeekTime weekTime = mWeekTimes.get(position);
        for (SelectDayTime dayTime : weekTime.getDayTimeList()) {
            viewHolder.newDayLayout.drawView(dayTime);
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, TimeSection timeSection, int week) {

    }

    @Override
    public void onCancel() {

    }

    private class ViewHolder {
        TextView newDayLeft;
        NewDayLayout newDayLayout;
    }

    /**
     * 判断当前点击的块是否在已经设置好的时间段内
     * @return 0：表示点击处是第一块时间，1：表示点击处是第二块时间
     */

    private int enableModify(int tag, List<SelectDayTime> dayTimeList) {
        for (int i = 0; i < dayTimeList.size(); i++) {
            if (dayTimeList.get(i).getStartHour() == 0 && dayTimeList.get(i).getStartMinute() == 0 &&
                    dayTimeList.get(i).getEndHour() == 0 && dayTimeList.get(i).getEndMinute() == 0) {
                return -1;
            }
            if (tag >= dayTimeList.get(i).getStartHour() && tag <= dayTimeList.get(i).getEndHour()) {
                return i;
            }
        }
        return -1;
    }
}
