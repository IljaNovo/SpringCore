package com.epam.spring.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;

public interface UserDao {
	Map<Integer, User> getAllUsers();

	void deleteUser(int index);

	void setUser(String name, String email, CustomerDate birthdate);

	User getUserById(int index);

	User getUserByEmail(String email);

	List<User> getUserByName(String name);
}
