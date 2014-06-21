package edu.upc.fib.wordguess.ui;

/**
 * Tuple-like class, to store the information returned
 * when a new match is created, to be sent to UI components.
 * 
 * For the sake of simplicity, all members are public, but final,
 * so no modification is possible afterwards.
 */
public class MatchInfoTuple {

	public final int matchId;
	public final int currentScore;
	public final int maximumErrorCount;
	public final int scoreOnSuccess;
	public final int scoreOnError;
	
	public MatchInfoTuple(int matchId, 
						  int currentScore, 
						  int maximumErrorCount,
						  int scoreOnSuccess,
						  int scoreOnError) {
		this.matchId = matchId;
		this.currentScore = currentScore;
		this.maximumErrorCount = maximumErrorCount;
		this.scoreOnSuccess = scoreOnSuccess;
		this.scoreOnError = scoreOnError;
	}
	
}
