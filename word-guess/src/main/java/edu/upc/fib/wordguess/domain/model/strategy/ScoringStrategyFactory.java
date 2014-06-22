package edu.upc.fib.wordguess.domain.model.strategy;

import edu.upc.fib.wordguess.domain.model.strategy.ScoringStrategy.StrategyValue;

public class ScoringStrategyFactory {

	public static ScoringStrategy buildStrategy(int wonMatchesCount) {
		ScoringStrategy strategy;
		if (wonMatchesCount < 2) {
			strategy = new NonPenaltyScoring();
		}
		else {
			strategy = new PenaltyScoringStrategy();
		}
		return strategy;
	}
	
	public static ScoringStrategy buildStrategy(StrategyValue value) {
		switch (value) {
		case nonpenalty:
			return new NonPenaltyScoring();
		case penalty:
			return new PenaltyScoringStrategy();
		default:
			return new NonPenaltyScoring();
		}
	}
	
}
