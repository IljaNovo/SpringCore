package com.epam.spring.data;

public class Auditorium {
	private String name;
	private int numberOfSeats;
	private String vipSeats;
	
	public Auditorium(String name, int numberOfSeats, String vipSeats) {
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.vipSeats = vipSeats;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public String getVipSeats() {
		return vipSeats;
	}
}
