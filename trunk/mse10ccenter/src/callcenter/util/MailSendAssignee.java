package callcenter.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import callcenter.entity.issue.IssueDetail;

public class MailSendAssignee {
    private static InitialContext CONTEXT;

    static {
	try {
	    CONTEXT = new InitialContext();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }

    private MailSendAssignee() {
    }

    public static void sendCreateIssueMessage(IssueDetail issueDetail) {
	try {
	    javax.mail.Session session = (javax.mail.Session) CommonUtil
		    .getInitialContext().lookup("java:/Mail");
	    Message message = new MimeMessage(session);

	    InternetAddress to[] = new InternetAddress[1];
	    to[0] = new InternetAddress(issueDetail.getAssignee());
	    message.setRecipients(Message.RecipientType.TO, to);

	    message.setSubject("MSE10 Call Center create issue for you.");
	    StringBuilder builder = new StringBuilder();
	    builder.append("Hello " + issueDetail.getAssignee() + ", <br/>");
	    builder.append("you have recently registered at MSE10 Call Center.<br/>");
	    builder.append("To confirm your registration please click on the following link.<br/>");
	    builder.append("<a href=\"http://localhost:8080/mse10ccenter/confirmation?id=");

	    builder.append("\">http://localhost:8080/mse10ccenter</a><br/><br/>");

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
