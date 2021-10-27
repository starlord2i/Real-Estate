package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.LoginDAO;
import com.keane.training.domain.User;

public class Login implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(Login.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		PrintWriter out = response.getWriter();
		String email  =request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int flag = -1;
		List users = null;
		LoginDAO dao = new LoginDAO();
		if(role.equals("Buyer"))
		{
		try {
			users = dao.validateBUser(email,password);
			log.info(users);
			for (Object object : users) {

				User user = (User) object;
				if (user.getPassword().equals(password)) {
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			Iterator itr1 = users.iterator();
			String name1=null;
			int id2=0;
			while(itr1.hasNext())
			{
				User u2 = (User) itr1.next();
				name1 = u2.getName();
				id2 = u2.getId();
			}
			if (flag == 0) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Buyerhome.jsp");
				request.setAttribute("Name", name1);
				request.setAttribute("Id", id2);
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Login.jsp");
				request.setAttribute("Err",
						"username are password is incorrect");
				dispatcher.forward(request, response);
			}

		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}

	}
	if(role.equals("Seller"))
	{
	try {
		users = dao.validateSUser(email,password);
		log.info(users);
		for (Object object : users) {

			User user = (User) object;
			if (user.getPassword().equals(password)) {
				flag = 0;
				break;
			}
		}
		log.info("Flag in login " + flag);
		Iterator itr = users.iterator();
		String name=null;
		int id=0;
		while(itr.hasNext())
		{
			User u1 = (User) itr.next();
			name = u1.getName();
			id = u1.getId();
		}
		if (flag == 0) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("SellerHome.jsp");
			request.setAttribute("Name", name);
			request.setAttribute("Id", id);
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Login.jsp");
			request.setAttribute("Err",
					"username are password is incorrect");
			dispatcher.forward(request, response);
		}

	} catch (DAOAppException e) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("error.jsp");
		request.setAttribute("Err", e.getMessage());
		dispatcher.forward(request, response);

	}

}
	if(role.equals("Admin"))
	{
	try {
		users = dao.validateAUser(email,password);
		log.info(users);
		for (Object object : users) {

			User user = (User) object;
			if (user.getPassword().equals(password)) {
				flag = 0;
				break;
			}
		}
		log.info("Flag in login " + flag);
		Iterator itr3 = users.iterator();
		String name3=null;
		int id3=0;
		while(itr3.hasNext())
		{
			User u3 = (User) itr3.next();
			name3 = u3.getName();
			id3 = u3.getId();
		}
		if (flag == 0) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("AdminHome.jsp");
			request.setAttribute("Name", name3);
			request.setAttribute("Id", id3);
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Login.jsp");
			request.setAttribute("Err",
					"username are password is incorrect");
			dispatcher.forward(request, response);
		}

	} catch (DAOAppException e) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("error.jsp");
		request.setAttribute("Err", e.getMessage());
		dispatcher.forward(request, response);

	}

}
}
}

