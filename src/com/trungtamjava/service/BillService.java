package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.Impl.BillDAOImpl;
import com.trungtamjava.model.Bill;

public class BillService {
	private BillDAOImpl billDAOImpl;
	
	public BillService() {
		billDAOImpl = new BillDAOImpl();
	}
	
	public List<Bill> pagination(int limit, int offset) throws Exception {
		return billDAOImpl.pagination(limit, offset);
	}
	
	public int count() throws Exception {
		return billDAOImpl.count();
	}
	
	public void addBill(Bill bill) throws Exception {
		billDAOImpl.addBill(bill);
	}
	
	public List<Bill> getBillByBuyerId(int id) throws Exception {
		return billDAOImpl.getBillByBuyerId(id);
	}
	
	public List<Bill> getBillByDate(java.util.Date start, java.util.Date end) throws Exception {
		return billDAOImpl.getBillByDate(start, end);
	}
	
	public void updateTotalPrice(Bill bill) throws Exception {
		billDAOImpl.updateTotalPrice(bill);
	}
	
}
