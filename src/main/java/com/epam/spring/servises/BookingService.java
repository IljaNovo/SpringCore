package com.epam.spring.servises;

import java.util.Calendar;
import java.util.List;

import com.epam.spring.dao.interfaces.TicketDao;
import com.epam.spring.dao.interfaces.TransactionDao;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;

public class BookingService {

	private TransactionDao transactDataBase;
	private TicketDao ticketDataBase;

	public BookingService(TransactionDao transactDataBase, TicketDao ticketDataBase) {
		this.transactDataBase = transactDataBase;
		this.ticketDataBase = ticketDataBase;
	}

	public List<Double> getTicketPrice(Event film, Calendar day, List<String> seats, User customer) {
		return transactDataBase.getTicketPrice(film, day, seats, customer);
	}

	public void bookTicket(User customer, Ticket order) {
		this.ticketDataBase.setTicket(order);
		this.transactDataBase.setTransaction(customer, order);
	}

	public List<Ticket> getTicketsForEvent(Event film, Calendar date) {
		return ticketDataBase.getTicketsForEvent(film, date);
	}
}
