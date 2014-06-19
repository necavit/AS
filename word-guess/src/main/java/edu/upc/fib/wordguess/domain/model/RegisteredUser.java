package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

public abstract class RegisteredUser implements Serializable {
	
	private static final long serialVersionUID = -283532121656300725L;
	
	public static final String TABLE_USER = "registered_user";

	private String name;
	
	private String surname;

	private String username;
	
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void initialize(String name, String surname, String username, String password) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}
	
}
