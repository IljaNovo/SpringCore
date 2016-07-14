package com.epam.spring.calculating;

import java.util.Calendar;

import com.epam.spring.dao.interfaces.TransactionDao;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;

public class Every10thTicketDiscountStrategy implements DiscountStrategy {

	private TransactionDao dataBase;
	private static final double NO_DISCOUNT = 1;
	private static final double YES_DISCOUNT = 0.5;

	public Every10thTicketDiscountStrategy(TransactionDao dataBase) {
		this.dataBase = dataBase;
	}

	public double calculate(User customer, Event film, Calendar date) {
		if (this.dataBase.getCountTicketsOf(customer) == 0) {
			return NO_DISCOUNT;
		}

		if ((this.dataBase.getCountTicketsOf(customer) % 9) == 0) {
			return YES_DISCOUNT;
		}
		return NO_DISCOUNT;
	}
}
