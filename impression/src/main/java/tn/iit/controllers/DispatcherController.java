package tn.iit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tn.iit.dao.PersonneDAO;
import tn.iit.models.Personne;
import tn.iit.models.PersonneType;



public class DispatcherController  extends HttpServlet{
	
	static PersonneDAO dao = new PersonneDAO();
	   static Logger log = Logger.getLogger(DispatcherController.class.getName());  
	   private static String URL="http://localhost:8080/impression";

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static String getPersonneType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 

{
		String login = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if ( login.equals("admin") && pwd.equals("admin"))
		{
			return PersonneType.ADMINISTRATEUR;
		}
		else {
			Personne p = dao.findByLoginPwd(login, pwd);
			if (p!= null) {
				return p.getDiscriminatorValue();
				
			}
			else return PersonneType.UNKNOWN;
			
		}
	
}
	
	
	
	public  void goToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (this.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
			
		{
			response.sendRedirect(URL+"/user-list.jsp");


			
		}
		else {
			this.goToNotAuthorized(request, response);
		}
		
	}
	
	public  void goToAjout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (this.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
			
		{
			response.sendRedirect(URL+"/user-form.jsp");



			
		}
		else {
			this.goToNotAuthorized(request, response);
		}
	}

	
	public  void goToAuth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (this.getPersonneType(request, response).equals(PersonneType.UNKNOWN))
			
		{
			response.sendRedirect(URL+"/auth.jsp");


			
		}
		
	}
	
	
	public  void goHomePAge( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		if (this.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
		{
			
	

			response.sendRedirect(URL+"/user-list.jsp");
			
			//getServletContext().getRequestDispatcher("/user-list.jsp").forward(request, response);

		}

		else if (this.getPersonneType(request, response).equals(PersonneType.TYPE_ENSEIGANT))
			
		{
			response.sendRedirect(URL+"/homeEnseignant.jsp");


			
		}
		else if (this.getPersonneType(request, response).equals(PersonneType.TYPE_AGENT_TIRAGE))
			response.sendRedirect(URL+"/homeAgentTirage.jsp");


		else {
			this.goToNotAuthorized(request, response);
		}
		
	}
	

	public  void goToNotFound(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(URL+"/not-found.jsp");


	}
	
	public  void goToNotAuthorized( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		response.sendRedirect(URL+"/not-auth.jsp");

		

	}
	


}
