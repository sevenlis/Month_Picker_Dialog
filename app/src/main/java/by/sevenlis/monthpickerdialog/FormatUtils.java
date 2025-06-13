package by.sevenlis.monthpickerdialog;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormatUtils {
    public static String fDate(Calendar cal, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return simpleDateFormat.format(cal.getTime());
    }

    public static String fMonth(Context mContext, Calendar calMonthDate) {
        String[] months = mContext.getResources().getStringArray(R.array.months_short);
        String pattern = FormatUtils.capitalize(months[calMonthDate.get(Calendar.MONTH)]) + " yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(calMonthDate.getTime());
    }

    public static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
