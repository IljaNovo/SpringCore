package com.epam.spring.data;

import java.util.Calendar;

public class User {
	private String name;
	private String email;
	private Calendar birthday;
	private boolean luckyTicket;

	public User(String name, String email, Calendar birthdate) {
		this.name = name;
		this.email = email;
		this.birthday = birthdate;
		this.luckyTicket = false;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void changeLuckyTicket(boolean lucky) {
		this.luckyTicket = lucky;
	}
	
	public boolean checkLuckyTicket() {
		return this.luckyTicket;
	}
}
