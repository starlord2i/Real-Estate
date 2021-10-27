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

public class booking implements HttpRequestHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		int sid = Integer.parseInt(request.getParameter("sid"));

		String choice = request.getParameter("choice");
	
			if(choice.equalsIgnoreCase("Yes"))
			{
				String intrest = request.getParameter("avail");
				if(intrest.equalsIgnoreCase("Yes"))
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("BookSite.jsp");
					request.setAttribute("choice", intrest);
					request.setAttribute("Name", name);
					request.setAttribute("Id", id);
					request.setAttribute("sid", sid);
					dispatcher.forward(request, response);
				}
			}
				
		
	
		
	}

}
