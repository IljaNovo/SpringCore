package com.epam.spring.servises;

import java.util.List;

import com.epam.spring.dao.SpringCoreDAO;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class BookingService {

	private SpringCoreDAO dataBase;
	
	public BookingService(SpringCoreDAO dataBase) {
		this.dataBase = dataBase;
	}

	public List<Double> getTicketPrice(Event film, CustomerDate day, List<String> seats, User customer) {
		return dataBase.getTicketPrice(film, day, seats, customer);
	}

	public void bookTicket(User customer, Ticket order) {
		this.dataBase.setTicket(order);
		this.dataBase.setTrancaction(customer, order);
	}

	public List<Ticket> getTicketsForEvent(Event film, CustomerDate date) {
		return dataBase.getTicketsForEvent(film, date);
	}
}
