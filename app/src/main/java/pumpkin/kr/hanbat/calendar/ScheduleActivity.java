package pumpkin.kr.hanbat.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import pumpkin.kr.hanbat.R;
import pumpkin.kr.hanbat.db.ScheduleDao;
import pumpkin.kr.hanbat.db.ScheduleVo;

/**
 * Created by farid on 2016-05-03.
 */
public class ScheduleActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay;
    private EditText[] mEdtText;
    private ScheduleDao mDao;
    private ScheduleVo[] mVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Intent intent = getIntent();
        mYear = intent.getIntExtra("YEAR", 0);
        mMonth = intent.getIntExtra("MONTH", 0);
        mDay = intent.getIntExtra("DAY", 0);

        ((TextView)findViewById(R.id.tv_today)).setText(mYear + "년 " + mMonth + "월 " + mDay + "일");

        mEdtText = new EditText[18];
        mEdtText[0] = (EditText)findViewById(R.id.edt_schedule06);
        mEdtText[1] = (EditText)findViewById(R.id.edt_schedule07);
        mEdtText[2] = (EditText)findViewById(R.id.edt_schedule08);
        mEdtText[3] = (EditText)findViewById(R.id.edt_schedule09);
        mEdtText[4] = (EditText)findViewById(R.id.edt_schedule10);
        mEdtText[5] = (EditText)findViewById(R.id.edt_schedule11);
        mEdtText[6] = (EditText)findViewById(R.id.edt_schedule12);
        mEdtText[7] = (EditText)findViewById(R.id.edt_schedule13);
        mEdtText[8] = (EditText)findViewById(R.id.edt_schedule14);
        mEdtText[9] = (EditText)findViewById(R.id.edt_schedule15);
        mEdtText[10] = (EditText)findViewById(R.id.edt_schedule16);
        mEdtText[11] = (EditText)findViewById(R.id.edt_schedule17);
        mEdtText[12] = (EditText)findViewById(R.id.edt_schedule18);
        mEdtText[13] = (EditText)findViewById(R.id.edt_schedule19);
        mEdtText[14] = (EditText)findViewById(R.id.edt_schedule20);
        mEdtText[15] = (EditText)findViewById(R.id.edt_schedule21);
        mEdtText[16] = (EditText)findViewById(R.id.edt_schedule22);
        mEdtText[17] = (EditText)findViewById(R.id.edt_schedule23);

        mDao = new ScheduleDao(getApplicationContext());
        mVo = mDao.retrieve(mYear, mMonth, mDay);

        if(mVo != null) {
            int size = mVo.length;
            for(int i=0; i<size; i++) {
                switch(mVo[i].HOUR) {
                    case 6: mEdtText[0].setText(mVo[i].EVENT); break;
                    case 7: mEdtText[1].setText(mVo[i].EVENT); break;
                    case 8: mEdtText[2].setText(mVo[i].EVENT); break;
                    case 9: mEdtText[3].setText(mVo[i].EVENT); break;
                    case 10: mEdtText[4].setText(mVo[i].EVENT); break;
                    case 11: mEdtText[5].setText(mVo[i].EVENT); break;
                    case 12: mEdtText[6].setText(mVo[i].EVENT); break;
                    case 13: mEdtText[7].setText(mVo[i].EVENT); break;
                    case 14: mEdtText[8].setText(mVo[i].EVENT); break;
                    case 15: mEdtText[9].setText(mVo[i].EVENT); break;
                    case 16: mEdtText[10].setText(mVo[i].EVENT); break;
                    case 17: mEdtText[11].setText(mVo[i].EVENT); break;
                    case 18: mEdtText[12].setText(mVo[i].EVENT); break;
                    case 19: mEdtText[13].setText(mVo[i].EVENT); break;
                    case 20: mEdtText[14].setText(mVo[i].EVENT); break;
                    case 21: mEdtText[15].setText(mVo[i].EVENT); break;
                    case 22: mEdtText[16].setText(mVo[i].EVENT); break;
                    case 23: mEdtText[17].setText(mVo[i].EVENT); break;
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        for(int i=0; i<18; i++) {
            String event = mEdtText[i].getText().toString();
            if(event != null && event.trim().length() > 0) {
                ScheduleVo vo = new ScheduleVo();
                vo.YEAR = mYear;
                vo.MONTH = mMonth;
                vo.DAY = mDay;
                vo.HOUR = i + 6;
                vo.EVENT = mEdtText[i].getText().toString();
                mDao.delete(vo);
                mDao.insert(vo);
            }
        }

        finish();
    }
}
