package com.epam.spring.data;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String email;
	private List<Event> tickets;
	
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.tickets = new ArrayList<Event>();
	}

	public String getName() {
		return this.name;
	}
    
	public List<Event> getTickets() {
		return this.tickets;
	}
	
	public void addTicket(Event newTicket) {
		this.tickets.add(newTicket);
	}
	
	public void removeTicket(int index) {
		this.tickets.remove(index);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return this.id;
	}
}
