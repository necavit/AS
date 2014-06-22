package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import edu.upc.fib.wordguess.data.dao.LetterBoxDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

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

	private static LetterBoxDAO dao = PostgresDAOFactory.getInstance().getLetterBoxDAO();
	
	public LetterBox() {
		//
	}
	
	public LetterBox(int position, char correctLetter) throws Exception {
		this.position = position;
		this.correctLetter = correctLetter;
		this.success = false;
		//this.wrongLetters = new ArrayList<Character>();
		//dao.store(this);
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) throws Exception {
		this.position = position;
		//dao.update(this);
	}

	public char getCorrectLetter() {
		return correctLetter;
	}

	public void setCorrectLetter(char correctLetter) throws Exception {
		this.correctLetter = correctLetter;
		//dao.update(this);
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) throws Exception {
		this.success =  success;
		//dao.update(this);
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
