package com.epam.spring.data;


import com.epam.spring.movie.date.MovieDate;

public class User {
	private int id;
	private String name;
	private String email;
	private MovieDate birthday;
	
	public User(int id, String name, String email, MovieDate birthdate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthday = birthdate;
	}

	public MovieDate getBirthday() {
		return birthday;
	}

	public String getName() {
		return this.name;
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
