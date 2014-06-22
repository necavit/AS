package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.List;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;
import edu.upc.fib.wordguess.domain.model.Category;

public class FetchCategoriesTransaction implements Transaction< List<Category> > {
		
	public FetchCategoriesTransaction(){
		// 
	}
	
	@Override
	public List<Category> execute(){
		//data controllers acquisition
		CategoryDAO categoryDAO = MockDAOFactory.getInstance().getCategoryDAO();
		return categoryDAO.getAll();
	}
	
}
