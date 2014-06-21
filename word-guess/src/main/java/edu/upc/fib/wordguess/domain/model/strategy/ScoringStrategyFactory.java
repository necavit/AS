package edu.upc.fib.wordguess.domain.model.strategy;

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
	
}
