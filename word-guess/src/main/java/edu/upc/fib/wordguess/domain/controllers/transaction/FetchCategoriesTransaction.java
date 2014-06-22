package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.List;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;
import edu.upc.fib.wordguess.domain.model.Category;

/*
 *aquesta classe hereda de transaccio i l'implementa mab les funcionalitats del
 *controlador de llistar les categories del sitema
 */

public class FetchCategoriesTransaction implements Transaction< List<Category> > {
		
	public FetchCategoriesTransaction(){
		// 
	}
	
	@Override
	/**
	 * retorna totes les instancies de categoria
	 */
	public List<Category> execute(){
		//data controllers acquisition
		CategoryDAO categoryDAO = MockDAOFactory.getInstance().getCategoryDAO();
		return categoryDAO.getAll();
	}
	
}
