package edu.upc.fib.wordguess.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.Button;
import java.awt.Color;

public class JLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tb_user;
	private JPasswordField tb_pass;
	//JugarPartidaController jpc = new JugarPartidaController();

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
				//jpc.PrLogin();
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

