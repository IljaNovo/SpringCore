package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.TicketsDataBase;
import com.epam.spring.dao.UsersDataBase;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;

public class UserService {
	
	public void register(String name, String email) {
		UsersDataBase.set(name, email);
	}
	
	public void remove(int index) {
		UsersDataBase.delete(index);
	}
	
	public User getById(int index) {
		return UsersDataBase.getUsersBase().get(index);
	}
	
	public User getUserByEmail(String email) {
		for (Integer key: UsersDataBase.getUsersBase().keySet()) {
			if (UsersDataBase.getUsersBase().get(key).getEmail().equals(email)) {
				return UsersDataBase.getUsersBase().get(key);
			}
		}
		return null;
	}
	
	public List<User> getUsersByName(String name) {
		List<User> usersNames = new ArrayList<User>();
		for (Integer key: UsersDataBase.getUsersBase().keySet()) {
			if (UsersDataBase.getUsersBase().get(key).getEmail().equals(name)) {
				usersNames.add(UsersDataBase.getUsersBase().get(key));
			}
		}
		return usersNames;
	}
	
	public List<Ticket> getBookedTickets() {
		List<Ticket> bookedTickets = new ArrayList<Ticket>();
		for (Integer key: TicketsDataBase.getTicketsBase().keySet()) {
			bookedTickets.add(TicketsDataBase.getTicketsBase().get(key));
		}
		return bookedTickets;
	}
}
