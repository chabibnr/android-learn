package net.chabibnr.latihan.Content;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import net.chabibnr.latihan.R;

public class ContentCalendar extends AppCompatActivity {

    CalendarView mCalendarView;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Calendar");


        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
    }
}
