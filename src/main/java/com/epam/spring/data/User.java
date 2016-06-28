package com.epam.spring.data;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String email;
	
	
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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
