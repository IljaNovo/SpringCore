package com.epam.spring.data;


import com.epam.spring.movie.date.MovieDate;
import com.epam.spring.utils.Rating;

public class Event {
	private int id;
	private String name;
	private double price;
	private Rating rating;
	private MovieDate date;
	
	public Event(int id, String name, double price, Rating rating, MovieDate date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.date = date;
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

	public MovieDate getDate() {
		return date;
	}
}
