package com.epam.spring.data;

public class Transaction {
	private User customer;
	private Ticket order;
	
	public Transaction(User customer, Ticket order) {
		this.customer = customer;
		this.order = order;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public Ticket getOrder() {
		return order;
	}
}
