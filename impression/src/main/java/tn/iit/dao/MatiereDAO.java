package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.idao.IMatiere;
import tn.iit.models.Matiere;
import tn.iit.utils.HibernateUtil;

public class MatiereDAO implements IMatiere{

	@Override
	public void save(Matiere matiere) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.persist(matiere);
		trx.commit();
	}

	@Override
	public void delete(Matiere matiere) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.delete(matiere);
		trx.commit();
	}

	@Override
	public void update(Matiere matiere) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.merge(matiere);
		trx.commit();
	}

	@Override
	public List<Matiere> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Matiere m");
		List<Matiere> listMatiere = query.getResultList();
		return listMatiere;
	}

	@Override
	public Matiere findByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Matiere m Where m.id=:id");
		query.setParameter("id", id);
		List<Matiere> listMatiere = query.getResultList();
		if(!listMatiere.isEmpty())
		return listMatiere.get(0);
		return null;
	}

}
