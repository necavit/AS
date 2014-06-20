package edu.upc.fib.wordguess.ui;


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
		//afegiu aqui els "inserts" que volgueu. per fer un insert, només cal fer:
		//
		//   new Category("mobles")
		//
		//perquè tots els constructors del domini ja criden al seu controlador de dades
		// correctament (als mocks, que es comporten com una BD, o haurien XDD)
		//els updates es fan cada vegada que fas un set() d'un objecte
		//els deletes no es fan, pq en java no hi ha operacio destructora... pero si et
		// petes l'objecte... bé, en tot cas crec que tenim pocs deletes
		
		
	}
}

