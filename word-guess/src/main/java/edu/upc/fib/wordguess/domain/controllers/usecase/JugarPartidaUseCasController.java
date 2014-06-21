package edu.upc.fib.wordguess.domain.controllers.usecase;

import java.util.ArrayList;
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
import edu.upc.fib.wordguess.domain.model.MatchInfoTuple;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;
import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategy;
import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategyFactory;

//projecte extern
//import ws1.Mail;

public class JugarPartidaUseCasController {
	
	/**
	 * The username of the current Player
	 */
	private String username;
	
	/**
	 * The current match being created and played
	 */
	private Match match;
	
	private int numEncerts;
	
	public JugarPartidaUseCasController() {
		numEncerts = 0;
	}
	
	public ArrayList<Object> ferJugada(int pos, char lletra, int idPartida) {
		ArrayList<Object> infojugada = new ArrayList<Object>();
		boolean encert,acabada,guanyada;
		int puntuacio,errors;
		encert=match.play(pos,lletra);
		guanyada = match.isWon();
		acabada = match.isFinished();
		
		if(encert) {
			++numEncerts;
			if(match.isWon()) {
				System.out.print("Partida Finalitzada");
				//servei missatgeria 
				//m.getPlayer().getEmail();
				//String paraula = m.getWord().getName();
				// String numErr = Integer.toString(m.getNumErrors());
				//String punts = 
				//String contingut = "Partida Guanyada : Paraula="+paraula+" Punts="+punts+"  errors="+numErr;
				
				// Mail m = new Mail();
				//m.enviaMissatge2("miquelmasriera@gmail.com","CONTINGUT");
				
			}
		}
		else {
			//Fer la comprobacio si supera nmaximerrors
		}
		
		errors = match.getNumErrors();
		puntuacio = 3; // ESTRATEGIA
		
		infojugada.add(encert);
		infojugada.add(acabada);
		infojugada.add(guanyada);
		infojugada.add(errors);
		infojugada.add(puntuacio);
		return infojugada;
	}
	
	public boolean ferAutentificacio(String username,String pass) throws PlayerNotExistsException, InvalidPasswordException {
		this.username = username;
		LoginTransaction login = new LoginTransaction(username, pass);
		return login.execute();
	}
	
	public MatchInfoTuple crearPartida(String categoryName) {
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
		
		//retrieve the global game parameters
		WordGuessParams params = new WordGuessParams();
		
		match = new Match(params, player, category);
		return match.getMatchInfoTuple();
	}
	
	
	public List<Category> obtenirCategories() {
		FetchCategoriesTransaction fetchCategories = new FetchCategoriesTransaction();
		return fetchCategories.execute();
	}
	
	public String getMatchWord() {
		return match.getWordName();
	}
	
	/**
	 * Use getMatchWord() instead, which retrieves the current match word.
	 */
	@Deprecated
	public String obteParaula(String cat) {
		return getMatchWord();
	}
	
}
