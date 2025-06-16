package by.sevenlis.monthpickerdialog;

import android.content.Context;

import java.util.Calendar;

public class FormatUtils {
    public static String fMonth(Context mContext, Calendar calMonthDate, boolean mShort) {
        String[] months = mContext.getResources().getStringArray(mShort ? R.array.months_short : R.array.months);
        return capitalize(months[calMonthDate.get(Calendar.MONTH)]) + " " + calMonthDate.get(Calendar.YEAR);
    }

    public static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
