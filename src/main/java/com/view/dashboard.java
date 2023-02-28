package com.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.UserDAO;
import com.google.gson.Gson;
import com.models.User;
import com.mysql.cj.Session;
import com.utils.Encryption;

/**
 * Servlet implementation class dashboard
 */
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			if(user.getType().equals("Admin")) rd = request.getRequestDispatcher("adminDashboard.jsp");
			if(user.getType().equals("Student")) rd = request.getRequestDispatcher("/");
			if(user.getType().equals("Faculty")) rd = request.getRequestDispatcher("/");	
		}
		else {
			rd = request.getRequestDispatcher("/");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String pass = request.getParameter("password");
		User user = UserDAO.getUser(id);
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if (user != null) {
			System.out.println(user.toString());
			if (user.getType().equals(type)) {
				if (user.getPassword().equals(Encryption.encrypt(pass))) {
					session.setAttribute("user", user);
					if(user.getType().equals("Admin")) rd = request.getRequestDispatcher("adminDashboard.jsp");
					if(user.getType().equals("Student")) rd = request.getRequestDispatcher("/");
					if(user.getType().equals("Faculty")) rd = request.getRequestDispatcher("/");
					rd.forward(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Incorred Password");
				}
			} else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN,"Invalid User");
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid User");
		}
	}
}
