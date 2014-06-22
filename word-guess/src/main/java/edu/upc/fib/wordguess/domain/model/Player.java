package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

/**
 * Classe java corresponent a la classe "Jugador" del model de classes de domini
 * */
@Entity
@Table(name=Player.TABLE_PLAYER)
public class Player extends RegisteredUser implements Serializable {
	
	private static final long serialVersionUID = 2249987917128104143L;

	public static final String TABLE_PLAYER = "player";
	
	@Column(nullable=false)
	private String email;
	
	@OneToOne
	private Match currentMatch;
	
	@OneToMany(mappedBy=Match.MAPPED_BY_PLAYER, fetch=FetchType.EAGER)
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
	
	public Player(String name, String surname, String username, String password, String email) throws Exception {
		initialize(name, surname, username, password);
		this.email = email;
		this.playedMatches = new ArrayList<Match>();
		this.currentMatch = null;
		dao.store(this);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		this.email = email;
		dao.update(this);
	}
	
	public void addPlayedMatch(Match match) throws Exception {
		if (playedMatches != null) {
			playedMatches.add(match);
			dao.update(this);
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
		for (Match match : getPlayedMatches()) {
			if (match.isWon()) {
				++wonMatches;
			}
		}
		return wonMatches;
	}
	
	public Match getCurrentMatch() {
		return currentMatch;
	}
	
	public void setCurrentMatch(Match match) throws Exception {
		this.currentMatch = match;
		dao.update(this);
	}
	
}
