package com.epam.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;

public class TicketsOfUserDataBase {
	private static Map<User, List<Ticket>> usersTickets = new HashMap<User, List<Ticket>>();
	private static TicketsOfUserDataBase base;
	private static int countTicketsOfUser = 0;

	private TicketsOfUserDataBase() {}

	public static TicketsOfUserDataBase instanse() {
		if (base == null) {
			base = new TicketsOfUserDataBase();
		}
		return base;
	}

	public static void set(User user, Ticket ticket) {
		List<Ticket> tickets = usersTickets.get(user);
		
		if (tickets == null) {
			usersTickets.put(user, (new ArrayList<Ticket>()));
		}
		usersTickets.get(user).add(ticket);
		++countTicketsOfUser;
	}

	public static void deleteTicket(User user, int index) {
		for(int i = 0; i < usersTickets.get(user).size(); ++i) {
			if (usersTickets.get(user).get(i).getId() == index) {
				usersTickets.get(user).remove(i);
				return;
			}
		}
	}
	
	public static void deleteAllTicketsOfUser(User user) {
		usersTickets.remove(user);
		--countTicketsOfUser;
	}

	public static Map<User, List<Ticket>> getBase() {
		return usersTickets;
	}
}
