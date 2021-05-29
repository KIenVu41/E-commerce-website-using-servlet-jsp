package com.trungtamjava.dao;

import java.util.Date;
import java.util.List;

import com.trungtamjava.model.Bill;

public interface BillDAO {
	
	void addBill(Bill bill) throws Exception;
	List<Bill> pagination(int limit, int offset) throws Exception;
	int count() throws Exception;
	List<Bill> getBillByBuyerId(int id) throws Exception;
	List<Bill> getBillByDate(Date start, Date end) throws Exception;
	void updateTotalPrice(Bill bill) throws Exception;
}
