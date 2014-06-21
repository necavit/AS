package edu.upc.fib.wordguess.domain.controllers.usecase;

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
