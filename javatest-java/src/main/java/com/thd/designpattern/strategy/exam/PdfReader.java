package com.thd.designpattern.strategy.exam;

public class PdfReader implements ContentReader {

	public String read() {
		return "读取pdf内容";
	}

}
