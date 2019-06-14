package com.candoo.carebobo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
    public static String currentDate() {
        return dateToString(null);
    }

    public static String currentDatetime() {
        return datetimeToString(null);
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    public static String datetimeToString(Date date) {
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date == null ? getCurrentDate() : date);
    }

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, "yyyy-MM-dd");
    }

    public static Date stringToDatetime(String dateString) {
        return stringToDate(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date stringToDate(String dateString, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCurrentDate();
    }

    public static String datePreDay(String dateString){
        Date date = stringToDate(dateString);
        return dateToString(new Date(date.getTime() - (long)24 * 60 * 60 * 1000));
    }

    public static String dateNextDay(String dateString){
        Date date = stringToDate(dateString);
        return dateToString(new Date(date.getTime() + (long)24 * 60 * 60 * 1000));
    }

    public static String dayOfWeek() {
        int week = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        switch (week) {
            case 1: return "周日";
            case 2: return "周一";
            case 3: return "周二";
            case 4: return "周三";
            case 5: return "周四";
            case 6: return "周五";
            case 7: return "周六";
            default: break;
        }
        return "";
    }

    public static String currentDatetimeWeek() {
        return currentDatetime() + " " + dayOfWeek();
    }
}
