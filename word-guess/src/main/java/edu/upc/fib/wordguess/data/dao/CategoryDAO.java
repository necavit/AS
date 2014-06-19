package edu.upc.fib.wordguess.data.dao;


import edu.upc.fib.wordguess.data.exception.CategoryNotExists;
import edu.upc.fib.wordguess.domain.model.Category;

public interface CategoryDAO extends GenericDAO<Category>{

	//getall no overwritte
	
	public Category getCategory( String  name ) throws CategoryNotExists;
	
}
