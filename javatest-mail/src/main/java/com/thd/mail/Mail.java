package com.thd.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mail {
	//发送文本邮件
	public static void sendTextMail(){
		try{
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("smtp.163.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("devil13th@163.com");
			mailInfo.setPassword("wl_18190");
			mailInfo.setFromAddress("devil13th@163.com");
			mailInfo.setToAddress("181907667@qq.com");
			mailInfo.setSubject("设置邮箱标题");
			mailInfo.setContent("设置邮箱内容");
			MailSender sms = new MailSender();
			sms.sendTextMail(mailInfo);//发送文体格式   
			
			sms.sendMail(mailInfo);
			System.out.println("邮件发送成功！");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("邮件发送失败！");
		}
	}
	
	//发送带附件的邮件
	public static void sendMail(){
		try{
			
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("smtp.163.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("devil13th@163.com");
			mailInfo.setPassword("wl_18190");
			mailInfo.setFromAddress("devil13th@163.com");
			mailInfo.setToAddress("lwang@ccsit.cn");
			mailInfo.setSubject("设置邮箱标题");
			mailInfo.setContent("设置邮箱内容");
			
			List<File> files = new ArrayList();
			files.add(new File("D:/s.jpg"));
			files.add(new File("D:/Chap0101x.pdf"));
			mailInfo.setFiles(files);
			
			MailSender sms = new MailSender();
			sms.sendMail(mailInfo);
			System.out.println("邮件发送成功！");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("邮件发送失败！");
		}
	}
	public static void main(String[] args) {
		
	//	sendTextMail();
		sendMail();
		sendMail();
		sendMail();
		
	}

}
