package com.epam.spring.dao;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.movie.date.MovieDate;
import com.epam.spring.utils.Rating;

public class EventsDataBase {
	private static Map<Integer, Event> events = new HashMap<Integer, Event>();
	private static EventsDataBase base;
	private static int countEvents = 0;
	
	private EventsDataBase() {}
	
	public static EventsDataBase instanse() {
		if (base == null) {
			base = new EventsDataBase();
		}
		return base;
	}
	
	public static void set(String name, double price, Rating rating, MovieDate date) {
		events.put(countEvents, new Event(countEvents, name, price, rating, date));
		++countEvents;
	}
	
	public static void delete(int index) {
		events.remove(index);
		--countEvents;
	}
	
	public static Map<Integer, Event> getEventsBase() {
		return events;
	}
}
