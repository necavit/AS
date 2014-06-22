package edu.upc.fib.wordguess.domain.model.strategy;

import edu.upc.fib.wordguess.domain.model.Match;

public interface ScoringStrategy {

	public enum StrategyValue {
		nonpenalty, penalty
	}
	
	public StrategyValue getValue();
	
	public int getScoreOnSuccess();
	
	public int getScoreOnError();
	
	public int getScore(Match match);
	
}
