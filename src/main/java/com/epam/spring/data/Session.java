package com.epam.spring.data;

import java.util.Calendar;

public class Session {
	private Event film;
	private Auditorium room;
	private Calendar date;

	public Session(Event film, Auditorium room, Calendar date) {
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

	public Calendar getDate() {
		return date;
	}
}
