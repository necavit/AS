package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.List;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.model.Category;

public class FetchCategoriesTransaction implements Transaction< List<Category> > {
		
	public FetchCategoriesTransaction(){
		// 
	}
	
	@Override
	public List<Category> execute(){
		//data controllers acquisition
		CategoryDAO categoryDAO = PostgresDAOFactory.getInstance().getCategoryDAO();
		return categoryDAO.getAll();
	}
	
}
