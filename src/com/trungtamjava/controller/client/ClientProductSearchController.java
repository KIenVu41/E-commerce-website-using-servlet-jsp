package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = "/product/search")
public class ClientProductSearchController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categoryName = req.getParameter("category");
		
		ProductService productService = new ProductService();
		List<Product> products = new ArrayList<Product>();
		
		try {
			int pageIndex = 1;

			String strPageIndex = req.getParameter("pageIndex");

			if (strPageIndex != null) {
				pageIndex = Integer.valueOf(strPageIndex);
			}

			req.setAttribute("current", pageIndex);

			int count = productService.countSearchedProudctByCategory(categoryName);
			int pageSize = 4;
			int endPage = 0;

			endPage = count / pageSize;

			if (count % pageSize != 0) {
				endPage += 1;
			}

			int offset = pageIndex * pageSize - pageSize;
			
			products = productService.searchByCategory(pageSize, offset, categoryName);
			
			req.setAttribute("endPage", endPage);
			req.setAttribute("products", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/shop.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String productName = req.getParameter("productName");
		
		ProductService productService = new ProductService();
		List<Product> products = new ArrayList<Product>();
		
		try {
			int pageIndex = 1;

			String strPageIndex = req.getParameter("pageIndex");

			if (strPageIndex != null) {
				pageIndex = Integer.valueOf(strPageIndex);
			}

			req.setAttribute("current", pageIndex);

			int count = productService.countSearchedProduct(productName);
			int pageSize = 4;
			int endPage = 0;

			endPage = count / pageSize;

			if (count % pageSize != 0) {
				endPage += 1;
			}

			int offset = pageIndex * pageSize - pageSize;
			
			products = productService.search(pageSize, offset, productName);
			
			req.setAttribute("endPage", endPage);
			req.setAttribute("products", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/shop.jsp");
		rd.forward(req, resp);
	}
}
