package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;

@WebServlet(urlPatterns = "/admin/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserService userService = new UserService();
		
		try {
			User user = userService.getUserByUsername(username);
			
			if(user != null) {
				if(username != null && password != null && user.getPassword().equals(password)) {
					HttpSession session = req.getSession();
					session.setAttribute("loginUser", user);
					
					if(user.getRole().equals("admin")) {
						resp.sendRedirect("/Final/admin/welcome");
					}else {
						resp.sendRedirect("/Final/admin/login?e=1");
					}	
					
				}else {
					resp.sendRedirect("/Final/admin/login?e=1");
				}
			}else {
				resp.sendRedirect("/Final/admin/login?e=1");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
