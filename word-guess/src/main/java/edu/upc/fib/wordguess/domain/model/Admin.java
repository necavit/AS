package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

public class Admin extends RegisteredUser implements Serializable {

	private static final long serialVersionUID = 4243456577935380231L;

	private String telephone;
	
	public Admin(String name, String surname, String username, String password, String telephone) {
		initialize(name, surname, username, password);
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
