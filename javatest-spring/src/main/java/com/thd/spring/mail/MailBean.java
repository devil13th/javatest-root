package com.thd.spring.mail;

import java.io.File;

public class MailBean {
	public MailBean(String fileName,File file){
		this.file = file;
		this.fileName = fileName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	private File file;
	private String fileName;
}
