package com.mwm.commons.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
	
	private static final String ENCODEING = "UTF-8";
	
	private static String host = "smtp.163.com"; // 服务器地址

	private static String sender = "thick_skin@163.com"; // 发件人的邮箱


	private static String name = "你离开南京从此没有人和我说话"; // 发件人昵称

	private static String username = "thick_skin@163.com"; // 账号

	private static String password = "Wangyi654123"; // 密码

	private String subject = ""; // 主题

	private String receiver; // 收件人的邮箱
	
	private String message; // 信息(支持HTML)

	public void send() throws EmailException {
		// 发送email
		HtmlEmail email = new HtmlEmail();
		// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
		email.setHostName(host);
		// 字符编码集的设置
		email.setCharset(ENCODEING);
		// 收件人的邮箱
		email.addTo(getReceiver());
		// 发送人的邮箱
		email.setFrom(sender, name);
		// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
		email.setAuthentication(username, password);
		// 要发送的邮件主题
		email.setSubject(getSubject());
		// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
		email.setMsg(getMessage());
		// 发送
		email.send();
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
