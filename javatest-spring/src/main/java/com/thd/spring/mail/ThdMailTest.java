package com.thd.spring.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThdMailTest {
	private ThdMail mail;
	@Before
	public void init(){
		String[] appContext = new String[]{"classpath:com/thd/spring/mail/app-mail.xml"};
		ApplicationContext factory=new ClassPathXmlApplicationContext(appContext); 
		mail = (ThdMail)factory.getBean("thdMail");
	}
	
	@Test
	public void sendMail(){
		mail.sendMail("DSMIS测试邮件","<h1>测试DSMIS邮件系统</h1>","lwang@ccsit.cn;");
		System.out.println("finish");
	}
	
	@Test
	public void sendHtmlMail(){
		mail.sendHtmlMail("DSMIS测试邮件","<h1>测试DSMIS邮件系统</h1>","lwang@ccsit.cn;");
		System.out.println("finish");
	}
	
	@Test
	public void sendHtmlFileMail(){
		List<MailBean> files = new ArrayList<MailBean>();
		files.add(new MailBean("PDF文件.pdf",new File("D:/p.pdf")));
		files.add(new MailBean("abb.txt",new File("D:/abb.txt")));
		mail.sendHtmlFileMail("DSMIS测试邮件","<h1>测试DSMIS邮件系统</h1>","lwang@ccsit.cn;",files);
		System.out.println("finish");
	}
}
