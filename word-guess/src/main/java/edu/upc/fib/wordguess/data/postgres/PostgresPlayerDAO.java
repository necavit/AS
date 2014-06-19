package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresPlayerDAO implements PlayerDAO {
	
	private static PostgresPlayerDAO instance = null;
	
	private PostgresPlayerDAO() {
		//TODO retrieve DB connection or something!
	}
	
	public static PostgresPlayerDAO getInstance() {
		if (instance == null) instance = new PostgresPlayerDAO();
		return instance;
	}
	
	@Override
	public boolean exists(String username) {
		//TODO see if this is correct
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		boolean exists = true;
		try {
			session.get(Player.class, username);
		} catch (HibernateException he) {
			exists = false;
		}
		
		session.getTransaction().commit();
		session.close();
		
		return exists;
	}
	
	@Override
	public Player get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Player> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
