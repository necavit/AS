package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresWordDAO implements WordDAO {
	
	@Override
	public boolean exists(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean exists = (session.get(Word.class, name) != null) ? true : false;
		
		session.close();
		
		return exists;
	}
	
	@Override
	public Word get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Word> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
