package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.ArrayList;

import edu.upc.fib.wordguess.data.DataControllersFactory;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;

public class CheckCategoriesTransaction implements Transaction< ArrayList<String> > {
	
	private ArrayList<String> categories;
	
	public CheckCategoriesTransaction(){
		categories = new ArrayList<String>(); 
	}
	
	@Override
	public ArrayList<String> execute(){
		
		ArrayList<String> result = new ArrayList<String>();
		//data controllers acquisition
		DataControllersFactory dataFactory = DataControllersFactory.getInstance();
		
		
		return result;
	}
	
}
