package tn.iit.models;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DemandeTirage {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDemande;
	private String matiere;
	private String groupe;
	private int nb_copies;
	private Calendar date_arrivee;
	
	@ManyToOne  
	@JoinColumn( name="idPersonne" )
    private Enseignant enseignant;
	
	public DemandeTirage() {
		super();
	}

	public DemandeTirage(int idDemande, String matiere, String groupe, int nb_copies, Calendar date_arrivee, Enseignant enseiganant) {
		super();
		this.idDemande = idDemande;
		this.matiere = matiere;
		this.groupe = groupe;
		this.nb_copies = nb_copies;
		this.date_arrivee = date_arrivee;
		this.enseignant = enseiganant;
	}
	
	public DemandeTirage(String matiere, String groupe, int nb_copies, Calendar date_arrivee, Enseignant enseiganant) {
		super();
		this.matiere = matiere;
		this.groupe = groupe;
		this.nb_copies = nb_copies;
		this.date_arrivee = date_arrivee;
		this.enseignant = enseiganant;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public int getIdIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int id) {
		this.idDemande = id;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public int getNb_copies() {
		return nb_copies;
	}

	public void setNb_copies(int nb_copies) {
		this.nb_copies = nb_copies;
	}

	public Calendar getDate_arrivee() {
		return date_arrivee;
	}

	public void setDate_arrivee(Calendar date_arrivee) {
		this.date_arrivee = date_arrivee;
	}
	
	public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Demande de >> " ).append( this.enseignant )
               .append( " - " ).append( this.date_arrivee ).append( "\n" );
        return builder.toString();
    }   
	
		

}
