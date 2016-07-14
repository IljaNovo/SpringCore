package com.epam.spring.dao.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.dao.interfaces.TicketDao;
import com.epam.spring.data.DataType;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.date.CustomerDateUtil;
import com.epam.spring.utils.SimpleCounter;
import com.epam.spring.utils.SimpleIdGenerator;

public class MapTicketDao implements TicketDao {

	private Map<Integer, Ticket> tickets;

	public MapTicketDao() {
		this.tickets = new HashMap<Integer, Ticket>();

		this.initCounter();
		this.initIdGenerater();
	}

	private void initIdGenerater() {
		SimpleIdGenerator.instanse().addDataType(DataType.TICKET);
	}

	private void initCounter() {
		SimpleCounter.instanse().addDataType(DataType.TICKET);
	}

	public void setTicket(Ticket order) {
		tickets.put(SimpleIdGenerator.instanse().generate(DataType.TICKET), order);
		SimpleCounter.instanse().increase(DataType.TICKET);
	}

	public void deleteTicket(int index) {
		tickets.remove(index);
		SimpleCounter.instanse().reduce(DataType.SESSION);
	}

	public Map<Integer, Ticket> getAllTickets() {
		return tickets;
	}

	public List<Ticket> getBookedTickets() {
		return new ArrayList<Ticket>(tickets.values());
	}

	public List<Ticket> getTicketsForEvent(Event film, Calendar date) {
		for (Integer key : this.tickets.keySet()) {
			if (this.equalsDateOfTickets(this.tickets.get(key), date)
					&& this.equalsEventOfTickets(this.tickets.get(key), film)) {
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

	private boolean equalsDateOfTickets(Ticket order, Calendar date) {
		if (CustomerDateUtil.getFullDate(order.getDataOfSession().getDate()).equals(CustomerDateUtil.getFullDate(date))) {
			return true;
		}
		return false;
	}
}
