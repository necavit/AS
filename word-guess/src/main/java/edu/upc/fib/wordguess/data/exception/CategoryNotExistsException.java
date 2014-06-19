package edu.upc.fib.wordguess.data.exception;

public class CategoryNotExistsException extends Exception {

	private static final long serialVersionUID = -7395751392493347458L;
	
	public CategoryNotExistsException() {
		super();
	}
	
	public CategoryNotExistsException(String message){
		super(message);
	}
}
