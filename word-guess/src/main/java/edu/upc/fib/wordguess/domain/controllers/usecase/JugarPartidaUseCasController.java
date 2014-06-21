package edu.upc.fib.wordguess.domain.controllers.usecase;

import java.util.List;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.exception.CategoryNotExistsException;
import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.controllers.transaction.FetchCategoriesTransaction;
import edu.upc.fib.wordguess.domain.controllers.transaction.LoginTransaction;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;
import edu.upc.fib.wordguess.util.Log;

//projecte extern
//import ws1.Mail;

public class JugarPartidaUseCasController {
	
	private static final String TAG = JugarPartidaUseCasController.class.getSimpleName();
	
	/**
	 * The username of the current Player
	 */
	private String username;
	
	/**
	 * The current match being created and played
	 */
	private Match match;
	
	
	public JugarPartidaUseCasController() {
		//
	}
	
	public PlayLetterInfoTuple playLetter(int position, char letter) {
		Log.debug(TAG, "play letter: " + letter);
		boolean success = match.play(position, letter);
		if (match.isFinished() && match.isWon()) {
			//TODO send mail
			//servei missatgeria 
			//m.getPlayer().getEmail();
			//String paraula = m.getWord().getName();
			// String numErr = Integer.toString(m.getNumErrors());
			//String punts = 
			//String contingut = "Partida Guanyada : Paraula="+paraula+" Punts="+punts+"  errors="+numErr;
			// Mail m = new Mail();
			//m.enviaMissatge2("miquelmasriera@gmail.com","CONTINGUT");
		}
		return new PlayLetterInfoTuple(success, match.isFinished(), match.isWon(),
									   match.getScore(), match.getNumErrors());
	}
	
	public boolean authenticate(String username, String pass) throws PlayerNotExistsException, InvalidPasswordException {
		Log.debug(TAG, "authenticate username: " + username);
		this.username = username;
		LoginTransaction login = new LoginTransaction(username, pass);
		return login.execute();
	}
	
	public MatchInfoTuple createMatch(String categoryName) {
		Log.debug(TAG, "create match for category: " + categoryName);
		DAOFactory daoFactory = PostgresDAOFactory.getInstance();
		
		//retrieve the player that is to be assigned to the new match
		PlayerDAO playerDAO = daoFactory.getPlayerDAO();
		Player player = null;
		try {
			player = playerDAO.get(username);
		} catch (PlayerNotExistsException e) {
			//this should never be the case, since this method (create match)
			// is only called after having been logged in
			e.printStackTrace();
		}
		
		//retrieve the category of the word that the match will have
		CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
		Category category = null;
		try {
			category = categoryDAO.get(categoryName);
		} catch (CategoryNotExistsException e) {
			//this should never be the case, since a valid and existing
			// category is chosen from the UI (it is a precondition)
			e.printStackTrace();
		}
		
		//retrieve the global game parameters //TODO this should be accessed from database
		WordGuessParams params = new WordGuessParams();
		
		match = new Match(params, player, category);
		return match.getMatchInfoTuple();
	}
	
	public List<Category> fetchCategories() {
		Log.debug(TAG, "fetch categories");
		FetchCategoriesTransaction fetchCategories = new FetchCategoriesTransaction();
		return fetchCategories.execute();
	}
	
	public String getMatchWord() {
		String matchWord = match.getWordName();
		Log.debug(TAG, "match word: " + matchWord);
		return matchWord;
	}
	
	public void stopMatch() {
		Log.debug(TAG, "stop match");
		this.match.stop();
	}
}
