package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.epam.spring.dao.DataBase;
import com.epam.spring.data.Event;

public class BookingService {
	// сравнивать строки
	public List<Double> getTicketPrice(Event event, String date, String time,
								 String seats, String user) {
		List<Double> bookedTickets = new ArrayList<Double>();
		for (Integer key: DataBase.getEventsBase().keySet()) {
			
		}
		return bookedTickets;
	}
	
	public String bookTicket(String user, String ticket) {
		return "";
	}
	
	public String getTicketsForEvent(String event, String date) {
		return "";
	}
}
