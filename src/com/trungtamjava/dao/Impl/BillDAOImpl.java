package com.trungtamjava.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.BillDAO;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.User;

public class BillDAOImpl implements BillDAO {
	private Connection conn;

	public BillDAOImpl() {
		// TODO Auto-generated constructor stub
		conn = JDBCConnection.getJDBCConnection();
	}

	@Override
	public void addBill(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO BILL(BUYDATE, TOTAL_PRICE, ID_USER) VALUES(?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, new java.sql.Date(bill.getBuyDate().getTime()));
			ps.setDouble(2, bill.getTotalPrice());
			ps.setInt(3, bill.getUser().getId());

			ps.execute();
			
			// tra ve id
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				bill.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Bill> getBillByBuyerId(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM BILL WHERE ID_USER = ?";
		List<Bill> bills = new ArrayList<Bill>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill();
				User user = new User();

				bill.setId(rs.getInt(1));
				bill.setBuyDate(rs.getDate(2));
				bill.setTotalPrice(rs.getLong(3));
				user.setId(rs.getInt(4));
				bill.setUser(user);

				bills.add(bill);
			}
		} catch (Exception e) {
			throw e;
		}

		return bills;
	}

	@Override
	public List<Bill> getBillByDate(java.util.Date start, java.util.Date end) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bill as b inner join user as u on b.id_user = u.id WHERE BUYDATE BETWEEN ? AND ?";
		List<Bill> bills = new ArrayList<Bill>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDate(1, new java.sql.Date(start.getTime()));
			ps.setDate(2, new java.sql.Date(end.getTime()));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill();
				User user = new User();

				bill.setId(rs.getInt(1));
				bill.setBuyDate(rs.getDate(2));
				bill.setTotalPrice(rs.getLong(3));
				user.setId(rs.getInt(4));
				user.setName(rs.getString(6));
				bill.setUser(user);

				bills.add(bill);
			}
		} catch (Exception e) {
			throw e;
		}

		return bills;
	}

	@Override
	public List<Bill> pagination(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM BILL AS B INNER JOIN USER AS U ON B.ID_USER = U.ID ORDER BY B.ID ASC LIMIT ? OFFSET ?";
		List<Bill> bills = new ArrayList<Bill>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, limit);
			ps.setInt(2, offset);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill();
				User user = new User();

				bill.setId(rs.getInt(1));
				bill.setBuyDate(rs.getDate(2));
				bill.setTotalPrice(rs.getLong(3));
				user.setName(rs.getString(6));
				bill.setUser(user);

				bills.add(bill);
			}
		} catch (Exception e) {
			throw e;
		}

		return bills;
	}

	@Override
	public void updateTotalPrice(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE BILL SET TOTAL_PRICE = ? WHERE ID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, bill.getTotalPrice());
			ps.setInt(2, bill.getId());

			ps.execute();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM BILL";

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
