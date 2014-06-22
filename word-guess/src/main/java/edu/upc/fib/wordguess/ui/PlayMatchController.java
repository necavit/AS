package edu.upc.fib.wordguess.ui;

import java.util.ArrayList;
import java.util.List;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.controllers.usecase.PlayMatchUseCaseController;
import edu.upc.fib.wordguess.domain.controllers.usecase.MatchInfoTuple;
import edu.upc.fib.wordguess.domain.controllers.usecase.PlayLetterInfoTuple;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Category;

public class PlayMatchController {
	
	private PlayMatchView jpv;
	private PlayMatchUseCaseController jpuc;
	private int idPartida;
	
	public PlayMatchController () {
		jpuc = new PlayMatchUseCaseController();
		jpv = new PlayMatchView(this);		
	}
	
	public void initialize() {
		jpv.setVisible(true);	
	}
				
	public boolean PrLogin(String username,String pass){
		boolean logged = false;
		try {
			logged = jpuc.authenticate(username, pass);
		} catch (PlayerNotExistsException e) {
			jpv.showMessage("L'usuari no existeix", 0);
		} catch (InvalidPasswordException e) {
			jpv.showMessage("La contrassenya és incorrecta", 0);
		}
		
		List<Category> cats = jpuc.fetchCategories();
		jpv.loadCategories(cats);
		//Capturar Excepcio no hi ha categories
		if (cats.size() == 0) {
			jpv.showMessage("No hi ha Categories", 1);
		}
		
		return logged;
	}
	
	public void PrLogout(){
		//No fa res
	}
	
	/**
	 * Creates a new match taking a word from the given category.
	 * 
	 * @param categoryName
	 */
	public void PrStartMatch(String categoryName) {
		MatchInfoTuple matchInfo = jpuc.createMatch(categoryName);		
		idPartida = matchInfo.matchId;
		jpv.loadPointsPer(matchInfo.scoreOnSuccess, matchInfo.scoreOnError);
		jpv.updateCurrentScoring(matchInfo.currentScore);
		jpv.updateErrorCount(0, matchInfo.maximumErrorCount);
		jpv.buildWord(jpuc.getMatchWord().length());
	}
	
	public void PrStopMatch(){
		System.out.println("JugarPartidaController.PrAturarPartida()");
		jpuc.stopMatch();
	}
	
	public void PrCheck(int pos, String lletra) {
		PlayLetterInfoTuple playInfo = jpuc.playLetter(pos, lletra.charAt(0));
		jpv.markLetterBox(playInfo.success);
		if (playInfo.isFinished) {
			jpv.finishMatch(playInfo.isWon);
		}
		jpv.updateCurrentScoring(playInfo.currentScore);
		jpv.updateErrors(playInfo.numErrors);
	}
		
	public void PrFinishGame(){
		System.exit(-1);
	}

}
