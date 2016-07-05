package com.epam.spring.calculating;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class BirthdayDiscountStrategy implements DiscountStrategy{

	public BirthdayDiscountStrategy() {}
	
	public double calculate(User user, Event event, CustomerDate date) {
		if (user.getBirthday().getFullDate().equals(date.getFullDate())) {
			return 0.95;
		}
		return 1;
	}
}
