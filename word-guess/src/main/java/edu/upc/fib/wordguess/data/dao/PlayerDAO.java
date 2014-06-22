package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.model.Player;

/**
 * Player Data Access Object.
 * It provides methods to access Player objects from the database.
 */
public interface PlayerDAO extends GenericDAO<Player> {

	/**
	 * Retrieves a Player from the database, given its username.
	 * @param username the username of the Player
	 * @return the stored Player
	 * @throws PlayerNotExistsException if no such Player was stored
	 */
	public Player get(String username) throws PlayerNotExistsException;
	
	/**
	 * Returns true if a Player with username "username" is stored in the database
	 * (false otherwise)
	 * @param name the name of the Player
	 * @return true if it is stored; false otherwise
	 */
	public boolean exists(String username);
	
}
