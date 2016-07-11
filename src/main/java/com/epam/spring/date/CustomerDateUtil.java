package com.epam.spring.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class CustomerDateUtil {
	private CustomerDateUtil() {}
	
	public static String getFullDate(Calendar time) {
		DateFormat df = new SimpleDateFormat("yyyy MM dd");
		return df.format(time.getTime());
	}

	public static String getYear(Calendar time) {
		DateFormat df = new SimpleDateFormat("yyyy");
		return df.format(time.getTime());
	}

	public static String getMonth(Calendar time) {
		DateFormat df = new SimpleDateFormat("MM");
		return df.format(time.getTime());
	}

	public static String getDay(Calendar time) {
		DateFormat df = new SimpleDateFormat("dd");
		return df.format(time.getTime());
	}

	public static String getHours(Calendar time) {
		DateFormat df = new SimpleDateFormat("HH");
		return df.format(time.getTime());
	}

	public static String getMinutes(Calendar time) {
		DateFormat df = new SimpleDateFormat("mm");
		return df.format(time.getTime());
	}

	public static String getSecond(Calendar time) {
		DateFormat df = new SimpleDateFormat("ss");
		return df.format(time.getTime());
	}

	public static long getTimeInMillis(Calendar time) {
		return time.getTimeInMillis();
	}
}
