package com.epam.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class LuckyWinnerAspect {

	public Object checkLucky(ProceedingJoinPoint joinpoint) {
		Object obj = null;

		try {
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
