package edu.upc.fib.wordguess.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordGuess extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5918244734376770020L;

	/**
	 * Create the panel.
	 */
	public WordGuess() {
		
		JButton btnRabosw = new JButton("Boton1");
		btnRabosw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnRabosw);

	}

}
