package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.BillProduct;
import com.trungtamjava.service.BillProductService;
import com.trungtamjava.service.BillService;

@WebServlet(urlPatterns = "/admin/bill/detail")
public class BillDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		BillProductService billProductService = new BillProductService();

		try {
			List<BillProduct> billProducts = billProductService.getAllBillProduct(id);	
			
			req.setAttribute("billProducts", billProducts);
			
			HttpSession session = req.getSession();
			session.setAttribute("billId", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/bill/billDetail.jsp");
		rd.forward(req, resp);
	}
}
