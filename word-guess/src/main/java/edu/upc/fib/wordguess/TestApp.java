package edu.upc.fib.wordguess;

import org.hibernate.Session;

import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class TestApp {

	public static void main( String[] args ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Word word = new Word("giraffe");
		Match match = new Match(1, word);
		
		session.save(word);
		session.save(match);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
	}
	
}
