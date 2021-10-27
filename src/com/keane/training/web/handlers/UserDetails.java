package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.BookingDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.training.domain.Booking;

public class UserDetails implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		PrintWriter out = response.getWriter();
		try
		{
			BookingDAO b = new BookingDAO();
			List l = b.getDetails(sid);
			String sname=null;
			String bname=null;
			if(!(l.isEmpty()))
			{
				Iterator itr = l.iterator();
				while(itr.hasNext())
				{
					Booking b1 = (Booking) itr.next();
					sname=b1.getS_name();
					bname=b1.getB_name();
				}
				
			}
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("verifysitedetails.jsp");
			request.setAttribute("sname",sname);
			request.setAttribute("bname",bname);
			request.setAttribute("sid",sid);
			dispatcher.forward(request, response);
		}
		catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
