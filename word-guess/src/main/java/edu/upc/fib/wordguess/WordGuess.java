package edu.upc.fib.wordguess;

import edu.upc.fib.wordguess.ui.PlayMatchController;

/**
 * WordGuess game main class. 
 */
public class WordGuess {

	/**
	 * Main program initializer method.
	 */
	public static void main(String[] args) {
		//inserts necessary objects in the database:
		Bootstrap.appBootstrap();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlayMatchController jpc = new PlayMatchController();
				jpc.initialize();
			}
		});
	}

}
