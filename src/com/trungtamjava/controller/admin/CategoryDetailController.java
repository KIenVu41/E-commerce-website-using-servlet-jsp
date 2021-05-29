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

@WebServlet(urlPatterns = {"/admin/category/detail"})
public class CategoryDetailController extends HttpServlet {
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		int id = Integer.valueOf(req.getParameter("id"));	
		CategoryService categoryService = new CategoryService();
		
		try {
			Category category = categoryService.getCategoryById(id);
			req.setAttribute("categoryDetail", category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/category/categoryDetail.jsp");
		rd.forward(req, resp);
	}
}	
