package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.upc.fib.wordguess.util.HibernateUtil;

@Entity
@Table(name=Player.TABLE_PLAYER)
public class Player extends RegisteredUser implements Serializable {

	private static final long serialVersionUID = 2249987917128104143L;

	public static final String TABLE_PLAYER = "player";
	
	@Column(nullable=false)
	private String email;
	
	/**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
	public Player() {
		//
	}
	
	public Player(String name, String surname, String username, String password, String email) {
		initialize(name, surname, username, password);
		this.email = email;
		HibernateUtil.store(this);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
