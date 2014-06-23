package edu.upc.fib.wordguess.domain.model.strategy;

import edu.upc.fib.wordguess.domain.model.LetterBox;
import edu.upc.fib.wordguess.domain.model.Match;

public class PenaltyScoringStrategy implements ScoringStrategy {

	@Override
	public StrategyValue getValue() {
		return StrategyValue.penalty;
	}
	
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
			Boolean success = letterBox.isSuccess(); 
			if (success != null) { //letter box has been answered
				if (success) {
					score += getScoreOnSuccess();
				}
				else {
					score += getScoreOnError();
				}
			}
			else { //letter box was not answered: do not sum nor penalize
				//do nothing
			}
		}
		return score;
	}

}
