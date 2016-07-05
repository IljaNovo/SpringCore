package com.epam.spring.servises;


import java.util.List;

import com.epam.spring.dao.SpringCoreDAO;
import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Rating;
import com.epam.spring.data.Session;
import com.epam.spring.date.CustomerDate;

public class EventService {
	
	private SpringCoreDAO dataBase;
	
	public EventService(SpringCoreDAO dataBase) {
		this.dataBase = dataBase;
	}
	
	public void create(String name, double price, Rating rating) {
		this.dataBase.setEvent(name, price, rating);
	}
	
	public void remove(int index) {
		this.dataBase.deleteEvent(index);
	}
	
	public List<Session> getForDateRange(CustomerDate from, CustomerDate to) {
		return dataBase.getForDateRange(from, to);
	}
	
	public List<Session> getNextEvents(CustomerDate to) {
		return dataBase.getNextEvents(to);
	}
	
	public void assignAuditorium(Event film, Auditorium room, CustomerDate date) {
		this.dataBase.setSessions(film, room, date);
	}
}
