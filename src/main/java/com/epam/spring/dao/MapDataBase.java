package com.epam.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;
import com.epam.spring.utils.Rating;

public class MapDataBase implements SpringCoreDAO{
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static int countUsers = 0;
	private static Map<Integer, Event> events = new HashMap<Integer, Event>();
	private static int countEvents = 0;
	private static Map<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
	private static int countTickets = 0;
	private static Map<User, List<Ticket>> usersTickets = new HashMap<User, List<Ticket>>();
	private static int countTicketsOfUser = 0;
	private static Map<Auditorium, Event> sessions = new HashMap<Auditorium, Event>();
	private static int countSessions = 0;
	private static MapDataBase base;
	private static Map<Event, MovieDate> sessionsDate = new HashMap<Event, MovieDate>();
	
	private MapDataBase() {}
	
	public static MapDataBase instanse() {
		if (base == null) {
			base = new MapDataBase();
		}
		return base;
	}
	
	@Override
	public void setEvent(String name, double price, Rating rating, MovieDate date) {
		events.put(countEvents, new Event(countEvents, name, price, rating, date));
		++countEvents;
	}

	@Override
	public void deleteEvent(int index) {
		events.remove(index);
		--countEvents;
	}

	@Override
	public Map<Integer, Event> getAllEvents() {
		return events;
	}

	@Override
	public void setSessions(Event event, Auditorium auditorium, MovieDate date) {
		sessions.put(auditorium, event);
		sessionsDate.put(event, date);
		++countSessions;
	}

	@Override
	public void deleteSessions(int index) {
		sessions.remove(index);
		--countSessions;
	}

	@Override
	public Map<Event, MovieDate> getSessionDates() {
		return sessionsDate;
	}

	@Override
	public Map<Auditorium, Event> getSessions() {
		return sessions;
	}

	@Override
	public void setTicket(Event event, double ticketPrice, String seat, MovieDate date) {
		tickets.put(countTickets, new Ticket(countTickets, event, ticketPrice, seat, date));
		++countTickets;
	}

	@Override
	public void deleteTicket(int index) {
		tickets.remove(index);
		--countTickets;
	}

	@Override
	public Map<Integer, Ticket> getAllTickets() {
		return tickets;
	}

	@Override
	public void setTicketOfUser(User user, Ticket ticket) {
		List<Ticket> tickets = usersTickets.get(user);
		
		if (tickets == null) {
			usersTickets.put(user, (new ArrayList<Ticket>()));
		}
		usersTickets.get(user).add(ticket);
		++countTicketsOfUser;	}

	@Override
	public void deleteTicketOfUser(User user, int index) {
		for(int i = 0; i < usersTickets.get(user).size(); ++i) {
			if (usersTickets.get(user).get(i).getId() == index) {
				usersTickets.get(user).remove(i);
				return;
			}
		}
	}

	@Override
	public void deleteAllTicketsOfUser(User user) {
		usersTickets.remove(user);
		--countTicketsOfUser;
	}

	@Override
	public Map<User, List<Ticket>> getAllTiketsOfUsers() {
		return usersTickets;
	}

	@Override
	public Map<Integer, User> getAllUsers() {
		return users;
	}

	@Override
	public void deleteUser(int index) {
		users.remove(index);
		--countUsers;
	}

	@Override
	public void setUser(String name, String email, MovieDate birthdate) {
		users.put(countUsers, new User(countUsers, name, email, birthdate));
		++countUsers;
	}
}
