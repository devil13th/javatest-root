package com.thd.lucene;

import java.io.File;
import java.io.FileInputStream;

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

public class IndexTest01 {
	public static void main(String[] args) throws Exception{
		//索引文件夹
		String indexFolder = "D://lucene//index";
		//被索引的文件所在文件夹
		String filesFolder = "D://lucene//files";
		
		//初始化被索引的文件夹
		File filesDir = new File(indexFolder);
		if(!filesDir.exists() || !filesDir.canRead()){
			System.out.println("被索引的文件夹[" + filesDir + "]不存在或不可读取");
		}
		
		
		
		//定义一个索引存放的目录对象，用于存放索引清单[[Directory]]
		/* Directory:
		 * Directory类代表一个Lucene索引的位置
		 * 它是一个抽象的类，允许它的子类存储索引
		 * 用一个适合的FSDirectory的是实现类
		 * 在存储真实文件的目录中 来获得一个合适的FSDirectory实现
		 * 通过它来实例化[[IndexWriter]]
		 * lucene 有若干个Directory实现
		 * IndexWriter不能对文本进行索引，除非被解析器(analyzer)解析成单独的词
		*/
		Directory dir = FSDirectory.open(filesDir.toPath());
		
		
		//解析器[[analyzer]]
		/* Analyzer:
		 * 文本被索引之前被传递到Analyzer
		 * 它负责消除那些除了文本之外的其余的信息，对文本进行索引
		 * 如果被索引的内容不是文本，在进行索引之前你要先从中提取文本内容
		 * [[analyzer]]是一个抽象类，lucene为他提供一些实现，他们可以跳过不进行索引的词(比如介词，形容词等)
		 * 他是lucene中比那些简单的输入过滤更重要的一部分
		 */
		//Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		Analyzer analyzer = new IKAnalyzer();
		
		//索引配置 建立索引工具所需要的配置
		IndexWriterConfig iwc =  new IndexWriterConfig( analyzer);
		
		
		
		//创建一个新的索引
		//iwc.setOpenMode(org.apache.lucene.index.IndexWriterConfig.OpenMode.CREATE);
		
		//更新一个新的索引
		//iwc.setOpenMode(org.apache.lucene.index.IndexWriterConfig.OpenMode.UPDATE);
		
		//如果没有索引则创建，如果有则在已有的索引上附加索引
		iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
		
		
		
		//附加索引
		//iwc.setOpenMode(org.apache.lucene.index.IndexWriterConfig.OpenMode.APPEND);
		
		// 创建和维护索引的工具[[IndexWriter]]
		/* IndexWriter:
		 * IndexWriter 是创建索引过程的核心组件
		 * 它可以创建一个新的索引或者打开一个已经存在的索引以及往已有的索引中添加新的索引或更新和删除
		 * 可以看作是一个对索引有写的功能但是没有读或搜索功能的一个对象
		 * 它需要一些空间来存储索引，这个空间就是Directory建立的
		 */
		IndexWriter indexWriter =  new IndexWriter(dir, iwc);
		
		//循环存放在文件夹下的文件
		String files[] = new File(filesFolder).list();
		
		for(int i = 0 , j = files.length ; i < j ; i++){
			try{
				File file = new File(filesFolder,files[i]);
				FileInputStream fis = new FileInputStream(file);
				
				/*
				 * [[Document]]
				 * Document:
				 * Document包含众多的Field，可以看作是一个想要被检索的数据块的虚拟文档，比如一个网页，一个邮件信息或者一个文本文件
				 * 
				 * Document的Field代表了一个文档或与文档相关的元数据
				 * lucene并不关心被索引的文件，索引是二进制文本，并且加入一个Field的实例，这就是lucene
				 * 元数据(作者，标题，主题和修改时间)被索引并存到文档中的Field中
				 */
				Document doc = new Document();
				System.out.println("文件："  + file.getAbsolutePath() + "建立索引...");
				//建立一个索引领域  1：key 2:关键词(也可以是整个文本) 3:是否被储存 4：建立怎样的索引
				
				/*
				 * [[Field]]
				 * Field:
				 * 每个在索引中的文档都包含了一个或多个Field，每个Field包含一个名字和与之相应的内容以及一些Lucene对这个内容进行索引的选项
				 * 每个文档有可能存在多个相同名字的Field,实际上他们会在索引的时候被合并到一起，在检索的时候他们会被看作一个单一的文本
				 */
				
				/*
				 * public Field(String name,String value,Field.Store store,Field.Index index);
				 * name : Field的名字
				 * value: Field的值
				 * store: Field的值 是否把索引的内容进行保存(会比较慢)
				 *       Field.Store.YES ： 存储字段值  (未分词前的字段值)
				 *       Field.Store.NO ： 不存储,存储与索引没有关系 
				 * index: 如何被索引
				 * 		Field.Index.ANALYZED：分词建索引
				 *      Field.Index.NO : 不进行索引
				 *      Field.Index.ANALYZED_NO_NORMS：分词建索引，但是Field的值不像通常那样被保存，而是只取一个byte，这样节约存储空间
				 *      Field.Index.NOT_ANALYZED：不分词且索引
				 *      Field.Index.NOT_ANALYZED_NO_NORMS：不分词建索引，Field的值去一个byte保存TermVector表示文档的条目（由一个Document和Field定位）和它们在当前文档中所出现的次数
				 *     
				 */
				
				
				Field pathField = new Field("path", file.getPath(), Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS);
				pathField.setIndexOptions(FieldInfo.IndexOptions.DOCS_ONLY);
		        doc.add(pathField);
		        
	//	        doc.add(new Field("contents", new BufferedReader(new InputStreamReader(fis, "UTF-8"))));
		        ReadFileContent rfc = ReadContent.getInstance();
		        //System.out.println(rfc.readContent(file.getPath()));
		        doc.add(new Field("contents", rfc.readContent(file.getPath()), Field.Store.YES, Field.Index.ANALYZED));
		        
		        
		        System.out.println(indexWriter.getConfig().getOpenMode());
		        if(indexWriter.getConfig().getOpenMode() == org.apache.lucene.index.IndexWriterConfig.OpenMode.CREATE)
		        {
		        	System.out.println("create index ...");
		        	 //如果是创建模式
		            System.out.println((new StringBuilder()).append("adding ").append(file).toString());
		            indexWriter.addDocument(doc);
		        } else
		        {
		        	System.out.println("update index ...");	
		        	//不是创建模式
		            System.out.println((new StringBuilder()).append("updating ").append(file).toString());
		            indexWriter.updateDocument(new Term("path", file.getPath()), doc);
		        }
		        
		        fis.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	        
		}
		
		
		indexWriter.close();
		
		System.out.println("索引建立完成");
		
		
	}
}
