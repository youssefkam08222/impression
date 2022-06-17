package tn.iit.models;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Enseignant")
public class Enseignant extends Personne implements Serializable {
	
	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Enseignant() {
		super();
		
	}

	public Enseignant(int id, String nom, String prenom, String login, String mp, boolean active) {
		super(id, nom, prenom, login, mp);
		this.active = active;
		
	}

}
