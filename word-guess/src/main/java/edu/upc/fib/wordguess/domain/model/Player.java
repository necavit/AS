package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

public class Player extends RegisteredUser implements Serializable {

	private static final long serialVersionUID = 2249987917128104143L;
	
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
