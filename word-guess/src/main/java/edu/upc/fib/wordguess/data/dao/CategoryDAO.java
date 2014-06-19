package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.domain.model.Category;

public interface CategoryDAO extends GenericDAO<Category> {

	public Category get(String name);
	
	public boolean exists(String name);
	
}
