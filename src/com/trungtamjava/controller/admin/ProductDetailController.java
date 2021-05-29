package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = {"/admin/product/detail"})
public class ProductDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		
		ProductService productService = new ProductService();
		
		try {
			Product product = productService.getProductById(id);
			req.setAttribute("productDetail", product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/product/productDetail.jsp");
		rd.forward(req, resp);
	}
}
