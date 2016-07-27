package guerer.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class MailInfo {

}

class SimpleAuthenticator extends Authenticator {

	private String user;

	private String pwd;

	public SimpleAuthenticator(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pwd);
	}

}

public class ReceipMailSender {
	// private static final Logger
	// logger=LoggerFactory.getLogger(IMIAlertMailSender.class);
	public void send(final MailInfo mailInfo) {
		new Thread(new Runnable() {

			public void run() {

				try {
					// Session session=null;
					// logger.info("smtpHost"+smtpHost);
					// logger.info("smtpPort"+smtpPort);
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.sina.com");
					props.put("mail.smtp.auth", true);
					Session session = Session.getInstance(props, new SimpleAuthenticator("gujunxiguerer@sina.com", "sinamail061310"));
					StringBuilder out = new StringBuilder();
					out.append("<!DOCTYPE html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />  <title>SpeedPass+</title>  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/></head><body style=\"margin: 0; padding: 0;\"> <table   cellpadding=\"0\" cellspacing=\"0\" width=\"600\"> ");
					out.append(" <tr>  <td>   Here is the receipt from your purchase on ");
					out.append(getSubjectDateYY() + " at " + "Test Station"
							+ ": ");
					out.append("</td> </tr><br> <tr>  <td>");
					out.append("Just<br>fo<br>test<br>Just<br/>fo<br/>test");
					out.append("</td> </tr> <br><tr> <td>    - Sent from the Speedpass+ app  </td> </tr><br/>  <tr>  <td>    COMMENTS: view and functions are dependent on user's default email client  </td> </tr></table></body></html>");
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(
							"gujunxiguerer@sina.com"));
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress("gujunxiguerer@sina.com"));
					message.setSubject(getSubjectDate() + " - "
							+ "Test Station");
					message.setContent(out.toString(), "text/html");
					// logger.info("Message "+ message);
					Transport.send(message);
					// logger.info("Message has been send");

				} catch (Exception e) {
					// logger.error(e.toString());
					e.printStackTrace();
				}

			}
		}).start();

	}

	public static String getSubjectDateYY() {
		String date = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
			date = dateFormat.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getSubjectDate() {
		String date = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd");
			date = dateFormat.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		ReceipMailSender sender = new ReceipMailSender();
		sender.send(new MailInfo());
	}
}
