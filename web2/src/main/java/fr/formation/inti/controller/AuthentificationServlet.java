package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/Authen")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (login == null)
			login = "";
		if (password == null)
			password = "";

		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index2.jsp") ;
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		session.setAttribute("password", password);

		if (("root".equals(login)) && ("123456".equals(password))) {
			session.setAttribute("message", "you are connected!");
			session.setAttribute("dateConnection", new Date());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginServlet") ;
			requestDispatcher.forward(request, response);
		
		} else {

			
			doGet(request,response);
		}
	}
}
