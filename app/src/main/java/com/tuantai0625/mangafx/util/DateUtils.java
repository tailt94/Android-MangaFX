package com.tuantai0625.mangafx.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Lionheart on 29-May-17.
 */

public class DateUtils {
    public static String getDate(long epochTime) {
        Date date = new Date(epochTime * 1000L);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return format.format(date);
    }
}
