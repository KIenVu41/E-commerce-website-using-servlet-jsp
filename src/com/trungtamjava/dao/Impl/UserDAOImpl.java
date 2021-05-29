package com.trungtamjava.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.UserDAO;
import com.trungtamjava.model.User;


public class UserDAOImpl implements UserDAO {
	private Connection conn;
	
	public UserDAOImpl() {
		conn = JDBCConnection.getJDBCConnection();
	}
	
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USER(NAME, USERNAME, PASSWORD, PHONE, EMAIL, ADDRESS, ROLE) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getRole());
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public List<User> pagination(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER ORDER BY ID ASC LIMIT ? OFFSET ?";
		List<User> users = new ArrayList<User>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, limit);
			ps.setInt(2, offset);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setRole(rs.getString(8));
				
				users.add(user);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return users;
	}

	@Override
	public void editUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE USER SET NAME = ?, USERNAME = ?, PASSWORD = ?, PHONE = ?, EMAIL = ?, ADDRESS = ?, ROLE = ? WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getRole());
			ps.setInt(8, user.getId());
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM USER WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setRole(rs.getString(8));
				
				return user;
			}
		}catch(Exception e) {
			throw e;
		}
		
		return null;
	}

	@Override
	public User getUserByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);;
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setRole(rs.getString(8));
				
				return user;
			}
		}catch(Exception e) {
			throw e;
		}
		
		return null;
	}

	@Override
	public List<User> getUserBySearchName(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER WHERE USERNAME LIKE ?";
		List<User> users = new ArrayList<User>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%" + name + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setRole(rs.getString(8));
				
				users.add(user);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return users;
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM USER";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return 0;
	}

	@Override
	public void updateInfor(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE USER SET PHONE = ?, EMAIL = ?, ADDRESS = ? WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getId());
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}

}
