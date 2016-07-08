package com.epam.spring.data;


public class Event {
	private String name;
	private double price;
	private Rating rating;
	
	public Event(String name, double price, Rating rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Rating getRating() {
		return rating;
	}
}
