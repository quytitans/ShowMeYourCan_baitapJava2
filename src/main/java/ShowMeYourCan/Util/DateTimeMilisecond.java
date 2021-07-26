package ShowMeYourCan.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeMilisecond {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/mm/yyyy");

    public static long convertToMillisec(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("DD/mm/yyyy");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long millis = ((Date) date).getTime();
        return  millis;
    }
}
