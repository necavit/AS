package edu.upc.fib.wordguess.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
	  public static void main (String[] args) {
	    javax.swing.SwingUtilities.invokeLater (
	      new Runnable() {
	        public void run() {
	        	JugarPartidaController jpc = new JugarPartidaController();
	        	jpc.inicialitza();
	    }});
	  }
	}

