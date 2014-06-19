package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.data.exception.WordNotExistsException;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresWordDAO extends PostgresGenericDAO<Word> implements WordDAO {
	
	@Override
	public boolean exists(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean exists = (session.get(Word.class, name) != null) ? true : false;
		
		session.close();
		
		return exists;
	}
	
	@Override
	public Word get(String name) throws WordNotExistsException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Word word = (Word) session.get(Word.class, name);
		if (word == null) {
			session.close();
			throw new WordNotExistsException();
		}
		
		session.close();
		return word;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Word> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Word> words = (List<Word>) session.createQuery("from " + Word.TABLE).list();
				
		session.close();
		
		return words;
	}
	
}
