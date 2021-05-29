package com.trungtamjava.controller.admin;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/admin/product/edit"})
public class EditProductController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		
		ProductService productService = new ProductService();
		
		try {
			Product product = productService.getProductById(id);
			req.setAttribute("editProduct", product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/product/editProduct.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("productName");
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		Long price = Long.valueOf(req.getParameter("price"));
		String categoryName = req.getParameter("category");
		
		CategoryService categoryService = new CategoryService();
		ProductService productService = new ProductService();
		
		try {
			Category category = categoryService.getCategoryByName(categoryName);
			
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setCategory(category);
			
			productService.editProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/Final/admin/product/search");
	}
}
