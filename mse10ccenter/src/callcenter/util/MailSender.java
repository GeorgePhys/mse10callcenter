package callcenter.util;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

import callcenter.entity.clients.User;
import callcenter.entity.issue.IssueDetail;

/**
 * Manage mail send for confirm registration and message for issue.
 * 
 * @author yasko
 * @author Sibel
 * 
 */
public final class MailSender {

    private MailSender() {
    }

    public static void sendRegistrationConfirmationMessage(User user,
	    String uuid, Date expirationDate) {
	try {
	    javax.mail.Session session = (javax.mail.Session) CommonUtil
		    .getInitialContext().lookup("java:/Mail");
	    Message message = new MimeMessage(session);

	    InternetAddress to[] = new InternetAddress[1];
	    to[0] = new InternetAddress(user.getMail());
	    message.setRecipients(Message.RecipientType.TO, to);

	    message.setSubject("MSE10 Call Center user registration confirmation.");
	    StringBuilder builder = new StringBuilder();
	    builder.append("Hello " + user.getFullName() + ", <br/>");
	    builder.append("you have recently registered at MSE10 Call Center.<br/>");
	    builder.append("To confirm your registration please click on the following link.<br/>");
	    builder.append("<a href=\"http://localhost:8080/mse10ccenter/confirmation?id=");
	    builder.append(uuid);
	    builder.append("\">http://localhost:8080/mse10ccenter</a><br/><br/>");
	    builder.append("Please note that you have until " + expirationDate
		    + " to confirm your registration.<br/>");
	    message.setContent(builder.toString(), "text/html");
	    Transport.send(message);
	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (AddressException e) {
	    e.printStackTrace();
	} catch (MessagingException e) {
	    e.printStackTrace();
	}
    }

    public static void sendCreateIssueMessage(IssueDetail issueDetail) {
	try {
	    javax.mail.Session session = (javax.mail.Session) CommonUtil
		    .getInitialContext().lookup("java:/Mail");
	    Message message = new MimeMessage(session);

	    InternetAddress to[] = new InternetAddress[1];
	    to[0] = new InternetAddress(issueDetail.getAssignee());
	    message.setRecipients(Message.RecipientType.TO, to);

	    message.setSubject("MSE10 Call Center created issue for you.");
	    StringBuilder builder = new StringBuilder();
	    builder.append("Hello " + issueDetail.getAssignee() + ", <br/>");
	    builder.append("there is created or updated issue for you at MSE10 Call Center.<br/><br/>");
	    builder.append("<b>Title Issue: </b>" + issueDetail.getTitleIssue()
		    + "<br/>");
	    builder.append("<b>From: </b>" + issueDetail.getReporter()
		    + "<br/>");

	    message.setContent(builder.toString(), "text/html");
	    Transport.send(message);
	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (AddressException e) {
	    e.printStackTrace();
	} catch (MessagingException e) {
	    e.printStackTrace();
	}
    }
}
