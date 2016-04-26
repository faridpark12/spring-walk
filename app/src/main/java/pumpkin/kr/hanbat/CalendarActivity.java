package pumpkin.kr.hanbat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by farid on 2016-04-26.
 */
public class CalendarActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        findViewById(R.id.btn_calendar).setOnClickListener(this);
        findViewById(R.id.btn_map).setOnClickListener(this);
        findViewById(R.id.btn_notification).setOnClickListener(this);
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
