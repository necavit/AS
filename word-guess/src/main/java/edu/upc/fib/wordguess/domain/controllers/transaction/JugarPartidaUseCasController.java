package edu.upc.fib.wordguess.domain.controllers.transaction;

import java.util.ArrayList;

import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.Word;


public class JugarPartidaUseCasController {
	
	private int numEncerts;
	private Word w;
	private Match m;
	private Player p;
	private Category c;
		
	public JugarPartidaUseCasController() {
		c = new Category("cat");
		w = new Word("patata",c);
		p = new Player("a","a","a","a","a");
		//w.setName("patata");
		m = new Match(1,w,p);
		numEncerts=0;
	}
	
	public ArrayList<Object> ferJugada(int pos, char lletra, int idPartida) {
		ArrayList<Object> infojugada = new ArrayList<Object>();
		boolean encert,acabada,guanyada;
		int puntuacio,errors;
		encert=m.play(pos,lletra);
		guanyada = m.isWon();
		acabada = m.isFinished();
		
		if(encert) {
			++numEncerts;
			if(m.isWon()) {
				System.out.print("Partida Finalitzada");
				//Servei missatgeria
			}
		}
		else {
			//Fer la comprobacio si supera nmaximerrors
		}
		
		errors = m.getNumErrors();
		puntuacio = 3; // ESTRATEGIA
		
		infojugada.add(encert);
		infojugada.add(acabada);
		infojugada.add(guanyada);
		infojugada.add(errors);
		infojugada.add(puntuacio);
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
