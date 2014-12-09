package com.sci.app.toolkit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToolkit {

	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static String getToday(){
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}
	
	public static void main(String[] args){
		System.out.println(getToday());
	}
	
	public static boolean verify(String date){
		boolean passed = true;
		try{
			String str = format.format(format.parse(date));
			if(!str.equals(date)){
				return false;
			}
		}catch(Exception e){
			return false;
		}
		return passed;
	}
}
