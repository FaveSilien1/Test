package fr.formation.inti.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		
		 if ( login == null ) login = "";
	        if ( pass == null ) pass = "";
	        
	        HttpSession session = request.getSession( true );
	        session.setAttribute( "login", login );
	        session.setAttribute( "password", pass );
	        
	        request.getRequestDispatcher( "/index.jsp" ).forward( request, response );

		
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession( true );
        session.setAttribute( "login", login );
        session.setAttribute( "password", pass );

        System.out.println( "in the doPost" );
        
        if ("root".equals(login) && "123456".equals(pass)) {
            session.setAttribute( "isConnected", true );
            request.getRequestDispatcher( "/LoginServlet " ).forward( request, response );
        } else {
            session.setAttribute( "isConnected", false );
            request.getRequestDispatcher( " index.jsp" ).forward( request, response );
        }
		doGet(request, response);
	}

}
