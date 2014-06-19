package edu.upc.fib.wordguess.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JSelcat extends JPanel {

	private static final long serialVersionUID = 1L;
	//JugarPartidaController jpc = new JugarPartidaController();
	
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
