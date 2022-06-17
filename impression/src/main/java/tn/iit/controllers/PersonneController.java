package tn.iit.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.PersonneDAO;
import tn.iit.models.Personne;
import tn.iit.models.PersonneType;

@WebServlet("/personne")
public class PersonneController extends HttpServlet {

	/*** 
	 */
	static PersonneDAO dao = new PersonneDAO();
	static AuthController auth = new AuthController();
	static DispatcherController dispatcher = new DispatcherController();
	private static final long serialVersionUID = 1L;



	protected void  addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Personne currentUser = (Personne) session.getAttribute("u");
		
		if (dispatcher.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
		{
			dao.save(currentUser);
			dispatcher.goHomePAge(request, response);
		}
		else {
			dispatcher.goToNotAuthorized(request, response);
		}


	}
	
	
	
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        doGet(request, response);
			    }
	
	
	
	
	  

	    private void listPersonne(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
			if (dispatcher.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
			{
	        List < Personne > listUser = dao.getAll();
	        request.setAttribute("listUser", listUser);
	        dispatcher.goHomePAge(request, response);}
			else dispatcher.goToNotAuthorized(request, response);
	    }
	    
	    
	    private void updateStatus(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	    	
			if (dispatcher.getPersonneType(request, response).equals(PersonneType.ADMINISTRATEUR))
			{
	    	
	    	HttpSession session = request.getSession();
			Personne currentUser = (Personne) session.getAttribute("u");
			Boolean status = (Boolean) session.getAttribute("status");

	        dao.updateStatus(currentUser.getId(), status);
	        dispatcher.goHomePAge(request, response);}
			
			else 
				dispatcher.goToNotAuthorized(request, response);
	     	
	    }
	  
	     
	    
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, ServletException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        Personne existingUser = dao.findByID(id);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	    	        request.setAttribute("user", existingUser);
	    	        dispatcher.forward(request, response);

	    	    }
	    
		    
	    
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        String action = request.getServletPath();

			        try {
			            switch (action) {
			              
			                case "/insert":
			                	addUser(request, response);
			                    break;
			                case "/updateStatus":
			                    updateStatus(request, response);
			                    break;
			                case "/edit":
			                    showEditForm(request, response);
			                    break;
			               
			                case "/list":
			                    listPersonne(request, response);
			                    break;
			                default:
			                	dispatcher.goToNotFound(request, response);
			            }
			        } catch (SQLException ex) {
			            throw new ServletException(ex);
			        }
			    }
	
	
	
	

}
