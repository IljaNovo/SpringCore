package com.epam.spring.movie.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CustomerDate {
	private Calendar time;
	
	public CustomerDate() {
		this.time = new GregorianCalendar();
	}

	public CustomerDate(int year, int month, int dayOfMonth) {
		this.time = new GregorianCalendar(year, month, dayOfMonth);
	}
	
	public CustomerDate(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
		this.time = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
	}
	
	public String getFullDate() {
		DateFormat df = new SimpleDateFormat("yyyy MM dd");
		return df.format(time.getTime());
	}
	
	public String getYear() {
		DateFormat df = new SimpleDateFormat("yyyy");
		return df.format(time.getTime());
	}

	public String getMonth() {
		DateFormat df = new SimpleDateFormat("MM");
		return df.format(time.getTime());
	}

	public String getDay() {
		DateFormat df = new SimpleDateFormat("dd");
		return df.format(time.getTime());
	}

	public String getHours() {
		DateFormat df = new SimpleDateFormat("HH");
		return df.format(time.getTime());
	}

	public String getMinutes() {
		DateFormat df = new SimpleDateFormat("mm");
		return df.format(time.getTime());
	}

	public String getSecond() {
		DateFormat df = new SimpleDateFormat("ss");
		return df.format(time.getTime());
	}
	
	public long getTimeInMillis() {
		return this.time.getTimeInMillis();
	}
}
