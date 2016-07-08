package com.epam.spring.servises;

import java.util.List;

import com.epam.spring.calculating.DiscountStrategy;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class DiscountService {

	private List<DiscountStrategy> strategy;

	public DiscountService() {
	}

	public DiscountService(List<DiscountStrategy> strategy) {
		this.strategy = strategy;
	}

	public double getDiscount(User user, Event event, CustomerDate date) {
		double maxDiscount = 1;
		double currentDiscount = 1;

		for (int i = 0; i < strategy.size(); ++i) {
			currentDiscount = strategy.get(i).calculate(user, event, date);
			if (currentDiscount < maxDiscount) {
				maxDiscount = currentDiscount;
			}
		}
		return maxDiscount;
	}
}
