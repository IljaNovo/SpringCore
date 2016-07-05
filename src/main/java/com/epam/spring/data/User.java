package com.epam.spring.data;


import com.epam.spring.movie.date.CustomerDate;

public class User {
	private String name;
	private String email;
	private CustomerDate birthday;
	
	public User(String name, String email, CustomerDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthday = birthdate;
	}

	public CustomerDate getBirthday() {
		return birthday;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}
}
