package com.epam.spring.dao;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;
import com.epam.spring.utils.Rating;

public interface SpringCoreDAO {
	void setEvent(String name, double price, Rating rating, MovieDate date);
	
	void deleteEvent(int index);
	
	Map<Integer, Event> getAllEvents();
	
	void setSessions(Event event, Auditorium auditorium, MovieDate date);
	
	void deleteSessions(int index);
	
	Map<Event, MovieDate> getSessionDates();
	
	Map<Auditorium, Event> getSessions();
	
	void setTicket(Event event, double ticketPrice, String seat, MovieDate date);
	
	void deleteTicket(int index);
	
	Map<Integer, Ticket> getAllTickets();
	
	void setTicketOfUser(User user, Ticket ticket);
	
	void deleteTicketOfUser(User user, int index);
	
	void deleteAllTicketsOfUser(User user);
	
	Map<User, List<Ticket>> getAllTiketsOfUsers();
	
	Map<Integer, User> getAllUsers();
	
	void deleteUser(int index);
	
	void setUser(String name, String email, MovieDate birthdate);
}
