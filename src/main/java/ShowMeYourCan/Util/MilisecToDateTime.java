package ShowMeYourCan.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MilisecToDateTime {
    public static String convertToDateTime(long milliseconds) {
        DateFormat simpleDate = new SimpleDateFormat("DD/mm/yyyy");
        Date result = new Date(milliseconds);
        return simpleDate.format(result);
    }
}
