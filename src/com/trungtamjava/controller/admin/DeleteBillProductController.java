package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Coupon;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.BillProductService;
import com.trungtamjava.service.BillService;
import com.trungtamjava.service.CouponService;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = {"/admin/billProduct/delete"})
public class DeleteBillProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		int productId = Integer.valueOf(req.getParameter("productId"));
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		int billId = Integer.valueOf(req.getParameter("billId"));
		
		BillProductService billProductService = new BillProductService();
		ProductService productService = new ProductService();
		BillService billService = new BillService();
		Product product = new Product();
		
		product.setId(productId);
		product.setQuantity(quantity);
		
		try {
			billProductService.deleteBillProduct(id);
			// cap nhat so luong san pham
			productService.updateQuantity(product);
			
			double totalPrice = billProductService.getTotalPrice(billId);
			
			CouponService couponService = new CouponService();
			Coupon coupon = new Coupon();
			// kiem tra xem bill co su dung coupon khong
			coupon = couponService.getCouponByBillId(billId);
			
			if(coupon != null) {
				totalPrice = totalPrice * (100 - coupon.getPercent())/100;
			}
			
			Bill bill = new Bill();
			bill.setId(billId);
			// cap nhat gia moi trong bill
			bill.setTotalPrice(totalPrice);
			
			billService.updateTotalPrice(bill);
			
			resp.sendRedirect("/Final/admin/bill/detail?id=" + billId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
