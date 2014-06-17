package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.domain.model.Word;


public interface WordDAO extends GenericDAO<Word> {

	public Word get(String name);
	
	public boolean exists(String name);
	
}
