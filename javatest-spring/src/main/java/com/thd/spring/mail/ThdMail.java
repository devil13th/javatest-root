package com.thd.spring.mail;


import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 发送邮件
 * 
 * 关于java.lang.NoClassDefFoundError: com/sun/mail/util/LineInputStream解决办法 
	X:/Program Files/MyEclipse 6.5/myeclipse/eclipse/plugins/com.genuitec.eclipse.j2eedt.core_6.5.0.zmyeclipse650200806/data/libraryset/EE_5
	这个路径里,可以看到javaee.jar,用rar把这个文件打开,然后进到javax文件夹里,删除mail.jar和activation.jar(我的javaee.jar里，这两个东西是文件夹，总之删掉就OK，不过要注意备份一下)
 * @author lwang
 *
 */
public class ThdMail {
	
	/**
	 * spring 发送邮件的核心对象(Spring注入进来)
	 */
	private JavaMailSender mailSender;
	/**
	 * 发送邮件的地址(Spring注入进来)
	 */
	private String from;
	
	
	/**
	 * 发送简单文本邮件
	 * @param title 标题
	 * @param content 内容
	 * @param to 收件人  多个收件人用";"隔开
	 */
	public void sendMail(String title,String content,String to){
		try{
			//SimpleMailMessage 只能发送text格式的邮件 不能带有附件和html格式
			SimpleMailMessage mail = new SimpleMailMessage();
			
	        mail.setFrom(from);
	        
	        //单个收件人
	        //mail.setTo(to);
	        
	        //多个收件人
			String[] tos = to.split(";");
	        mail.setTo(tos);
	        mail.setSubject(title);
	        mail.setText(content);
	        mailSender.send(mail);
		}catch(Exception e){
			e.printStackTrace();
		}
	};
	
	/**
	 * 发送HTML格式的文本邮件
	 * @param title 标题
	 * @param content 内容
	 * @param to 收件人  多个收件人用";"隔开
	 */
	public void sendHtmlMail(String title,String content,String to){
		try{
			//发送HTML格式的邮件
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl(); 
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");  
			
			messageHelper.setFrom(from);
			
			//单个收件人
			//messageHelper.setTo(to);
			
	        //多个收件人
			String[] tos = to.split(";");
			messageHelper.setTo(tos);
			messageHelper.setSubject(title);
			messageHelper.setText(content,true);
		    mailSender.send(mailMessage);
		        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送HTML格式的带附件的文本邮件
	 * @param title 标题
	 * @param content 内容
	 * @param to 收件人  多个收件人用";"隔开
	 * @param files 附件文件 key是文件名称 value是附件对象
	 */
	public void sendHtmlFileMail(String title,String content,String to,List<MailBean> files){
		try{
			//发送HTML格式的邮件
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");  
			
			messageHelper.setFrom(from);
			
			//单个收件人
			//messageHelper.setTo(to);
			
	        //多个收件人
			String[] tos = to.split(";");
			messageHelper.setTo(tos);
			messageHelper.setSubject(title);
			messageHelper.setText(content,true);
			
			
			//附件内容  
			for(MailBean mb : files){
				//插入的是图片
				//messageHelper.addInline(mb.getFileName(),mb.getFile());
				
				// 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题  
				messageHelper.addAttachment(MimeUtility.encodeWord(mb.getFileName()), mb.getFile());   
			}
		    mailSender.send(mailMessage);
		        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
