package com.epam.spring.calculating;

import java.util.Calendar;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDateUtil;

public class BirthdayDiscountStrategy implements DiscountStrategy {

	private static final double NO_DISCOUNT = 1;
	private static final double YES_DISCOUNT = 0.95;

	public double calculate(User user, Event event, Calendar date) {

		if (CustomerDateUtil.getFullDate(user.getBirthday()).equals(CustomerDateUtil.getFullDate(date))) {
			return YES_DISCOUNT;
		}
		return NO_DISCOUNT;
	}
}
