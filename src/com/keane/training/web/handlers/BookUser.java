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
import com.keane.training.domain.Booking;

public class BookUser implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String choice =request.getParameter("choice");
		String date = request.getParameter("datebook");
		int sid = Integer.parseInt(request.getParameter("sid"));
		long cardno=Long.parseLong(request.getParameter("cardno"));
		PrintWriter out = response.getWriter();
		
		try
		{
			BookingDAO b1  = new BookingDAO();
			Booking b=new Booking(id,sid,choice,date,cardno,name);
			int num1=b1.insertBook(b);
			if(num1!=0)
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("BookedSite.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				out.print("<h4>Site Is not Booked<h4>");
			}
			out.print("</div></div></body></html>");
		}
		catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		
	}

}
