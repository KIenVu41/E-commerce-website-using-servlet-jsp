package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;

@WebServlet(urlPatterns = {"/admin/user/detail"})
public class UserDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		UserService userService = new UserService();
		
		try {
			User user = userService.getUserById(id);
			req.setAttribute("userDetail", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/userDetail.jsp");
		rd.forward(req, resp);
	}
}
