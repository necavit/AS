package edu.upc.fib.wordguess.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;

@Entity
@Table(name=WordGuessParams.TABLE)
public class WordGuessParams {
	/**
	 * Classe java corresponent a la classe "Par�metres" del model de classes de domini
	 * */
	public static final String TABLE = "word_guess_params";
	
	@Id
	@Column
	private String id = WordGuessParams.class.getSimpleName();
	
	@Column
	private int maxErrorsCount;
	
	@Column
	private int nextMatchId;
	
	public WordGuessParams() {
		//
	}
	
	private static ParamsDAO dao = MockDAOFactory.getInstance().getParamsDAO();
	
	public WordGuessParams(int maxErrorsCount, int nextMatchId) throws Exception {
		this.maxErrorsCount = maxErrorsCount;
		this.nextMatchId = nextMatchId;
		dao.store(this);
	}
	
	public int getMaxErrorsCount() {
		return maxErrorsCount;
	}
	
	public void setMaxErrorsCount(int maxErrorsCount) {
		this.maxErrorsCount = maxErrorsCount;
		try {
			dao.update(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNextMatchId() {
		int next = nextMatchId;
		setNextMatchId(nextMatchId + 1);
		return next;
	}
	
	private void setNextMatchId(int nextMatchId) {
		this.nextMatchId = nextMatchId;
		try {
			dao.update(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}
	
}
