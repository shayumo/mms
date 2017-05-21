package com.hiext.mms.core.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 获取当前系统时间
 */
public class GetDateTime {
	public static String getStrDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Date getNowDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(time, pos);
		return strtodate;
	}
	

    public static String getDate(Date date) {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return formatter.format(date);
    }
    
    public static String getStrYMDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		String time = format.format(date);
		return time;
	}
    
    public static String getStrYMDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        return formatter.format(date);
     }


}
