package edu.upc.fib.wordguess.data.exception;

public class UserNotExistsException extends Exception {

	private static final long serialVersionUID = -7395751392493347458L;
	
	public UserNotExistsException() {
		super();
	}
	
	public UserNotExistsException(String message) {
		super(message);
	}

}
