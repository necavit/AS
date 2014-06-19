package edu.upc.fib.wordguess.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
			
			JLabel lb_missatges = new JLabel("Àrea de missatges");
			lb_missatges.setBounds(97, 180, 385, 99);
			add(lb_missatges);
			
			JButton btn_login = new JButton("Login");
			btn_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(ipc.PrLogin()) {
					//setContentPane(selcat);	
					//selcat.updateUI();
					setContentPane(partenjoc);
					partenjoc.updateUI();
					}
				}
			});
			btn_login.setBackground(Color.green);
			btn_login.setBounds(223, 304, 89, 23);
			add(btn_login);
			
			tb_pass = new JPasswordField();
			tb_pass.setBounds(271, 137, 143, 25);
			add(tb_pass);

		}
		
	}
	
	
	public class JPartidaEnJoc extends JPanel {
				
		public void creaParaula(int numlletres) {
			
			lletres = new JTextField[numlletres];
			int x=225;
			for(int i=0;i<numlletres;i++) {
				x=x+20;
				lletres[i]= new JTextField();
				lletres[i].setName(""+i);
				lletres[i].setBounds(x,183,20,20);
				lletres[i].addKeyListener(new KeyAdapter() {
				      public void keyReleased(KeyEvent e) {

				      }

				      public void keyTyped(KeyEvent e) {
				    	  JTextField casella = (JTextField) e.getSource();
				    	  String pos = casella.getName();
				    	  System.out.println(pos);
				    	  System.out.println("comproba("+pos+")");
				    	  if(casella.getText().length()==1) 
				    		  e.consume();
				      }

				      public void keyPressed(KeyEvent e) {
				    	  
				      }
			    });
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
					//ipc.PrTancarPartida();
				}
			});
			btn_TancarPartida.setBounds(229, 324, 109, 30);
			add(btn_TancarPartida);
			
			btn_TancarPartida.setVisible(true);
			
			creaParaula(5);

		}
	}
	
	public class JSelcat extends JPanel {

		
		public JSelcat() {
			setLayout(null);
			
			JLabel lb_Selcat = new JLabel("Tria una categoria:");
			lb_Selcat.setFont(new java.awt.Font("Tahoma",0,20));
			lb_Selcat.setBounds(204, 42, 218, 24);
			add(lb_Selcat);
			
			JComboBox cb_cat = new JComboBox();
			cb_cat.setBounds(220, 97, 156, 20);
			add(cb_cat);
			
			JLabel lb_missatges = new JLabel("New label");
			lb_missatges.setBounds(93, 156, 412, 87);
			add(lb_missatges);
			
			JButton btn_logout = new JButton("Logout");
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_logout.setBounds(169, 268, 89, 23);
			add(btn_logout);
			
			JButton btn_ok = new JButton("Jugar");
			btn_ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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

}
