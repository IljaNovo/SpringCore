package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.spring.dao.DataBase;
import com.epam.spring.users.User;
import com.epam.spring.users.Event;

public class UserService {
	
	public void register(String name, String email) {
		DataBase.set(name, email);
	}
	
	public void remove(int index) {
		DataBase.delete(index);
	}
	
	public User getById(int index) {
		return DataBase.getBase().get(index);
	}
	
	public User getUserByEmail(String email) {
		for (Integer key: DataBase.getBase().keySet()) {
			if (DataBase.getBase().get(key).getEmail().equals(email)) {
				return DataBase.getBase().get(key);
			}
		}
		return null;
	}
	
	public List<User> getUsersByName(String name) {
		List<User> usersNames = new ArrayList<User>();
		for (Integer key: DataBase.getBase().keySet()) {
			if (DataBase.getBase().get(key).getEmail().equals(name)) {
				usersNames.add(DataBase.getBase().get(key));
			}
		}
		return usersNames;
	}
	
	public String getBookedTickets() {
		return "";
	}
}
