package edu.upc.fib.wordguess.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public class DataControllersFactory {

	/* **** **** MEMBERS ***** **** */
	private RegisteredUserDAO registeredUserDAO;
	
	/* **** **** SINGLETON MEMBER & METHODS ***** **** */
	
	private static DataControllersFactory instance = null;
	
	private DataControllersFactory() {
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
	
	public static DataControllersFactory getInstance() {
		if (instance == null) instance = new DataControllersFactory();
		return instance;
	}
	
	/* **** **** METHODS ***** **** */
	
	public RegisteredUserDAO getRegisteredUserDAO() {
		return registeredUserDAO;
	}
	
}
