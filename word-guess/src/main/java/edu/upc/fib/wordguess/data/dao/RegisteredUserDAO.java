package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.UserNotExistsException;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

/**
 * RegisteredUser Data Access Object.
 * It provides methods to access RegisteredUser objects from the database.
 */
public interface RegisteredUserDAO extends GenericDAO<RegisteredUser> {

	/**
	 * Retrieves a RegisteredUser from the database, given its username.
	 * @param username the username of the RegisteredUser
	 * @return the stored RegisteredUser
	 * @throws UserNotExistsException if no such RegisteredUser was stored
	 */
	public RegisteredUser getUser(String username) throws UserNotExistsException;
	
	/**
	 * Returns true if a RegisteredUser with username "username" is stored in the database
	 * (false otherwise)
	 * @param username the username of the RegisteredUser
	 * @return true if it is stored; false otherwise
	 */
	public boolean exists(String username);
	
}
