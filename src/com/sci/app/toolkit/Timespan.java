package com.sci.app.toolkit;

import java.util.Calendar;
import java.util.Vector;

public class Timespan {

	
	private static Vector timespan = new Vector();
	
	private static Vector createTimespan(){
		Vector<Integer> v = new Vector<Integer>();
		int y = Calendar.getInstance().get(Calendar.YEAR);
		for(int i=1900;i<=y;i++){
			v.add(i);
		}
		return v;
	}
	
	public static Vector getTimespan(){
		if(timespan == null || timespan.isEmpty()){
			timespan = createTimespan();
		}
		return timespan;
	}
	
}
