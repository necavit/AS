package edu.upc.fib.wordguess.data;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.dao.WordDAO;

/**
 * DAOFactory provides centralized access to domain object
 *  DAOs (Data Access Object).
 *  
 * Please note that this is just an interface. Refer to class
 *  implementations to know more about the things they do.
 */
public interface DAOFactory {
	
	/**
	 * Retrieves a WordDAO, to be able to query the persistency
	 * layer for Word objects.
	 * 
	 * @return an implementation of WordDAO
	 */
	public WordDAO getWordDAO();
	
	/**
	 * Retrieves a MatchDAO, to be able to query the persistency
	 * layer for Match objects.
	 * 
	 * @return an implementation of MatchDAO
	 */
	public MatchDAO getMatchDAO();
	
	/**
	 * Retrieves a PlayerDAO, to be able to query the persistency
	 * layer for Player objects.
	 * 
	 * @return an implementation of PlayerDAO
	 */
	public PlayerDAO getPlayerDAO();
	
	/**
	 * Retrieves a CategoryDAO, to be able to query the persistency
	 * layer for Category objects.
	 * 
	 * @return an implementation of CategoryDAO
	 */
	public CategoryDAO getCategoryDAO();

	/**
	 * Retrieves a RegisteredUserDAO, to be able to query the persistency
	 * layer for RegsiteredUser objects.
	 * 
	 * @return an implementation of RegisteredUserDAO
	 */
	public RegisteredUserDAO getRegisteredUserDAO();

	/**
	 * Retrieves a ParamsDAO, to be able to query the persistency
	 * layer for WordGuessParams objects.
	 * 
	 * @return an implementation of ParamsDAO
	 */
	public ParamsDAO getParamsDAO();
	
}
