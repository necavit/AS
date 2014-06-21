package edu.upc.fib.wordguess.service.exception;

public class NoSuchServiceException extends Exception {

	private static final long serialVersionUID = -6191445505409231422L;
	
	public NoSuchServiceException() {
		super();
	}

	public NoSuchServiceException(String message) {
		super(message);
	}
	
}
