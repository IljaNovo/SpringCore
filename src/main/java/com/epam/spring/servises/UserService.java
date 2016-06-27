package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.DataBase;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;

public class UserService {
	
	public void register(String name, String email) {
		DataBase.setUser(name, email);
	}
	
	public void remove(int index) {
		DataBase.deleteUser(index);
	}
	
	public User getById(int index) {
		return DataBase.getUsersBase().get(index);
	}
	
	public User getUserByEmail(String email) {
		for (Integer key: DataBase.getUsersBase().keySet()) {
			if (DataBase.getUsersBase().get(key).getEmail().equals(email)) {
				return DataBase.getUsersBase().get(key);
			}
		}
		return null;
	}
	
	public List<User> getUsersByName(String name) {
		List<User> usersNames = new ArrayList<User>();
		for (Integer key: DataBase.getUsersBase().keySet()) {
			if (DataBase.getUsersBase().get(key).getEmail().equals(name)) {
				usersNames.add(DataBase.getUsersBase().get(key));
			}
		}
		return usersNames;
	}
	
	public List<Event> getBookedTickets() {
		List<Event> bookedTickets = new ArrayList<Event>();
		for (Integer key: DataBase.getUsersBase().keySet()) {
			bookedTickets.addAll(DataBase.getUsersBase().get(key).getTickets());
		}
		return bookedTickets;
	}
}
