package com.epam.spring.data;

import com.epam.spring.movie.date.MovieDate;

public class Ticket {
	private int id;
	private Event event;
	private double ticketPrice;
	private String seat;
	private MovieDate date;
	
	public Ticket(int id, Event event, double ticketPrice, String seat, MovieDate date) {
		this.id = id;
		this.event = event;
		this.ticketPrice = ticketPrice;
		this.seat = seat;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public Event getEvent() {
		return event;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public String getSeat() {
		return seat;
	}

	public MovieDate getDate() {
		return date;
	}
}


