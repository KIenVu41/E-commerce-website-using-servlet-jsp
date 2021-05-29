package com.trungtamjava.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.CategoryDAO;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	private Connection conn;

	public CategoryDAOImpl() {
		// TODO Auto-generated constructor stub
		conn = JDBCConnection.getJDBCConnection();
	}

	@Override
	public List<Category> pagination(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORY ORDER BY ID ASC LIMIT ? OFFSET ?";
		List<Category> categories = new ArrayList<Category>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, limit);
			ps.setInt(2, offset);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));

				categories.add(category);
			}
		} catch (Exception e) {
			throw e;
		}

		return categories;
	}

	public Category getCategoryById(int id) throws Exception {
		String sql = "SELECT * FROM CATEGORY WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));

				return category;
			}
		} catch (Exception e) {
			throw e;
		}

		return null;
	}

	@Override
	public void addCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CATEGORY(ID, NAME) VALUES(?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, category.getId());
			ps.setString(2, category.getName());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void editCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORY SET NAME = ? WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteCategory(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORY WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Category getCategoryByName(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORY WHERE NAME = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));

				return category;
			}
		} catch (Exception e) {
			throw e;
		}

		return null;
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM CATEGORY";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		}

		return 0;
	}

}
