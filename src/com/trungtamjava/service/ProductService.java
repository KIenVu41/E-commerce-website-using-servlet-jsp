package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.Impl.ProductDAOImpl;
import com.trungtamjava.model.Product;

public class ProductService {
	private ProductDAOImpl  productDAOImpl;
	
	public ProductService() {
		productDAOImpl = new ProductDAOImpl();
	}
	
	public List<Product> pagination(int limit, int offset) throws Exception {
		return productDAOImpl.pagination(limit, offset);
	}
	
	public  List<Product>  getProductByName(String searchedName) throws Exception {
		return productDAOImpl.getProductByName(searchedName);
	}
	
	public int count() throws Exception {
		return productDAOImpl.count();
	}
	
	public Product getProductById(int id) throws Exception {
		return productDAOImpl.getProductById(id);
	}
	
	public void updateImage(Product product) throws Exception {
		productDAOImpl.updateImage(product);
	}
	
	public void updatePrice(Product product) throws Exception {
		productDAOImpl.updatePrice(product);
	}
	
	public void updateQuantity(Product product) throws Exception {
		productDAOImpl.updateQuantity(product);
	}
	
	public void updateQuantityWhenAddBillProduct(Product product) throws Exception {
		productDAOImpl.updateQuantityWhenAddBillProduct(product);
	}
	
	public void addProduct(Product product) throws Exception {
		productDAOImpl.addProduct(product);
	}
	
	public void deleteProduct(int id) throws Exception {
		productDAOImpl.deleteProduct(id);
	}
	
	public void editProduct(Product product) throws Exception {
		productDAOImpl.editProduct(product);
	}
	
	public List<Product> search(int limit, int offset, String keyword) throws Exception {
		return productDAOImpl.search(limit, offset, keyword);
	}
	
	public int countSearchedProduct(String keyword) throws Exception {
		return productDAOImpl.countSearchedProduct(keyword);
	}
	
	public int countSearchedProudctByCategory(String keyword) throws Exception {
		return productDAOImpl.countSearchedProudctByCategory(keyword);
	}
	public List<Product> searchByCategory(int limit, int offset, String keyword) throws Exception {
		return productDAOImpl.searchByCategory(limit, offset, keyword);
	}
}
