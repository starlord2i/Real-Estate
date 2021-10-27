package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.SiteDAO;
import com.keane.training.domain.Site;

public class seller implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name =request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		Double amount = Double.parseDouble(request.getParameter("amt"));
		String location = request.getParameter("location");
		String purpose = request.getParameter("pur");
		String avail = request.getParameter("avail");
		PrintWriter out = response.getWriter();
		boolean isExists;
		Site site = new Site(id, type, location, amount, purpose, avail);
		
		try {
			SiteDAO s = new SiteDAO();
			int i = s.insertSite(site);
			int id1 = s.getSiteId(location, amount);
			if(i!=0)
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("insertedsite.jsp");
				request.setAttribute("id", id1);
				dispatcher.forward(request, response);
				
				out.print("<html><head><title></title><body>");
				out.print("<h1>Your Site has been Inserted</h1><br>"
						+ "<h1>Your Site ID is: "+id1+"(Please Note For Futher use)</h1></body></html>");
			}
			else
			{
				out.print("Your Site is not inserted");
			}
			
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		
		
	}

}
