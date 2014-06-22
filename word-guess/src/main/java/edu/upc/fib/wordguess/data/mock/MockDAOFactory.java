package edu.upc.fib.wordguess.data.mock;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.dao.WordDAO;

/**
 * MockDAOFactory provides centralized access to domain object
 *  DAOs (Data Access Object).
 *  
 * It is a DAOFactory interface implementation and returns DAOs
 * 	which are mocking the persistency application layer, in the
 *  sense that no real persistency is achieved. Objects can still
 *  be accessed the same way as if they had been stored in a database,
 *  but they are simply mocked in-memory.
 *  
 * Please refer to each MockDAO for further details on the mocking
 * strategy.
 */
public class MockDAOFactory implements DAOFactory {

	/* **** **** MEMBERS ***** **** */
	
	private MatchDAO matchDAO = null;
	
	private WordDAO wordDAO = null;
	
	private CategoryDAO categoryDAO = null;
	
	private PlayerDAO playerDAO = null;

	private RegisteredUserDAO registeredUserDAO = null;

	private ParamsDAO paramsDAO = null;
	
	/* **** **** SINGLETON MEMBER & METHODS ***** **** */
	
	private static MockDAOFactory instance = null;
	
	private MockDAOFactory() {
		//empty constructor
	}
	
	public static MockDAOFactory getInstance() {
		if (instance == null) instance = new MockDAOFactory();
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
		if (categoryDAO == null) categoryDAO = new MockCategoryDAO();
		return categoryDAO;
	}
	
	@Override
	public MatchDAO getMatchDAO() {
		if (matchDAO == null) matchDAO = new MockMatchDAO();
		return matchDAO;
	}
	
	@Override
	public PlayerDAO getPlayerDAO() {
		if (playerDAO == null) playerDAO = new MockPlayerDAO();
		return playerDAO;
	}
	
	@Override
	public WordDAO getWordDAO() {
		if (wordDAO == null) wordDAO = new MockWordDAO();
		return wordDAO;
	}
	
	@Override
	public RegisteredUserDAO getRegisteredUserDAO() {
		if (registeredUserDAO  == null) registeredUserDAO = new MockRegisteredUserDAO();
		return registeredUserDAO;
	}
	
	@Override
	public ParamsDAO getParamsDAO() {
		if (paramsDAO  == null) paramsDAO = new MockParamsDAO();
		return paramsDAO;
	}
	
}
