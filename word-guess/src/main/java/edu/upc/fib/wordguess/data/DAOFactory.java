package edu.upc.fib.wordguess.data;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.dao.WordDAO;

public interface DAOFactory {

	public RegisteredUserDAO getRegisteredUserDAO();
	
	public WordDAO getWordDAO();
	
	public MatchDAO getMatchDAO();
	
	public PlayerDAO getPlayerDAO();
	
	public CategoryDAO getCategoryDAO();
	
}
