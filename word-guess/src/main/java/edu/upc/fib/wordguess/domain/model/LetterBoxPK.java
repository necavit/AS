package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

public class LetterBoxPK implements Serializable {

	private static final long serialVersionUID = -2730791475497868230L;

	private int position;
	
	private int matchId;
	
	public LetterBoxPK() {
		//
	}
	
	public LetterBoxPK(int position, int matchId) {
		this.position = position;
		this.matchId = matchId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LetterBoxPK) {
			LetterBoxPK pk = (LetterBoxPK) obj;
			return position == pk.position && matchId == pk.matchId; 
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return position + matchId;
	}
	
}
