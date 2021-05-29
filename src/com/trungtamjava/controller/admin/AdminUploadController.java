package com.trungtamjava.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;


@WebServlet(urlPatterns = {"/admin/product/upload"})
public class AdminUploadController extends HttpServlet{
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.valueOf(req.getParameter("id"));
			//tao doi tuong de luu tam thoi file upload len vao
			DiskFileItemFactory factory = new DiskFileItemFactory();

			/// doi thanh duong dan toi thu muc, luu tam thoi file upload len
			factory.setRepository(new File("D:\\code\\eclipse\\Servlet-JSP\\Final\\images"));
			///TREN WINDOW THI D:\\files (thu muc files trong o D)

			//nho truyen factory vao consrtuctor
			// doc request tu client gui len trong form upload
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			/// danh sach cac truong input tu form client
			// duoc goi la fileitem
			List<FileItem> 	fieldList = servletFileUpload.parseRequest(req);

			Product product = new Product();
			// lay ra tung input
			for (FileItem item : fieldList) {
				if (item.getFieldName().equals("imageFile")) {
					//kiem tra dung luong file upload
					if (item.getSize() > 0) {//neu co upload file
						final String UPLOAD_FOLDER = "D:\\code\\eclipse\\Servlet-JSP\\Final\\images";
						//tao 1 file tren server
						//tim dinh dang file
						String name = item.getName();//tra ve ten file upload
						int index = name.lastIndexOf(".");
						String ext = name.substring(index);//lay ra phan dinh dang file
						
						//MINH se ko lay ten file anh upload len, vi se xay ra trung ten
						// ma tao 1 file ten moi
						///tao file de luu tren server
						String image = System.currentTimeMillis() + ext;//ten file anh moi
						File file = new File(UPLOAD_FOLDER + File.separator + image);
						
						//ghi du lieu upload len vao file
						item.write(file);
						
						product.setImage(image);//luu lai ten file anh vao product
						product.setId(id);
					}
				}
			}

			ProductService productService = new ProductService();
			productService.updateImage(product);
			
			resp.sendRedirect("/Final/admin/product/detail?id=" + id);
		} catch (Exception e) {
			System.out.println("Loi " + e);
		}

	}	
}
