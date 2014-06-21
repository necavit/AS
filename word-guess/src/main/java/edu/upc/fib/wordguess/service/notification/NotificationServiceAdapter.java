package edu.upc.fib.wordguess.service.notification;

import edu.upc.fib.wordguess.service.ServiceLocator;
import edu.upc.fib.wordguess.service.exception.NoSuchServiceException;
import edu.upc.fib.wordguess.service.mail.MailerService;
import edu.upc.fib.wordguess.util.Log;


public class NotificationServiceAdapter implements NotificationService {
	
	private static final String TAG = NotificationServiceAdapter.class.getSimpleName();
	
	private static String subjectBase =
			"WordGuess - You guessed \"%s\"!";
	
	private static String messageBodyBase = 
			"Congratulations!\n\n" + 
			"You have correctly guessed the word: %s.\n" +
			"Your score was %d and you did %d errors.\n\n" +
			"Best regards,\n" +
			"  WordGuess team";
	
	private MailerService mailer;
	
	public NotificationServiceAdapter() {
		try {
			mailer = (MailerService) ServiceLocator.getInstance().find(ServiceLocator.SERVICE_MAIL);
		} catch (NoSuchServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void notifyWonMatch(String playerName, String playerEmailAddress, String guessedWord, int score, int numErrors) {
		String subject = String.format(subjectBase, guessedWord);
		String emailBody = String.format(messageBodyBase, guessedWord, score, numErrors);
		Log.debug(TAG, "email body: " + emailBody);
		mailer.sendMail(playerName, playerEmailAddress, subject, emailBody);
	}
	
}
