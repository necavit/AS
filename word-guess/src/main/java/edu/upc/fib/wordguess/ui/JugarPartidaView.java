package edu.upc.fib.wordguess.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JugarPartidaView extends JFrame {
	
	JLogin login = new JLogin();
	JSelcat selcat = new JSelcat();
	JPartidaEnJoc partidaenjoc = new JPartidaEnJoc();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugarPartidaView frame = new JugarPartidaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void mostraCategories(String array[]) {
		
	}
	
	public void mostraMissatge(String text) {
		
	}
	
	public void mostraPuntuacions(int array[]) {
		
	}
	
	public void PuntuacioActual(int p) {
		
	}
	
	public void mostraNumMaximErrors(int e) {
		
	}
	
	public void mostraErrorsActuals(int e) {
		
	}
	
	public void mostraLletra(char lletra,int pos) {
		
	}
	
	public void tancar() {
		System.exit(-1);
	}

	public JugarPartidaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600 , 400);
		setContentPane(login);
	}

}
