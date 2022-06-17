package tn.iit.idao;

import java.util.List;

import tn.iit.models.Groupe;

public interface IGroupe {
	void save(Groupe groupe);

	void delete(Groupe groupe);

	void update(Groupe groupe);

	List<Groupe> getAll();

	Groupe findByID(int idGroupe);

}
