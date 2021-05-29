package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Product;

public interface ProductDAO {
	
	List<Product> pagination(int limit, int offset) throws Exception;
	List<Product> getProductByName(String searchedName) throws Exception;
	List<Product> search(int limit, int offset, String keyword) throws Exception;
	List<Product> searchByCategory(int limit, int offset, String keyword) throws Exception;
	int countSearchedProduct(String keyword) throws Exception;
	int count() throws Exception;
	int countSearchedProudctByCategory(String keyword) throws Exception;
	Product getProductById(int id) throws Exception;
	void updateImage(Product product) throws Exception;
	void updatePrice(Product product) throws Exception;
	void updateQuantity(Product product) throws Exception;
	void updateQuantityWhenAddBillProduct(Product product) throws Exception;
	void addProduct(Product product) throws Exception;
	void deleteProduct(int id) throws Exception;
	void editProduct(Product product) throws Exception;
	
}
