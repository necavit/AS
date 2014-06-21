package edu.upc.fib.wordguess.domain.model.strategy;

import edu.upc.fib.wordguess.domain.model.LetterBox;
import edu.upc.fib.wordguess.domain.model.Match;

public class PenaltyScoringStrategy implements ScoringStrategy {

	@Override
	public int getScoreOnSuccess() {
		return 2; //just because it seemed right
	}
	
	@Override
	public int getScoreOnError() {
		return -1; //penalty!!
	}
	
	@Override
	public int getScore(Match match) {
		int score = 0;
		for (LetterBox letterBox : match.getLetterBoxes()) {
			if (letterBox.isSuccess()) {
				score += getScoreOnSuccess();
			}
			else {
				score += getScoreOnError();
			}
		}
		return score;
	}

}
