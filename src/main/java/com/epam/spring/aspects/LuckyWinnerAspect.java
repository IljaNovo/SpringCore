package com.epam.spring.aspects;

import java.util.Random;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;

public class LuckyWinnerAspect {

	public Object checkLucky(ProceedingJoinPoint joinpoint) {
		Object obj = null;
		Random r = new Random();
		
		int number = r.nextInt(10) % 2;
		
		
		if (number == 0) {
			((User) joinpoint.getArgs()[0]).changeLuckyTicket(true);
			((Ticket) joinpoint.getArgs()[1]).setPrice(0);
		} else {
			((User) joinpoint.getArgs()[0]).changeLuckyTicket(false);
		}
		try {
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
