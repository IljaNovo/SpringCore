package com.epam.spring.movie.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MovieDate {
	private Calendar timeStartMovie;
	
	public MovieDate(Calendar timeStartMovie) {
		this.timeStartMovie = timeStartMovie;
	}
	
	public MovieDate(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
		this.timeStartMovie = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
	}
	
	public String getTimeStartMovie() {
		DateFormat df = new SimpleDateFormat("HH mm ss");
		return df.format(timeStartMovie.getTime());
	}

	public String getDayStartMovie() {
		DateFormat df = new SimpleDateFormat("dd MM yyyy");
		return df.format(timeStartMovie.getTime());
	}
}
