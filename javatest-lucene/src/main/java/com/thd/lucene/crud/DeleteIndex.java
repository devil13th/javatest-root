package com.thd.lucene.crud;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class DeleteIndex {
	public static void main(String[] args) throws Exception{
		//索引文件夹
		String indexFolder = "D://lucene//crud//index";
		//被索引的文件所在文件夹
		String filesFolder = "D://lucene//crud//files";
		
		//初始化被索引的文件夹
		File filesDir = new File(indexFolder);
		if(!filesDir.exists() || !filesDir.canRead()){
			System.out.println("被索引的文件夹[" + filesDir + "]不存在或不可读取");
		}

		Directory dir = FSDirectory.open(filesDir);

		//Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		Analyzer analyzer = new IKAnalyzer();
		
		//索引配置 建立索引工具所需要的配置
		IndexWriterConfig iwc =  new IndexWriterConfig(Version.LUCENE_35, analyzer);
		
		File file = new File("D:\\lucene\\crud\\files\\test.html");
		
		//创建一个新的索引
		//iwc.setOpenMode(org.apache.lucene.index.IndexWriterConfig.OpenMode.CREATE);
		
		//更新一个新的索引
		//iwc.setOpenMode(org.apache.lucene.index.IndexWriterConfig.OpenMode.UPDATE);
		
		//如果没有索引则创建，如果有则在已有的索引上附加索引
		iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
		
		

		IndexWriter indexWriter =  new IndexWriter(dir, iwc);
		
		//循环存放在文件夹下的文件
	
		
		//indexWriter.deleteDocuments(new Term("path", file.getAbsolutePath()));
		indexWriter.deleteDocuments(new Term("path","D:\\lucene\\crud\\files\\test.html"));
		
		indexWriter.close();
		
		System.out.println("索引删除完成");
		
		
	}
}
