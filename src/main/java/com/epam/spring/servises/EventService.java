package com.epam.spring.servises;


import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.EventsDataBase;
import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.movie.date.MovieDate;
import com.epam.spring.utils.Rating;

public class EventService {
	public void create(String name, double price, Rating rating, MovieDate date) {
		EventsDataBase.set(name, price, rating, date);
	}
	
	public void remove(int index) {
		EventsDataBase.delete(index);
	}
	
	public Event getByName(String name) {
		for (Integer key: EventsDataBase.getEventsBase().keySet()) {
			if (EventsDataBase.getEventsBase().get(key).getName().equals(name)) {
				return EventsDataBase.getEventsBase().get(key);
			}
		}
		return null;
	}
	
	public List<Event> getAll() {
		List<Event> events = new ArrayList<Event>(); 
		for (Integer key: EventsDataBase.getEventsBase().keySet()) {
			events.add(EventsDataBase.getEventsBase().get(key));
		}
		return events;
	}
	
	public String getForDateRange(String from, String to) {
		return "";
	}
	
	public String getNextEvents(String to) {
		return "";
	}
	
	public void assignAuditorium(Event event, Auditorium auditorium, MovieDate date) {
		
	}
}
