package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.WordNotExistsException;
import edu.upc.fib.wordguess.domain.model.Word;

/**
 * Word Data Access Object.
 * It provides methods to access Word objects from the database.
 */
public interface WordDAO extends GenericDAO<Word> {

	/**
	 * Retrieves a Word from the database, given its name.
	 * @param name the name of the Word
	 * @return the stored Word
	 * @throws WordNotExistsException if no such Word was stored
	 */
	public Word get(String name) throws WordNotExistsException;
	
	/**
	 * Returns true if a Word with name "name" is stored in the database
	 * (false otherwise)
	 * @param name the name of the Word
	 * @return true if it is stored; false otherwise
	 */
	public boolean exists(String name);
	
}
