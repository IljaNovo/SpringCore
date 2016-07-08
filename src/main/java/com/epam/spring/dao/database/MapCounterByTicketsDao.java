package com.epam.spring.dao.database;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.dao.interfaces.CounterByTicketsDao;
import com.epam.spring.data.Event;

public class MapCounterByTicketsDao implements CounterByTicketsDao {
	private Map<Event, Integer> countTickets;

	public MapCounterByTicketsDao() {
		this.countTickets = new HashMap<Event, Integer>();
	}

	public int getCount(Event film) {
		if (this.countTickets.get(film) == null) {
			return 0;
		}
		return this.countTickets.get(film);
	}

	public void increase(Event film) {
		this.countTickets.put(film, this.countTickets.get(film) + 1);
	}

	public void reset(Event film) {
		this.countTickets.put(film, 0);
	}

	public void addEvent(Event film) {
		if (this.countTickets.get(film) == null) {
			this.countTickets.put(film, 0);
		}
	}
}
