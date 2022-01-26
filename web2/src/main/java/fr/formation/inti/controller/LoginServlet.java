package fr.formation.inti.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("message");
		Date con = (Date) session.getAttribute("dateConnection");
		if (message == null) {
			response.sendRedirect("index2.jsp");
		} else {
			response.getWriter().append(message).append("<br>").append(con.toString()).append("<br>")
					.append(session.getId());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String message = null,login = null;
		if(session != null) {
			message = (String) session.getAttribute("message");
			login = (String) session.getAttribute("login");
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String date = dtf.format(LocalDateTime.now()).toString();

		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Login</title></head>");
		out.println("<body>");
		out.println("<p>hello " + login + "</p>");
		out.println("<p>"+message+"</p>");
		out.println("<p>" + date + "</p>");

		out.println("<form action=\"index2.jsp\" method=\"post\">" + "<input type=\"submit\" value=\"Retour home\">"
				+ "</form>");

	}

}
