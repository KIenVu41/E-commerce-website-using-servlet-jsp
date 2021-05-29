package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.Impl.CategoryDAOImpl;
import com.trungtamjava.model.Category;

public class CategoryService {
	private CategoryDAOImpl categoryDAOImpl;
	
	public CategoryService() {
		categoryDAOImpl = new CategoryDAOImpl();
	}
	
	public List<Category> pagination(int limit, int offset) throws Exception {
		return categoryDAOImpl.pagination(limit, offset);
	}
	
	public int count() throws Exception {
		return categoryDAOImpl.count();
	}
	
	public void addCategory(Category category) throws Exception {
		categoryDAOImpl.addCategory(category);
	}
	
	public void editCategory(Category category) throws Exception {
		categoryDAOImpl.editCategory(category);
	}
	
	public void deleteCategory(int id) throws Exception {
		categoryDAOImpl.deleteCategory(id);
	}
	
	public Category getCategoryById(int id) throws Exception {
		return categoryDAOImpl.getCategoryById(id);
	}
	
	public Category getCategoryByName(String name) throws Exception {
		return categoryDAOImpl.getCategoryByName(name);
	}
	
}
