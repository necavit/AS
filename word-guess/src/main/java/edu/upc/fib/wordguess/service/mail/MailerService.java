package edu.upc.fib.wordguess.service.mail;

import edu.upc.fib.wordguess.service.Service;

public interface MailerService extends Service {

	public void sendMail(String recipientName, String recipientAddress,	String subject, String messageBody);
	
}
