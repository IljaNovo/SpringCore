package com.epam.spring.calculating;

import java.util.Calendar;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;

public interface DiscountStrategy {
	double calculate(User user, Event event, Calendar date);
}
