package edu.upc.fib.wordguess.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import edu.upc.fib.wordguess.domain.model.Category;

public class PlayMatchView extends JFrame {
	
	PlayMatchController pmc;
	JLogin login;
	JSelcat categoriesSelectionPanel;
	JPartidaEnJoc matchPanel;
	JTextField [] letters;
	JComboBox<String> cBox_Categories;
	JLabel lb_messagesLoginPanel;
	JLabel lb_messagesMatchPanel;
	JLabel lb_messagesCategoriesPanel;
	JLabel lb_pointsPerCorrectLetter;
	JLabel lb_PointsPerError;
	JLabel lb_currentPoints;
	JLabel lb_ErrorCounter;
	JButton btn_startMatch;
	JButton btn_CheckLetter;
	JButton btn_stopMatch;
	JButton btn_finishMatch;
	private int index;
	private boolean matchWon;
	private int numLetters;
	private int maxErrors;
	
	public void disableLetterBoxes (int pos) {
		for (int i=0; i<numLetters; ++i) {
			if (i!=pos) {
				letters[i].setEnabled(false);
			}
		}
	}
	
	public void buildWord(int numLetters) {
		this.numLetters = numLetters;
		letters = new JTextField[numLetters];
		
		int x = numLetters/2;
		x = 300 - (x*50); // meitat del panell - la meitat del tamany de la paraula
		if( (numLetters % 2) != 0 )
			x = x-25; //si es imparell desplaco mitja
		
		for(int i=0;i<numLetters;i++) {
			letters[i]= new JTextField();
			String pos = Integer.toString(i);
			letters[i].setText("");
			letters[i].setName(pos);
			letters[i].setBounds(x,180,45,45);
			letters[i].setHorizontalAlignment(JTextField.CENTER);
			letters[i].setBorder( BorderFactory.createLineBorder( new Color(0,0,0), 1 ));
			letters[i].setFont(new java.awt.Font("Tahoma",1,20));
			letters[i].addKeyListener(new KeyAdapter() {
			      public void keyReleased(KeyEvent e) {

			      }

			      public void keyTyped(KeyEvent e) {
			    	  JTextField letterBox = (JTextField) e.getSource();
			    	  String pos = letterBox.getName();
			  		  int posint = Integer.parseInt(pos);
			  		  index=posint;
			  		  disableLetterBoxes(index);
			  		  String lletra = letters[posint].getText();
			    	  if(letterBox.getText().length()==1) e.consume();	
			      }

			      public void keyPressed(KeyEvent e) {
			    	  
			      }
		    });
			matchPanel.add(letters[i]);//adiciono al contentpane
			x=x+50;
		}
	}
	
	public class JLogin extends JPanel {
		/**Pantalla corresponent al login del sistema, és la primera pantalla que es mostra al iniciar 
		 *el programa*/
		private static final long serialVersionUID = 1L;
		private JTextField tb_user;
		private JPasswordField tb_pass;
		public JLogin() {
			setLayout(null);
			
			//label usuari
			JLabel lb_user = new JLabel("Usuari");
			lb_user.setFont(new java.awt.Font("Tahoma",0,20));
			lb_user.setBounds(160, 100, 150, 30);
			lb_user.setHorizontalAlignment(SwingConstants.CENTER);
			add(lb_user);
			
			//label contrasenya
			JLabel lb_pass = new JLabel("Contrasenya");
			lb_pass.setFont(new java.awt.Font("Tahoma",0,20));
			lb_pass.setBounds(160, 150, 130, 30);
			lb_pass.setHorizontalAlignment(SwingConstants.CENTER);
			add(lb_pass);
			
			//label imatge logo
			JLabel lb_logo = new JLabel("");
			lb_logo.setBounds(-4, -2, 87, 87);
			ImageIcon ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("logoWG.png"));
			lb_logo.setIcon(ImgIcon);
			add(lb_logo);
			
			//textField username
			tb_user = new JTextField();
			tb_user.setBounds(320, 100, 130, 30);
			tb_user.setHorizontalAlignment(SwingConstants.CENTER);
			tb_user.setBackground( Color.LIGHT_GRAY );
			tb_user.setBorder( BorderFactory.createLineBorder( new Color(160, 160, 160), 2 ));
			tb_user.setFont(new java.awt.Font("Tahoma",0,17));
			add(tb_user);
			tb_user.setColumns(10);
			
			//textField contrasenya
			tb_pass = new JPasswordField();
			tb_pass.setBounds(320, 150, 130, 30);
			tb_pass.setHorizontalAlignment(SwingConstants.CENTER);
			tb_pass.setBackground( Color.lightGray );
			tb_pass.setBorder( BorderFactory.createLineBorder( new Color(160, 160, 160), 2 ));
			tb_pass.setFont(new java.awt.Font("Tahoma",0,17));
			add(tb_pass);
			
			//panell missatges
			lb_messagesLoginPanel = new JLabel("",JLabel.CENTER);
			lb_messagesLoginPanel.setBounds(150, 200, 300, 60);
			lb_messagesLoginPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lb_messagesLoginPanel.setFont(new java.awt.Font("Tahoma",0,17));
			add(lb_messagesLoginPanel);
			
			//boto de login
			JButton btn_login = new JButton("Login");
			btn_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String username = tb_user.getText();
					String pass = tb_pass.getText();
					if(pmc.PrLogin(username,pass)) {
						setContentPane(categoriesSelectionPanel);
						categoriesSelectionPanel.updateUI();
					}
					tb_user.setText("");
					tb_pass.setText("");
				}
			});
			btn_login.setBackground( new Color( 117, 255, 71) );
			btn_login.setBounds(250, 270, 100, 35);
			btn_login.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
			btn_login.setBorder( BorderFactory.createLineBorder( new Color(0,133,0), 2 ));
			add(btn_login);
		}
	}
	
	
	public class JPartidaEnJoc extends JPanel {
	   /**Pantalla corresponent a la partida que s'està jugant
		* Mostra puntuació actual, num errors i les caselles per tal d'endevinar la paraula, 
		* a més apareixaràn els botons: comprovar, aturar partida i tancar partida*/
		public JPartidaEnJoc() {
			setLayout(null);
			
			//label imatge logo
			JLabel lb_logo = new JLabel("");
			lb_logo.setBounds(-4, -2, 87, 87);
			ImageIcon ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("logoWG.png"));
			lb_logo.setIcon(ImgIcon);
			add(lb_logo);
			
			// marcador puntucio actual
			lb_currentPoints = new JLabel("Punts:",SwingConstants.CENTER);
			lb_currentPoints.setBounds(102, 62, 172, 35);
			lb_currentPoints.setFont(new java.awt.Font("Tahoma",1,18));
			lb_currentPoints.setBackground( new Color( 51, 102, 255 ) );
			lb_currentPoints.setForeground(Color.white);
			lb_currentPoints.setOpaque(true);
			add(lb_currentPoints);		
			
			//marcador errors
			lb_ErrorCounter = new JLabel("Errors 0 de X:",SwingConstants.CENTER);
			lb_ErrorCounter.setBounds(323, 62, 172, 35);
			lb_ErrorCounter.setFont(new java.awt.Font("Tahoma",1,18));
			//lbErrors.setFont(boldfont);
			lb_ErrorCounter.setBackground(Color.gray);
			lb_ErrorCounter.setForeground(Color.white);
			lb_ErrorCounter.setOpaque(true);
			add(lb_ErrorCounter);
			
			//area missatges
			lb_messagesMatchPanel = new JLabel("",SwingConstants.CENTER);
			lb_messagesMatchPanel.setBounds(100, 240, 400, 30);
			lb_messagesMatchPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lb_messagesMatchPanel.setVerticalAlignment(SwingConstants.CENTER);
			lb_messagesMatchPanel.setFont(new java.awt.Font("Tahoma",1,15));
			add(lb_messagesMatchPanel);
			
			//lbPuntsEncert
			lb_pointsPerCorrectLetter = new JLabel("+10",SwingConstants.CENTER);
			lb_pointsPerCorrectLetter.setBounds(175, 115, 250, 25);
			lb_pointsPerCorrectLetter.setFont(new java.awt.Font("Tahoma",1,14));
			lb_pointsPerCorrectLetter.setForeground( new Color(0,133,0) );
			lb_pointsPerCorrectLetter.setOpaque(true);
			add(lb_pointsPerCorrectLetter);
			
			lb_PointsPerError = new JLabel("-5",SwingConstants.CENTER);
			lb_PointsPerError.setBounds(175, 140, 250, 25);
			lb_PointsPerError.setFont(new java.awt.Font("Tahoma",1,14));
			//lb_PuntsError.setFont(boldfont);
			//lb_PuntsError.setBackground(Color.red);
			lb_PointsPerError.setForeground(Color.red);
			lb_PointsPerError.setOpaque(true);
			add(lb_PointsPerError);
				
			//boto aturar partida
			btn_stopMatch = new JButton("Aturar");
			btn_stopMatch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pmc.PrStopMatch();
					setContentPane(categoriesSelectionPanel);
					categoriesSelectionPanel.updateUI();
					for (int i=0; i<numLetters; ++i) matchPanel.remove(letters[i]);
				}
			});
			
			btn_stopMatch.setBackground( new Color( 255, 172, 92) );
			btn_stopMatch.setBounds( 150 , 290, 100, 35);
			btn_stopMatch.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
			btn_stopMatch.setBorder( BorderFactory.createLineBorder( new Color(255,103,1), 2 ));
			
			btn_stopMatch.setVisible(true);
			add(btn_stopMatch);
			
			
			//boto comprovar
			btn_CheckLetter = new JButton("Comprovar");
			btn_CheckLetter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					  try {
						  lb_messagesMatchPanel.setText("");
						  pmc.PrCheck(index,letters[index].getText());
					  } catch(Exception e) {
						  e.printStackTrace();
						  if (!matchWon) {
							  System.out.println("Saltem al catch!");
							  lb_messagesMatchPanel.setText("La casella no pot estar buida");
						  }
					  }
				}
			});
			
			btn_CheckLetter.setBackground( new Color( 117, 255, 71) );
			btn_CheckLetter.setBounds(350, 290, 100, 35);
			btn_CheckLetter.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
			btn_CheckLetter.setBorder( BorderFactory.createLineBorder( new Color(0,133,0), 2 ));
			
			btn_CheckLetter.setVisible(true);
			add(btn_CheckLetter);
			
			btn_finishMatch = new JButton("Tancar");
			btn_finishMatch.setBackground( new Color( 255, 112, 112) );
			btn_finishMatch.setBounds( 250 , 290, 100, 35);
			btn_finishMatch.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
			btn_finishMatch.setBorder( BorderFactory.createLineBorder( new Color(133,0,0), 2 ));
			
			btn_finishMatch.setVisible(false);
			btn_finishMatch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pmc.PrFinishGame();
				}
			});
			add(btn_finishMatch);
		}
	}
	
	public class JSelcat extends JPanel {
		/**Pantalla corresponent a seleccionar una categoria de paraules per tal de que la partida
		 *sigui creada amb una paraula random de les corresponents a la categoria escollida*/
		public JSelcat() {
			setLayout(null);
			
			//label imatge logo
			JLabel lb_logo = new JLabel("");
			lb_logo.setBounds(-4, -2, 87, 87);
			ImageIcon ImgIcon = new ImageIcon(getClass().getClassLoader().getResource("logoWG.png"));
			lb_logo.setIcon(ImgIcon);
			add(lb_logo);
			
			//label seleccionar categoria
			JLabel lb_Selcat = new JLabel("Tria una categoria:");
			lb_Selcat.setFont(new java.awt.Font("Tahoma",0,20));
			lb_Selcat.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Selcat.setBounds(200, 60, 200, 30);
			add(lb_Selcat);
			
			//combobox
			cBox_Categories = new JComboBox<String>();
			cBox_Categories.setBorder( BorderFactory.createLineBorder( new Color(160, 160, 160), 2 ));
			cBox_Categories.setFont(new java.awt.Font("Tahoma",1, 14));
			cBox_Categories.setBounds(220, 120, 160, 30);
			add(cBox_Categories);
			
			//label missatge
			lb_messagesCategoriesPanel = new JLabel("",JLabel.CENTER);
			lb_messagesCategoriesPanel.setBounds(100, 170, 400, 40 );
			lb_messagesCategoriesPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lb_messagesCategoriesPanel.setFont(new java.awt.Font("Tahoma",0,17));
			add(lb_messagesCategoriesPanel);
			
			//boto logout
			JButton btn_logout = new JButton("Logout");
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lb_messagesLoginPanel.setText("");
					setContentPane(login);
					login.updateUI();
					btn_startMatch.setEnabled(true);
				}
			});
			btn_logout.setBackground( new Color( 255, 92, 92) );
			btn_logout.setBounds( 150 , 280, 100, 35);
			btn_logout.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
			btn_logout.setBorder( BorderFactory.createLineBorder( new Color(133,0,0), 2 ));
			add(btn_logout);
			
			//boto ok
			btn_startMatch = new JButton("Jugar");
			btn_startMatch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cat = String.valueOf(cBox_Categories.getSelectedItem());
					pmc.PrStartMatch(cat);
					setContentPane(matchPanel);
					matchPanel.updateUI();
				}
			});

			btn_startMatch.setBackground( new Color( 92, 92, 255) );
			btn_startMatch.setBounds( 350 , 280, 100, 35);
			btn_startMatch.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
			btn_startMatch.setBorder( BorderFactory.createLineBorder( new Color(0,0,133), 2 ));
			add(btn_startMatch);
			
		}
	}


	public PlayMatchView(PlayMatchController jpc) {
		pmc = jpc;
		login = new JLogin();
		categoriesSelectionPanel = new JSelcat();
		matchPanel = new JPartidaEnJoc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600 , 400);
		this.setTitle("Word-guess 2014");
		setContentPane(login);
	}
	
	public void loadCategories(List<Category> categories) {
		/**Carrega les categories dins del combobox corresponent*/
		cBox_Categories.removeAllItems();
		for (Category category : categories) {
			cBox_Categories.addItem(category.getName());
		}
	}
	
	public void showMessage(String text,int panelNumber) {
		/**Mostra un missatge al label corresponent en funció de la pantalla indicada*/
		if(panelNumber==0) {
			//Pantalla de Login
			lb_messagesLoginPanel.setText(text);
			lb_messagesLoginPanel.setForeground(Color.red);
		}
		else if(panelNumber==1) {
			//Pantalla de Categories
			lb_messagesCategoriesPanel.setText(text);
			lb_messagesCategoriesPanel.setForeground(Color.red);
			btn_startMatch.setEnabled(false);
		}
		else {
			//Pantalla de Partida
			lb_messagesMatchPanel.setText(text);
			lb_messagesMatchPanel.setForeground(Color.red);
		}		
	}
	
	public void loadPointsPer(int en, int err) {
		/**Mostra la quantitat de punts per error i punt per encert definit prèviament a 
		  l'estratègia que se l'hi ha aplicat a la partida*/
		String encert = Integer.toString(en);
		String error = Integer.toString(err);
		lb_pointsPerCorrectLetter.setText("Punts per encert: +"+encert);
		lb_PointsPerError.setText("Punts per fallada: "+error);
	}
	
	public void updateCurrentScoring(int points) {
		/**Actualitza la puntuació actual*/
		String Spoints = Integer.toString(points);
		lb_currentPoints.setText("Punts: \n"+ Spoints);
	}
		
	public void updateErrorCount(int ea,int nme) {
		/**Actualitza la quantitat d'errors actuals respecte el nombre màxim d'errors permesos*/
		this.maxErrors = nme;
		String errActuals = Integer.toString(ea);
		String numMaxErr = Integer.toString(nme);
		this.lb_ErrorCounter.setText("Errors : "+ea+" de "+maxErrors);
	}
	public void updateErrors(int ea) {
		/**Actualitza la quantitat d'errors actuals respecte el nombre màxim d'errors permesos*/
		String errActuals = Integer.toString(ea);
		lb_ErrorCounter.setText("Errors : "+ea+" de "+maxErrors );
	}
	
	public void emptyLetterBoxes() {
		/**Buidar el text corresponent a les caselles de la partida*/
		for(int i=0; i < letters.length; ++i ) {
			letters[i].setText("");
		}
	}
	
	public void stopMatch() {
		/**Funció corresponent al event de click sobre el botó "Aturar Partida"*/
		emptyLetterBoxes();
		setContentPane(login);
		login.updateUI();
	}
	
	public void close() {
		/**Funció corresponent al event de click sobre el botó "Tancar Partida"*/
		System.exit(-1);
	}
	
	public void finishMatch(boolean guanyada) {
		/**Quan una partida és finalitzada, pot ser que o bé hagui guanyat o bé hagui superat
		  la quantitat maxima d'errors permesos, en funció d'aquestes possibilitats actualitzem
		  els labels de missatges i l'aparició o no, del botons corresponents a l'interface*/
		this.matchWon = guanyada;
		if (guanyada) {
			lb_messagesMatchPanel.setForeground( new Color( 0, 113, 0 ) );
			lb_messagesMatchPanel.setText("Enhorabona has guanyat la partida!");
		}
		else lb_messagesMatchPanel.setText("Has superat el nombre maxim d'errors");
		btn_CheckLetter.setVisible(false);
		btn_stopMatch.setVisible(false);
		btn_finishMatch.setVisible(true);		
	}
	
	public void markLetterBox(boolean encert) {
		/**Pinta la casella corresponent de color verd o vermell en funció de si en aquesta casella
		  s'ha produït un encert o una fallada*/
		if(encert) {
			letters[index].setBackground(Color.green);
		}
		else {
			letters[index].setBackground(Color.red);
			showMessage("La lletra es incorrecta",2);
		}
		for (int i=0; i<numLetters; ++i) {
			if (letters[i].getBackground() == Color.green) {
				letters[i].setEnabled(false);
				letters[i].setDisabledTextColor(Color.BLACK);
			}
			else {
				letters[i].setEnabled(true);
			}
			letters[i].setBorder(UIManager.getBorder("TextField.border"));
		}
		if(!encert) letters[index].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	}
}
