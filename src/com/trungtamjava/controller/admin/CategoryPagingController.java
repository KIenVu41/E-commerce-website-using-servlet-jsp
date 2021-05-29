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

@WebServlet(urlPatterns = {"/admin/category"})
public class CategoryPagingController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryService categoryService = new CategoryService();
		
		try {
			int pageIndex = 1;

			String strPageIndex = req.getParameter("pageIndex");

			if (strPageIndex != null) {
				pageIndex = Integer.valueOf(strPageIndex);
			}

			req.setAttribute("current", pageIndex);

			int count = categoryService.count();
			int pageSize = 3;
			int endPage = 0;

			endPage = count / pageSize;

			if (count % pageSize != 0) {
				endPage += 1;
			}

			int offset = pageIndex * pageSize - pageSize;
			
			List<Category> categories = categoryService.pagination(pageSize, offset);
			
			req.setAttribute("endPage", endPage);
			req.setAttribute("categories", categories);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/category/categoryList.jsp");
		rd.forward(req, resp);
	}
}
