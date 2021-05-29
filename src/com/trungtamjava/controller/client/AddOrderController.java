package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.Impl.UserDAOImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.Coupon;
import com.trungtamjava.model.User;
import com.trungtamjava.service.BillProductService;
import com.trungtamjava.service.BillService;
import com.trungtamjava.service.CouponService;

@WebServlet(urlPatterns = "/member/add-order")
public class AddOrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		HttpSession session = req.getSession();
		Double total = (Double) session.getAttribute("total");
		Coupon coupon = (Coupon) session.getAttribute("coupon");

		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = (User) session.getAttribute("memberLogin");
		user.setAddress(address + "-" + city + "-" + country);
		user.setEmail(email);
		user.setPhone(phone);

		try {
			// cap nhap thong tin nguoi dung
			userDAOImpl.updateInfor(user);

			Object obj = session.getAttribute("cart");
			Map<Integer, BillProduct> items = (Map<Integer, BillProduct>) obj;

			Bill bill = new Bill();

			bill.setBuyDate(new Date());
			bill.setUser(user);

			if (coupon == null) {
				bill.setTotalPrice(total);
			} else {
				bill.setTotalPrice(total * (100 - coupon.getPercent()) / 100);
			}

			BillService billService = new BillService();
			billService.addBill(bill);

			for (Entry<Integer, BillProduct> entry : items.entrySet()) {
				BillProduct billProduct = entry.getValue();

				billProduct.setBill(bill);

				BillProductService billProductService = new BillProductService();
				billProductService.addBillProduct(billProduct);
			}

			if (coupon != null) {
				CouponService couponService = new CouponService();
				coupon.setBill(bill);
				coupon.setUser(user);

				couponService.addCoupon(coupon);
			}

			session.removeAttribute("cart");
			session.removeAttribute("total");
			session.removeAttribute("coupon");

			// gui mail cho nguoi mua
			MailController.sendEmail(email);
			
			resp.sendRedirect(req.getContextPath() + "/view/client/orderSuccess.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
}
