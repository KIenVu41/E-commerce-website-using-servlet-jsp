package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = {"/admin/product/add"})
public class AddProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/product/addProduct.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String productName = req.getParameter("productName");
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		long price = Long.valueOf(req.getParameter("price"));
		String categoryName = req.getParameter("category");
		
		ProductService productService = new ProductService();
		CategoryService categoryService = new CategoryService();
		
		try {
			Category category = categoryService.getCategoryByName(categoryName);
			Product product = new Product();
			
			product.setName(productName);
			product.setQuantity(quantity);
			product.setPrice(price);
			product.setCategory(category);
			
			productService.addProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/Final/admin/product/search");
	}
}
