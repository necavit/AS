package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.domain.model.WordGuessParams;

/**
 * WordGuessParams Data Access Object.
 * It provides methods to access WordGuessParams objects from the database.
 */
public interface ParamsDAO extends GenericDAO<WordGuessParams> {

	/**
	 * Returns the only instance of the global WordGuessParams
	 * stored in the database (it is a singleton class)
	 * @return the global WordGuessParams stored
	 */
	public WordGuessParams getParams();
	
}
