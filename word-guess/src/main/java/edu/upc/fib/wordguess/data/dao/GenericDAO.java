package edu.upc.fib.wordguess.data.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public List<T> getAll();
		
}
