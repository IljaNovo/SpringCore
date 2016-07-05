package com.epam.spring.calculating;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.dao.SpringCoreDAO;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public class Every10thTicketDiscountStrategy implements DiscountStrategy{
	
	private SpringCoreDAO dataBase;
	private static final double NO_DISCOUNT = 1;
	private static final double YES_DISCOUNT = 0.5;
	
	
	public Every10thTicketDiscountStrategy(SpringCoreDAO dataBase) {
		this.dataBase = dataBase;
	}

	public double calculate(User customer, Event film, CustomerDate date) {
		if (this.dataBase.getCountTicketsOf(customer) == 0) {
			return NO_DISCOUNT;
		}
		
		if ((this.dataBase.getCountTicketsOf(customer) % 9) == 0) {
			return YES_DISCOUNT;
		}
		return NO_DISCOUNT;
	}
}
