package com.socialtour.adapters;

import java.util.Date;

public class DateFormatter {
	public DateFormatter() {
	}
	
	public static Date getDate(String dateString) {
		int year = Integer.parseInt(dateString.split("-")[0]);
		int month = Integer.parseInt(dateString.split("-")[1]);
		int day = Integer.parseInt(dateString.split("-")[2].split("T")[0]);
		
		int hour = Integer.parseInt(dateString.split("T")[1].split(":")[0]);
		int min = Integer.parseInt(dateString.split("T")[1].split(":")[1]);
		int sec = Integer.parseInt(dateString.split("T")[1].split(":")[2].split("Z")[0]);
		
		return new Date(year, month, day, hour, min, sec);
	}
	
	public static String getString(Date date) {
		String s = "";
		
		String month = (date.getMonth()+1)+"";
		if(month.length()==1)
			month = "0"+month;
		
		String day = (date.getDate()+1)+"";
		if(day.length()==1)
			day = "0"+day;
		
		String hou = (date.getHours()+1)+"";
		if(hou.length()==1)
			hou = "0"+hou;
		
		String min = (date.getMinutes()+1)+"";
		if(min.length()==1)
			min = "0"+min;
		
		s = s.concat((date.getYear()+1900)+"-");
		s = s.concat(month+"-");
		s = s.concat(day+"T");
		
		s = s.concat(hou+":");
		s = s.concat(min+":");
		s = s.concat("00Z");		
		
		return s;
	}
	
	
}
