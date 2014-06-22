package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.controllers.usecase.MatchInfoTuple;
import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategy;
import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategyFactory;
import edu.upc.fib.wordguess.util.Log;

@Entity
@Table(name=Match.TABLE)
public class Match implements Serializable {
	/**
	 * Classe java corresponent a la classe "Partida" del model de classes de domini
	 * */
    private static final long serialVersionUID = -5210486939375055839L;
    public static final String TABLE = "match";

    @Id
    @Column
    private int matchId;

    @Column
    private int numErrors;

    @Column
    private boolean isFinished;

    @Column
    private boolean isWon;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="word_id")
    private Word word;
    public static final String MAPPED_BY_WORD = "word";
    
    public static final String PLAYER = "player";
    @ManyToOne
    @JoinColumn
    private Player player;
    
    private int maximumErrorCount;
    
    private ScoringStrategy strategy;
    
    @OneToMany(mappedBy=LetterBox.MATCH_ID)
	private List<LetterBox> letterBoxes;
    
    public Match () {
    	
    }
	
    private static MatchDAO dao = PostgresDAOFactory.getInstance().getMatchDAO();
      
    public Match(WordGuessParams params, Player player, Word word) throws Exception {
    	//match params
    	matchId = params.getNextMatchId();
		Log.debug("new Match", "matchId: " + matchId);
		maximumErrorCount = params.getMaxErrorsCount();
		Log.debug("new Match", "maxErrors: " + maximumErrorCount);
		
		this.isFinished = false;
        this.isWon = false;
        this.numErrors = 0;
		
    	//assign player
    	this.player = player;
    	player.setCurrentMatch(this);
    	
    	//decide strategy
		int wonMatchesCount = player.getWonMatches();
		strategy = ScoringStrategyFactory.buildStrategy(wonMatchesCount);
		
		//get word
		this.word = word;
		try {
			word.addMatch(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//build letter boxes
		letterBoxes = new ArrayList<LetterBox>();
        for (int i = 0; i < word.getName().length(); ++i) {
        	letterBoxes.add(new LetterBox(matchId, i, word.getName().charAt(i)));
        }
		
    	dao.store(this);
	}

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) throws Exception {
        this.matchId = matchId;
        dao.update(this);
    }
    
    public Player getPlayer() {
		return player;
	}
    
    public void setPlayer(Player player) throws Exception {
		this.player = player;
		dao.update(this);
	}

    public int getNumErrors() {
        return numErrors;
    }

    public void setNumErrors(int numErrors) throws Exception {
        this.numErrors = numErrors;
        dao.update(this);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) throws Exception {
    	Log.debug("match", "isFinished: " + isFinished);
    	this.isFinished = isFinished;
        dao.update(this);
        if (isFinished) {
        	player.setCurrentMatch(null);
        	player.addPlayedMatch(this);
        }
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean isWon) throws Exception {
    	Log.debug("match", "isWon: " + isWon);
        this.isWon = isWon;
        dao.update(this);
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) throws Exception {
        this.word = word;
        dao.update(this);
    }

	public List<LetterBox> getLetterBoxes() {
		return letterBoxes;
	}
	
	public void setLetterBoxes(List<LetterBox> letterBoxes) throws Exception {
		this.letterBoxes = letterBoxes;
		dao.update(this);
	}

	public String getWordName() {
		return word.getName();
	}

	public MatchInfoTuple getMatchInfoTuple() {
		int scoreOnSuccess = strategy.getScoreOnSuccess();
		int scoreOnError = strategy.getScoreOnError();
		return new MatchInfoTuple(matchId, getScore(), maximumErrorCount, scoreOnSuccess, scoreOnError);
	}

	public int getScore() {
		return strategy.getScore(this);
	}
	
	public boolean play(int position, char letter) {
    	boolean success = letterBoxes.get(position).checkLetter(letter);
    	if (success) {
    		checkMatchWon();
    	}
    	else {
    		try {
				setNumErrors(getNumErrors() + 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		checkMatchLost();
    	}
    	return success;
    }
	
	private void checkMatchWon() {
		boolean won = true;
		for (LetterBox box : letterBoxes) {
			if (!box.isSuccess()) {
				won = false;
				break;
			}
		}
		if (won) {
			try {
				setWon(true);
				setFinished(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkMatchLost() {
		if (numErrors > maximumErrorCount) {
			try {
				setFinished(true);
				setWon(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		try {
			setFinished(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
