package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresPlayerDAO extends PostgresGenericDAO<Player> implements PlayerDAO {
	
	@Override
	public boolean exists(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean exists = (session.get(Player.class, username) != null) ? true : false;
		
		session.close();
		
		return exists;
	}
	
	@Override
	public Player get(String username) throws PlayerNotExistsException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Player player = (Player) session.get(Player.class, username);
		if (player == null) {
			session.close();
			throw new PlayerNotExistsException();
		}
		
		session.close();
		return player;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Player> players = (List<Player>) session.createQuery("from " + Player.class.getSimpleName()).list();
				
		session.close();
		
		return players;
	}
	
}
