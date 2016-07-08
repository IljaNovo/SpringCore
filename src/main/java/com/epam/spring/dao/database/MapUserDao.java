package com.epam.spring.dao.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.dao.interfaces.UserDao;
import com.epam.spring.data.DataType;
import com.epam.spring.data.User;
import com.epam.spring.date.CustomerDate;
import com.epam.spring.utils.SimpleCounter;
import com.epam.spring.utils.SimpleIdGenerator;

public class MapUserDao implements UserDao {

	private Map<Integer, User> users;

	public MapUserDao() {
		this.users = new HashMap<Integer, User>();

		this.initCounter();
		this.initIdGenerater();
	}

	private void initIdGenerater() {
		SimpleIdGenerator.instanse().addDataType(DataType.USER);
	}

	private void initCounter() {
		SimpleCounter.instanse().addDataType(DataType.USER);
	}

	public Map<Integer, User> getAllUsers() {
		return users;
	}

	public void deleteUser(int index) {
		users.remove(index);
		SimpleCounter.instanse().reduce(DataType.USER);
	}

	public void setUser(String name, String email, CustomerDate birthdate) {
		users.put(SimpleIdGenerator.instanse().generate(DataType.USER), new User(name, email, birthdate));
		SimpleCounter.instanse().increase(DataType.USER);
	}

	public User getUserById(int index) {
		return this.users.get(index);
	}

	public User getUserByEmail(String email) {
		for (Integer key : this.users.keySet()) {
			if (this.users.get(key).getEmail().equals(email)) {
				return this.users.get(key);
			}
		}
		return null;
	}

	public List<User> getUserByName(String name) {
		List<User> usersNames = new ArrayList<User>();
		for (Integer key : this.users.keySet()) {
			if (this.users.get(key).getName().equals(name)) {
				usersNames.add(this.users.get(key));
			}
		}
		return usersNames;
	}
}
