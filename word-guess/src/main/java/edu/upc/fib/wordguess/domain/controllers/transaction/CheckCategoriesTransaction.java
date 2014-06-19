package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.ArrayList;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

public class CheckCategoriesTransaction implements Transaction< ArrayList<String> > {
	
	private ArrayList<String> categories;
	
	public CheckCategoriesTransaction(){
		categories = new ArrayList<String>(); 
	}
	
	@Override
	public ArrayList<String> execute(){
		
		ArrayList<String> result = new ArrayList<String>();
		//data controllers acquisition
		DAOFactory dataFactory = PostgresDAOFactory.getInstance();
		
		
		return result;
	}
	
}
