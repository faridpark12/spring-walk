package pumpkin.kr.hanbat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by farid on 2016-04-26.
 */
public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.btn_calendar).setOnClickListener(this);
        findViewById(R.id.btn_map).setOnClickListener(this);
        findViewById(R.id.btn_notification).setOnClickListener(this);

        mWebView = (WebView)findViewById(R.id.web_view);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://m.hanbat.ac.kr/_prog/bbs_list/?code=bachelor");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();;
        }
    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        Intent intent;

        switch(vid) {
            case R.id.btn_calendar:
                intent = new Intent(NotificationActivity.this, CalendarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_map:
                intent = new Intent(NotificationActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_notification:
                break;
        }
    }
}
