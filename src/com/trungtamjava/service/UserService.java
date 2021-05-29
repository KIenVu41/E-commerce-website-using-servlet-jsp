package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.Impl.UserDAOImpl;
import com.trungtamjava.model.User;

public class UserService {
	private UserDAOImpl userDAOImpl;

	public UserService() {
		userDAOImpl = new UserDAOImpl();
	}

	public void addUser(User user) throws Exception {
		userDAOImpl.addUser(user);
	}

	public User getUserById(int id) throws Exception {
		return userDAOImpl.getUserById(id);
	}
	
	public List<User> pagination(int limit, int offset) throws Exception {
		return userDAOImpl.pagination(limit, offset);
	}
	
	public void editUser(User user) throws Exception {
		userDAOImpl.editUser(user);
	}

	public void deleteUser(int id) throws Exception {
		userDAOImpl.deleteUser(id);
	}
	
	public User getUserByUsername(String username) throws Exception {
		return userDAOImpl.getUserByUsername(username);
	}
	
	public List<User> getUserBySearchName(String name) throws Exception{
		return userDAOImpl.getUserBySearchName(name);
	}
	
	public int count() throws Exception {
		return userDAOImpl.count();
	}
}
