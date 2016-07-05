package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.dao.SpringCoreDAO;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.CustomerDate;

public class UserService {
	private SpringCoreDAO dataBase;
	
	public UserService(SpringCoreDAO dataBase) {
		this.dataBase = dataBase;
	}

	public void register(String name, String email, CustomerDate birthdate) {
		dataBase.setUser(name, email, birthdate);
	}
	
	public void remove(int index) {
		dataBase.deleteUser(index);
	}
	
	public User getById(int index) {
		return dataBase.getUserById(index);
	}
	
	public User getUserByEmail(String email) {
		return dataBase.getUserByEmail(email);
	}
	
	public List<User> getUsersByName(String name) {
		return dataBase.getUserByName(name);
	}
	
	public List<Ticket> getBookedTickets() {
		return dataBase.getBookedTickets();
	}
}
