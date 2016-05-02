package pumpkin.kr.hanbat.db;

import android.content.Context;

import java.util.GregorianCalendar;

/**
 * Created by farid on 2016-05-02.
 */
public class HanbatBaseDao {
    public Context mContext;
    public HanbatDBHelper mDBHelper;
    public GregorianCalendar mCalendar;

    public HanbatBaseDao(Context ctx) {
        mContext = ctx;
        mDBHelper = HanbatDBHelper.getInstance(ctx);
        mCalendar = new GregorianCalendar();
    }
}
