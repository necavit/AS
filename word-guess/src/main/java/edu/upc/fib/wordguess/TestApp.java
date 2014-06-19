package edu.upc.fib.wordguess;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.model.Player;


public class TestApp {
    
	public static void main( String[] args ) {    	
    	PlayerDAO dao = PostgresDAOFactory.getInstance().getPlayerDAO();
    	
    	try {
    		if (!dao.exists("john.doe")) {
    			Player player = new Player("John", "Doe", "john.doe", "passsss", "john@doe.com");
    			dao.store(player);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	Player john = null;
    	try {
    		john = dao.get("john.doe");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (john != null) {
    		System.out.println("john is: " + john.getEmail());
    	}
    }
	
}
