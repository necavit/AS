package edu.upc.fib.wordguess.ui;

import java.util.List;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.data.exception.UserNotExistsException;
import edu.upc.fib.wordguess.domain.controllers.usecase.MatchInfoTuple;
import edu.upc.fib.wordguess.domain.controllers.usecase.PlayLetterInfoTuple;
import edu.upc.fib.wordguess.domain.controllers.usecase.PlayMatchUseCaseController;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Category;

/*
 Controlador de la capa de presentacio
 te un controlador de les vistes i el controlador de cas d'us de domini (associacions)
 */

public class PlayMatchController {
	
	private PlayMatchView jpv;
	private PlayMatchUseCaseController jpuc;
	private int idPartida;
	
	/**
	 * constructora per defecte
	 */
	public PlayMatchController () {
		jpuc = new PlayMatchUseCaseController();
		jpv = new PlayMatchView(this);		
	}
	
	/**
	 *arranca la interficie grafica 
	 */
	public void initialize() {
		jpv.setVisible(true);	
	}
				
	/**
	 * al premer el boto de login es comprovara si es pot loguejar
	 * en cas contrari es capturaran les excepcions corresponent
	 * tot i ser el login correcte aqui comprovem si el sistema disposa de categories
	 * per passar a la seguent vista
	 * 
	 * 
	 * @username
	 * 
	 * @pass
	 * */
	public boolean PrLogin(String username,String pass){
		boolean logged = false;
		try {
			logged = jpuc.authenticate(username, pass);
		} catch (UserNotExistsException e) {
			jpv.showMessage("L'usuari no existeix", 0);
		} catch (InvalidPasswordException e) {
			jpv.showMessage("La contrassenya és incorrecta", 0);
		}
		
		List<Category> cats = jpuc.fetchCategories();
		jpv.loadCategories(cats);
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
	 * @throws UserIsNotPlayerException 
	 */
	public void PrStartMatch(String categoryName) throws UserIsNotPlayerException {
		MatchInfoTuple matchInfo = null;
		try {
			matchInfo = jpuc.createMatch(categoryName);
		} catch (PlayerNotExistsException e) {
			throw new UserIsNotPlayerException();
		}		
		idPartida = matchInfo.matchId;
		jpv.loadPointsPer(matchInfo.scoreOnSuccess, matchInfo.scoreOnError);
		jpv.updateCurrentScoring(matchInfo.currentScore);
		jpv.updateErrorCount(0, matchInfo.maximumErrorCount);
		jpv.buildWord(jpuc.getMatchWord().length());
	}
	
	/**
	 * para la partida, retornara a la pantalla de seleccio de categories
	 */
	public void PrStopMatch(){
		System.out.println("JugarPartidaController.PrAturarPartida()");
		jpuc.stopMatch();
	}
	
	/**
	 * li passem una posicio i una lletra i el sistema comprova si es un encert
	 * i actualitza tot el que calgui a la partida
	 * 
	 * @param pos
	 * @param lletra
	 */
	public void PrCheck(int pos, String lletra) {
		PlayLetterInfoTuple playInfo = jpuc.playLetter(pos, lletra.charAt(0));
		jpv.markLetterBox(playInfo.success);
		if (playInfo.isFinished) {
			jpv.finishMatch(playInfo.isWon);
		}
		jpv.updateCurrentScoring(playInfo.currentScore);
		jpv.updateErrors(playInfo.numErrors);
	}
		
	/**
	 * tanca le programa un cop s'ha acabat el joc
	 */
	public void PrFinishGame(){
		System.exit(-1);
	}

}
