package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Bill;
import com.trungtamjava.service.BillService;

@WebServlet(urlPatterns = "/admin/bill")
public class AdminBillController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BillService billService = new BillService();

		try {
			int pageIndex = 1;

			String strPageIndex = req.getParameter("pageIndex");

			if (strPageIndex != null) {
				pageIndex = Integer.valueOf(strPageIndex);
			}

			req.setAttribute("current", pageIndex);

			int count = billService.count();
			int pageSize = 3;
			int endPage = 0;

			endPage = count / pageSize;

			if (count % pageSize != 0) {
				endPage += 1;
			}

			int offset = pageIndex * pageSize - pageSize;
			
			List<Bill> bills = billService.pagination(pageSize, offset);
			
			req.setAttribute("endPage", endPage);		
			req.setAttribute("bills", bills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/bill/bill.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String start = req.getParameter("start");
		String end = req.getParameter("end");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		BillService billService = new BillService();

		try {
			Date dateStart = sdf.parse(start);
			Date dateEnd = sdf.parse(end);

			List<Bill> bills = billService.getBillByDate(dateStart, dateEnd);
			req.setAttribute("bills", bills);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/bill/bill.jsp");
		rd.forward(req, resp);
	}
}
