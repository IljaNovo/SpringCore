package com.epam.spring.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Session;
import com.epam.spring.date.CustomerDate;

public interface SessionDao {
	void setSessions(Event film, Auditorium room, CustomerDate date);

	void deleteSessions(int index);

	Map<Integer, Session> getSessions();
	
	List<Session> getForDateRange(CustomerDate from, CustomerDate to);
	
	List<Session> getNextEvents(CustomerDate to);
}
