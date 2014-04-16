package edu.upc.fib.wordguess.domain.model;

public class Player extends RegisteredUser {

	private String email;

	public Player(String name, String surname, String username, String password, String email) {
		initialize(name, surname, username, password);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
