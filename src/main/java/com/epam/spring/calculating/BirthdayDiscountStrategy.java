package com.epam.spring.calculating;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.MovieDate;

public class BirthdayDiscountStrategy implements DiscountStrategy{

	public BirthdayDiscountStrategy() {}
	
	@Override
	public double calculate(User user, Event event, MovieDate date) {
		if (user.getBirthday().getDayStartMovie().equals(date.getDayStartMovie())) {
			return 0.95;
		}
		return 1;
	}
}
