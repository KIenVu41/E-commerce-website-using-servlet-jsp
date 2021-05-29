package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.BillProduct;

@WebServlet(urlPatterns = "/cart/update")
public class UpdateCartController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("action");
		int productId = Integer.parseInt(req.getParameter("id"));
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		
		Map<Integer, BillProduct> items = (Map<Integer, BillProduct>) obj;
		
		BillProduct billProduct = items.get(productId);
		
		if(action.equals("decrease")) {
			billProduct.setQuantity(billProduct.getQuantity() - 1);		
			
			if(billProduct.getQuantity() < 1) {
				items.remove(productId);
			}
		}else if(action.equals("increase")) {
			billProduct.setQuantity(billProduct.getQuantity() + 1);
		}
		
		session.setAttribute("cart", items);
		
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
