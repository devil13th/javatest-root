package com.thd.lucene.crud;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.thd.util.file.ReadContent;
import com.thd.util.file.ReadFileContent;

public class UpdateIndex {
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
	
		iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
		IndexWriter indexWriter =  new IndexWriter(dir, iwc);
		Document doc = new Document();
		File file = new File("D:\\lucene\\crud\\files\\test.html");
		
		Field pathField = new Field("path", file.getPath(), Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS);
		pathField.setIndexOptions(FieldInfo.IndexOptions.DOCS_ONLY);
        doc.add(pathField);
        ReadFileContent rfc = ReadContent.getInstance();
        doc.add(new Field("contents", rfc.readContent(file.getPath()), Field.Store.YES, Field.Index.ANALYZED));
        System.out.println("文件："  + file.getAbsolutePath() + "建立索引...");
        indexWriter.updateDocument(new Term("path", file.getPath()), doc);
		indexWriter.close();
		System.out.println("索引更新完成");
		
		
	}
}
