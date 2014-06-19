package edu.upc.fib.wordguess.data.exception;

public class CategoryNotExists extends Exception{

	// ? 
	//private static final long serialVersionUID = -7395751392493347458L;
	
	public CategoryNotExists() {
		super();
	}
	
	public CategoryNotExists( String message ){
		super(message);
	}
}
