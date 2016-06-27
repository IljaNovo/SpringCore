package com.epam.spring.dao;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.users.User;

public class DataBase {
	private static Map<Integer, User> events = new HashMap<Integer, User>();
	private static DataBase base;
	private static int count = 0;
	
	private DataBase() {}
	
	public static DataBase instanse() {
		if (base == null) {
			base = new DataBase();
		}
		return base;
	}
	
	public static void set(String name, String email) {
		events.put(count, new User(count, name, email));
		++count;
	}
	
	public static void delete(int index) {
		events.remove(index);
		--count;
	}
	
	public static Map<Integer, User> getBase() {
		return events;
	}
}
