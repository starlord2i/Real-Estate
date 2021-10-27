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
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.SiteDAO;
import com.keane.training.domain.Site;

public class Buyer implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		int minimum = Integer.parseInt(request.getParameter("mini"));
		int maximum = Integer.parseInt(request.getParameter("maxi"));
		String location = request.getParameter("loc");
		String purpose = request.getParameter("pur");
		try {
		SiteDAO s = new SiteDAO();
		List list12= null;
		list12=s.getSite(type,location,minimum,maximum,purpose);
		Iterator itr = list12.iterator();
		PrintWriter out = response.getWriter();
		int sid=0;
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AvailableSites.jsp");
		request.setAttribute("list1", list12);
		request.setAttribute("Name", name);
		request.setAttribute("Id", id);
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
