package com.epam.spring.dao.database;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.dao.interfaces.CounterByEventNameDao;
import com.epam.spring.data.Event;

public class MapCounterByEventNameDao implements CounterByEventNameDao {
	private Map<Event, Integer> countAccessions;

	public MapCounterByEventNameDao() {
		this.countAccessions = new HashMap<Event, Integer>();
	}

	public int getCount(Event film) {
		return this.countAccessions.get(film);
	}

	public void increase(Event film) {
		this.countAccessions.put(film, this.countAccessions.get(film) + 1);
	}

	public void reset(Event film) {
		this.countAccessions.put(film, 0);
	}

	public void addEvent(Event film) {
		if (this.countAccessions.get(film) == null) {
			this.countAccessions.put(film, 0);
		}
	}
}
