package com.epam.spring.dao.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.dao.interfaces.EventDao;
import com.epam.spring.data.DataType;
import com.epam.spring.data.Event;
import com.epam.spring.data.Rating;
import com.epam.spring.data.Session;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.Transaction;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;
import com.epam.spring.utils.SimpleCounter;
import com.epam.spring.utils.SimpleIdGenerator;

public class MapEventDao implements EventDao {
	private Map<Integer, Event> events;

	public MapEventDao() {
		this.events = new HashMap<Integer, Event>();
		
		this.initCounter();
		this.initIdGenerater();
	}

	private void initIdGenerater() {
		SimpleIdGenerator.instanse().addDataType(DataType.EVENT);
	}

	private void initCounter() {
		SimpleCounter.instanse().addDataType(DataType.EVENT);
	}

	public void setEvent(String name, double price, Rating rat) {
		events.put(SimpleIdGenerator.instanse().generate(DataType.EVENT), new Event(name, price, rat));
		SimpleCounter.instanse().increase(DataType.EVENT);
	}

	public void deleteEvent(int index) {
		events.remove(index);
		SimpleCounter.instanse().reduce(DataType.EVENT);
	}

	public Map<Integer, Event> getAllEvents() {
		return events;
	}

	public Event getEventByName(String name) {
		for (Event item : this.events.values()) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
}
