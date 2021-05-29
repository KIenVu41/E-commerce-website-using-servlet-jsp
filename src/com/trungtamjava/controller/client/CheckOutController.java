package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.Impl.CouponDAOImpl;
import com.trungtamjava.model.Coupon;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = {"/member/check-out"})
public class CheckOutController extends HttpServlet {
	private int time;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		time = 0;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double total = Double.valueOf(req.getParameter("total"));
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/checkout.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = req.getParameter("coupon_code");
		CouponDAOImpl couponDAOImpl = new CouponDAOImpl();
		HttpSession session = req.getSession();
		Double total = (Double) session.getAttribute("total");
		
		try {
			// chi nhap coupon 1 lan
			if(time == 0) {
				Coupon coupon =  couponDAOImpl.getCouponByCode(code);
				
				if(coupon != null) {
					String status = coupon.getStatus();
					// kiem tra xem coupon duoc dung chua
					if(status == null) {					
						session.setAttribute("coupon", coupon);
						resp.sendRedirect("/Final/member/check-out?total=" + total);
					}else {
						resp.sendRedirect("/Final/member/check-out?total=" + total + "&msg=This coupon was used");
					}
				}else {
					resp.sendRedirect("/Final/member/check-out?total=" + total + "&msg=This coupon isn't correct");
				}
				time += 1;
			}else {
				resp.sendRedirect("/Final/member/check-out?total=" + total + "&msg=You can only use 1 coupon");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
