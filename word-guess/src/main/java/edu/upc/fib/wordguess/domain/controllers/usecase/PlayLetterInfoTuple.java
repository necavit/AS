package edu.upc.fib.wordguess.domain.controllers.usecase;

/**
 * Tuple-like class, to store the information returned
 * when a new match is created, to be sent to UI components.
 * 
 * For the sake of simplicity, all members are public, but final,
 * so no modification is possible afterwards.
 */
public final class PlayLetterInfoTuple {

	public final boolean success;
	
	public final boolean isFinished;
	
	public final boolean isWon;
	
	public final int currentScore;
	
	public final int numErrors;
	
	public PlayLetterInfoTuple(boolean success,
							   boolean isFinished, 
							   boolean isWon, 
							   int currentScore, 
							   int numErrors) {
		this.success = success;
		this.currentScore = currentScore;
		this.isFinished = isFinished;
		this.isWon = isWon;
		this.numErrors = numErrors;
	}

}
