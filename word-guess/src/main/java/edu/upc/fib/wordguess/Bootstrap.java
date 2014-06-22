package edu.upc.fib.wordguess;

import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;

public class Bootstrap {

	/**
	 * Utility method to initialize the database, in case it was the
	 * first time the program is run.
	 */
	public static void appBootstrap() {
		if (!databaseFilled()) {
			try {
				//word-guess global params
				// DO NOT DELETE THIS - it would break the whole program
				createParams();
				
				//categories and words in each category
				Category test = createCategory("Test");
					createWord("test", test);
					
				Category mobles = createCategory("Mobles");
					createWord("cadira", mobles);
					createWord("armari", mobles);
					createWord("llit", mobles);
					createWord("taula", mobles);
					createWord("prestatge", mobles);
				
				Category transports = createCategory("Transports");
					createWord("cotxe", transports);
					createWord("vaixell", transports);
					createWord("moto", transports);
					createWord("bici", transports);
					
				//players
				createPlayer("David", "Martínez", "david", "test", "gollumdeagol@gmail.com");
				createPlayer("Daniel", "Ariñez", "daniel", "test", "daniel.arinez92@gmail.com");
				createPlayer("Miquel", "Masriera", "miquel", "test", "miquelmasriera@gmail.com");
				createPlayer("Marcel", "Pujol", "marcel", "test", "pujy25@gmail.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Assess whether or not the database has been initialized.
	 * To do so, a query for the application persistent global
	 * parameters is issued (they are singleton and univoquely
	 * accessible). If the query returns no objects, then the
	 * database has to be pre-filled with data.
	 * 
	 * @return true if the database has already been initialized;
	 * false otherwise.
	 */
	private static boolean databaseFilled() {
		ParamsDAO paramsDAO = PostgresDAOFactory.getInstance().getParamsDAO();
		return paramsDAO.getParams() != null;
	}
	
	private static void createParams() {
		int maxErrorsCount = 10;
		int nextMatchId = 1;
		try {
			new WordGuessParams(maxErrorsCount, nextMatchId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Category createCategory(String name) {
		Category category = null;
		try {
			category = new Category(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	private static void createWord(String name, Category category) {
		try {
			new Word(name, category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createPlayer(String name, String surname, String username, String password, String email) {
		try {
			new Player(name, surname, username, password, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
