package com.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.UserDAO;
import com.models.User;
import com.utils.Encryption;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		if (currentUser != null) {
			if (currentUser.getType().equals("Admin")) {
				User user = new User();
				user.setId(request.getParameter("id"));
				user.setEmail(request.getParameter("email"));
				user.setName(request.getParameter("name"));
				user.setPassword(Encryption.encrypt(request.getParameter("password")));
				user.setType(request.getParameter("type"));
				UserDAO.insertUser(user);
				request.setAttribute("message", "User Added Successfully");
				request.setAttribute("redirect", "dashboard");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}
		}
		response.sendRedirect("/");
	}
}
