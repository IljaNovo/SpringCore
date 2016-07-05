package com.epam.spring.dao;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Session;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.Transaction;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.CustomerDate;
import com.epam.spring.utils.Rating;

public interface SpringCoreDAO {

	void setEvent(String name, double price, Rating rat);

	void deleteEvent(int index);

	Map<Integer, Event> getAllEvents();

	void setSessions(Event film, Auditorium room, CustomerDate date);

	void deleteSessions(int index);

	Map<Integer, Session> getSessions();

	void setTicket(double ticketPrice, String seat, Session dataOfSession);

	void deleteTicket(int index);

	Map<Integer, Ticket> getAllTickets();

	void setTrancaction(User customer, Ticket order);

	void deleteTransaction(int index);

	Map<Integer, Transaction> getAllTransactions();

	Map<Integer, User> getAllUsers();

	void deleteUser(int index);

	void setUser(String name, String email, CustomerDate birthdate);
	
	int getCountTicketsOf(User customer);
	
	User getUserById(int index);
	
	User getUserByEmail(String email);
	
	List<User> getUserByName(String name);
	
	List<Ticket> getBookedTickets();
	
	List<Double> getTicketPrice(Event film, CustomerDate day, List<String> seats, User customer);
	
	List<Ticket> getTicketsForEvent(Event film, CustomerDate date);
}
