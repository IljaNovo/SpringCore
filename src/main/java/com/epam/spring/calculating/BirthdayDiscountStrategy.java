package com.epam.spring.calculating;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class BirthdayDiscountStrategy implements DiscountStrategy {

	private static final double NO_DISCOUNT = 1;
	private static final double YES_DISCOUNT = 0.95;

	public double calculate(User user, Event event, CustomerDate date) {

		if (user.getBirthday().getFullDate().equals(date.getFullDate())) {
			return YES_DISCOUNT;
		}
		return NO_DISCOUNT;
	}
}
