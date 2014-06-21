package edu.upc.fib.wordguess.domain.controllers.transaction;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Player;

public class LoginTransaction implements Transaction<Boolean> {

	private String username;
	private String password;
	
	public LoginTransaction(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public Boolean execute() throws PlayerNotExistsException, InvalidPasswordException {
		//data controllers acquisition
		PostgresDAOFactory dataFactory = PostgresDAOFactory.getInstance();
		PlayerDAO userController = dataFactory.getPlayerDAO();
		
		//fetch user
		Player user = userController.get(username);
		
		//if no UsernameNotExists has yet been propagated,
		// the user exists -> check password
		if (!password.equals(user.getPassword())) {
			throw new InvalidPasswordException();
		}
		return true;
	}
}
