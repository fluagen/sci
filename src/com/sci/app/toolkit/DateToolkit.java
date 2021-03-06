package com.sci.app.toolkit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToolkit {

	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
	//计算计划日期与当前日期相差的毫秒数
	public static long delay(String startTime){
		long delay = 1000;
		try {
			Date plan = format.parse(startTime);
			Date now = Calendar.getInstance().getTime();
			long subtracter = plan.getTime() - now.getTime();
			delay = subtracter;
			if(subtracter < 0){
				delay = 1000;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return delay;
	}
}
