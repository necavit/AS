package edu.upc.fib.wordguess.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JugarPartidaView extends JFrame {
	
	JugarPartidaController ipc;
	JLogin login;
	JSelcat selcat;
	JPartidaEnJoc partenjoc;
	JTextField [] lletres;
	JComboBox cb_cat;
	JLabel lb_missatges;
	JLabel lb_missatges1;
	JLabel lb_missatges2;
	JLabel lb_PuntEncert;
	JLabel lb_PuntsError;
	JLabel lbNumErrors;
	JLabel lbPunts;
	JButton btn_ok;
	private int index;
	
	public void creaParaula(int numlletres) {
		
		lletres = new JTextField[numlletres];
		int x=200;
		for(int i=0;i<numlletres;i++) {
			x=x+20;
			lletres[i]= new JTextField();
			String pos = Integer.toString(i);
			lletres[i].setText("");
			lletres[i].setName(pos);
			lletres[i].setBounds(x,183,20,20);
			lletres[i].addKeyListener(new KeyAdapter() {
			      public void keyReleased(KeyEvent e) {

			      }

			      public void keyTyped(KeyEvent e) {
			    	  JTextField casella = (JTextField) e.getSource();
			    	  String pos = casella.getName();
			  		  int posint = Integer.parseInt(pos);
			  		  index=posint;
			  		  String lletra = lletres[posint].getText();
			    	  if(casella.getText().length()==1) e.consume();				    	  
			      }

			      public void keyPressed(KeyEvent e) {
			    	  
			      }
		    });
			partenjoc.add(lletres[i]);//adiciono al contentpane
		}
	}
	
	public class JLogin extends JPanel {

		private static final long serialVersionUID = 1L;
		private JTextField tb_user;
		private JPasswordField tb_pass;

		public JLogin() {
			setLayout(null);
			
			JLabel lb_user = new JLabel("Usuari");
			lb_user.setFont(new java.awt.Font("Tahoma",0,20));
			lb_user.setBounds(118, 86, 69, 26);
			add(lb_user);
			
			JLabel lb_pass = new JLabel("Contrassenya");
			lb_pass.setFont(new java.awt.Font("Tahoma",0,20));
			lb_pass.setBounds(113, 137, 148, 22);
			add(lb_pass);
			
			tb_user = new JTextField();
			tb_user.setBounds(275, 86, 139, 28);
			add(tb_user);
			tb_user.setColumns(10);
			
			
			tb_pass = new JPasswordField();
			tb_pass.setBounds(271, 137, 143, 25);
			add(tb_pass);
			
			lb_missatges = new JLabel("",JLabel.CENTER);
			lb_missatges.setBounds(97, 180, 385, 99);
			add(lb_missatges);
			
			JButton btn_login = new JButton("Login");
			btn_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String username = tb_user.getText();
					String pass = tb_pass.getText();
					if(ipc.PrLogin(username,pass)) {
						setContentPane(selcat);
						selcat.updateUI();
					}
					tb_user.setText("");
					tb_pass.setText("");
				}
			});
			btn_login.setBackground(Color.green);
			btn_login.setBounds(223, 304, 89, 23);
			add(btn_login);
		}
	}
	
	
	public class JPartidaEnJoc extends JPanel {
					
		public JPartidaEnJoc() {
			setLayout(null);
			JLabel lbPuntuacioActual = new JLabel("PUNTUACI� ACTUAL:",SwingConstants.CENTER);
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
			
			lbPunts = new JLabel("0",SwingConstants.CENTER);
			lbPunts.setBounds(31, 72, 253, 30);
			lbPunts.setFont(new java.awt.Font("Tahoma",0,20));
			lbPunts.setFont(boldfont);
			lbPunts.setBackground(Color.blue);
			lbPunts.setForeground(Color.white);
			lbPunts.setOpaque(true);
			add(lbPunts);
			
			lbNumErrors = new JLabel("",SwingConstants.CENTER);
			lbNumErrors.setBounds(326, 72, 253, 30);
			lbNumErrors.setFont(new java.awt.Font("Tahoma",0,20));
			lbNumErrors.setFont(boldfont);
			lbNumErrors.setBackground(Color.gray);
			lbNumErrors.setForeground(Color.white);
			lbNumErrors.setOpaque(true);
			add(lbNumErrors);
			
			lb_missatges1 = new JLabel("",SwingConstants.CENTER);
			lb_missatges1.setBounds(57, 246, 422, 76);
			add(lb_missatges1);
			
			lb_PuntEncert = new JLabel("+10",SwingConstants.CENTER);
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
			
			lb_PuntsError = new JLabel("-5",SwingConstants.CENTER);
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
					ipc.PrAturarPartida();
				}
			});
			btn_AturarPartida.setBounds(140, 324, 122, 30);
			add(btn_AturarPartida);
			
			JButton btn_Comprovar = new JButton("Comprovar");
			btn_Comprovar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			    	  ipc.PrComprovar(index,lletres[index].getText());
				}
			});
			btn_Comprovar.setBounds(318, 324, 109, 30);
			add(btn_Comprovar);
			
			JButton btn_TancarPartida = new JButton("Tancar Partida");
			btn_TancarPartida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//ipc.PrTancarPartida();
				}
			});
			btn_TancarPartida.setBounds(229, 324, 109, 30);
			add(btn_TancarPartida);
			
			btn_TancarPartida.setVisible(true);

		}
	}
	
	public class JSelcat extends JPanel {

		
		public JSelcat() {
			setLayout(null);
			
			JLabel lb_Selcat = new JLabel("Tria una categoria:");
			lb_Selcat.setFont(new java.awt.Font("Tahoma",0,20));
			lb_Selcat.setBounds(204, 42, 218, 24);
			add(lb_Selcat);
			
			cb_cat = new JComboBox();
			cb_cat.setBounds(220, 97, 156, 20);
			add(cb_cat);
			
			lb_missatges2 = new JLabel("",JLabel.CENTER);
			lb_missatges2.setBounds(93, 156, 412, 87);
			add(lb_missatges2);
			
			JButton btn_logout = new JButton("Logout");
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lb_missatges.setText("");
					setContentPane(login);
					login.updateUI();
					btn_ok.setEnabled(true);
				}
			});
			btn_logout.setBounds(169, 268, 89, 23);
			add(btn_logout);
			
			btn_ok = new JButton("Jugar");
			btn_ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cat = String.valueOf(cb_cat.getSelectedItem());
					ipc.PrJugar(cat);
					setContentPane(partenjoc);
					partenjoc.updateUI();
				}
			});
			btn_ok.setBounds(333, 268, 89, 23);
			add(btn_ok);

		}
	}


	public JugarPartidaView(JugarPartidaController jpc) {
		ipc = jpc;
		login = new JLogin();
		selcat = new JSelcat();
		partenjoc = new JPartidaEnJoc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600 , 400);
		setContentPane(login);
	}
	
	public void mostraCategories(ArrayList<String> cats) {
		for(int i=0; i<cats.size(); ++i) {
			cb_cat.addItem(cats.get(i));
		}
	}
	
	public void mostraMissatge(String text,int pantalla) {
		if(pantalla==0) {
			//Pantalla de Login
			lb_missatges.setText(text);
			lb_missatges.setForeground(Color.red);
		}
		else if(pantalla==1) {
			//Pantalla de Categories
			lb_missatges2.setText(text);
			lb_missatges2.setForeground(Color.red);
			btn_ok.setEnabled(false);
		}
		else {
			//Pantalla de Partida
			lb_missatges1.setText(text);
			lb_missatges1.setForeground(Color.red);
		}		
	}
	
	public void mostraPuntuacions(int en, int err) {
		String encert = Integer.toString(en);
		String error = Integer.toString(err);
		lb_PuntEncert.setText(encert);
		lb_PuntsError.setText(error);
	}
	
	public void mostraPuntuacioActual(int p) {
		String puntuacio = Integer.toString(p);
		lbPunts.setText(puntuacio);
	}
		
	public void mostraErrorsActuals(int ea,int nme) {
		String eactuals = Integer.toString(ea);
		String numaxe = Integer.toString(nme);
		lbNumErrors.setText(eactuals + " de " + numaxe);
	}
	
	public void mostraErrors(int ea) {
		String eactuals = Integer.toString(ea);
		lbNumErrors.setText(eactuals);
	}
	
	public void mostraLletra(char lletra,int pos) {
		
	}
	
	public void netejarcaselles() {
		for(int i=0; i < lletres.length; ++i ) {
			lletres[i].setText("");
		}
	}
	
	public void aturaPartida() {
		netejarcaselles();
		setContentPane(login);
		login.updateUI();
	}
	
	public void tancar() {
		System.exit(-1);
	}

}
