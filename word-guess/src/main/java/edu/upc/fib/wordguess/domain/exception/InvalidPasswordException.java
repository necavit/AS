package edu.upc.fib.wordguess.domain.exception;

public class InvalidPasswordException extends Exception {

	private static final long serialVersionUID = 4082663299935063378L;
	
	public InvalidPasswordException() {
		super();
	}
	
	public InvalidPasswordException(String message) {
		super(message);
	}

}
