/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.commonUltil.view;

/**
 * @author Thy Dinh Jun 13, 2017
 *
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class MailService.
 */
public class MailService extends Thread {
	
	/** The email. */
	private String email;
	
	/** The user name. */
	private String userName;
	
	/** The content. */
	private String content;
	
	/** The subject. */
	private String subject;
	
	/** The Constant EMAIL. */
	public static final String EMAIL = "SkyPlus.withLove@gmail.com";
	
	/** The Constant PASSWORD. */
	public static final String PASSWORD = "trangtruongtinhthyuyen";

	/**
	 * Instantiates a new mail service.
	 *
	 * @param email the email
	 * @param subject the subject
	 * @param userName the user name
	 * @param message the message
	 */
	public MailService(String email, String subject, String userName, String message) {
		this.email = email;
		this.content = message;
		this.userName = userName;
		this.subject = subject;
	}

	/* 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, PASSWORD);
			}
		});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText("Hello " + this.userName + "\n\n\n" + this.content
					+ "\n\n\n If you have any concern or question, please dont hesitabe us follow email: SkyPlus.withLove@gmail.com."
					+ " \n\n\n This is the automatic email.Please don't relay this email !\n\nBest regards!\n\n\nTraining manage systerm");

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
