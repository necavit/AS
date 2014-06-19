package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.UserNotExistsException;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public interface RegisteredUserDAO extends GenericDAO<RegisteredUser> {

	public RegisteredUser getUser(String username) throws UserNotExistsException;
	
	public boolean exists(String username);
	
}
