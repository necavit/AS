package edu.upc.fib.wordguess;

import org.hibernate.Session;

import edu.upc.fib.wordguess.domain.model.FooHibernateEntityTest;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class App {

	public static void main( String[] args ) {
		System.out.println( "Hello World!" );
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//FIXME data is not persisted, or so it seems... using pgAdmin data is not stored on the 'public' schema
		session.beginTransaction();
		FooHibernateEntityTest testEntity = new FooHibernateEntityTest(123, "one_two_three");
		session.save(testEntity);
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
		System.out.println("Closing... Goodbye!");
	}
	
}
