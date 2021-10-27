package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.UserDAO;

public class admin implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String uname = request.getParameter("uname");
		int uid = Integer.parseInt(request.getParameter("uid"));
		try
		{
			PrintWriter out = response.getWriter();
			UserDAO u =  new UserDAO();
			int ress1 = u.getUser(uid, uname);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("userverification.jsp");
			request.setAttribute("res", ress1);
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
