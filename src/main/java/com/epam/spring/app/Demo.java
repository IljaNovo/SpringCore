package com.epam.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.dao.database.MapCounterByEventNameDao;
import com.epam.spring.dao.database.MapCounterByPriceDao;
import com.epam.spring.dao.database.MapCounterByTicketsDao;
import com.epam.spring.dao.database.MapDiscountDao;
import com.epam.spring.dao.database.MapEventDao;
import com.epam.spring.data.Auditorium;
import com.epam.spring.data.Event;
import com.epam.spring.data.Session;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;
import com.epam.spring.servises.AuditoriumService;
import com.epam.spring.servises.BookingService;
import com.epam.spring.servises.DiscountService;
import com.epam.spring.servises.EventService;


// Небольшое демо, здесь из контейнера берётся user, event
// Создаётся сессия (сеанс для фильма)
// Создаётся тикет
// Создаётся транзакция на покупку
// При этом высчитывается скидка на цену
// Вычисляется количество обращений к ивенту по имени
// Вычисляется скидка для конкретного пользователя
// Если требуется, могу добавить ещё функционала в демо

public class Demo {
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext("all-beans.xml");
		
		DiscountService disServise = (DiscountService) actx.getBean("discount-servise");
		AuditoriumService room = (AuditoriumService) actx.getBean("auditorium-servise");
		BookingService bookServece = (BookingService) actx.getBean("booking-servise");
		
		User customer = (User) actx.getBean("user2");
		Event film = (Event)actx.getBean("event1");
		Event film2 = (Event)actx.getBean("event2");
		Session ses = new Session(film, room.getAuditoriums().get(0), new CustomerDate(2000, 07, 13));
		
		double price = film.getPrice() * disServise.getDiscount(customer, film, new CustomerDate(1995, 04, 20));
		Ticket order = new Ticket(price, "1", ses);
		
		bookServece.bookTicket(customer, order);
		
		System.out.print("Количество заказов на " + new CustomerDate(2000, 01, 13).getFullDate() + " : ");
		System.out.println(bookServece.getTicketsForEvent(film, new CustomerDate(2000, 07, 13)).size());
        MapEventDao med = (MapEventDao) actx.getBean("map_event_dao");
        med.setEvent(film);
        med.setEvent(film2);
        
        EventService es = (EventService) actx.getBean("event-servise");
        es.getEventByName("eventName1");
        es.getEventByName("eventName1");
        es.getEventByName("eventName1");
        
        MapCounterByEventNameDao mcbend = (MapCounterByEventNameDao)actx.getBean("map_counter_by_event_name_dao");
        System.out.println("Количество обращений к фильму " + film.getName() + ": " + mcbend.getCount(film));
        
        MapDiscountDao mdd = (MapDiscountDao) actx.getBean("map_discount_dao");
        System.out.println("Общая скидка для пользователя " + customer.getName() + ": " + mdd.getSpecificDiscount(customer));
	}
}
