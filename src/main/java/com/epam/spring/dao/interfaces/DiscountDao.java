package com.epam.spring.dao.interfaces;

import com.epam.spring.data.User;

public interface DiscountDao {
	
	double getTotalDiscount();
	
	double getSpecificDiscount(User customer);
	
	void addDiscount(User customer, double discount);
	
	void addUser(User order);
}
