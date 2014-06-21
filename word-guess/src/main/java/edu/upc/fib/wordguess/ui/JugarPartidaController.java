package edu.upc.fib.wordguess.ui;

import java.util.ArrayList;
import java.util.List;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.controllers.usecase.JugarPartidaUseCasController;
import edu.upc.fib.wordguess.domain.controllers.usecase.MatchInfoTuple;
import edu.upc.fib.wordguess.domain.controllers.usecase.PlayLetterInfoTuple;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Category;

public class JugarPartidaController {
	
	private JugarPartidaView jpv;
	private JugarPartidaUseCasController jpuc;
	private int idPartida;
	
	public JugarPartidaController () {
		jpuc = new JugarPartidaUseCasController();
		jpv = new JugarPartidaView(this);		
	}
	
	public void inicialitza () {
		jpv.setVisible(true);	
	}
				
	public boolean PrLogin(String username,String pass){
		boolean logged = false;
		try {
			logged = jpuc.authenticate(username, pass);
		} catch (PlayerNotExistsException e) {
			jpv.mostraMissatge("L'usuari no existeix", 0);
		} catch (InvalidPasswordException e) {
			jpv.mostraMissatge("La contrassenya és incorrecta", 0);
		}
		
		List<Category> cats = jpuc.fetchCategories();
		jpv.mostraCategories(cats);
		//Capturar Excepcio no hi ha categories
		if (cats.size() == 0) {
			jpv.mostraMissatge("No hi ha Categories", 1);
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
	public void PrJugar(String categoryName) {
		MatchInfoTuple matchInfo = jpuc.createMatch(categoryName);		
		idPartida = matchInfo.matchId;
		jpv.mostraPuntuacions(matchInfo.scoreOnSuccess, matchInfo.scoreOnError);
		jpv.mostraPuntuacioActual(matchInfo.currentScore);
		jpv.mostraErrorsActuals(0, matchInfo.maximumErrorCount);
		jpv.creaParaula(jpuc.getMatchWord().length());
	}
	
	public void PrAturarPartida(){
		jpv.aturaPartida();
	}
	
	public void PrComprovar(int pos, String lletra) {
		PlayLetterInfoTuple playInfo = jpuc.playLetter(pos, lletra.charAt(0));
		if (playInfo.isFinished) {
			jpv.finalitzarPartida(playInfo.isWon);
		}
		jpv.marcaCasella(playInfo.success);
		jpv.mostraPuntuacioActual(playInfo.currentScore);
		jpv.actualitzaErrors(playInfo.numErrors);
	}
		
	public void PrTancarPartida(){
		System.exit(-1);
	}

}
