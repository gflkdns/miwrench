package com.miqt.miwrenchlib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MTimeUtils {

    private static SimpleDateFormat format;

    static {
        format = new SimpleDateFormat();
    }

    public static String getYearMonthDay(long time) {
        format.applyPattern("yyyy/MM/dd");
        return format.format(time);
    }

    public static String getComTime(long time) {
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = new Date(time);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);
            if (diffDay == 0) {
                return "今天";
            } else if (diffDay == -1) {
                return "昨天";
            } else if (diffDay == -2) {
                return "前天";
            }
        }
        format.applyPattern("yyyy/MM/dd");
        return format.format(time);
    }

    public static String getMonthDay(long time) {
        format.applyPattern("MM-dd");
        return format.format(time);
    }

    public static Date StringToDate(String strTime, String formatType) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        Date date = null;
        date = format.parse(strTime);
        return date;
    }

}
