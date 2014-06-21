package edu.upc.fib.wordguess.ui;

import java.util.ArrayList;
import java.util.List;

import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.controllers.usecase.JugarPartidaUseCasController;
import edu.upc.fib.wordguess.domain.exception.InvalidPasswordException;
import edu.upc.fib.wordguess.domain.model.Category;

public class JugarPartidaController {
	
	private JugarPartidaView jpv;
	private JugarPartidaUseCasController jpuc;
	private String username;
	private int idPartida;
	
	public JugarPartidaController () {
		jpuc = new JugarPartidaUseCasController();
		jpv = new JugarPartidaView(this);		
	}
	
	public void inicialitza () {
		jpv.setVisible(true);	
	}
				
	public boolean PrLogin(String username,String pass){
		this.username = username;
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
	
	public void PrJugar(String cat){
			ArrayList<Integer> infopartida = jpuc.crearPartida(cat, this.username);
			int pi = infopartida.get(0);
			int nme = infopartida.get(1);
			int pe = infopartida.get(2);
			int perr = infopartida.get(3);
			idPartida = infopartida.get(4);
			jpv.mostraPuntuacions(pe,perr);
			jpv.mostraPuntuacioActual(pi);
			jpv.mostraErrorsActuals(0, nme);
			String paraula = jpuc.obteParaula(cat);
			jpv.creaParaula(paraula.length());
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
		jpv.mostraPuntuacioActual(puntuacio);
		jpv.actualitzaErrors(errors);
	}
	
	public void PrTancarPartida(){
		
	}

}
