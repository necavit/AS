package edu.upc.fib.wordguess.data.dao;


import edu.upc.fib.wordguess.data.exception.CategoryNotExistsException;
import edu.upc.fib.wordguess.domain.model.Category;

public interface CategoryDAO extends GenericDAO<Category>{

	public Category get(String name) throws CategoryNotExistsException;
	
	public boolean exists(String name);
	
}
