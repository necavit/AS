package edu.upc.fib.wordguess.data.exception;

public class MatchNotExistsException extends Exception {

	private static final long serialVersionUID = 7597094288905421200L;

	public MatchNotExistsException() {
		super();
	}
	
	public MatchNotExistsException(String message) {
		super(message);
	}
	
}
