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
		
	}
}

