package pumpkin.kr.hanbat.common;

import android.util.Log;

/**
 * Created by farid on 2016-04-26.
 */
public class Utils {
    public static void Log(String msg) {
        if(Constants.LOG_VIEW) {
            Log.d("Pumpkin", msg);
        }
    }
}
