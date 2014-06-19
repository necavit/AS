package edu.upc.fib.wordguess.data.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public List<T> getAll();
	
	public T store(T object) throws Exception;
	
	public T update(T object) throws Exception;
	
	public T delete(T object) throws Exception;
		
}
