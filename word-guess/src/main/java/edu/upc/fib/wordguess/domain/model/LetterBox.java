package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name=LetterBox.TABLE)
@IdClass(value=LetterBoxPK.class)
public class LetterBox implements Serializable {
	/**
	 * Classe java corresponent a la classe "Casella" del model de classes de domini
	 * */
	public static final String TABLE = "letter_box";
	
	private static final long serialVersionUID = -6982945784764306460L;
	
	@Id
	@Column
	private int position;
	
	public static final String MATCH_ID = "matchId";
	
	@Id
	@ManyToOne
	@JoinColumn
	private int matchId;
	
	@Column(nullable=false)
	private char correctLetter;
	
	@Column
	private Boolean success;
	
	
	private List<Character> wrongLetters;

	public LetterBox() {
		//
	}
	
	public LetterBox(int matchId, int position, char correctLetter) {
		this.matchId = matchId;
		this.position = position;
		this.correctLetter = correctLetter;
		this.success = false;
		this.wrongLetters = new ArrayList<Character>();
		//TODO store this!!
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
		//TODO update on dao
	}
	
	public int getMatchId() {
		return matchId;
	}
	
	public void setMatchId(int matchId) {
		this.matchId = matchId;
		//TODO update on dao
	}

	public char getCorrectLetter() {
		return correctLetter;
	}

	public void setCorrectLetter(char correctLetter) {
		this.correctLetter = correctLetter;
		//TODO update on dao
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success =  success;
		//TODO update on dao
	}

	public boolean checkLetter(char letter){
		setSuccess(letter == this.correctLetter);
		if (!success) {
			wrongLetters.add(letter);
		}
		return this.success;
	}	
}
