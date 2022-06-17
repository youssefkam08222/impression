package tn.iit.idao;

import java.util.List;

import tn.iit.models.DemandeTirage;

public interface IDemandeTirageDAO {
	
	void save(DemandeTirage demandeTirage);
	
	void delete(int id);
	
	List<DemandeTirage> getAll();
	
	DemandeTirage findByID (int id);

}
