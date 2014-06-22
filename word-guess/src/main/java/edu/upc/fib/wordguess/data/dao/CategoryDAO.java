package edu.upc.fib.wordguess.data.dao;


import edu.upc.fib.wordguess.data.exception.CategoryNotExistsException;
import edu.upc.fib.wordguess.domain.model.Category;

/**
 * Category Data Access Object.
 * It provides methods to access Category objects from the database.
 */
public interface CategoryDAO extends GenericDAO<Category>{

	/**
	 * Retrieves a Category from the database, given its name.
	 * @param name the name of the Category
	 * @return the stored Category
	 * @throws CategoryNotExistsException if no such Category was stored
	 */
	public Category get(String name) throws CategoryNotExistsException;
	
	/**
	 * Returns true if a Category with name "name" is stored in the database
	 * (false otherwise)
	 * @param name the name of the Category
	 * @return true if it is stored; false otherwise
	 */
	public boolean exists(String name);
	
}
