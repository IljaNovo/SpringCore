package com.epam.spring.dao.interfaces;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Session;

public interface SessionDao {
	void setSessions(Event film, Auditorium room, Calendar date);

	void deleteSessions(int index);

	Map<Integer, Session> getSessions();

	List<Session> getForDateRange(Calendar from, Calendar to);

	List<Session> getNextEvents(Calendar to);
}
