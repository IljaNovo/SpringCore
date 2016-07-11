package com.epam.spring.dao.interfaces;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.Transaction;
import com.epam.spring.data.User;

public interface TransactionDao {
	void setTransaction(User customer, Ticket order);

	void deleteTransaction(int index);

	Map<Integer, Transaction> getAllTransactions();

	int getCountTicketsOf(User customer);

	List<Double> getTicketPrice(Event film, Calendar day, List<String> seats, User customer);
}
