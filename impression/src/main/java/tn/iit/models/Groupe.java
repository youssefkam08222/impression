package tn.iit.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGroupe;
	private String nom;

	@ManyToMany
	@JoinTable(name = "Table_join_M_G", 
			   joinColumns = { @JoinColumn(name = "idGroupe") },
			   inverseJoinColumns = {@JoinColumn(name = "idMatiere") })
	private List<Matiere> subMatieres = new ArrayList<>();

	public Groupe() {
		super();

	}

	public Groupe(int idGroupe, String nom) {
		super();
		this.idGroupe = idGroupe;
		this.nom = nom;
	}

	public int getId() {
		return idGroupe;
	}

	public void setId(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Matiere> getSubMatieres() {
		return subMatieres;
	}

	public void setSubMatieres(List<Matiere> subMatieres) {
		this.subMatieres = subMatieres;
	}

}
