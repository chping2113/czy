package com.kjlink.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateTypeConvert extends StrutsTypeConverter {
	private static final String format = "yyyy-MM-dd";
	private static final String formatData = "yyyy-MM-dd hh:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(format);
	
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if(arg1 != null && arg1.length > 0 
				&& arg1[0] != null && arg1[0].trim().length() > 0) {
			Date d = null;
			try {
				d = sdf.parse(arg1[0].trim());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return d;
		}
		return null;
	}

	public String convertToString(Map arg0, Object arg1) {
		if(arg1 != null && (arg1 instanceof Date)) {
			return sdf.format((Date)arg1);
		}
		return "";
	}
	
	public static String dateToYear(Date date){
		String f = "yyyy";
		SimpleDateFormat sdformat = new SimpleDateFormat(f);
		return sdformat.format(date);
	}
	
	public static String dateToTime(Date date){
		String f = "MMddhhmmss";
		SimpleDateFormat sdformat = new SimpleDateFormat(f);
		return sdformat.format(date);
	}
	
	public static String dateToTime2(Date date){
		String f = "ddhhmmssSSS";
		SimpleDateFormat sdformat = new SimpleDateFormat(f);
		return sdformat.format(date);
	}
	
	public static Date stringToDate(String str) throws ParseException{
		String f = "yyyy-MM-dd" ;
		SimpleDateFormat sdformat = new SimpleDateFormat(f);
		return sdformat.parse(str);
	}
	public static String dateToTime3(Date date){
		String f = "yyyy-MM-dd";
		SimpleDateFormat sdformat = new SimpleDateFormat(f);
		return sdformat.format(date);
	}
	
	public static void main(String[] args) throws ParseException{
		String date = "2011-1-1";
		Date datee = stringToDate(date);
		System.out.println(datee.toString());
		String str=dateToTime3(new Date());
		System.out.println(str);
		Date dateStr=stringToDate(str);
		System.out.println(dateStr.toString());
		
	}
}
