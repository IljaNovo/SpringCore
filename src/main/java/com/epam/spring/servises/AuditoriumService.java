package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.data.Auditorium;

public class AuditoriumService {
	private List<Auditorium> auditoriums;
	
	public AuditoriumService(List<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	public List<Auditorium> getAuditoriums() {
		return this.auditoriums;
	}
	
	public List<Integer> getSeatsNumber() {
		List<Integer> seatsNumbers = new ArrayList<Integer>();
		for(int i = 0; i < auditoriums.size(); ++i) {
			seatsNumbers.add(this.auditoriums.get(i).getNumberOfSeats());
		}
		return seatsNumbers;
	}
	
	public List<String> getVipSeats() {
		List<String> vipSeats = new ArrayList<String>();
		for(int i = 0; i < auditoriums.size(); ++i) {
			vipSeats.add(this.auditoriums.get(i).getVipSeats());
		}
		return vipSeats;
	}
}
