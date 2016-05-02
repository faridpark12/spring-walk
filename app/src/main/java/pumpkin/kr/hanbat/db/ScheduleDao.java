package pumpkin.kr.hanbat.db;

import android.content.Context;

/**
 * Created by farid on 2016-05-02.
 */
public class ScheduleDao extends HanbatBaseDao {
    public static String YEAR = "year";
    public static String MONTH = "month";
    public static String DAY = "day";
    public static String HOUR = "hour";
    public static String MINUTE = "minute";
    public static String EVENT = "event";
    public static String WRITE_TIME = "writetime";
    public static final String TABLE_NAME = "tb_hanbat_schedule";
    public static final String CREATE =
            "create table "+TABLE_NAME+"("
                    +YEAR+" integer, "
                    +MONTH+" integer, "
                    +DAY+" integer, "
                    +HOUR+" integer, "
                    +MINUTE+" integer, "
                    +EVENT+" text, "
                    +WRITE_TIME+" long);";

    public ScheduleDao(Context ctx) {
        super(ctx);
    }
}
