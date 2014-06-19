package edu.upc.fib.wordguess.data.exception;

public class PlayerNotExistsException extends Exception {

	private static final long serialVersionUID = 2782380404125467811L;

	public PlayerNotExistsException() {
		super();
	}
	
	public PlayerNotExistsException(String message) {
		super(message);
	}
	
}
