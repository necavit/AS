package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.ArrayList;

import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.domain.model.Word;


public class JugarPartidaUseCasController {
	
	private int numEncerts;
	private Word w;
	private Match m;
		
	public JugarPartidaUseCasController() {
		w = new Word();
		m = new Match();
		w.setName("Patata");
		numEncerts=0;
	}
	
	public ArrayList<Object> ferJugada(int pos, char lletra, int idPartida) {
		ArrayList<Object> infojugada = new ArrayList<Object>();
		if(m.play(pos,lletra)) {
			++numEncerts;
			if(m.isWon()) {
				//Servei missatgeria
			}
		}
		else {
			
		}
		return infojugada;
	}
	
	public void ferAutentificacio(String username,String pass) {
		
	}
	
	public ArrayList<Integer> crearPartida(String cat, String username) {
		ArrayList<Integer> infopartida = new ArrayList<Integer>();
		infopartida.add(0); //puntuacioActual
		infopartida.add(5); //numMaximErrors
		infopartida.add(3); //punxEncert
		infopartida.add(-10); //puntxError
		infopartida.add(0); // idPartida
		return infopartida;
	}
	
	public void defineixEstrategia(int npg) {
		
	}
	
	public ArrayList<String> obtenirCategories() {
		ArrayList<String> categories = new ArrayList<String>();
		//Llamada a la base de datos
		categories.add("Porno");
		categories.add("Gayer");
		return categories;
	}
	
	public String obteParaula(String cat) {
		//S'ha d'anar a buscar la paraula a base de dades
		return w.getName();
	}

}
