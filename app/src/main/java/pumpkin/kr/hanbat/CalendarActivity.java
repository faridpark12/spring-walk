package pumpkin.kr.hanbat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pumpkin.kr.hanbat.calendar.MonthlyFragment;
import pumpkin.kr.hanbat.common.Utils;

/**
 * Created by farid on 2016-04-26.
 */
public class CalendarActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView thisMonthTv;
    private int current, mSelectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        findViewById(R.id.btn_calendar).setOnClickListener(this);
        findViewById(R.id.btn_map).setOnClickListener(this);
        findViewById(R.id.btn_notification).setOnClickListener(this);

        thisMonthTv = (TextView) findViewById(R.id.this_month_tv);

        MonthlyFragment mf = (MonthlyFragment) getSupportFragmentManager().findFragmentById(R.id.monthly);
        mf.setOnMonthChangeListener(new MonthlyFragment.OnMonthChangeListener() {
            @Override
            public void onChange(int year, int month) {
                Utils.Log("onChange " + year + "." + month);
                thisMonthTv.setText(year + "년 " + (month + 1) + "월");
            }
        });
    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        Intent intent;

        switch(vid) {
            case R.id.btn_calendar:
                break;
            case R.id.btn_map:
                intent = new Intent(CalendarActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_notification:
                intent = new Intent(CalendarActivity.this, NotificationActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
