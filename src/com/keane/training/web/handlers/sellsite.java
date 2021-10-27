package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.BookingDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.SiteDAO;

public class sellsite implements HttpRequestHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String opt =request.getParameter("sell");
		int sid = Integer.parseInt(request.getParameter("sid"));
		PrintWriter out = response.getWriter();
		try
		{
			SiteDAO s = new SiteDAO();
			BookingDAO b = new BookingDAO();
			if(opt.equalsIgnoreCase("Yes"))
			{
				int n = s.updateAvailabiliy(sid);
				int n1 = b.updateName(sid, name);
				if(n!=0 & n1!=0)
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("soldsite.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					out.print("Site not sold");
				}
			}
		}
		catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		
	}

}
