package edu.upc.fib.wordguess.ui;

import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.Word;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;


public class main {

	public static void main(String[] args) {
		//inserts mock objects:
		appBootstrap();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JugarPartidaController jpc = new JugarPartidaController();
				jpc.inicialitza();
			}
		});
	}
	
	static void appBootstrap() {
		try {
			//word-guess global params
			// DO NOT DELETE THIS - it would break the whole program
			new WordGuessParams(10, 6);
			
			//categories and words in each category
			Category test = new Category("Test");
				new Word("test", test);
			Category mobles = new Category("Mobles");
				new Word("cadira", mobles);
				new Word("taula", mobles);
				new Word("armari", mobles);
			Category transports = new Category("Transports");
				new Word("cotxe", transports);
				new Word("vaixell", transports);
				new Word("moto", transports);
			
			//players
			new Player("John", "Doe", "test", "test", "john@doe.com");
			new Player("David", "Martínez", "david", "test", "gollumdeagol@gmail.com");
			new Player("Daniel", "Ariñez", "daniel", "test", "daniel.arinez92@gmail.com");
			new Player("Miquel", "Masriera", "miquel", "test", "miquelmasriera@gmail.com");
			new Player("Marcel", "Pujol", "marcel", "test", "pujy25@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

