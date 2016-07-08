package com.epam.spring.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.data.Rating;
import com.epam.spring.data.Session;
import com.epam.spring.date.CustomerDate;

public interface EventDao {
	void setEvent(String name, double price, Rating rat);

	void deleteEvent(int index);

	Map<Integer, Event> getAllEvents();
	
	Event getEventByName(String name);
}
