package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.domain.model.WordGuessParams;

public interface ParamsDAO extends GenericDAO<WordGuessParams> {

	public WordGuessParams getParams();
	
}
