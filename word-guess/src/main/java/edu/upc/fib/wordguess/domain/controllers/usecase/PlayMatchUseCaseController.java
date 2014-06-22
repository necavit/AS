package edu.upc.fib.wordguess.domain.controllers.usecase;

import java.util.List;

import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.exception.CategoryNotExistsException;
import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;
import edu.upc.fib.wordguess.domain.controllers.transaction.FetchCategoriesTransaction;
import edu.upc.fib.wordguess.domain.controllers.transaction.LoginTransaction;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;
import edu.upc.fib.wordguess.service.ServiceLocator;
import edu.upc.fib.wordguess.service.notification.NotificationService;
import edu.upc.fib.wordguess.util.Log;

/**
 *
 */

public class PlayMatchUseCaseController {
	
	private static final String TAG = PlayMatchUseCaseController.class.getSimpleName();
	
	/**
	 * The username of the current Player
	 */
	private String username;
	
	/**
	 * The current Player (needed to send the notification email)
	 */
	private Player player;
	
	/**
	 * The current match being created and played
	 */
	private Match match;
	
	
	public PlayMatchUseCaseController() {
		//
	}
	
	/**
	 * play a letter and check the match values, so if the user wins, the user receives an
	 * email with the information of the match played 
	 * 
	 * @param position
	 * @param letter
	 * @return
	 */
	public PlayLetterInfoTuple playLetter(int position, char letter) {
		Log.debug(TAG, "play letter: " + letter);
		boolean success = match.play(position, letter);
		if (match.isFinished() && match.isWon()) {
			NotificationService notificationService = null;
			try {
				notificationService = 
						(NotificationService) ServiceLocator.getInstance().find(ServiceLocator.SERVICE_NOTIFICATION);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (notificationService != null) {
				notificationService.notifyWonMatch(player.getName() + " " + player.getSurname(),
												   player.getEmail(), 
												   match.getWordName(), 
												   match.getScore(), 
												   match.getNumErrors());
			}
		}
		return new PlayLetterInfoTuple(success, match.isFinished(), match.isWon(),
									   match.getScore(), match.getNumErrors());
	}
	
	/**
	 * uses the login transaction controller to autenticate a user, it throws the
	 * possible exceptions the loginTransaction may throw
	 * 
	 * @param username
	 * @param pass
	 * @return
	 * @throws PlayerNotExistsException
	 * @throws InvalidPasswordException
	 */
	public boolean authenticate(String username, String pass) throws PlayerNotExistsException, InvalidPasswordException {
		Log.debug(TAG, "authenticate username: " + username);
		this.username = username;
		LoginTransaction login = new LoginTransaction(username, pass);
		return login.execute();
	}
	
	
	/**
	 * given the name of a category, it creates a match with its player, word and letterboxes 
	 * 
	 * @param categoryName
	 * @return
	 */
	public MatchInfoTuple createMatch(String categoryName) {
		Log.debug(TAG, "create match for category: " + categoryName);
		DAOFactory daoFactory = MockDAOFactory.getInstance();
		
		//retrieve the player that is to be assigned to the new match
		PlayerDAO playerDAO = daoFactory.getPlayerDAO();
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
		
		//retrieve the global game parameters
		ParamsDAO paramsDAO = daoFactory.getParamsDAO();
		WordGuessParams params = paramsDAO.getParams();
		
		Word word = category.getRandomWord();
		
		try {
			match = new Match(params, player, word);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (match != null) {
			return match.getMatchInfoTuple();
		}
		else {
			return null;
		}
	}
	
	
	/**
	 * 
	 * @return all the catgories of the system
	 */
	public List<Category> fetchCategories() {
		Log.debug(TAG, "fetch categories");
		FetchCategoriesTransaction fetchCategories = new FetchCategoriesTransaction();
		return fetchCategories.execute();
	}
	
	/**
	 * 
	 * @return the word of the match
	 */
	public String getMatchWord() {
		String matchWord = match.getWordName();
		Log.debug(TAG, "match word: " + matchWord);
		return matchWord;
	}
	
	/**
	 * set the match as finished
	 */
	public void stopMatch() {
		Log.debug(TAG, "stop match");
		this.match.stop();
	}
}
