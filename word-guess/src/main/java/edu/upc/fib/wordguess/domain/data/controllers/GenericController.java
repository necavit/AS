package edu.upc.fib.wordguess.domain.data.controllers;

import java.util.List;

public interface GenericController<T> {
	
	public List<T> getAll();
	
}
