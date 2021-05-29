package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Bill;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.Coupon;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.BillProductService;
import com.trungtamjava.service.BillService;
import com.trungtamjava.service.CouponService;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = {"/admin/billProduct/add"})
public class AddBillProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/bill/addBillProduct.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		req.setCharacterEncoding("UTF-8");
		
		int billId = Integer.valueOf(req.getParameter("billId"));
		String name = req.getParameter("product");
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		
		ProductService productService = new ProductService();
		BillService billService = new BillService();
		BillProductService billProductService = new BillProductService();
		BillProduct billProduct = new BillProduct();
		Bill bill = new Bill();
		bill.setId(billId);
		
		try {
			List<Product> products = productService.getProductByName(name);
			
			int productId = products.get(0).getId();
			int productQuantity = products.get(0).getQuantity();
			long productPrice = products.get(0).getPrice();
			
			// kiem tra so luong nhap vao voi so luong trong db
			if(productQuantity >= quantity) {			
				Product product = new Product();
				product.setId(productId);
				product.setQuantity(productQuantity - quantity);
				
				billProduct.setPrice(productPrice);
				billProduct.setQuantity(quantity);
				billProduct.setBill(bill);
				billProduct.setProduct(product);
				
				billProductService.addBillProduct(billProduct);
				
				// cap nhat so luong san pham trong db
				productService.updateQuantityWhenAddBillProduct(product);
				// lay tong so tien san pham
				double totalPrice = billProductService.getTotalPrice(billId);
				
				CouponService couponService = new CouponService();
				Coupon coupon = new Coupon();
				// kiem tra xem bill co su dung coupon khong
				coupon = couponService.getCouponByBillId(billId);
				
				if(coupon != null) {
					totalPrice = totalPrice * (100 - coupon.getPercent())/100;
				}
				
				bill.setTotalPrice(totalPrice);
				billService.updateTotalPrice(bill);
				
				resp.sendRedirect("/Final/admin/bill/detail?id=" + billId);	
			}else {
				resp.sendRedirect("/Final/admin/billProduct/add?e=Khong du so luong");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
