package com.epam.spring.calculating;

import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public interface DiscountStrategy {
	double calculate(User user, Event event, CustomerDate date);
	
}
