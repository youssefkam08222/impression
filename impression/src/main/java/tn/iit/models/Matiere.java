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
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatiere;
	private String nom;

	@ManyToMany
	@JoinTable(name = "Table_join_M_G",
			   joinColumns = { @JoinColumn(name = "idMatiere") },
			   inverseJoinColumns = {@JoinColumn(name = "idGroupe") })
	private List<Groupe> subGroupes = new ArrayList<>();

	public Matiere() {
		super();
	}

	public Matiere(int idMatiere, String nom) {
		super();
		this.idMatiere = idMatiere;
		this.nom = nom;
	}

	public int getId() {
		return idMatiere;
	}

	public void setId(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Groupe> getSubGroupes() {
		return subGroupes;
	}

	public void setSubGroupes(List<Groupe> subGroupes) {
		this.subGroupes = subGroupes;
	}

}
