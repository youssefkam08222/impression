package tn.iit.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisconnectController
 */
@WebServlet("/disconnect")
public class DisconnectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private static DispatcherController dispatcher = new DispatcherController();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
this.dispatcher.goToAuth(request, response);	}

}
