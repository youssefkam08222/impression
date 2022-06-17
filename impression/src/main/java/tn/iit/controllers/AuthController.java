package tn.iit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import tn.iit.dao.PersonneDAO;
import tn.iit.models.Personne;
import tn.iit.models.PersonneType;

@WebServlet("/auth")
public class AuthController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   static Logger log = Logger.getLogger(AuthController.class.getName());  


	 private static PersonneDAO dao = new PersonneDAO();
	 private static DispatcherController dispatcher = new DispatcherController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("username");
		String pwd = request.getParameter("password");
		log.info(getServletConfig());
		log.info(getServletContext());

		if (dispatcher.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
		      dispatcher.goHomePAge(request, response);

		else {
		Personne currentUser = dao.findByLoginPwd(login, pwd);
		if (currentUser == null) {
			request.setAttribute("error", "La personne n'est pas inscrite");
			dispatcher.goToNotAuthorized(request, response);
		} else
			dispatcher.goHomePAge(request, response);}
	}
	
	

}
