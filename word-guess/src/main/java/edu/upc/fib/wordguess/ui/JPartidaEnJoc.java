package edu.upc.fib.wordguess.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPartidaEnJoc extends JPanel {
	
	JugarPartidaController jpc = new JugarPartidaController();
	
	public void creaParaula(int numlletres) {
		
		JTextField [] lletres = new JTextField[numlletres];
		int x=225;
		for(int i=0;i<numlletres;i++) {
			x=x+20;
			lletres[i]= new JTextField();
			lletres[i].setBounds(x,183,20,20);
			/*lletres[i].addKeyListener(new KeyAdapter() {
			      public void keyReleased(KeyEvent e) {

			      }

			      public void keyTyped(KeyEvent e) {
			    	  if(lletres[i].getText().length()>0) System.out.print("a");
			      }

			      public void keyPressed(KeyEvent e) {
			    	  
			      }
		    });*/
			add(lletres[i]);//adiciono al contentpane
		}
	}

	
	public JPartidaEnJoc() {
		setLayout(null);
		JLabel lbPuntuacioActual = new JLabel("PUNTUACIÓ ACTUAL:",SwingConstants.CENTER);
		lbPuntuacioActual.setBounds(31, 42, 253, 30);
		lbPuntuacioActual.setFont(new java.awt.Font("Tahoma",0,20));
		Font f = lbPuntuacioActual.getFont();
		Font boldfont = new Font(f.getFontName(),f.BOLD,f.getSize());
		lbPuntuacioActual.setFont(boldfont);
		lbPuntuacioActual.setBackground(Color.blue);
		lbPuntuacioActual.setForeground(Color.white);
		lbPuntuacioActual.setOpaque(true);
		add(lbPuntuacioActual);
		
		JLabel lbErrors = new JLabel("ERRORS:",SwingConstants.CENTER);
		lbErrors.setBounds(326, 42, 253, 30);
		lbErrors.setFont(new java.awt.Font("Tahoma",0,20));
		lbErrors.setFont(boldfont);
		lbErrors.setBackground(Color.gray);
		lbErrors.setForeground(Color.white);
		lbErrors.setOpaque(true);
		add(lbErrors);
		
		JLabel lbPunts = new JLabel("0",SwingConstants.CENTER);
		lbPunts.setBounds(31, 72, 253, 30);
		lbPunts.setFont(new java.awt.Font("Tahoma",0,20));
		lbPunts.setFont(boldfont);
		lbPunts.setBackground(Color.blue);
		lbPunts.setForeground(Color.white);
		lbPunts.setOpaque(true);
		add(lbPunts);
		
		JLabel lbNumErrors = new JLabel("0 de 3",SwingConstants.CENTER);
		lbNumErrors.setBounds(326, 72, 253, 30);
		lbNumErrors.setFont(new java.awt.Font("Tahoma",0,20));
		lbNumErrors.setFont(boldfont);
		lbNumErrors.setBackground(Color.gray);
		lbNumErrors.setForeground(Color.white);
		lbNumErrors.setOpaque(true);
		add(lbNumErrors);
		
		JLabel lb_missatges = new JLabel("New label",SwingConstants.CENTER);
		lb_missatges.setBounds(57, 246, 422, 76);
		add(lb_missatges);
		
		JLabel lb_PuntEncert = new JLabel("+10",SwingConstants.CENTER);
		lb_PuntEncert.setBounds(31, 113, 62, 30);
		lb_PuntEncert.setFont(new java.awt.Font("Tahoma",0,20));
		lb_PuntEncert.setFont(boldfont);
		lb_PuntEncert.setBackground(Color.green);
		lb_PuntEncert.setForeground(Color.white);
		lb_PuntEncert.setOpaque(true);
		add(lb_PuntEncert);
		
		JLabel lb_Encerts = new JLabel("Encert",SwingConstants.CENTER);
		lb_Encerts.setBounds(103, 113, 181, 30);
		lb_Encerts.setFont(new java.awt.Font("Tahoma",0,20));
		lb_Encerts.setFont(boldfont);
		lb_Encerts.setBackground(Color.green);
		lb_Encerts.setForeground(Color.white);
		lb_Encerts.setOpaque(true);
		add(lb_Encerts);
		
		JLabel lb_PuntsError = new JLabel("-5",SwingConstants.CENTER);
		lb_PuntsError.setBounds(326, 113, 62, 30);
		lb_PuntsError.setFont(new java.awt.Font("Tahoma",0,20));
		lb_PuntsError.setFont(boldfont);
		lb_PuntsError.setBackground(Color.red);
		lb_PuntsError.setForeground(Color.white);
		lb_PuntsError.setOpaque(true);
		add(lb_PuntsError);
		
		JLabel lb_Errors = new JLabel("Fallada",SwingConstants.CENTER);
		lb_Errors.setBounds(398, 113, 181, 30);
		lb_Errors.setFont(new java.awt.Font("Tahoma",0,20));
		lb_Errors.setFont(boldfont);
		lb_Errors.setBackground(Color.red);
		lb_Errors.setForeground(Color.white);
		lb_Errors.setOpaque(true);
		add(lb_Errors);
		
		JButton btn_AturarPartida = new JButton("Aturar Partida");
		btn_AturarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_AturarPartida.setBounds(140, 324, 122, 30);
		add(btn_AturarPartida);
		
		JButton btn_Comprovar = new JButton("Comprovar");
		btn_Comprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Comprovar.setBounds(318, 324, 109, 30);
		add(btn_Comprovar);
		
		JButton btn_TancarPartida = new JButton("Tancar Partida");
		btn_TancarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpc.PrTancarPartida();
			}
		});
		btn_TancarPartida.setBounds(229, 324, 109, 30);
		add(btn_TancarPartida);
		
		btn_TancarPartida.setVisible(true);
		
		creaParaula(5);

	}
}
