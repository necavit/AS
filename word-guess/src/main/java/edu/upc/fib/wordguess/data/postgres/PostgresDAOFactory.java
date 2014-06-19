package edu.upc.fib.wordguess.data.postgres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public class PostgresDAOFactory implements DAOFactory {

	/* **** **** MEMBERS ***** **** */
	private RegisteredUserDAO registeredUserDAO = null;
	
	private MatchDAO matchDAO = null;
	
	private WordDAO wordDAO = null;
	
	private CategoryDAO categoryDAO = null;
	
	private PlayerDAO playerDAO = null;
	
	/* **** **** SINGLETON MEMBER & METHODS ***** **** */
	
	private static PostgresDAOFactory instance = null;
	
	private PostgresDAOFactory() {
		//TODO get a DB connection
		//TODO initialize registeredUserController
		//TODO add other controllers and initialize them
		
		//FIXME delete this mocked UserController:
		registeredUserDAO = new RegisteredUserDAO() {
			
			private Map<String, RegisteredUser> users = new HashMap<String, RegisteredUser>(){{
				put("john.doe", new Player("John", "Doe", "john.doe", "john.doe.pass", "john.doe@example.com"));
				put("testuser", new Player("Test", "User", "testuser", "test1234", "testuser@example.com"));
			}};
			
			@Override
			public List<RegisteredUser> getAll() {
				List<RegisteredUser> usersList = new ArrayList<RegisteredUser>(users.size());
				for (Entry<String, RegisteredUser> entry : users.entrySet()) {
					usersList.add(entry.getValue());
				}
				return usersList;
			}
			
			@Override
			public RegisteredUser getUser(String username) throws UsernameNotExists {
				if (users.containsKey(username)) {
					RegisteredUser user = users.get(username);
					return user;
				}
				else {
					throw new UsernameNotExists();
				}
			}

			@Override
			public boolean exists(String username) {
				return users.containsKey(username);
			}
		};
	}
	
	public static PostgresDAOFactory getInstance() {
		if (instance == null) instance = new PostgresDAOFactory();
		return instance;
	}
	
	/* **** **** PUBLIC METHODS ***** **** */
	@Override
	public RegisteredUserDAO getRegisteredUserDAO() {
		// TODO replace with real implementation
		return registeredUserDAO;
	}
	
	@Override
	public CategoryDAO getCategoryDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MatchDAO getMatchDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PlayerDAO getPlayerDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public WordDAO getWordDAO() {
		if (wordDAO == null) wordDAO = new PostgresWordDAO();
		return wordDAO;
	}
	
}
