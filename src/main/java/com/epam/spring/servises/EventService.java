package com.epam.spring.servises;

import java.util.Date;

import com.epam.spring.dao.DataBase;
import com.epam.spring.utils.Rating;

public class EventService {
	public void create(String name, double price, Rating rating, Date date) {
		DataBase.setEvent(name, price, rating, date);
	}
	
	public void remove(int index) {
		DataBase.deleteEvent(index);
	}
	
	public String getByName() {
		return "";
	}
	
	public String getAll() {
		return "";
	}
	
	public String getForDateRange(String from, String to) {
		return "";
	}
	
	public String getNextEvents(String to) {
		return "";
	}
	
	public void assignAuditorium(String event, String auditorium, String date) {
		
	}
}
