package com.trungtamjava.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.ProductDAO;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

public class ProductDAOImpl implements ProductDAO {
	private Connection conn;

	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
		conn = JDBCConnection.getJDBCConnection();
	}

	@Override
	public List<Product> getProductByName(String searchedName) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT WHERE NAME LIKE ?";
		List<Product> products = new ArrayList<Product>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, '%' + searchedName + '%');

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				product.setPrice(rs.getLong(4));
				product.setImage(rs.getString(5));
				category.setId(rs.getInt(6));

				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			throw e;
		}

		return products;
	}

	@Override
	public void updateImage(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET IMAGE = ? WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, product.getImage());
			ps.setInt(2, product.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updatePrice(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET PRICE = ? WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, product.getPrice());
			ps.setInt(2, product.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product getProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Product product = new Product();
				Category category = new Category();

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				product.setPrice(rs.getLong(4));
				product.setImage(rs.getString(5));
				category.setId(rs.getInt(6));

				product.setCategory(category);

				return product;
			}
		} catch (Exception e) {
			throw e;
		}

		return null;
	}

	@Override
	public List<Product> pagination(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT ORDER BY ID ASC LIMIT ? OFFSET ?";
		List<Product> products = new ArrayList<Product>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, limit);
			ps.setInt(2, offset);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				product.setPrice(rs.getLong(4));
				product.setImage(rs.getString(5));
				category.setId(rs.getInt(6));
				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			throw e;
		}

		return products;
	}

	@Override
	public void updateQuantity(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET QUANTITY = QUANTITY + ? WHERE ID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, product.getQuantity());
			ps.setInt(2, product.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateQuantityWhenAddBillProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET QUANTITY = ? WHERE ID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, product.getQuantity());
			ps.setInt(2, product.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUCT(NAME, QUANTITY, PRICE, ID_CATEGORY) VALUES(?, ?, ? ,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setInt(2, product.getQuantity());
			ps.setLong(3, product.getPrice());
			ps.setInt(4, product.getCategory().getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteProduct(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM PRODUCT WHERE ID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void editProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET NAME = ?, QUANTITY = ?, PRICE = ?, ID_CATEGORY = ? WHERE ID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setInt(2, product.getQuantity());
			ps.setLong(3, product.getPrice());
			ps.setInt(4, product.getCategory().getId());
			ps.setInt(5, product.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM PRODUCT";

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

	@Override
	public List<Product> search(int limit, int offset, String keyword) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT WHERE NAME LIKE ? LIMIT ? OFFSET ?";
		List<Product> products = new ArrayList<Product>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + keyword + "%");
			ps.setInt(2, limit);
			ps.setInt(3, offset);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				product.setPrice(rs.getLong(4));
				product.setImage(rs.getString(5));
				category.setId(rs.getInt(6));
				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			throw e;
		}

		return products;
	}

	@Override
	public int countSearchedProduct(String keyword) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE NAME LIKE ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		}

		return 0;
	}

	@Override
	public int countSearchedProudctByCategory(String keyword) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM PRODUCT AS P INNER JOIN CATEGORY AS C ON P.ID_CATEGORY = C.ID WHERE C.NAME LIKE ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		}

		return 0;
	}

	@Override
	public List<Product> searchByCategory(int limit, int offset, String keyword) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCT AS P INNER JOIN CATEGORY AS C ON P.ID_CATEGORY = C.ID WHERE C.NAME LIKE ? LIMIT ? OFFSET ?";
		List<Product> products = new ArrayList<Product>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%" + keyword + "%");
			ps.setInt(2, limit);
			ps.setInt(3, offset);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();

				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				product.setPrice(rs.getLong(4));
				product.setImage(rs.getString(5));
				category.setId(rs.getInt(6));
				product.setCategory(category);

				products.add(product);
			}
		}catch(Exception e){
			throw e;
		}
		
		return products;
	}

}
