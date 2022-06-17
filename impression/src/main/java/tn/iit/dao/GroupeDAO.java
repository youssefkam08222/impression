package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.idao.IGroupe;
import tn.iit.models.Groupe;
import tn.iit.utils.HibernateUtil;

public class GroupeDAO implements IGroupe {

	@Override
	public void save(Groupe groupe) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.persist(groupe);
		trx.commit();
	}

	@Override
	public void delete(Groupe groupe) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.delete(groupe);
		trx.commit();
	}

	@Override
	public void update(Groupe groupe) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.merge(groupe);
		trx.commit();
	}

	@Override
	public List<Groupe> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Groupe g");
		List<Groupe> listGroupe = query.getResultList();
		return listGroupe;
	}

	@Override
	public Groupe findByID(int idGroupe) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Groupe g Where g.idGroupe=:idGroupe");
		query.setParameter("idGroupe", idGroupe);
		List<Groupe> listGroupe = query.getResultList();
		if(!listGroupe.isEmpty())
		return listGroupe.get(0);
		return null;
	}

}


	


