package pumpkin.kr.hanbat.calendar;

import java.util.Calendar;

/**
 * Value object for a day
 * @author brownsoo
 *
 */
public class OneDayData {
    Calendar cal;
    private CharSequence msg = "";
    
    /**
     * OneDayData
     */
    public OneDayData() {
        this.cal = Calendar.getInstance();
    }
    
    /**
     * Set info by given data
     * @param year 4 digits of a year
     * @param month month Calendar.JANUARY ~ Calendar.DECEMBER
     * @param day day of month (1~#)
     */
    public void setDay(int year, int month, int day) {
        cal = Calendar.getInstance();
        cal.set(year, month, day);
    }

    /**
     * Set info by cloning calendar
     * @param cal calendar to clone
     */
    public void setDay(Calendar cal) {
        this.cal = (Calendar) cal.clone();
    }

    /**
     * Get calendar
     * @return Calendar instance
     */
    public Calendar getDay() {
        return cal;
    }
    
    /**
     * Returns the value of the given field after computing the field values by
     * calling {@code complete()} first.
     *
     * @throws IllegalArgumentException
     *                if the fields are not set, the time is not set, and the
     *                time cannot be computed from the current field values.
     * @throws ArrayIndexOutOfBoundsException
     *                if the field is not inside the range of possible fields.
     *                The range is starting at 0 up to {@code FIELD_COUNT}.
     */
    public int get(int field) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return cal.get(field);
    }


    /**
     * Get message
     * @return message
     */
    public CharSequence getMessage() {
        return msg;
    }
    
    /**
     * Set message
     * @param msg message to display
     */
    public void setMessage(CharSequence msg) {
        this.msg = msg;
    }
}
