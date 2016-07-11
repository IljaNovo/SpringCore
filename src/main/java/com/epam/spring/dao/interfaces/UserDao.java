package com.epam.spring.dao.interfaces;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.User;

public interface UserDao {
	Map<Integer, User> getAllUsers();

	void deleteUser(int index);

	void setUser(String name, String email, Calendar birthdate);

	User getUserById(int index);

	User getUserByEmail(String email);

	List<User> getUserByName(String name);
}
