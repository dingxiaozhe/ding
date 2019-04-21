package com.example.geeknew.activity;





import android.content.Intent;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseActivity;

import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.fragment.DailyNewsFragment;

import com.example.geeknew.net.RxBus;
import com.example.geeknew.presenter.EmptyPresenter;

import com.example.geeknew.util.DateUtil;
import com.example.geeknew.view.EmptyView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;


public class CalendarActivity extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView {
    private static final String TAG = "CalendarActivity";
    @BindView(R.id.view_calender)
    MaterialCalendarView mCalender;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
 CalendarDay mDate;
@BindView(R.id.tv_calender_enter)
TextView tv_calender_enter;


    private String format;


    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

   @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar;
    }




    @OnClick(R.id.tv_calender_enter)
    void chooseDate() {
        if (format != null) {
           // RxBus.getDefault().post(currentDate);
         /*   String year = mDate.getYear()+"";
            String month=mDate.getMonth()+"";
            String day = mDate.getDay()+"";*/

            //String date=year+month+day;
           // Intent intent = new Intent();
            Intent intent = getIntent();
            intent.putExtra("date",format);
            Log.e(TAG, "chooseDate: "+format );
            setResult(1002,intent);
            }
        finish();
    }


    @Override
    protected void initListener() {
         setToolBar(mToolbar, "选择日期");
         mCalender.state().edit()
                 .setFirstDayOfWeek(Calendar.WEDNESDAY)
                 .setMinimumDate(CalendarDay.from(2013, 5, 20))
                 .setMaximumDate(CalendarDay.from(DateUtil.getCurrentYear(), DateUtil.getCurrentMonth(), DateUtil.getCurrentDay()))
                 .setCalendarDisplayMode(CalendarMode.MONTHS)
                 .commit();
         mCalender.setOnDateChangedListener(new OnDateSelectedListener() {


             @Override
             public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                 /*mDate = date;
                 currentDate = DateUtil.getTomorrowDate();*/
                Date date1 = date.getDate();
                 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
                 format = sf.format(date1);

                 Log.e(TAG, "onDateSelected: "+ format);

             }
         });
     }

}
