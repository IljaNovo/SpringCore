package com.epam.spring.servises;

import java.util.List;

import com.epam.spring.dao.interfaces.TicketDao;
import com.epam.spring.dao.interfaces.UserDao;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class UserService {
	private UserDao userDataBase;
	private TicketDao ticketDataBase;
	
	public UserService(UserDao userDataBase, TicketDao ticketDataBase) {
		this.userDataBase = userDataBase;
		this.ticketDataBase = ticketDataBase;
	}

	public void register(String name, String email, CustomerDate birthdate) {
		userDataBase.setUser(name, email, birthdate);
	}
	
	public void remove(int index) {
		userDataBase.deleteUser(index);
	}
	
	public User getById(int index) {
		return userDataBase.getUserById(index);
	}
	
	public User getUserByEmail(String email) {
		return userDataBase.getUserByEmail(email);
	}
	
	public List<User> getUsersByName(String name) {
		return userDataBase.getUserByName(name);
	}
	
	public List<Ticket> getBookedTickets() {
		return ticketDataBase.getBookedTickets();
	}
}
