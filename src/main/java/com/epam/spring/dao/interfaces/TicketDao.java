package com.epam.spring.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public interface TicketDao {
	void setTicket(Ticket order);

	void deleteTicket(int index);

	Map<Integer, Ticket> getAllTickets();
	
	List<Ticket> getBookedTickets();
	
	List<Ticket> getTicketsForEvent(Event film, CustomerDate date);
}
