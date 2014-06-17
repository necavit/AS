package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public interface RegisteredUserDAO extends GenericDAO<RegisteredUser> {

	public RegisteredUser getUser(String username) throws UsernameNotExists;
	
	public boolean exists(String username);
	
}
