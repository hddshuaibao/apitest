package com.weixt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static String getCurrentDate(){

        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        return ft.format(date);
    }
}
