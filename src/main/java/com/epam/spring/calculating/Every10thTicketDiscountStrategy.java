package com.epam.spring.calculating;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;

public class Every10thTicketDiscountStrategy implements DiscountStrategy{

	public Every10thTicketDiscountStrategy() {}
	
	@Override
	public double calculate(User user, Event event, MovieDate date) {
		if ((MapDataBase.instanse().getAllTiketsOfUsers().get(user).size() % 10) == 0) {
			return 0.5;
		}
		return 1;
	}
}
