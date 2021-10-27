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

public class deletesite implements HttpRequestHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String del =request.getParameter("del");
		PrintWriter out = response.getWriter();
		try
		{
			SiteDAO s = new SiteDAO();
			if(del.equalsIgnoreCase("Yes"))
			{
				Boolean b = s.deleteSite();
				if(b)
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("deletedsites.jsp");
					dispatcher.forward(request, response);
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
