package biz.libra.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by steve on 11/25/15.
 */
public class WorkWithDate {

    public static Date[][] getTimeIntervals(Date[] date){
        Date[][] intervals = new Date[2][2];

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date[1]);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        intervals[0][0] = date[0];
        intervals[0][1] = calendar.getTime();

        calendar = new GregorianCalendar();
        calendar.setTime(date[1]);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        intervals[1][0] = calendar.getTime();
        intervals[1][1] = date[1];

        return intervals;
    }

}
