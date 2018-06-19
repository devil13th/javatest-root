package com.thd.designpattern.strategy.exam;

public class Client {

	public static void main(String[] args) throws Exception {
		ContentReader pdfReader = new PdfReader();
		ContentReader txtReader = new TxtReader();
		ContentReader wordReader = new WordReader();
		String type = "word";
		Reader reader = null;
		if(type.equals("word")){
			reader = new Reader(wordReader);
		}else if(type.equals("txt")){
			reader = new Reader(txtReader);
		}else if(type.equals("pdf")){
			reader = new Reader(pdfReader);
		}else{
			throw new Exception("未知的文件类型");
		}
		String str = reader.getContent();
		System.out.println(str);
		
	}

}
