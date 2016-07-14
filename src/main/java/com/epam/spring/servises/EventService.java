package com.epam.spring.servises;

import java.util.Calendar;
import java.util.List;

import com.epam.spring.dao.interfaces.EventDao;
import com.epam.spring.dao.interfaces.SessionDao;
import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Rating;
import com.epam.spring.data.Session;

public class EventService {

	private EventDao eventDataBase;
	private SessionDao sessionDataBase;

	public EventService(EventDao eventDataBase, SessionDao sessionDataBase) {
		this.eventDataBase = eventDataBase;
		this.sessionDataBase = sessionDataBase;
	}

	public void create(String name, double price, Rating rating) {
		this.eventDataBase.setEvent(new Event(name, price, rating));
	}

	public void remove(int index) {
		this.eventDataBase.deleteEvent(index);
	}

	public List<Session> getForDateRange(Calendar from, Calendar to) {
		return sessionDataBase.getForDateRange(from, to);
	}

	public List<Session> getNextEvents(Calendar to) {
		return sessionDataBase.getNextEvents(to);
	}

	public void assignAuditorium(Event film, Auditorium room, Calendar date) {
		this.sessionDataBase.setSessions(film, room, date);
	}

	public Event getEventByName(String name) {
		return this.eventDataBase.getEventByName(name);
	}

	public double getEventPrice(String name) {
		return this.eventDataBase.getEventByName(name).getPrice();
	}
}
