package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.RegisterDAO;
import com.keane.training.domain.User;

public class RegisterUser implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterUser.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterDAO dao = new RegisterDAO();
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("pass"));
		user.setContact(Integer.parseInt(request.getParameter("phno")));
		user.setRolename(request.getParameter("role"));

		boolean isExists;
		try {
			isExists = dao.validateUser(user.getEmail(),user.getPassword());

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\Register.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} else {
				if(user.getRolename().equalsIgnoreCase("Buyer"))
				{
				int finalRes = dao.registerBUser(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\success.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
				}
				if(user.getRolename().equalsIgnoreCase("Seller"))
				{
				int finalRes = dao.registerSUser(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\success.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
				}
				if(user.getRolename().equalsIgnoreCase("Admin"))
				{
				int finalRes = dao.registerAUser(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\success.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
