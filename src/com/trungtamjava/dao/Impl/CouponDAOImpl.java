package com.trungtamjava.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.CouponDAO;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Coupon;
import com.trungtamjava.model.User;

public class CouponDAOImpl implements CouponDAO {	
	private Connection conn;

	public CouponDAOImpl() {
		// TODO Auto-generated constructor stub
		conn = JDBCConnection.getJDBCConnection();
	}
	
	@Override
	public void addCoupon(Coupon coupon) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE COUPON SET USER_ID = ?, STATUS =  'used', BILL_ID = ? WHERE CODE = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, coupon.getUser().getId());
			ps.setInt(2, coupon.getBill().getId());
			ps.setString(3, coupon.getCode());
			
			ps.execute();
		}catch(Exception e) {
			throw e;
		}
	}
		
	@Override
	public Coupon getCouponByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM COUPON WHERE CODE = ?";
		

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, code);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Coupon coupon = new Coupon();
				User user  = new User();
				
				coupon.setId(rs.getInt(1));
				coupon.setCode(rs.getString(2));
				coupon.setPercent(rs.getInt(3));
				user.setId(rs.getInt(4));
				coupon.setUser(user);
				coupon.setStatus(rs.getString(5));
				
				return coupon;
			}
		}catch(Exception e) {
			throw e;
		}
		
		return null;	
	}

	@Override
	public Coupon getCouponByBillId(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM BILL AS B INNER JOIN COUPON AS C ON B.ID = C.BILL_ID WHERE B.ID = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Coupon coupon = new Coupon();
				Bill bill = new Bill();
				User user = new User();
				
				bill.setId(rs.getInt(1));
				bill.setBuyDate(rs.getDate(2));
				bill.setTotalPrice(rs.getDouble(3));
				user.setId(4);
				bill.setUser(user);
				
				coupon.setId(rs.getInt(5));
				coupon.setCode(rs.getString(6));
				coupon.setPercent(rs.getInt(7));
				coupon.setStatus(rs.getString(9));
				coupon.setUser(user);
				coupon.setBill(bill);
				
				return coupon;
			}
		}catch(Exception e) {
			throw e;
		}
		
		return null;
	}

	@Override
	public List<Coupon> getAllCoupon() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM COUPON";
		List<Coupon> coupons = new ArrayList<Coupon>();
		
		try {
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Coupon coupon = new Coupon();
				User user = new User();
				Bill bill = new Bill();
				
				coupon.setId(rs.getInt(1));
				coupon.setCode(rs.getString(2));
				coupon.setPercent(rs.getInt(3));
				coupon.setStatus(rs.getString(5));
				
				user.setId(rs.getInt(4));
				coupon.setUser(user);
				
				bill.setId(rs.getInt(6));
				coupon.setBill(bill);
				
				coupons.add(coupon);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return coupons;
	}

	@Override
	public List<Coupon> getCouponByUserId(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM COUPON WHERE USER_ID = ?";
		List<Coupon> coupons = new ArrayList<Coupon>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Coupon coupon = new Coupon();
				User user = new User();
				Bill bill = new Bill();
				
				coupon.setId(rs.getInt(1));
				coupon.setCode(rs.getString(2));
				coupon.setPercent(rs.getInt(3));
				coupon.setStatus(rs.getString(5));
				
				user.setId(rs.getInt(4));
				coupon.setUser(user);
				
				bill.setId(rs.getInt(6));
				coupon.setBill(bill);
				
				coupons.add(coupon);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return coupons;
	}

}
