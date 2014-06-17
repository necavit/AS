package edu.upc.fib.wordguess.data.exception;

public class UsernameNotExists extends Exception {

	private static final long serialVersionUID = -7395751392493347458L;
	
	public UsernameNotExists() {
		super();
	}
	
	public UsernameNotExists(String message) {
		super(message);
	}

}
