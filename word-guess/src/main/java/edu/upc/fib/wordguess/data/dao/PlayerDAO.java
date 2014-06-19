package edu.upc.fib.wordguess.data.dao;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.model.Player;

public interface PlayerDAO extends GenericDAO<Player> {

	public Player get(String username) throws PlayerNotExistsException;
	
	public boolean exists(String username);
	
}
