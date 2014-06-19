package edu.upc.fib.wordguess.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Retrieves a configurated Hibernate SessionFactory instance, shared
	 * among all application components.
	 * 
	 * @return the shared SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
	
	/**
	 * Stores a generic Object in the session retrieved by {@link getSessionFactory}.
	 * 
	 * @param object the Object to be stored
	 * @return the same Object that was passed in
	 */
	public static Object store(Object object) throws HibernateException {
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
	
	public static Object update(Object object) {
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
	
	public static void delete(Object object) {
		//open session
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//transaction
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		
		//close session
		session.close();
	}
}
