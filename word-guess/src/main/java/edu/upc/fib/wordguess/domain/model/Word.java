package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=Word.TABLE)
public class Word implements Serializable {

	private static final long serialVersionUID = -7024212638179206833L;

	public static final String TABLE = "word";
	
	@Id
	@Column
	private String name;
	
	@Column
	private int numLetters;
	
	public Word(String name) {
		this.name = name;
		this.numLetters = name.length();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.numLetters = name.length();
	}

	public int getNumLetters() {
		return numLetters;
	}
	
}
