package com.epam.spring.dao.database;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.data.Event;

public class MapCounterByPriceDao{
	private Map<Event, Integer> countRequests;

	public MapCounterByPriceDao() {
		this.countRequests = new HashMap<Event, Integer>();
	}

	public int getCount(Event film) {
		return this.countRequests.get(film);
	}

	public void increase(Event film) {
		this.countRequests.put(film, this.countRequests.get(film) + 1);
	}

	public void reset(Event film) {
		this.countRequests.put(film, 0);
	}

	public void addEvent(Event film) {
		if (this.countRequests.get(film) == null) {
			this.countRequests.put(film, 0);
		}
	}
}
