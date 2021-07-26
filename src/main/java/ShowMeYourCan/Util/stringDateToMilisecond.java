package ShowMeYourCan.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class stringDateToMilisecond {
    public static long convertStringToMili (String str){
        //creates a formatter that parses the date in the given format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timeInMillis = date.getTime();
        return timeInMillis;
    }
}
