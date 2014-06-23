package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LetterBox implements Serializable {
	/**
	 * Classe java corresponent a la classe "Casella" del model de classes de domini
	 * */
	public static final String TABLE = "letter_box";
	
	private static final long serialVersionUID = -6982945784764306460L;
	
	@Column
	private int position;
		
	@Column(nullable=false)
	private char correctLetter;
	
	@Column
	private Boolean success;
	
	/*
	@ElementCollection
	  @CollectionTable(
	        name="wrong_letters",
	        joinColumns=@JoinColumn(name="letter_box")
	  )
	  @Column
	private List<Character> wrongLetters;
	*/
	
	public LetterBox() {
		//
	}
	
	public LetterBox(int position, char correctLetter) {
		this.position = position;
		this.correctLetter = correctLetter;
		this.success = null;
		//this.wrongLetters = new ArrayList<Character>();
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public char getCorrectLetter() {
		return correctLetter;
	}

	public void setCorrectLetter(char correctLetter) {
		this.correctLetter = correctLetter;
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success =  success;
	}

	public boolean checkLetter(char letter){
		try {
			setSuccess(letter == this.correctLetter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!success) {
			//wrongLetters.add(letter);
		}
		return this.success;
	}	
}
