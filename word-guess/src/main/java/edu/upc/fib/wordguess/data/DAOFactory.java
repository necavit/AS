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
 * Please note that this is just an interface. 
 */
public interface DAOFactory {
	
	public WordDAO getWordDAO();
	
	public MatchDAO getMatchDAO();
	
	public PlayerDAO getPlayerDAO();
	
	public CategoryDAO getCategoryDAO();

	public RegisteredUserDAO getRegisteredUserDAO();

	public ParamsDAO getParamsDAO();
	
}
