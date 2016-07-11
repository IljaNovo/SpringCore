package com.epam.spring.dao.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.dao.interfaces.SessionDao;
import com.epam.spring.data.Auditorium;
import com.epam.spring.data.DataType;
import com.epam.spring.data.Event;
import com.epam.spring.data.Session;
import com.epam.spring.utils.SimpleCounter;
import com.epam.spring.utils.SimpleIdGenerator;

public class MapSessionDao implements SessionDao {
	private Map<Integer, Session> sessions;

	public MapSessionDao() {
		this.sessions = new HashMap<Integer, Session>();

		this.initCounter();
		this.initIdGenerater();
	}

	private void initIdGenerater() {
		SimpleIdGenerator.instanse().addDataType(DataType.SESSION);
	}

	private void initCounter() {
		SimpleCounter.instanse().addDataType(DataType.SESSION);
	}

	public List<Session> getForDateRange(Calendar from, Calendar to) {
		List<Session> films = new ArrayList<Session>();

		for (Integer key : this.sessions.keySet()) {
			if (this.sessions.get(key).getDate().getTimeInMillis() >= from.getTimeInMillis()
					&& this.sessions.get(key).getDate().getTimeInMillis() <= to.getTimeInMillis()) {
				films.add(this.sessions.get(key));
			}
		}
		return films;
	}

	public List<Session> getNextEvents(Calendar to) {
		List<Session> films = new ArrayList<Session>();

		Calendar date = new GregorianCalendar();

		for (Integer key : this.sessions.keySet()) {
			if (date.getTimeInMillis() <= to.getTimeInMillis()) {
				films.add(this.sessions.get(key));
			}
		}
		return films;
	}

	public void setSessions(Event film, Auditorium room, Calendar date) {
		sessions.put(SimpleIdGenerator.instanse().generate(DataType.SESSION), new Session(film, room, date));
		SimpleCounter.instanse().increase(DataType.SESSION);
	}

	public void deleteSessions(int index) {
		sessions.remove(index);
		SimpleCounter.instanse().reduce(DataType.SESSION);
	}

	public Map<Integer, Session> getSessions() {
		return sessions;
	}

}
