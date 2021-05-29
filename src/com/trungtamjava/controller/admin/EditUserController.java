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

@WebServlet(urlPatterns = "/admin/user/edit")
public class EditUserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.valueOf(req.getParameter("id"));
		UserService userService = new UserService();
		User user = new User();
		
		try {
			user = userService.getUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editUser.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String role = req.getParameter("role");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		user.setPhone(phone);
		user.setRole(role);
		
		UserService userService = new UserService();
		
		try {
			userService.editUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/Final/admin/user");
	}
}
