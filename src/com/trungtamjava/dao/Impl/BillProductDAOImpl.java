package com.trungtamjava.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.BillProductDAO;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.UserService;

public class BillProductDAOImpl implements BillProductDAO {
	private Connection conn;
	
	public BillProductDAOImpl() {
		// TODO Auto-generated constructor stub
		conn = JDBCConnection.getJDBCConnection();
	}
	
	@Override
	public void addBillProduct(BillProduct billProduct) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO BILL_PRODUCT(QUANTITY, PRICE, ID_BILL, ID_PRODUCT) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, billProduct.getQuantity());
			ps.setLong(2, billProduct.getPrice());
			ps.setInt(3, billProduct.getBill().getId());
			ps.setInt(4, billProduct.getProduct().getId());
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public List<BillProduct> getAllBillProduct(int idBill) throws Exception {
		String sql = "select * from (bill_product as bp inner join bill as b on b.id = bp.id_bill) inner join product as p on p.id = bp.id_product where b.id = ?";
		List<BillProduct> billProducts = new ArrayList<BillProduct>();
		UserService userService = new UserService();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idBill);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BillProduct billProduct = new BillProduct();
				Bill bill = new Bill();
				Product product = new Product();
				User user = new User();
				
				billProduct.setId(rs.getInt(1));
				billProduct.setQuantity(rs.getInt(2));
				billProduct.setPrice(rs.getLong(3));
				
				bill.setId(rs.getInt(4));
				bill.setBuyDate(rs.getDate(7));
				bill.setTotalPrice(rs.getLong(8));
				
				user = userService.getUserById(rs.getInt(9));
				bill.setUser(user);
				
				product.setId(rs.getInt(10));
				product.setName(rs.getString(11));
				product.setImage(rs.getString(14));
				product.setQuantity(rs.getInt(12));
				
				billProduct.setProduct(product);
				billProduct.setBill(bill);
				
				billProducts.add(billProduct);
			}

		}catch(Exception e) {
			throw e;
		}
		
		return billProducts;
	}

	@Override
	public void deleteBillProduct(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM BILL_PRODUCT WHERE ID = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void editBillProduct(BillProduct billProduct) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE BILL_PRODUCT SET QUANTITY = ?, PRICE = ? WHERE ID = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, billProduct.getQuantity());
			ps.setLong(2,billProduct.getPrice());
			ps.setInt(3, billProduct.getId());
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public double getTotalPrice(int billId) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select sum(price*quantity) from bill_product where id_bill = ?";
		double totalPrice = 0.0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, billId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				totalPrice =  rs.getDouble(1);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return totalPrice;
	}
	
}
