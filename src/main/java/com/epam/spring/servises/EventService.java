package com.epam.spring.servises;


import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.movie.date.CustomerDate;
import com.epam.spring.utils.Rating;

public class EventService {
	public void create(String name, double price, Rating rating, CustomerDate date) {
		MapDataBase.instanse().setEvent(name, price, rating, date);
	}
	
	public void remove(int index) {
		MapDataBase.instanse().deleteEvent(index);
	}
	
	public Event getByName(String name) {
		for (Integer key: MapDataBase.instanse().getAllEvents().keySet()) {
			if (MapDataBase.instanse().getAllEvents().get(key).getName().equals(name)) {
				return MapDataBase.instanse().getAllEvents().get(key);
			}
		}
		return null;
	}
	
	public List<Event> getAll() {
		List<Event> events = new ArrayList<Event>(); 
		for (Integer key: MapDataBase.instanse().getAllEvents().keySet()) {
			events.add(MapDataBase.instanse().getAllEvents().get(key));
		}
		return events;
	}
	
	public String getForDateRange(String from, String to) {
		return "";
	}
	
	public String getNextEvents(String to) {
		return "";
	}
	
	public void assignAuditorium(Event event, Auditorium auditorium, CustomerDate date) {
		
	}
}
