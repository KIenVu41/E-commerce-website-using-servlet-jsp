package com.trungtamjava.dao;

import java.sql.Connection;
import java.util.List;

import com.trungtamjava.model.User;

public interface UserDAO {
	
	int count() throws Exception;
	void addUser(User user) throws Exception;
	void updateInfor(User user) throws Exception;
	List<User> pagination(int limit, int offset) throws Exception;
	User getUserById(int id) throws Exception;
	void editUser(User user) throws Exception;
	void deleteUser(int id) throws Exception;
	User getUserByUsername(String username) throws Exception;
	List<User> getUserBySearchName(String name) throws Exception;
}
