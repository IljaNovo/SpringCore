package com.epam.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.spring.dao.interfaces.DiscountDao;
import com.epam.spring.data.Event;
import com.epam.spring.data.User;

public class DiscountAspect {
	private DiscountDao discountBase;

	public DiscountAspect(DiscountDao discountBase) {
		this.discountBase = discountBase;
	}

	public Object countDiscoun(ProceedingJoinPoint joinpoint) {
		Object obj = null;

		final double PRECISION = 0.000001;

		try {
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if (!(Math.abs((Double) obj - 1) < PRECISION)) {
			double discount = ((Double) obj) * ((Event) joinpoint.getArgs()[1]).getPrice();

			this.discountBase.addUser((User) joinpoint.getArgs()[0]);
			this.discountBase.addDiscount((User) joinpoint.getArgs()[0], discount);
		}
		return obj;
	}
}
