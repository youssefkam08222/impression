package tn.iit.models;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne", discriminatorType=DiscriminatorType.STRING)

public class Personne implements Serializable {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String mp;
	
	public Personne() {
		super();
	}
	public Personne(int id, String nom, String prenom,String login, String mp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login=login;
		this.mp = mp;		
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
	    return val == null ? null : val.value();
	}

}
