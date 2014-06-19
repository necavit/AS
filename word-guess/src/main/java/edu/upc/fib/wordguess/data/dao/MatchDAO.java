package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.MatchNotExistsException;
import edu.upc.fib.wordguess.domain.model.Match;

public interface MatchDAO extends GenericDAO<Match> {

	public Match get(int matchId) throws MatchNotExistsException;
	
	public boolean exists(int matchId);
	
}
