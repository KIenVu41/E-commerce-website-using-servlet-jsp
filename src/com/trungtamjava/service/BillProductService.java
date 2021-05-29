package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.Impl.BillProductDAOImpl;
import com.trungtamjava.model.BillProduct;

public class BillProductService {
	private BillProductDAOImpl billProductDAOImpl;
	
	public BillProductService() {
		billProductDAOImpl = new BillProductDAOImpl();
	}
	
	public void addBillProduct(BillProduct billProduct) throws Exception {
		billProductDAOImpl.addBillProduct(billProduct);
	}
	
	public List<BillProduct> getAllBillProduct(int idBill) throws Exception {
		return billProductDAOImpl.getAllBillProduct(idBill);
	}
	
	public void deleteBillProduct(int id) throws Exception {
		billProductDAOImpl.deleteBillProduct(id);
	}
	
	public void editBillProduct(BillProduct billProduct) throws Exception {
		billProductDAOImpl.editBillProduct(billProduct);
	}
	
	public double getTotalPrice(int billId) throws Exception {
		return billProductDAOImpl.getTotalPrice(billId);
	}
}
