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

import com.trungtamjava.model.Coupon;
import com.trungtamjava.service.CouponService;

@WebServlet(urlPatterns = "/admin/coupon")
public class CouponController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CouponService couponService = new CouponService();
		List<Coupon> coupons = new ArrayList<Coupon>();
		
		try {
			coupons = couponService.getAllCoupon();
			
			req.setAttribute("coupons", coupons);
			
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/coupon/coupons.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
