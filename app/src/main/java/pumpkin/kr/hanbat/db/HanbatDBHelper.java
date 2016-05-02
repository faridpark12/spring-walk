package pumpkin.kr.hanbat.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by farid on 2016-05-02.
 */
public class HanbatDBHelper {
    private static HanbatDBHelper mDBHelper;
    private static final String DATABASE_NAME = "hanbat.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase mDB;
    private DatabaseHelper mDataBaseHelper;
    private Context mContext;

    public static HanbatDBHelper getInstance(Context ctx) {
        if(mDBHelper == null) {
            mDBHelper = new HanbatDBHelper(ctx);
            mDBHelper.open();
        }

        return mDBHelper;
    }

    public static void destroyDBHelper() {
        if(mDBHelper != null) {
            mDBHelper.close();
            mDBHelper = null;
        }
    }

    private class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ScheduleDao.CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + ScheduleDao.TABLE_NAME);
            onCreate(db);
        }
    }

    private HanbatDBHelper(Context context) {
        this.mContext = context;
    }

    public HanbatDBHelper open() throws SQLException {
        mDataBaseHelper = new DatabaseHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDataBaseHelper.getWritableDatabase();

        return this;
    }

    private void close() {
        mDB.close();
    }


    public Cursor executeRawQuery(String sql, String[] selectionArgs) {
        if(!mDB.isOpen()) open();

        try {
            return mDB.rawQuery(sql, selectionArgs);
        } catch(Exception e) {
            return null;
        }
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        if(!mDB.isOpen()) open();
        return mDB.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        if(!mDB.isOpen()) open();
        return mDB.insert(table, nullColumnHack, values);
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        if(!mDB.isOpen()) open();
        return mDB.update(table, values, whereClause, whereArgs);
    }

    public int delete(String table, String whereClause, String[] whereArgs) {
        if(!mDB.isOpen()) open();
        return mDB.delete(table, whereClause, whereArgs);
    }
}
