package edu.upc.fib.wordguess.domain.data.controllers;

import edu.upc.fib.wordguess.domain.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public interface RegisteredUserController extends GenericController<RegisteredUser> {

	public RegisteredUser getUser(String username) throws UsernameNotExists;
	
}
