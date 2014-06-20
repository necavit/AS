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

import edu.upc.fib.wordguess.util.HibernateUtil;

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
    
    @OneToMany(mappedBy=LetterBox.MATCH_ID)
	private List<LetterBox> letterBoxes;
    
    public Match () {
    	
    }
	
    public Match(int matchId, Word word, Player player) {
        this.matchId = matchId;
        this.word = word;
        this.numErrors = 0;
        this.isFinished = false;
        this.isWon = false;
        this.player = player;
        
        letterBoxes = new ArrayList<LetterBox>();
        for (int i = 0; i < word.getName().length(); ++i) {
        	letterBoxes.add(new LetterBox(matchId, i, word.getName().charAt(i)));
        }
        
        HibernateUtil.store(this);
    }
    
    public boolean play (int pos, char letter) {
    	if(letter==letterBoxes.get(pos).getCorrectLetter()) {
    		
    	}
    	return true;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
    
    public Player getPlayer() {
		return player;
	}
    
    public void setPlayer(Player player) {
		this.player = player;
	}

    public int getNumErrors() {
        return numErrors;
    }

    public void setNumErrors(int numErrors) {
        this.numErrors = numErrors;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean isWon) {
        this.isWon = isWon;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

	public List<LetterBox> getLetterBoxes() {
		return letterBoxes;
	}
	
	public void setLetterBoxes(List<LetterBox> letterBoxes) {
		this.letterBoxes = letterBoxes;
	}
	
}
