package tn.iit.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.dao.DemandeTirageDAO;
import tn.iit.dao.PersonneDAO;
import tn.iit.models.DemandeTirage;
import tn.iit.models.Enseignant;

/**
 * Servlet implementation class DemandeTirageController
 */
public class DemandeTirageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DemandeTirageDAO demandeTirageDAO;
	private PersonneDAO personneDAO;
	
	public void init() {
		demandeTirageDAO= new DemandeTirageDAO();
		personneDAO = new PersonneDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeTirageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertDemande(request, response);
                    break;
                case "/delete":
                    deleteDemande(request, response);
                    break;
                default:
                    listDemandes(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listDemandes(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List <DemandeTirage> listDemandes = demandeTirageDAO.getAll();
		        request.setAttribute("listDemandes", listDemandes);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("demandes-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("demande-form.jsp");
		        dispatcher.forward(request, response);
		    }
	private void insertDemande(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ParseException {
		        String matiere = request.getParameter("matiere");
		        String groupe = request.getParameter("groupe");
		        int nb_copies = Integer.parseInt(request.getParameter("nb_copies"));
		        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
		        Calendar date_arrivee = Calendar.getInstance();
		        date_arrivee.setTime(sdf.parse(request.getParameter("date_arrivee")));
		        Enseignant enseignant = (Enseignant) personneDAO.findByID(Integer.parseInt(request.getParameter("idPersonne")));
		        DemandeTirage newDemande = new DemandeTirage(matiere, groupe, nb_copies, date_arrivee,enseignant);
		        demandeTirageDAO.save(newDemande);
		        response.sendRedirect("list");
		    }
	private void deleteDemande(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int idDemande = Integer.parseInt(request.getParameter("idDemande"));
		        demandeTirageDAO.delete(idDemande);
		        response.sendRedirect("list");
		    }

}
