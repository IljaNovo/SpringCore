package com.epam.spring.calculating;

import com.epam.spring.dao.MapDataBase;
import com.epam.spring.dao.SpringCoreDAO;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;
import com.epam.spring.movie.date.CustomerDate;

public class Every10thTicketDiscountStrategy implements DiscountStrategy{

	private SpringCoreDAO dataBase;
	
	public Every10thTicketDiscountStrategy(SpringCoreDAO dataBase) {
		this.dataBase = dataBase;
	}

	public double calculate(User customer, Event film, CustomerDate date) {
		if ((this.dataBase.getCountTicketsOf(customer) % 9) == 0) {
			return 0.5;
		}
		return 1;
	}
}
