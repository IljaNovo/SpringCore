package com.epam.spring.dao;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.data.User;

public class UsersDataBase {
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static int countUsers = 0;
	private static UsersDataBase base;
	
	private UsersDataBase() {}
	
	public static UsersDataBase instanse() {
		if (base == null) {
			base = new UsersDataBase();
		}
		return base;
	}
	
	public static Map<Integer, User> getUsersBase() {
		return users;
	}
	
	public static void delete(int index) {
		users.remove(index);
		--countUsers;
	}
	
	public static void set(String name, String email) {
		users.put(countUsers, new User(countUsers, name, email));
		++countUsers;
	}
}
