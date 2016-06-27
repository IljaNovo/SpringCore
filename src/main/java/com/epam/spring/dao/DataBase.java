package com.epam.spring.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.utils.Rating;

public class DataBase {
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static Map<Integer, Event> events = new HashMap<Integer, Event>();
	private static DataBase base;
	private static int countUsers = 0;
	private static int countEvents = 0;
	
	private DataBase() {}
	
	public static DataBase instanse() {
		if (base == null) {
			base = new DataBase();
		}
		return base;
	}
	
	public static void setUser(String name, String email) {
		users.put(countUsers, new User(countUsers, name, email));
		++countUsers;
	}
	
	public static void deleteUser(int index) {
		users.remove(index);
		--countUsers;
	}
	
	public static void setEvent(String name, double price, Rating rating, Date date) {
		events.put(countEvents, new Event(name, price, rating, date));
		++countEvents;
	}
	
	public static void deleteEvent(int index) {
		events.remove(index);
		--countEvents;
	}
	
	public static Map<Integer, Event> getEventsBase() {
		return events;
	}
	
	public static Map<Integer, User> getUsersBase() {
		return users;
	}
}
