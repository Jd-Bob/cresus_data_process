package mg.orange.cresus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class DateTimeUtils {

    public static Date parsDate(Date today, String format) {
        Date parseDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            parseDate = simpleDateFormat.parse(simpleDateFormat.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parseDate;
    }
    
    public static Date jump(Date date, int periodicity, int step) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(periodicity, step);

        return calendar.getTime();
    }

    public static double diffTime(long start) {
        return (System.nanoTime() -  start) / 1e9;
    }
}
