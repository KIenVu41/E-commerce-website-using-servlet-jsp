package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryDAO {

	List<Category> pagination(int limit, int offset) throws Exception;
	int count() throws Exception;
	void addCategory(Category category) throws Exception;
	void editCategory(Category category) throws Exception;
	void deleteCategory(int id) throws Exception;
	Category getCategoryById(int id) throws Exception;
	Category getCategoryByName(String name) throws Exception;
}
