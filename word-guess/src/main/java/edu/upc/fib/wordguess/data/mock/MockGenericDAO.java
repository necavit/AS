package edu.upc.fib.wordguess.data.mock;

import edu.upc.fib.wordguess.data.dao.GenericDAO;

public abstract class MockGenericDAO<T> implements GenericDAO<T> {

	//no store, update or delete methods, because they are implemented
	// on the concrete mock controllers
	
}
