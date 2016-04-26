package pumpkin.kr.hanbat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhn.android.maps.NMapActivity;

/**
 * Created by farid on 2016-04-26.
 */
public class MapActivity extends NMapActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

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
                intent = new Intent(MapActivity.this, CalendarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_map:
                break;
            case R.id.btn_notification:
                intent = new Intent(MapActivity.this, NotificationActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
