package edu.upc.fib.wordguess.service;

import java.security.InvalidParameterException;

import edu.upc.fib.wordguess.service.exception.NoSuchServiceException;
import edu.upc.fib.wordguess.service.mail.MailerServiceAdapter;
import edu.upc.fib.wordguess.service.notification.NotificationServiceAdapter;

public class ServiceLocator {

	public static final String SERVICE_MAIL = "mail_service";
	public static final String SERVICE_NOTIFICATION = "notification_service";
	
	private static ServiceLocator instance = null;
	
	private ServiceLocator() {
		//
	}
	
	public static ServiceLocator getInstance() {
		if (instance == null) instance = new ServiceLocator();
		return instance;
	}
	
	public Service find(String serviceName) throws NoSuchServiceException {
		if (serviceName != null && !serviceName.equals("")) {
			if (serviceName.equals(SERVICE_MAIL)) {
				return getMailService();
			}
			else if (serviceName.equals(SERVICE_NOTIFICATION)) {
				return getNotificationService();
			}
			else {
				throw new NoSuchServiceException("no service was found with the name: " + serviceName);
			}
		}
		else {
			throw new InvalidParameterException("serviceName must not be empty or null");
		}
	}
	
	private Service mailerService = null;
	
	private Service getMailService() {
		if (mailerService == null) mailerService = new MailerServiceAdapter();
		return mailerService;
	}
	
	private Service notificationService = null;
	
	private Service getNotificationService() {
		if (notificationService == null) notificationService = new NotificationServiceAdapter();
		return notificationService;
	}
	
}
