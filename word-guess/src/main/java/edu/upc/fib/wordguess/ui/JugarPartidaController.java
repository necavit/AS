package edu.upc.fib.wordguess.ui;

import java.util.ArrayList;
import java.util.List;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.controllers.usecase.JugarPartidaUseCasController;
import edu.upc.fib.wordguess.domain.controllers.usecase.MatchInfoTuple;
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
			logged = jpuc.ferAutentificacio(username, pass);
		} catch (PlayerNotExistsException e) {
			jpv.mostraMissatge("L'usuari no existeix", 0);
		} catch (InvalidPasswordException e) {
			jpv.mostraMissatge("La contrassenya és incorrecta", 0);
		}
		
		List<Category> cats = jpuc.obtenirCategories();
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
		MatchInfoTuple matchInfo = jpuc.crearPartida(categoryName);		
		idPartida = matchInfo.matchId;
		jpv.mostraPuntuacions(matchInfo.scoreOnSuccess, matchInfo.scoreOnError);
		jpv.mostraPuntuacioActual(matchInfo.currentScore);
		jpv.mostraErrorsActuals(0, matchInfo.maximumErrorCount);
		jpv.creaParaula(jpuc.getMatchWord().length());
	}
	
	public void PrAturarPartida(){
		jpv.aturaPartida();
	}
	
	public void PrComprovar(int pos, String lletra){
		ArrayList<Object> infop = jpuc.ferJugada(pos, lletra.charAt(0) , idPartida);
		boolean encert = (boolean) infop.get(0);
		boolean acabada = (boolean) infop.get(1);
		boolean guanyada = (boolean) infop.get(2);
		int puntuacio = (int) infop.get(4);
		int errors = (int) infop.get(3);
		if (acabada) jpv.finalitzarPartida(guanyada);
		jpv.marcaCasella(encert);
		jpv.mostraPuntuacioActual(puntuacio);
		jpv.actualitzaErrors(errors);
	}
		
	public void PrTancarPartida(){
		System.exit(-1);
	}

}
