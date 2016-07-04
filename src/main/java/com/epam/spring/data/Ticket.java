package com.epam.spring.data;


public class Ticket {
	private double ticketPrice;
	private String seat;
	private Session dataOfSession;
	
	public Ticket(double ticketPrice, String seat, Session dataOfSession) {
		this.ticketPrice = ticketPrice;
		this.seat = seat;
		this.dataOfSession = dataOfSession;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public String getSeat() {
		return seat;
	}

	public Session getDataOfSession() {
		return dataOfSession;
	}
}


