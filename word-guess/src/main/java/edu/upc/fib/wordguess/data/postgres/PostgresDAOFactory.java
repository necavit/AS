package edu.upc.fib.wordguess.data.postgres;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.dao.WordDAO;

public class PostgresDAOFactory implements DAOFactory {

	/* **** **** MEMBERS ***** **** */
	
	private MatchDAO matchDAO = null;
	
	private WordDAO wordDAO = null;
	
	private CategoryDAO categoryDAO = null;
	
	private PlayerDAO playerDAO = null;

	private RegisteredUserDAO registeredUserDAO = null;
	
	/* **** **** SINGLETON MEMBER & METHODS ***** **** */
	
	private static PostgresDAOFactory instance = null;
	
	private PostgresDAOFactory() {
		//empty constructor
	}
	
	public static PostgresDAOFactory getInstance() {
		if (instance == null) instance = new PostgresDAOFactory();
		return instance;
	}
	
	/* **** **** PUBLIC METHODS ***** **** */
	@Override
	public CategoryDAO getCategoryDAO() {
		if (categoryDAO == null) categoryDAO = new PostgresCategoryDAO();
		return categoryDAO;
	}
	
	@Override
	public MatchDAO getMatchDAO() {
		if (matchDAO == null) matchDAO = new PostgresMatchDAO();
		return matchDAO;
	}
	
	@Override
	public PlayerDAO getPlayerDAO() {
		if (playerDAO == null) playerDAO = new PostgresPlayerDAO();
		return playerDAO;
	}
	
	@Override
	public WordDAO getWordDAO() {
		if (wordDAO == null) wordDAO = new PostgresWordDAO();
		return wordDAO;
	}
	
	@Override
	public RegisteredUserDAO getRegisteredUserDAO() {
		if (registeredUserDAO  == null) registeredUserDAO = new PostgresRegisteredUserDAO();
		return registeredUserDAO;
	}
	
}
