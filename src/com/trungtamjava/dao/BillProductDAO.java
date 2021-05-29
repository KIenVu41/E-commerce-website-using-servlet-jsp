package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.BillProduct;

public interface BillProductDAO {
	
	void addBillProduct(BillProduct billProduct) throws Exception;
	List<BillProduct> getAllBillProduct(int idBill) throws Exception;
	void deleteBillProduct(int id) throws Exception;
	void editBillProduct(BillProduct billProduct) throws Exception;
	double getTotalPrice(int billId) throws Exception;
}
