package com.epam.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.spring.dao.interfaces.CounterByEventNameDao;
import com.epam.spring.dao.interfaces.CounterByPriceDao;
import com.epam.spring.dao.interfaces.CounterByTicketsDao;
import com.epam.spring.dao.interfaces.EventDao;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;

public class CounterAspect {
	private CounterByEventNameDao byEventNameBase;
	private CounterByPriceDao byPriseBase;
	private CounterByTicketsDao byTicketBase;
	private EventDao eventBase;
	
	public CounterAspect(CounterByEventNameDao byEventNameBase,
						 CounterByPriceDao byPriseBase,
						 CounterByTicketsDao byTicketBase,
					     EventDao eventBase) {
		this.byEventNameBase = byEventNameBase;
		this.byPriseBase = byPriseBase;
		this.byTicketBase = byTicketBase;
		this.eventBase = eventBase;
	}
	
	public Object incByTicket(ProceedingJoinPoint joinpoint) {
		Object obj = null;
		
		this.byTicketBase.addEvent(((Ticket)joinpoint.getArgs()[1]).getDataOfSession().getFilm());
		this.byTicketBase.increase(((Ticket)joinpoint.getArgs()[1]).getDataOfSession().getFilm());
		
		try {
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object incByPrice(ProceedingJoinPoint joinpoint) {
		Object obj = null;
		this.byPriseBase.addEvent(this.eventBase.getEventByName((String) joinpoint.getArgs()[0]));
		this.byPriseBase.increase(this.eventBase.getEventByName((String) joinpoint.getArgs()[0]));
		
		try {
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void incByEventName(Object obj) {
		this.byEventNameBase.addEvent((Event)obj);
		this.byEventNameBase.increase((Event)obj);
	}
}
