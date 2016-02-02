package com.xinyue.manage.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;

import com.xinyue.manage.model.Member;

/**
 * 邮件发送器
 * 
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年7月10日
 */
public class MailSender {

	@Resource
	@Qualifier("mail.smtp.host")
	protected static String mailServerHost ;
	
	@Resource
	@Qualifier("mail.send.address")
	protected static String sendAddress ;
	
	@Resource
	@Qualifier("mail.send.address")
	protected static String sendUserName ;
	
	@Resource
	@Qualifier("mail.send.password")
	protected static String sendUserPassword ;
	
	@Resource
	@Qualifier("mail.send.auth")
	protected static String authValidate;
	
	
	
	static String MAIL_IMG_BJ = "bj.png";
	
	static String MAIL_ING_BTN = "zc_btn.png";
	
	
	

	/**
	 * 发送邮件
	 * 
	 * @param receiveAddress
	 *            接收地址
	 * @param theme
	 *            主题
	 * @param mailContent
	 *            内容
	 * @return true:发送成功 false:发送失败
	 */
	public static boolean sendMail(String receiveAddress, String theme,
			String mailContent) {

		// 发送邮件的资源文件
		Properties properties = new Properties();
		properties.put("mail.smtp.host", mailServerHost);
		properties.put("mail.smtp.auth", authValidate);

		try {
			// 创建一个密码验证器
			MailAuthenticator authenticator = new MailAuthenticator(
					sendUserName, sendUserPassword);

			// 根据邮件会话属性和密码验证器构造一个发送邮件的session
			Session mailSession = Session.getDefaultInstance(properties,
					authenticator);

			// 根据session创建一个邮件消息
			MimeMessage mailMessage = new MimeMessage(mailSession);

			// 创建邮件发送者地址
			Address from = new InternetAddress(sendAddress);

			// 设置邮件消息的发送者
			mailMessage.setFrom(from);

			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(receiveAddress);
			mailMessage.setRecipient(Message.RecipientType.TO, to);

			// 设置邮件消息的主题
			mailMessage.setSubject(theme);

			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());

			// mailMessage.setText(mailContent);
			mailMessage.setContent(mailContent, "text/html;charset=utf-8");

			Transport.send(mailMessage);

			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 多邮箱同内容
	 * 
	 * @param receiveAddressList
	 * @param theme
	 * @param mailContent
	 * @return
	 */
	public static boolean sendMails(List<String> receiveAddressList,
			String theme, String mailContent) {

		// 发送邮件的资源文件
		Properties properties = new Properties();
		properties.put("mail.smtp.host", mailServerHost);
		properties.put("mail.smtp.auth", authValidate);

		try {
			// 创建一个密码验证器
			MailAuthenticator authenticator = new MailAuthenticator(
					sendUserName, sendUserPassword);

			// 根据邮件会话属性和密码验证器构造一个发送邮件的session
			Session mailSession = Session.getDefaultInstance(properties,
					authenticator);

			// 根据session创建一个邮件消息
			MimeMessage mailMessage = new MimeMessage(mailSession);

			// 创建邮件发送者地址
			Address from = new InternetAddress(sendAddress);

			// 设置邮件消息的发送者
			mailMessage.setFrom(from);

			// 创建邮件的接收者地址，并设置到邮件消息中
			int total = receiveAddressList.size();
			InternetAddress[] addresses = new InternetAddress[total];
			for (int i = 0; i < total; i++) {
				addresses[i] = new InternetAddress(receiveAddressList.get(i));
			}
			mailMessage.setRecipients(RecipientType.TO, addresses);

			// 设置邮件消息的主题
			mailMessage.setSubject(theme);

			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());

			// mailMessage.setText(mailContent);
			mailMessage.setContent(mailContent, "text/html;charset=utf-8");
			Transport.send(mailMessage);

			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	public static boolean sendHtmlMail(String receiveAddress, String theme, String mailContent, HttpServletRequest request) {
		// 发送邮件的资源文件
		Properties properties = new Properties();
		properties.put("mail.smtp.host", mailServerHost);
		properties.put("mail.smtp.auth", authValidate);
		Member member = (Member)request.getSession().getAttribute(GlobalConstant.SESSION_MEMBER_INFO);
		try {
			
			String content = MailSender.getMailContent(mailContent, member.getContactName());
			
			// 创建一个密码验证器
			MailAuthenticator authenticator = new MailAuthenticator(
					sendUserName, sendUserPassword);

			// 根据邮件会话属性和密码验证器构造一个发送邮件的session
			Session mailSession = Session.getDefaultInstance(properties,
					authenticator);

			// 根据session创建一个邮件消息
			MimeMessage mailMessage = new MimeMessage(mailSession);

			// 创建邮件发送者地址
			Address from = new InternetAddress(sendAddress);

			// 设置邮件消息的发送者
			mailMessage.setFrom(from);

			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(receiveAddress);
			mailMessage.setRecipient(Message.RecipientType.TO, to);

			// 设置邮件消息的主题
			mailMessage.setSubject(theme);

			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			
			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + content,
					"text/html;charset=UTF-8");
			
			MimeMultipart multipart = new MimeMultipart();
			
			multipart.addBodyPart(bodyPart);
			
			List<String> imgList = new ArrayList<String>();
			imgList.add(MailSender.MAIL_IMG_BJ);
			imgList.add(MailSender.MAIL_ING_BTN);
			
			for (String imgName : imgList) {
			    MimeBodyPart image = new MimeBodyPart();
		        DataHandler dh = new DataHandler(new FileDataSource(MailSender.getMailImg(imgName)));
		        image.setDataHandler(dh);
		        image.setContentID(imgName);
		        multipart.addBodyPart(image);
			}
			

			mailMessage.setContent(multipart);

			
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(mailServerHost, 25, sendUserName, sendUserPassword);
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
		
	}
	
	
	/**获取html文件所在位置
	 * add by lzc     date: 2015年12月29日
	 * @return
	 */
	private static String getMailURI(){
		String re = MailSender.class.getResource("/").toString() + "mailTemplete/mail.html";
		if (re.startsWith("file")) {
			re = re.substring(5);
		}
		return re ;
	}
	
	
	/**获取发送所需的html模板
	 * add by lzc     date: 2015年12月30日
	 * @param content
	 * @param recommendName
	 * @return
	 */
	private static String getMailContent(String content, String recommendName) {
		String result = CommonFunction.read(getMailURI());
		result = result.replace("${name}", recommendName);
		result = result.replace("${content}", content);
		return result;
		
	}
	
	
	
	
	
	/**获取
	 * add by lzc     date: 2015年12月29日
	 * @param imgName
	 * @return
	 */
	private static String getMailImg(String imgName){
		String re = MailSender.class.getResource("/").toString() + "mailTemplete/image/" +imgName;
		if (re.startsWith("file")) {
			re = re.substring(5);
		}
		return re;
	}
	
	
	
}
