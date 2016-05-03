package pumpkin.kr.hanbat.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by farid on 2016-05-02.
 */
public class ScheduleDao extends HanbatBaseDao {
    public static String YEAR = "year";
    public static String MONTH = "month";
    public static String DAY = "day";
    public static String HOUR = "hour";
    public static String EVENT = "event";
    public static String WRITE_TIME = "writetime";
    public static final String TABLE_NAME = "tb_hanbat_schedule";
    public static final String CREATE =
            "create table "+TABLE_NAME+"("
                    +YEAR+" integer, "
                    +MONTH+" integer, "
                    +DAY+" integer, "
                    +HOUR+" integer, "
                    +EVENT+" text, "
                    +WRITE_TIME+" long);";

    public ScheduleDao(Context ctx) {
        super(ctx);
    }

    public ScheduleVo[] retrieve(int year, int month, int day) {
        ScheduleVo[] data = null;
        String selection = YEAR + "=? AND " + MONTH + "=? AND " + DAY + "=?";
        String[] selectionArgs = {
                Integer.toString(year),
                Integer.toString(month),
                Integer.toString(day) };

        Cursor cursor = mDBHelper.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
        if(cursor == null || cursor.getCount() == 0)
            return null;

        int rowCount = cursor.getCount();
        data = new ScheduleVo[rowCount];

        int yearIdx = cursor.getColumnIndex(YEAR);
        int monthIdx = cursor.getColumnIndex(MONTH);
        int dayIdx = cursor.getColumnIndex(DAY);
        int hourIdx = cursor.getColumnIndex(HOUR);
        int eventIdx = cursor.getColumnIndex(EVENT);
        int writeTimeIdx = cursor.getColumnIndex(WRITE_TIME);

        cursor.moveToFirst();
        for(int i=0; i<rowCount; i++) {
            data[i] = new ScheduleVo();

            data[i].YEAR = cursor.getInt(yearIdx);
            data[i].MONTH = cursor.getInt(monthIdx);
            data[i].DAY = cursor.getInt(dayIdx);
            data[i].HOUR = cursor.getInt(hourIdx);
            data[i].EVENT = cursor.getString(eventIdx);
            data[i].WRITE_TIME = cursor.getInt(writeTimeIdx);

            cursor.moveToNext();
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return data;
    }

    public long insert(ScheduleVo data) {
        ContentValues values = new ContentValues();
        long milliTime = mCalendar.getTimeInMillis();

        values.put(YEAR, data.YEAR);
        values.put(MONTH, data.MONTH);
        values.put(DAY, data.DAY);
        values.put(HOUR, data.HOUR);
        values.put(EVENT, data.EVENT);
        values.put(WRITE_TIME, milliTime);

        return mDBHelper.insert(TABLE_NAME, null, values);
    }

    public int delete(ScheduleVo data) {
        String whereClause = YEAR + "=? AND " + MONTH + "=? AND " + DAY + "=? AND " + HOUR + "=?";
        String[] whereArgs = {
                Integer.toString(data.YEAR),
                Integer.toString(data.MONTH),
                Integer.toString(data.DAY),
                Integer.toString(data.HOUR)};

        return mDBHelper.delete(TABLE_NAME, whereClause, whereArgs);
    }
}
