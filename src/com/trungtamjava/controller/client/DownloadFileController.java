package com.trungtamjava.controller.client;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

@WebServlet(urlPatterns = "/product/download")
public class DownloadFileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String img = req.getParameter("url");
		final String UPLOAD_FOLDER = "D:\\code\\eclipse\\Servlet-JSP\\Final\\images";//thu muc o upload file
		File file = new File(UPLOAD_FOLDER + File.separator + img);
		if (file.exists()) {
			FileUtils.copyFile(file, resp.getOutputStream());
		}	
	}
}
