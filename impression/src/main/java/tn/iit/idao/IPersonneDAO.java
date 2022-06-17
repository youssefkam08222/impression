package tn.iit.idao;

import java.util.List;

import tn.iit.models.Personne;

public interface IPersonneDAO {
	
	void save(Personne personne);

	void activer(Personne personne);
	
	void desactiver (Personne personne);

	void update(Personne personne);

	List<Personne> getAll();

	Personne findByLoginPwd(String login, String pwd);
	
	Personne findByID (int id);

}
