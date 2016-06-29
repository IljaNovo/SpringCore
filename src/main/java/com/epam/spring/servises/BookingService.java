package com.epam.spring.servises;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;

public class BookingService {
	public List<Double> getTicketPrice(String eventName, MovieDate day,
								 List<String> seats, User user) {
		List<Ticket> bookedTickets = MapDataBase.instanse().getAllTiketsOfUsers().get(user);
		List<Double> prices = new ArrayList<Double>();
		
		for (int i = 0; i < bookedTickets.size(); ++i) {
			if (bookedTickets.get(i).getDate().getDayStartMovie().equals(day.getDayStartMovie()) &&
			    bookedTickets.get(i).getEvent().getName().equals(eventName) &&
			    seats.contains(bookedTickets.get(i).getSeat())) {
					prices.add(bookedTickets.get(i).getTicketPrice());
			}
		}
		return prices;
	}
	
	public void bookTicket(User user, Ticket ticket) {
		MapDataBase.instanse().setTicketOfUser(user, ticket);
	}
	
	public List<Ticket> getTicketsForEvent(String eventName, MovieDate date) {
		List<Ticket> bookedTickets = new ArrayList<Ticket>();
		
		for (Integer key: MapDataBase.instanse().getAllTickets().keySet()) {
			Ticket currentTicket = MapDataBase.instanse().getAllTickets().get(key); 
			
			if (currentTicket.getEvent().getName().equals(eventName) &&
				currentTicket.getDate().getDayStartMovie().equals(date.getDayStartMovie())) {
					bookedTickets.add(MapDataBase.instanse().getAllTickets().get(key));
			}
		}
		return bookedTickets;
	}
}
