package edu.upc.fib.wordguess.data.postgres;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.GenericDAO;
import edu.upc.fib.wordguess.util.HibernateUtil;

public abstract class PostgresGenericDAO<T> implements GenericDAO<T> {

	@Override
	public T store(T object) throws Exception {
		//open session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//transaction
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return object;
	}
	
	@Override
	public T update(T object) throws Exception {
		//open session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//transaction
		session.beginTransaction();
		session.merge(object);
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return object;
	}
	
	@Override
	public T delete(T object) throws Exception {
		//open session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//transaction
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return object;
	}
	
}
