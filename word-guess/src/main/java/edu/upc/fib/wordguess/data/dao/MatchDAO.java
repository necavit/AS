package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.domain.model.Match;

public interface MatchDAO extends GenericDAO<Match> {

	public Match get(String name);
	
	public boolean exists(String name);
	
}
