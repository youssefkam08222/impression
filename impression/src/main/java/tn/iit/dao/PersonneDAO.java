package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.idao.IPersonneDAO;
import tn.iit.models.AgentDeTirage;
import tn.iit.models.Enseignant;
import tn.iit.models.Personne;
import tn.iit.utils.HibernateUtil;

public class PersonneDAO implements IPersonneDAO {

	@Override
	public void save(Personne personne) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.persist(personne);
		trx.commit();
		
	}

	@Override
	public void updateStatus(int id, Boolean status) {
		// TODO Auto-generated method stub
		Personne p = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("From Personne u Where u.id=:id ");
		query.setParameter("id", id);
		List<Personne> listUser = query.getResultList();
		if(!listUser.isEmpty())
		 p= listUser.get(0);
		if (p != null)
			if(p instanceof AgentDeTirage)
				
			{p = new AgentDeTirage();
			AgentDeTirage agent =(AgentDeTirage)p;
		    agent.setActive(status);
		     session.merge(agent);
		     trx.commit();}
			else if( p instanceof Enseignant)
			{
				{p = new Enseignant();
				Enseignant ens =(Enseignant)p;
			    ens.setActive(status);
			     session.merge(ens);
			     trx.commit();}
			}
		
	}

	@Override
	public void update(Personne personne) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.merge(personne);
		trx.commit();		
	}

	@Override
	public List<Personne> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Personne p");
		List<Personne> listUser = query.getResultList();
		if (!listUser.isEmpty())
		  return listUser;
		
		return null;
	}

	@Override
	public Personne findByLoginPwd(String login, String pwd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Personne u Where u.login=:log and u.mp=:mp");
		query.setParameter("log", login).setParameter("mp", pwd);
		List<Personne> listUser = query.getResultList();
		if(!listUser.isEmpty())
		return listUser.get(0);
		return null;
		
	}

	@Override
	public Personne findByID(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From Personne u Where u.id=:id");
		query.setParameter("id",id);
		List<Personne> listUser = query.getResultList();
		if(!listUser.isEmpty())
		return listUser.get(0);
		return null;
	}

}
