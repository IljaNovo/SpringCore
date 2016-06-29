package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;

public class UserService {
	
	public void register(String name, String email, MovieDate birthdate) {
		MapDataBase.instanse().setUser(name, email, birthdate);
	}
	
	public void remove(int index) {
		MapDataBase.instanse().deleteUser(index);
	}
	
	public User getById(int index) {
		return MapDataBase.instanse().getAllUsers().get(index);
	}
	
	public User getUserByEmail(String email) {
		for (Integer key: MapDataBase.instanse().getAllUsers().keySet()) {
			if (MapDataBase.instanse().getAllUsers().get(key).getEmail().equals(email)) {
				return MapDataBase.instanse().getAllUsers().get(key);
			}
		}
		return null;
	}
	
	public List<User> getUsersByName(String name) {
		List<User> usersNames = new ArrayList<User>();
		for (Integer key: MapDataBase.instanse().getAllUsers().keySet()) {
			if (MapDataBase.instanse().getAllUsers().get(key).getEmail().equals(name)) {
				usersNames.add(MapDataBase.instanse().getAllUsers().get(key));
			}
		}
		return usersNames;
	}
	
	public List<Ticket> getBookedTickets() {
		List<Ticket> bookedTickets = new ArrayList<Ticket>();
		for (Integer key: MapDataBase.instanse().getAllTickets().keySet()) {
			bookedTickets.add(MapDataBase.instanse().getAllTickets().get(key));
		}
		return bookedTickets;
	}
}
