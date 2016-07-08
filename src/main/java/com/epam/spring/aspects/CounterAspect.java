package com.epam.spring.aspects;

import com.epam.spring.dao.interfaces.CounterByEventNameDao;
import com.epam.spring.dao.interfaces.CounterByPriceDao;
import com.epam.spring.dao.interfaces.CounterByTicketDao;

public class CounterAspect {
	private CounterByEventNameDao ByEventNameBase;
	private CounterByPriceDao ByPriseBase;
	private CounterByTicketDao ByTicketBase;
	
	public CounterAspect(CounterByEventNameDao byEventNameBase,
						 CounterByPriceDao byPriseBase,
						 CounterByTicketDao byTicketBase) {
		ByEventNameBase = byEventNameBase;
		ByPriseBase = byPriseBase;
		ByTicketBase = byTicketBase;
	}
	
	
}
