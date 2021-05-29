package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.UserService;

@WebServlet(urlPatterns = {"/admin/user"})
public class UserPagingController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		List<User> users = new ArrayList<User>();
		
		try {
			int pageIndex = 1;
			
			String strPageIndex = req.getParameter("pageIndex");
			
			if(strPageIndex != null) {
				pageIndex = Integer.valueOf(strPageIndex);
			}
			
			req.setAttribute("current", pageIndex);
			
			int count = userService.count();
			int pageSize = 3;
			int endPage = 0;
			
			endPage = count / pageSize;
			
			if(count % pageSize != 0) {
				endPage += 1;
			}
			
			int offset = pageIndex * pageSize - pageSize;
			
			users = userService.pagination(pageSize, offset);
			
			req.setAttribute("endPage", endPage);
			
			//users = userService.getAllUser();
			req.setAttribute("users", users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/userList.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String searchName = req.getParameter("searchName");
		
		UserService userService = new UserService();
		
		try {
			List<User> users = userService.getUserBySearchName(searchName);
			req.setAttribute("users", users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/userList.jsp");
		rd.forward(req, resp);
	}
}
