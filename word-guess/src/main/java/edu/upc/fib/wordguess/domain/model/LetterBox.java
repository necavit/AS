package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.List;

public class LetterBox implements Serializable {

	private static final long serialVersionUID = -6982945784764306460L;

	private int position;
	
	private char correctLetter;
	
	private Boolean success;
	
	private List<Character> wrongLetters;

	public LetterBox(int position, char correctLetter) {
		this.position = position;
		this.correctLetter = correctLetter;
	}
	
	public LetterBox(int position, char correctLetter, Boolean success) {
		this.position = position;
		this.correctLetter = correctLetter;
		this.success = success;
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

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<Character> getWrongLetters() {
		return wrongLetters;
	}

	public void setWrongLetters(List<Character> wrongLetters) {
		this.wrongLetters = wrongLetters;
	}
	
}
