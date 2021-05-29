package com.trungtamjava.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;

@WebServlet(urlPatterns = {"/signup"})
public class ClientSignupController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/memberSignup.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repeatPassword");
		
		UserService userService = new UserService();
		
		try {
			if(password.equals(repassword)) {
				User user = new User();
				user.setName(name);
				user.setUsername(username);
				user.setUsername(username);
				user.setPassword(password);
				user.setRole("member");
				userService.addUser(user);
				
				resp.sendRedirect("/Final/login");
			}else {
				resp.sendRedirect("/Final/signup?e=Password doesn't match");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
