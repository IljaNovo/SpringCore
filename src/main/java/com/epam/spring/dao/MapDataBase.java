package com.epam.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Session;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.Transaction;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.CustomerDate;
import com.epam.spring.utils.DataType;
import com.epam.spring.utils.Rating;
import com.epam.spring.utils.SimpleCounter;
import com.epam.spring.utils.SimpleIdGenerator;

public class MapDataBase implements SpringCoreDAO {
	private Map<Integer, User> users;
	private Map<Integer, Event> events;
	private Map<Integer, Ticket> tickets;
	private Map<Integer, Transaction> transactions;
	private Map<Integer, Session> sessions;

	public MapDataBase(Map<Integer, User> users, 
					   Map<Integer, Event> events, 
					   Map<Integer, Ticket> tickets,
					   Map<Integer, Transaction> transactions, 
					   Map<Integer, Session> sessions) {
		this.users = users;
		this.events = events;
		this.tickets = tickets;
		this.transactions = transactions;
		this.sessions = sessions;

		this.initCounter();
		this.initIdGenerater();
	}

	private void initIdGenerater() {
		SimpleIdGenerator.instanse().addDataType(DataType.USER);
		SimpleIdGenerator.instanse().addDataType(DataType.EVENT);
		SimpleIdGenerator.instanse().addDataType(DataType.SESSION);
		SimpleIdGenerator.instanse().addDataType(DataType.TICKET);
		SimpleIdGenerator.instanse().addDataType(DataType.TRANSACTION);
	}

	private void initCounter() {
		SimpleCounter.instanse().addDataType(DataType.USER);
		SimpleCounter.instanse().addDataType(DataType.EVENT);
		SimpleCounter.instanse().addDataType(DataType.SESSION);
		SimpleCounter.instanse().addDataType(DataType.TICKET);
		SimpleCounter.instanse().addDataType(DataType.TRANSACTION);
	}

	public void setEvent(String name, double price, Rating rat) {
		events.put(SimpleIdGenerator.instanse().generate(DataType.EVENT), 
					new Event(name, price, rat));
		SimpleCounter.instanse().increase(DataType.EVENT);
	}

	public void deleteEvent(int index) {
		events.remove(index);
		SimpleCounter.instanse().reduce(DataType.EVENT);
	}

	public Map<Integer, Event> getAllEvents() {
		return events;
	}

	public void setSessions(Event film, Auditorium room, CustomerDate date) {
		sessions.put(SimpleIdGenerator.instanse().generate(DataType.SESSION),
				new Session(film, room, date));
		SimpleCounter.instanse().increase(DataType.SESSION);
	}

	public void deleteSessions(int index) {
		sessions.remove(index);
		SimpleCounter.instanse().reduce(DataType.SESSION);
	}
	 
	public Map<Integer, Session> getSessions() {
		return sessions;
	}

	public void setTicket(double ticketPrice, String seat, Session dataOfSession) {
		tickets.put(SimpleIdGenerator.instanse().generate(DataType.TICKET), 
				    new Ticket(ticketPrice, seat, dataOfSession));
		SimpleCounter.instanse().increase(DataType.TICKET);
	}

	public void deleteTicket(int index) {
		tickets.remove(index);
		SimpleCounter.instanse().reduce(DataType.SESSION);
	}

	public Map<Integer, Ticket> getAllTickets() {
		return tickets;
	}

	public void setTrancaction(User customer, Ticket order) {
		transactions.put(SimpleIdGenerator.instanse().generate(DataType.TRANSACTION), 
				         new Transaction(customer, order));
		SimpleCounter.instanse().increase(DataType.TRANSACTION);
	}

	public void deleteTransaction(int index) {
		transactions.remove(index);
		SimpleCounter.instanse().reduce(DataType.TRANSACTION);
	}

	public Map<Integer, Transaction> getAllTransactions() {
		return transactions;
	}

	public Map<Integer, User> getAllUsers() {
		return users;
	}

	public void deleteUser(int index) {
		users.remove(index);
		SimpleCounter.instanse().reduce(DataType.USER);
	}

	public void setUser(String name, String email, CustomerDate birthdate) {
		users.put(SimpleIdGenerator.instanse().generate(DataType.USER), 
				  new User(name, email, birthdate));
		SimpleCounter.instanse().increase(DataType.USER);
	}

	public int getCountTicketsOf(User customer) {
		int count = 0;
		
		for (Integer key: this.transactions.keySet()) {
			if (this.transactions.get(key).getCustomer().equals(customer)) {
				++count;
			}
		}
		return count;
	}

	public User getUserById(int index) {
		return this.users.get(index);
	}

	public User getUserByEmail(String email) {
		for (Integer key: this.users.keySet()) {
			if (this.users.get(key).getEmail().equals(email)) {
				return this.users.get(key);
			}
		}
		return null;
	}

	public List<User> getUserByName(String name) {
		List<User> usersNames = new ArrayList<User>();
		for (Integer key: this.users.keySet()) {
			if (this.users.get(key).getName().equals(name)) {
				usersNames.add(this.users.get(key));
			}
		}
		return usersNames;
	}

	public List<Ticket> getBookedTickets() {
		return new ArrayList<Ticket>(tickets.values());
	}

	public List<Double> getTicketPrice(Event film, CustomerDate day, List<String> seats, User customer) {
		List<Double> prices = new ArrayList<Double>();

		for (Integer key : this.transactions.keySet()) {
			if (this.equalsAllAttributes(this.transactions.get(key), film, day, seats, customer)) {
				prices.add(this.transactions.get(key).getOrder().getTicketPrice());
			}
		}
		return prices;
	}

	private boolean equalsAllAttributes(Transaction order, Event film, 
										CustomerDate day, List<String> seats, 
										User customer) {
		return  this.equalsCustomers(order, customer) &&
				this.equalsDay(order, day) &&
				this.equalsEvents(order, film) &&
				this.equalsSeats(order, seats);
	}
	
	private boolean equalsDay(Transaction order, CustomerDate day) {
		if (order.getOrder().getDataOfSession().getDate().getFullDate().equals(day.getFullDate())) {
			return true;
		}
		return false;
	}
	
	private boolean equalsCustomers(Transaction order, User customer) {
		if (order.getCustomer().equals(customer)) {
			return true;
		}
		return false;
	}
	
	private boolean equalsSeats(Transaction order, List<String> seats) {
		for(String item : seats) {
			if (order.getOrder().getSeat().equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean equalsEvents(Transaction order, Event film) {
		if (order.getOrder().getDataOfSession().getFilm().equals(film)) {
			return true;
		}
		return false;
	}
	
	public List<Ticket> getTicketsForEvent(Event film, CustomerDate date) {
		List<Ticket> bookedTickets = new ArrayList<Ticket>();

		for (Integer key : this.tickets.keySet()) {
			if (this.equalsDateOfTickets(this.tickets.get(key), date) &&
				this.equalsEventOfTickets(this.tickets.get(key), film)) {
				bookedTickets.add(this.tickets.get(key));
			}
		}
		return bookedTickets;
	}
	
	private boolean equalsEventOfTickets(Ticket order, Event film) {
		if (order.getDataOfSession().getFilm().equals(film)) {
			return true;
		}
		return false;
	}
	
	private boolean equalsDateOfTickets(Ticket order, CustomerDate date) {
		if (order.getDataOfSession().getDate().getFullDate().equals(date.getFullDate())) {
			return true;
		}
		return false;
	}
}
