package com.epam.spring.dao.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.dao.interfaces.TransactionDao;
import com.epam.spring.data.DataType;
import com.epam.spring.data.Event;
import com.epam.spring.data.Ticket;
import com.epam.spring.data.Transaction;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDateUtil;
import com.epam.spring.utils.SimpleCounter;
import com.epam.spring.utils.SimpleIdGenerator;

public class MapTransactionDao implements TransactionDao {

	private Map<Integer, Transaction> transactions;

	public MapTransactionDao() {
		this.transactions = new HashMap<Integer, Transaction>();

		this.initCounter();
		this.initIdGenerater();
	}

	private void initIdGenerater() {
		SimpleIdGenerator.instanse().addDataType(DataType.TRANSACTION);
	}

	private void initCounter() {
		SimpleCounter.instanse().addDataType(DataType.TRANSACTION);
	}

	public void setTransaction(User customer, Ticket order) {
		transactions.put(SimpleIdGenerator.instanse().generate(DataType.TRANSACTION), new Transaction(customer, order));
		SimpleCounter.instanse().increase(DataType.TRANSACTION);
	}

	public void deleteTransaction(int index) {
		transactions.remove(index);
		SimpleCounter.instanse().reduce(DataType.TRANSACTION);
	}

	public Map<Integer, Transaction> getAllTransactions() {
		return transactions;
	}

	public int getCountTicketsOf(User customer) {
		int count = 0;

		for (Integer key : this.transactions.keySet()) {
			if (this.transactions.get(key).getCustomer().equals(customer)) {
				++count;
			}
		}
		return count;
	}

	public List<Double> getTicketPrice(Event film, Calendar day, List<String> seats, User customer) {
		List<Double> prices = new ArrayList<Double>();

		for (Integer key : this.transactions.keySet()) {
			if (this.equalsAllAttributes(this.transactions.get(key), film, day, seats, customer)) {
				prices.add(this.transactions.get(key).getOrder().getTicketPrice());
			}
		}
		return prices;
	}

	private boolean equalsAllAttributes(Transaction order, Event film, Calendar day, List<String> seats,
			User customer) {
		return this.equalsCustomers(order, customer) && this.equalsDay(order, day) && this.equalsEvents(order, film)
				&& this.equalsSeats(order, seats);
	}

	private boolean equalsDay(Transaction order, Calendar day) {
		if (CustomerDateUtil.getFullDate(order.getOrder().getDataOfSession().getDate()).equals(CustomerDateUtil.getFullDate(day))) {
			return true;
		}
		return false;
	}

	private boolean equalsCustomers(Transaction order, User customer) {
		if (order.getCustomer().equals(customer)) {
			return true;
		}
		return false;
	}

	private boolean equalsSeats(Transaction order, List<String> seats) {
		for (String item : seats) {
			if (order.getOrder().getSeat().equals(item)) {
				return true;
			}
		}
		return false;
	}

	private boolean equalsEvents(Transaction order, Event film) {
		if (order.getOrder().getDataOfSession().getFilm().equals(film)) {
			return true;
		}
		return false;
	}
}
