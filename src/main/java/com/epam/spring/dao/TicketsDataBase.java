package com.epam.spring.dao;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.movie.date.MovieDate;

public class TicketsDataBase {
	private static Map<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
	private static TicketsDataBase base;
	private static int countTickets = 0;
	
	private TicketsDataBase() {}
	
	public static TicketsDataBase instanse() {
		if (base == null) {
			base = new TicketsDataBase();
		}
		return base;
	}
	
	public static void set(Event event, double ticketPrice, String seat, MovieDate date) {
		tickets.put(countTickets, new Ticket(countTickets, event, ticketPrice, seat, date));
		++countTickets;
	}
	
	public static void delete(int index) {
		tickets.remove(index);
		--countTickets;
	}
	
	public static Map<Integer, Ticket> getTicketsBase() {
		return tickets;
	}
}
