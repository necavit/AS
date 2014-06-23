package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.LetterBoxDAO;
import edu.upc.fib.wordguess.domain.model.LetterBox;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresLetterBoxDAO extends PostgresGenericDAO<LetterBox> implements LetterBoxDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<LetterBox> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<LetterBox> letterBoxes = (List<LetterBox>) session.createQuery("from " + LetterBox.class.getSimpleName()).list();
				
		session.close();
		
		return letterBoxes;
	}
	
}
