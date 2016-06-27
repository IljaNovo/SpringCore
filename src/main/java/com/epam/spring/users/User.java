package com.epam.spring.users;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String email;
	private List<Ticket> tickets;
	
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.tickets = new ArrayList<Ticket>();
	}

	public String getName() {
		return name;
	}
    
	public void addTicket(Ticket newTicket) {
		this.tickets.add(newTicket);
	}
	
	public void removeTicket(int index) {
		this.tickets.remove(index);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
}
