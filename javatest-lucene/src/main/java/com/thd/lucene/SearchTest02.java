package com.thd.lucene;

import java.io.File;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class SearchTest02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String indexFolder = "D://lucene//index";
		
		
		
		String q = "要使页面不出现乱码";
		
		IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexFolder)));
		IndexSearcher is = new IndexSearcher(reader);

		String field = "contents";
		
		//Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);		
		Analyzer analyzer = new IKAnalyzer();
		
		QueryParser parser = new QueryParser(Version.LUCENE_35,field,analyzer);
		
		
		Query query = parser.parse(q);
		//TokenStream tokenStream = analyzer.reusableTokenStream("text", new StringReader(q)); 
		SimpleHTMLFormatter simpleHtmlFormatter = new SimpleHTMLFormatter("<------------->", "</---------->");  
		Highlighter highlighter = new Highlighter(simpleHtmlFormatter, new QueryScorer(query));
		
		//提取前15个记录
		TopScoreDocCollector collector = TopScoreDocCollector.create(15, true);
		long start = new Date().getTime();

		is.search(query, collector);
		
		//全部搜索集合
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		//分页结合
		//ScoreDoc[] hits = collector.topDocs(2,10).scoreDocs;
		
		
		System.out.println("有【"+ hits.length + "】条结果");

		for (int i = 0; i < hits.length; i++) {
			System.out.println("========================================================================================================================================================================================================================");
			Document doc = is.doc(hits[i].doc);
			//得分
			System.out.println(hits[i].score);
			
			//获取最佳匹配的段落
			String highLightText = highlighter.getBestFragment(analyzer,"",doc.get("contents"));
			System.out.println(highLightText);
			System.out.println(doc.get("path"));
			//System.out.println(doc.get("contents"));
		}

		long end = new Date().getTime();

		System.out.println("Found " + collector.getTotalHits() + " document(s) (in " + (end - start) + " milliseconds) that matched query '" + q + "':");

	}

}
