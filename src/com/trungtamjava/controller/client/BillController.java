package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Coupon;
import com.trungtamjava.model.User;
import com.trungtamjava.service.BillService;
import com.trungtamjava.service.CouponService;

@WebServlet(urlPatterns = "/member/order-history")
public class BillController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BillService billService = new BillService();
		CouponService couponService = new CouponService();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("memberLogin");
		
		try {	
			List<Bill> bills = billService.getBillByBuyerId(user.getId());
			List<Coupon> coupons = couponService.getCouponByUserId(user.getId());
			
			req.setAttribute("bills", bills);
			req.setAttribute("coupons", coupons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/view/client/bill/bill.jsp");
		rd.forward(req, resp);
	}
}
