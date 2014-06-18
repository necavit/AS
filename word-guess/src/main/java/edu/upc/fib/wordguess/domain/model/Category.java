package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 7847291535698838393L;

	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
