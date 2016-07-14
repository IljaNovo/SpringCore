package com.epam.spring.dao.interfaces;

import java.util.Map;

import com.epam.spring.data.Event;

public interface EventDao {
	void setEvent(Event film);

	void deleteEvent(int index);

	Map<Integer, Event> getAllEvents();

	Event getEventByName(String name);
}
