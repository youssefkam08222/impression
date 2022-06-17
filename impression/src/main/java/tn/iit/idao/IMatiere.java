package tn.iit.idao;

import java.util.List;

import tn.iit.models.Matiere;

public interface IMatiere {
	void save(Matiere matiere);

	void delete(Matiere matiere);

	void update(Matiere matiere);

	List<Matiere> getAll();

	Matiere findByID(int idMatiere);	
}
