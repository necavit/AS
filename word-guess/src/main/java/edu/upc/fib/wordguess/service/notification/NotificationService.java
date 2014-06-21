package edu.upc.fib.wordguess.service.notification;

import edu.upc.fib.wordguess.service.Service;

public interface NotificationService extends Service {

	public void notifyWonMatch(String playerName, String playerEmailAddress, 
			String guessedWord, int score, int numErrors);
	
}
