package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.data.postgres.PostgresPlayerDAO;
import edu.upc.fib.wordguess.util.HibernateUtil;

@Entity
@Table(name=Player.TABLE_PLAYER)
public class Player extends RegisteredUser implements Serializable {

	private static final long serialVersionUID = 2249987917128104143L;

	public static final String TABLE_PLAYER = "player";
	
	@Column(nullable=false)
	private String email;
	
	private Match currentMatch;
	
	@OneToMany(mappedBy=Match.PLAYER)
	private List<Match> playedMatches;
	
	/**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
	public Player() {
		//
	}
	
	private static PlayerDAO dao = PostgresDAOFactory.getInstance().getPlayerDAO();
	
	public Player(String name, String surname, String username, String password, String email) {
		initialize(name, surname, username, password);
		this.email = email;
		this.playedMatches = new ArrayList<Match>();
		
		try {
			dao.store(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPlayedMatch(Match match) {
		if (playedMatches != null) {
			playedMatches.add(match);
			try {
				dao.update(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("playedMatches is null. username is: " + getUsername());
		}
	}

	public List<Match> getPlayedMatches() {
		return playedMatches;
	}
	
	public void setPlayedMatches(List<Match> playedMatches) {
		this.playedMatches = playedMatches;
	}
	
	public int getWonMatches() {
		int wonMatches = 0;
		for (Match match : playedMatches) {
			if (match.isWon()) {
				++wonMatches;
			}
		}
		return wonMatches;
	}
	
	public Match getCurrentMatch() {
		return currentMatch;
	}
	
	public void setCurrentMatch(Match match) {
		this.currentMatch = match;
	}
	
}
