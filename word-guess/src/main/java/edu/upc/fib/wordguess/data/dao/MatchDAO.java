package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.MatchNotExistsException;
import edu.upc.fib.wordguess.domain.model.Match;

/**
 * Match Data Access Object.
 * It provides methods to access Match objects from the database.
 */
public interface MatchDAO extends GenericDAO<Match> {

	/**
	 * Retrieves a Match from the database, given its id.
	 * @param matchId the id of the Match
	 * @return the stored Match
	 * @throws MatchNotExistsException if no such Match was stored
	 */
	public Match get(int matchId) throws MatchNotExistsException;
	
	/**
	 * Returns true if a Match with id "id" is stored in the database
	 * (false otherwise)
	 * @param name the name of the Match
	 * @return true if it is stored; false otherwise
	 */
	public boolean exists(int matchId);
	
}
