package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.idao.IDemandeTirageDAO;
import tn.iit.models.DemandeTirage;
import tn.iit.utils.HibernateUtil;

public class DemandeTirageDAO implements IDemandeTirageDAO {

	@Override
	public void save(DemandeTirage demandeTirage) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.persist(demandeTirage);
		trx.commit();
		
	}

	@Override
	public void delete(int id) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		DemandeTirage demandeTirage = session.get(DemandeTirage.class, id);
		if (demandeTirage != null)
			session.delete(demandeTirage);
		trx.commit();		
	}

	@Override
	public List<DemandeTirage> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From DemandeTirage DT");
		List<DemandeTirage> listDemandes = query.getResultList();
		return listDemandes;
	}

	@Override
	public DemandeTirage findByID(int idDemande) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From DemandeTirage dt Where dt.idDemande=:idDemande");
		query.setParameter("idDemande", idDemande);
		List<DemandeTirage> listUser = query.getResultList();
		if(!listUser.isEmpty())
			return listUser.get(0);
		return null;
	}

}
