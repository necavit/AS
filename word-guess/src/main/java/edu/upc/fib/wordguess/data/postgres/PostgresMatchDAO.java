package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.exception.MatchNotExistsException;
import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresMatchDAO extends PostgresGenericDAO<Match> implements MatchDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Match> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Match> matches = (List<Match>) session.createQuery("from " + Match.TABLE).list();
				
		session.close();
		
		return matches;
	}

	@Override
	public Match get(int matchId) throws MatchNotExistsException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Match match = (Match) session.get(Match.class, matchId);
		if (match == null) {
			session.close();
			throw new MatchNotExistsException();
		}
		
		session.close();
		return match;
	}

	@Override
	public boolean exists(int matchId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean exists = (session.get(Match.class, matchId) != null) ? true : false;
		
		session.close();
		
		return exists;
	}

}
