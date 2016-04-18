package lesson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by steve on 12/4/15.
 */
public class MyCal {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);

        String endTime = sdf.format(calendar.getTime());

        System.out.println(endTime);

        calendar.add(Calendar.DAY_OF_MONTH, -1);

        String startTime = sdf.format(calendar.getTime());

        System.out.println(startTime + "   "  + endTime);

    }
}
