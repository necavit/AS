package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.exception.UserNotExistsException;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresRegisteredUserDAO extends PostgresGenericDAO<RegisteredUser> implements RegisteredUserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegisteredUser> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<RegisteredUser> words = (List<RegisteredUser>) session.createQuery("from " + RegisteredUser.TABLE_USER).list();
				
		session.close();
		
		return words;
	}

	@Override
	public RegisteredUser getUser(String username) throws UserNotExistsException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		RegisteredUser user = (RegisteredUser) session.get(RegisteredUser.class, username);
		if (user == null) {
			session.close();
			throw new UserNotExistsException();
		}
		
		session.close();
		return user;
	}

	@Override
	public boolean exists(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean exists = (session.get(RegisteredUser.class, username) != null) ? true : false;
		
		session.close();
		
		return exists;
	}

}
