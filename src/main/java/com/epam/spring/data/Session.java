package com.epam.spring.data;

import com.epam.spring.date.CustomerDate;

public class Session {
	private Event film;
	private Auditorium room;
	private CustomerDate date;
	
	public Session(Event film, Auditorium room,  CustomerDate date) {
		this.film = film;
		this.room = room;
		this.date = date;
	}

	public Event getFilm() {
		return film;
	}

	public Auditorium getRoom() {
		return room;
	}

	public CustomerDate getDate() {
		return date;
	}
}
