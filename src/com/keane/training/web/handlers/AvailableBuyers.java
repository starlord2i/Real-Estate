package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.UserDAO;

public class AvailableBuyers implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		PrintWriter out = response.getWriter();
		try
		{
		UserDAO u = new UserDAO();
		List res=null;
		res= u.getBuyers(sid);
		if(res.isEmpty())
		{
			out.print("No Buyers available");
		}
		else
		{
			RequestDispatcher dispatcher1 = request
					.getRequestDispatcher("BuyersList.jsp");
			
			request.setAttribute("List1", res);
			request.setAttribute("Name", name);
			request.setAttribute("Id", id);
			request.setAttribute("sid", sid);
			dispatcher1.forward(request, response);
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
