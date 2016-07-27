package guerer.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.smtp.SMTPAddressFailedException;

public class MailSender {
	private String host;
	private String user;
	private String password;

	public MailSender() {
		this.host = "";
		this.user = "";
		this.password = "";
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setAccount(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public boolean send(String from, String to, String subject, String content) {
		boolean bl = true;
		Properties props = new Properties();
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.auth", "true");
		try {
			Session mailSession = null;
			mailSession = Session.getInstance(props, new MyAuthenticator(this.user, this.password));
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from,"教立方"));
			Address[] ttAddress = null;
			List addList = new ArrayList();
			if (to.indexOf(";") > 0) {
				String[] strs = to.split(";");
				for (int i = 0; i < strs.length; i++) {
					Address toAddress = new InternetAddress(strs[i]);
					addList.add(toAddress);
				}
			} else {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
			}
			if ((addList != null) && (addList.size() > 0)) {
				ttAddress = new Address[addList.size()];
				for (int i = 0; i < addList.size(); i++) {
					ttAddress[i] = ((Address) addList.get(i));
				}
				message.addRecipients(Message.RecipientType.TO, ttAddress);
			}

			message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();

			mbp.setContent(content, "text/html;charset=UTF-8");
			mp.addBodyPart(mbp);
			message.setContent(mp);

			message.saveChanges();
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(this.host, this.user, this.password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (SMTPAddressFailedException es) {
			throw new RuntimeException("邮件地址错误:" + es.getMessage());
		} catch (SendFailedException ef) {
			throw new RuntimeException("邮件发送失败:" + ef.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			bl = false;
		}
		return bl;
	}

	public boolean send(String from, String to, String subject, String content, List<File> accessories) {
		boolean bl = true;
		Properties props = new Properties();
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.auth", "true");
		try {
			Session mailSession = null;
			mailSession = Session.getInstance(props, new MyAuthenticator(this.user, this.password));
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from,"教立方"));
			Address[] ttAddress = null;
			List addList = new ArrayList();
			if (to.indexOf(";") > 0) {
				String[] strs = to.split(";");
				for (int i = 0; i < strs.length; i++) {
					Address toAddress = new InternetAddress(strs[i]);
					addList.add(toAddress);
				}
			} else {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
			}
			if ((addList != null) && (addList.size() > 0)) {
				ttAddress = new Address[addList.size()];
				for (int i = 0; i < addList.size(); i++) {
					ttAddress[i] = ((Address) addList.get(i));
				}
				message.addRecipients(Message.RecipientType.TO, ttAddress);
			}

			message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(content, "text/html;charset=UTF-8");
			for (int k = 0; k < accessories.size(); k++) {
				MimeBodyPart mbp2 = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(accessories.get(k));
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setFileName(MimeUtility.encodeText(fds.getName()));
				mp.addBodyPart(mbp2);
			}
			mp.addBodyPart(mbp);
			message.setContent(mp);	

			message.saveChanges();
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(this.host, this.user, this.password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (SMTPAddressFailedException es) {
			throw new RuntimeException("邮件地址错误:" + es.getMessage());
		} catch (SendFailedException ef) {
			throw new RuntimeException("邮件发送失败:" + ef.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			bl = false;
		}
		return bl;
	}
	
	class MyAuthenticator extends Authenticator {
		protected String id = "";
		protected String password = "";

		public MyAuthenticator(String id, String password) {
			this.id = id;
			this.password = password;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.id, this.password);
		}
	}
	
	public static void main(String[] args){
		MailSender sender = new MailSender();
		sender.setHost("smtp.sina.com");
		sender.setAccount("gujunxiguerer@sina.com", "sinamail061310");
		
		sender.send("gujunxiguerer@sina.com", "gujunxiguerer@sina.com", "test", "test");
	}
}
