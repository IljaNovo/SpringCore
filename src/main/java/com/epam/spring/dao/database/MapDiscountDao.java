package com.epam.spring.dao.database;

import java.util.HashMap;
import java.util.Map;

import com.epam.spring.dao.interfaces.DiscountDao;
import com.epam.spring.data.User;

public class MapDiscountDao implements DiscountDao {
	private double totalDiscount;
	private Map<User, Double> discountsBase;

	public MapDiscountDao() {
		this.discountsBase = new HashMap<User, Double>();
	}

	public double getTotalDiscount() {
		return this.totalDiscount;
	}

	public double getSpecificDiscount(User customer) {
		if (this.discountsBase.get(customer) == null) {
			return 0.0;
		}
		return this.discountsBase.get(customer);
	}

	public void addUser(User customer) {
		if (this.discountsBase.get(customer) == null) {
			this.discountsBase.put(customer, 0.0);
		}
	}

	public void addDiscount(User customer, double discount) {
		this.discountsBase.put(customer, this.discountsBase.get(customer) + discount);
		this.totalDiscount += discount;
	}
}
