package tn.iit.idao;

import java.util.List;

import tn.iit.models.Personne;

public interface IPersonneDAO {
	
	void save(Personne personne);
	
	void updateStatus (int id, Boolean status);

	void update(Personne personne);

	List<Personne> getAll();

	Personne findByLoginPwd(String login, String pwd);
	
	Personne findByID (int id);

}
