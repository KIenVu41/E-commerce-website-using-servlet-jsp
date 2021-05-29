package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.ProductService;

@WebServlet(urlPatterns = {"/add-to-cart"})
public class AddToCartController extends HttpServlet {
	ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(req.getParameter("productId"));
		String quantityStr = req.getParameter("quantity");
		int quantity;
		
		if(quantityStr == null) {
			quantity = 1;	
		}else {
			quantity = Integer.parseInt(quantityStr);
		}
		
		try {
			Product product = productService.getProductById(productId);
			HttpSession session = req.getSession();		
			Object obj = session.getAttribute("cart");
			
			// tao gio hang
			if(obj == null) {
				BillProduct billProduct = new BillProduct();
				
				billProduct.setProduct(product);
				billProduct.setPrice(product.getPrice());
				billProduct.setQuantity(quantity);
				
				HashMap<Integer, BillProduct> items =  new HashMap<Integer, BillProduct>();
				items.put(productId, billProduct);
				
				session.setAttribute("cart", items);
			}else {
				Map<Integer, BillProduct> items = (Map<Integer, BillProduct>) obj;
				
				BillProduct billProduct = items.get(productId);
				
				if(billProduct == null) {
					billProduct = new BillProduct();
					
					billProduct.setProduct(product);
					billProduct.setQuantity(quantity);
					billProduct.setPrice(product.getPrice());
					
					items.put(productId, billProduct);
				}else {
					billProduct.setQuantity(billProduct.getQuantity() + 1);
				}
				
				session.setAttribute("cart", items);
			}
				
			resp.sendRedirect(req.getContextPath() + "/shop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
