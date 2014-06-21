package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategy;
import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategyFactory;
import edu.upc.fib.wordguess.ui.MatchInfoTuple;
import edu.upc.fib.wordguess.util.Log;

@Entity
@Table(name=Match.TABLE)
public class Match implements Serializable {

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

    @ManyToOne
    private Word word;
    
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
      
    public Match(WordGuessParams params, Player player, Category category) {
    	//match params
    	matchId = params.nextMatchId;
		Log.debug("new Match", "matchId: " + matchId);
		maximumErrorCount = params.maxErrorsCount;
		Log.debug("new Match", "maxErrors: " + maximumErrorCount);
		
		this.isFinished = false;
        this.isWon = false;
        this.numErrors = 0;
		
    	//assign player
    	this.player = player;
    	player.addPlayedMatch(this);
    	
    	//decide strategy
		int wonMatchesCount = player.getWonMatches();
		strategy = ScoringStrategyFactory.buildStrategy(wonMatchesCount);
		
		//get word
		this.word = category.getRandomWord();
		
		//build letter boxes
		letterBoxes = new ArrayList<LetterBox>();
        for (int i = 0; i < word.getName().length(); ++i) {
        	letterBoxes.add(new LetterBox(matchId, i, word.getName().charAt(i)));
        }
		
    	try {
			dao.store(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean play (int pos, char letter) {
    	boolean encertada=letterBoxes.get(pos).checkLetter(letter);
    	if( letterBoxes.get(pos).checkLetter(letter)) {
    		boolean won = true;
    		for(int i=0; i<letterBoxes.size() && won ; ++i) {
    			won = letterBoxes.get(i).isSuccess();
    		}
    		if(won) {
    			setFinished(true);
    			setWon(true);
    		}
    	}
    	else {
    		setNumErrors(getNumErrors() + 1);		
    	}
    	return encertada;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
        try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Player getPlayer() {
		return player;
	}
    
    public void setPlayer(Player player) {
		this.player = player;
		try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public int getNumErrors() {
        return numErrors;
    }

    public void setNumErrors(int numErrors) {
        this.numErrors = numErrors;
        try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
        try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean isWon) {
        this.isWon = isWon;
        try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
        try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public List<LetterBox> getLetterBoxes() {
		return letterBoxes;
	}
	
	public void setLetterBoxes(List<LetterBox> letterBoxes) {
		this.letterBoxes = letterBoxes;
		try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getWordName() {
		return word.getName();
	}

	public MatchInfoTuple getMatchInfoTuple() {
		int scoreOnSuccess = strategy.getScoreOnSuccess();
		int scoreOnError = strategy.getScoreOnError();
		return new MatchInfoTuple(matchId, getCurrentScore(), maximumErrorCount, scoreOnSuccess, scoreOnError);
	}

	private int getCurrentScore() {
		return strategy.getScore(this);
	}
	
	
}
