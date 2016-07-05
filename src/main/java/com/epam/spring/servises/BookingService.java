package com.epam.spring.servises;

import java.util.List;

import com.epam.spring.dao.interfaces.TicketDao;
import com.epam.spring.dao.interfaces.TransactionDao;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class BookingService {

	private TransactionDao transactDataBase;
	private TicketDao ticketDataBase;
	
	
	public BookingService(TransactionDao transactDataBase, TicketDao ticketDataBase) {
		this.transactDataBase = transactDataBase;
		this.ticketDataBase = ticketDataBase;
	}

	public List<Double> getTicketPrice(Event film, CustomerDate day, List<String> seats, User customer) {
		return transactDataBase.getTicketPrice(film, day, seats, customer);
	}

	public void bookTicket(User customer, Ticket order) {
		this.ticketDataBase.setTicket(order);
		this.transactDataBase.setTrancaction(customer, order);
	}

	public List<Ticket> getTicketsForEvent(Event film, CustomerDate date) {
		return ticketDataBase.getTicketsForEvent(film, date);
	}
}
