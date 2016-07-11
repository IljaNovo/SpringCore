package com.epam.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.spring.dao.interfaces.DiscountDao;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;

public class DiscountAspect {
	private DiscountDao discountBase;

	public DiscountAspect(DiscountDao discountBase) {
		this.discountBase = discountBase;
	}

	public Object countDiscount(ProceedingJoinPoint joinpoint) {
		Object obj = null;
		
		Ticket order = (Ticket) joinpoint.getArgs()[1]; 
		
		if(!(((User) joinpoint.getArgs()[0]).checkLuckyTicket())) {
			double discount = order.getDataOfSession().getFilm().getPrice() - order.getTicketPrice();
			
			this.discountBase.addUser((User) joinpoint.getArgs()[0]);
			this.discountBase.addDiscount((User) joinpoint.getArgs()[0], discount);
		}
		return obj;
	}
}
