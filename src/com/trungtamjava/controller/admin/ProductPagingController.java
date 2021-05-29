package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = { "/admin/product/search" })
public class ProductPagingController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService productService = new ProductService();

		try {
			int pageIndex = 1;

			String strPageIndex = req.getParameter("pageIndex");

			if (strPageIndex != null) {
				pageIndex = Integer.valueOf(strPageIndex);
			}

			req.setAttribute("current", pageIndex);

			int count = productService.count();
			int pageSize = 3;
			int endPage = 0;

			endPage = count / pageSize;

			if (count % pageSize != 0) {
				endPage += 1;
			}

			int offset = pageIndex * pageSize - pageSize;
			
			List<Product> products = productService.pagination(pageSize, offset);
			
			req.setAttribute("endPage", endPage);
			req.setAttribute("searchProduct", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/product/productList.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productName = req.getParameter("productName");
		ProductService productService = new ProductService();

		try {
			List<Product> products = productService.getProductByName(productName);
			req.setAttribute("searchProduct", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/product/productList.jsp");
		rd.forward(req, resp);
	}
}
