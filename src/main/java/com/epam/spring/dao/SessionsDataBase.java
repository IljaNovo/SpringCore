package com.epam.spring.dao;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;

public class SessionsDataBase {
	private static Map<Auditorium, Event> sessions = new HashMap<Auditorium, Event>();
	private static Map<Event, MovieDate> sessionsDate = new HashMap<Event, MovieDate>();
	private static SessionsDataBase base;
	private static int countSessions = 0;
	
	private SessionsDataBase() {}
	
	public static SessionsDataBase instanse() {
		if (base == null) {
			base = new SessionsDataBase();
		}
		return base;
	}
	
	public static void set(Event event, Auditorium auditorium, MovieDate date) {
		sessions.put(auditorium, event);
		sessionsDate.put(event, date);
		++countSessions;
	}
	
	public static void delete(int index) {
		sessions.remove(index);
		--countSessions;
	}
	
	public static Map<Event, MovieDate> getSessionDates() {
		return sessionsDate;
	}
	
	public static Map<Auditorium, Event> getSessions() {
		return sessions;
	}
}
