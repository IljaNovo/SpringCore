package com.epam.spring.data;

import java.util.Date;

import com.epam.spring.utils.Rating;

public class Event {
	private String name;
	private double price;
	private Rating rating;
	private Date date;
	
	public Event(String name, double price, Rating rating, Date date) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
