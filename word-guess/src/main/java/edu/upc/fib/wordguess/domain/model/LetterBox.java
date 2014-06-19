package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name=LetterBox.TABLE)
@IdClass(LetterBoxPK.class)
public class LetterBox implements Serializable {

	public static final String TABLE = "letter_box";
	
	private static final long serialVersionUID = -6982945784764306460L;

	@Id
	@Column
	private int position;
	
	@Id
	@Column
	private int matchId;
	
	@Column(nullable=false)
	private char correctLetter;
	
	@Column
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
		this.success =  success;
	}

	public List<Character> getWrongLetters() {
		return wrongLetters;
	}

	public void setWrongLetters(List<Character> wrongLetters) {
		this.wrongLetters = wrongLetters;
	}
	
}
