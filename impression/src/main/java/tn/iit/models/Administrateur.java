package tn.iit.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Personne implements Serializable {

	public Administrateur() {
		super();
	}

	public Administrateur(int id, String nom, String prenom, String login, String mp) {
		super(id, nom, prenom, login, mp);
	}

}
