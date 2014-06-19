package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.upc.fib.wordguess.util.HibernateUtil;

@Entity
@Table(name=LetterBox.TABLE)
@IdClass(value=LetterBoxPK.class)
public class LetterBox implements Serializable {

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
	
	
	//TODO private List<Character> wrongLetters;

	public LetterBox() {
		//
	}
	
	public LetterBox(int matchId, int position, char correctLetter) {
		this.matchId = matchId;
		this.position = position;
		this.correctLetter = correctLetter;
		this.success = null;
		HibernateUtil.store(this);
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getMatchId() {
		return matchId;
	}
	
	public void setMatchId(int matchId) {
		this.matchId = matchId;
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

	/*
	public List<Character> getWrongLetters() {
		return wrongLetters;
	}

	public void setWrongLetters(List<Character> wrongLetters) {
		this.wrongLetters = wrongLetters;
	}
	*/
	
}
