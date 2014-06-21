package edu.upc.fib.wordguess.service.mail;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.MailException;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import edu.upc.fib.wordguess.util.Log;

public class MailerServiceAdapter implements MailerService {
	
	private static final String TAG = MailerServiceAdapter.class.getSimpleName();
	
	private static final String MAILER_HOST = "smtp.gmail.com";
	private static final int MAILER_PORT = 465;
	private static final String MAILER_USERNAME = "mikimikimail2@gmail.com";
	private static final String MAILER_PASSWORD = "mikimail22";
	
	private static final String MAILER_FROM_ADDRESS = MAILER_USERNAME;
	private static final String MAILER_FROM_DISPLAY_NAME = "WordGuess team";
	
	private Mailer mailer;

	public MailerServiceAdapter() {
		this.mailer = 
				new Mailer(MAILER_HOST, MAILER_PORT, MAILER_USERNAME, MAILER_PASSWORD, TransportStrategy.SMTP_SSL); 
	}
	
	@Override
	public void sendMail(String recipientName, String recipientAddress, String subject, String messageBody) {
		Email email = new Email();
		email.setFromAddress(MAILER_FROM_DISPLAY_NAME, MAILER_FROM_ADDRESS);
		email.setSubject(subject);
		email.addRecipient(recipientName, recipientAddress, RecipientType.TO);
		email.setText(messageBody);
		try {
			mailer.sendMail(email);
		} catch (MailException e) {
			Log.error(TAG, e.getMessage());
			e.printStackTrace();
		}
	}
	
}
