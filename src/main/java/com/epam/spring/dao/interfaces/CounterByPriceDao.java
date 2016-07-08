package com.epam.spring.dao.interfaces;

import com.epam.spring.data.Event;

public interface CounterByPriceDao {

	int getCount(Event film);

	void increase(Event film);

	void reset(Event film);

	void addEvent(Event film);
}
