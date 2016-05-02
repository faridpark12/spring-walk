package pumpkin.kr.hanbat.calendar;

import java.util.Calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pumpkin.kr.hanbat.R;
import pumpkin.kr.hanbat.common.Utils;

/**
 * View to display a day
 * @author Brownsoo
 *
 */
public class OneDayView extends RelativeLayout {
    private static final String NAME = "OneDayView";
    
    /** number text field */
    private TextView dayTv;

    /** message text field*/
    private TextView msgTv;

    /** Value object for a day info */
    private OneDayData one;

    private LinearLayout eventDotLayout;

    /**
     * OneDayView constructor
     * @param context
     */
    public OneDayView(Context context) {
        super(context);
        init(context);
 
    }

    /**
     * OneDayView constructor for xml
     * @param context
     * @param attrs
     */
    public OneDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
 
    private void init(Context context) {
        View v = View.inflate(context, R.layout.oneday, this);
        
        dayTv = (TextView) v.findViewById(R.id.onday_dayTv);
        msgTv = (TextView) v.findViewById(R.id.onday_msgTv);
        eventDotLayout = (LinearLayout) v.findViewById(R.id.onday_eventDots);
        one = new OneDayData();
    }
    
    /**
     * Set a day
     * @param year 4 digits of a year
     * @param month Calendar.JANUARY ~ Calendar.DECEMBER
     * @param day day of month
     */
    public void setDay(int year, int month, int day) {
        this.one.cal.set(year, month, day);
    }

    /**
     * Set a day
     * @param cal Calendar instance
     */
    public void setDay(Calendar cal) {
        this.one.setDay((Calendar) cal.clone());
    }

    /**
     * Set a day
     * @param one OneDayData instance
     */
    public void setDay(OneDayData one) {
        this.one = one;
    }
    
    /**
     * Get a day info
     * @return OneDayData instance
     */
    public OneDayData getDay() {
        return one;
    }

    /**
     * Set the message to display
     * @param msg message
     */
    public void setMsg(String msg){
        one.setMessage(msg);
    }

    /**
     * Get the message is displaying
     * @return message
     */
    public CharSequence getMsg(){
        return  one.getMessage();
    }

    /**
     * Returns the value of the given field after computing the field values by
     * calling {@code complete()} first.
     * 
     * @param field Calendar.YEAR or Calendar.MONTH or Calendar.DAY_OF_MONTH
     *
     * @throws IllegalArgumentException
     *                if the fields are not set, the time is not set, and the
     *                time cannot be computed from the current field values.
     * @throws ArrayIndexOutOfBoundsException
     *                if the field is not inside the range of possible fields.
     *                The range is starting at 0 up to {@code FIELD_COUNT}.
     */
    public int get(int field) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return one.get(field);
    }

    /**
     * Updates UI upon the value object.
     */
    public void refresh() {
        Utils.Log("refresh -- ");
        
        dayTv.setText(String.valueOf(one.get(Calendar.DAY_OF_MONTH)));
        msgTv.setText((one.getMessage()==null)?"":one.getMessage());
    }
}