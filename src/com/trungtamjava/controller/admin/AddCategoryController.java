package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.service.CategoryService;

@WebServlet(urlPatterns = {"/admin/category/add"})
public class AddCategoryController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/category/addCategory.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("categoryName");
		
		CategoryService categoryService = new CategoryService();
		Category category = new Category();
		category.setName(name);
		
		try {
			categoryService.addCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/Final/admin/category");
	}
}
