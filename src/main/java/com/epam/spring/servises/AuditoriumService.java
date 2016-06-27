package com.epam.spring.servises;

public class AuditoriumService {
	private String name;
	private int numberOfSeats;
	private String vipSeats;
	
	public AuditoriumService(String name, int numberOfSeats, String vipSeats) {
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.vipSeats = vipSeats;
	}

	public String getAuditoriums() {
		return this.name;
	}
	
	public int getSeatsNumber() {
		return this.numberOfSeats;
	}
	
	public String getVipSeats() {
		return this.vipSeats;
	}
}
