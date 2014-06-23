package edu.upc.fib.wordguess.domain.model.strategy;

import edu.upc.fib.wordguess.domain.model.LetterBox;
import edu.upc.fib.wordguess.domain.model.Match;

public class NonPenaltyScoring implements ScoringStrategy {
	
	@Override
	public StrategyValue getValue() {
		return StrategyValue.nonpenalty;
	}
	
	@Override
	public int getScoreOnSuccess() {
		return 1;
	}
	
	@Override
	public int getScoreOnError() {
		return 0;
	}
	
	@Override
	public int getScore(Match match) {
		int score = 0;
		for (LetterBox letterBox : match.getLetterBoxes()) {
			Boolean success = letterBox.isSuccess();
			if (success != null) { //letterBox was answered
				if (letterBox.isSuccess()) {
					score += getScoreOnSuccess();
				}
			}
			else { //was not answered
				//do nothing
			}
		}
		return score;
	}

}
