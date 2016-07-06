package com.epam.spring.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.Transaction;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public interface TransactionDao {
	void setTrancaction(User customer, Ticket order);

	void deleteTransaction(int index);

	Map<Integer, Transaction> getAllTransactions();
	
	int getCountTicketsOf(User customer);
	
	List<Double> getTicketPrice(Event film, CustomerDate day, List<String> seats, User customer);
}
