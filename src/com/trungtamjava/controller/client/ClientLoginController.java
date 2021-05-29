package com.trungtamjava.controller.client;

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

@WebServlet(urlPatterns = "/login")
public class ClientLoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/memberLogin.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserService userService = new UserService();
		User user = new User();
		HttpSession session = req.getSession();
		
		try {
			user = userService.getUserByUsername(username);
			
			if(user != null) {
				if(user.getPassword().equals(password)) {
						session.setAttribute("memberLogin", user);
						resp.sendRedirect("/Final/shop");
						
				}else {
					resp.sendRedirect("/Final/login?e=Wrong username or password");
				}
			}else {
				resp.sendRedirect("/Final/login?e=Your account doesn't exist");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
