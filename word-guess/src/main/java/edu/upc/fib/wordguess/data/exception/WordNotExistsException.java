package edu.upc.fib.wordguess.data.exception;

public class WordNotExistsException extends Exception {

	private static final long serialVersionUID = 8112024679684686637L;

	public WordNotExistsException() {
		super();
	}
	
	public WordNotExistsException(String message) {
		super(message);
	}
	
}
