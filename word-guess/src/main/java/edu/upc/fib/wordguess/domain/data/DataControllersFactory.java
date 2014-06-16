package edu.upc.fib.wordguess.domain.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upc.fib.wordguess.domain.data.controllers.RegisteredUserController;
import edu.upc.fib.wordguess.domain.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public class DataControllersFactory {

	/* **** **** MEMBERS ***** **** */
	private RegisteredUserController registeredUserController;
	
	/* **** **** SINGLETON MEMBER & METHODS ***** **** */
	
	private static DataControllersFactory instance = null;
	
	private DataControllersFactory() {
		//TODO get a DB connection
		//TODO initialize registeredUserController
		//TODO add other controllers and initialize them
		
		//FIXME delete this mocked UserController:
		registeredUserController = new RegisteredUserController() {
			
			@Override
			public List<RegisteredUser> getAll() {
				List<RegisteredUser> users = new ArrayList<RegisteredUser>();
				RegisteredUser john = new Player("John", "Doe", "john.doe", "john.doe.pass", "john.doe@example.com");
				RegisteredUser test = new Player("Test", "User", "testuser", "test1234", "testuser@example.com");
				users.add(john);
				users.add(test);
				return users;
			}
			
			@Override
			public RegisteredUser getUser(String username) throws UsernameNotExists {
				Map<String, RegisteredUser> users = new HashMap<String, RegisteredUser>();
				RegisteredUser john = new Player("John", "Doe", "john.doe", "john.doe.pass", "john.doe@example.com");
				RegisteredUser test = new Player("Test", "User", "testuser", "test1234", "testuser@example.com");
				users.put("john.doe", john);
				users.put("testuser", test);
				if (users.containsKey(username)) {
					RegisteredUser user = users.get(username);
					return user;
				}
				else {
					throw new UsernameNotExists();
				}
			}
		};
	}
	
	public static DataControllersFactory getInstance() {
		if (instance == null) instance = new DataControllersFactory();
		return instance;
	}
	
	/* **** **** METHODS ***** **** */
	
	public RegisteredUserController getRegisteredUserController() {
		return registeredUserController; 
	}
	
}
