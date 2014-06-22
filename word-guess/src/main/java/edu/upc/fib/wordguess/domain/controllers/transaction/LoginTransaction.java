package edu.upc.fib.wordguess.domain.controllers.transaction;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Player;

/*
 *aquesta classe hereda de transaccio i l'implementa amb les funcionalitats del
 *controlador de fer autentificacio d'un usuari
 */

public class LoginTransaction implements Transaction<Boolean> {

	private String username;
	private String password;
	
	public LoginTransaction(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	/**
	 * agafa una instancia del jugador amb el username que s'ha rebut a la constructora
	 * i comprova si te la mateixa contrasenya que l'atribut de la classe
	 * llen�a la excepcio de contrasenya no valida
	 * 
	 * retrna un boolea que indica si el login es correcre
	 */
	public Boolean execute() throws PlayerNotExistsException, InvalidPasswordException {
		//data controllers acquisition
		DAOFactory dataFactory = PostgresDAOFactory.getInstance();
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
