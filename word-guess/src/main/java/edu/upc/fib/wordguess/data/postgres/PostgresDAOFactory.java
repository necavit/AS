package edu.upc.fib.wordguess.data.postgres;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.dao.WordDAO;

/**
 * PostgresDAOFactory provides centralized access to domain object
 *  DAOs (Data Access Object).
 *  
 * It is a DAOFactory interface implementation and returns DAOs
 * 	which are usign an Object-Relational-Mapping strategy to achieve
 *  persistency. The ORM used is Hibernate and the underlying database
 *  used is PostgreSQL.
 */
public class PostgresDAOFactory implements DAOFactory {
	
	/* **** **** MEMBERS ***** **** */
	
	private MatchDAO matchDAO = null;
	
	private WordDAO wordDAO = null;
	
	private CategoryDAO categoryDAO = null;
	
	private PlayerDAO playerDAO = null;

	private RegisteredUserDAO registeredUserDAO = null;

	private ParamsDAO paramsDAO = null;
	
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
	/*
	 * All methods below provide an implementation for the 
	 *  DAOFactory interface. See the Javadoc provided for
	 *  each method in the interface file.
	 */
	
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
	
	@Override
	public ParamsDAO getParamsDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
