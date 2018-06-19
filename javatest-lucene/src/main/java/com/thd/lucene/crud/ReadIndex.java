package com.thd.lucene.crud;

import java.io.File;
import java.io.StringReader;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class ReadIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String indexFolder = "D://lucene//crud//index";
		String q = "字典";
		IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexFolder)));
		IndexSearcher is = new IndexSearcher(reader);

		String field = "contents";
		
		//Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		Analyzer analyzer = new IKAnalyzer();
		QueryParser parser = new QueryParser(Version.LUCENE_35,field,analyzer);

		Query query = parser.parse(q);
		
		
		
		long start = new Date().getTime();

		TopDocs docs = is.search(query, 15);
		
		//全部搜索集合
		ScoreDoc[] hits = docs.scoreDocs;
		
		
		//分页 从第几条开始 拿出几条
		//ScoreDoc[] hits = collector.topDocs(2, 3).scoreDocs;
		
		
		System.out.println("有【"+ hits.length + "】条结果");
		
		
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
		Highlighter highlighter_abstract = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
		Highlighter highlighter_all = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
		
		//new SimpleFragmenter(200) 是关键词附件多少字(字数不是很准确)
		highlighter_abstract.setTextFragmenter(new SimpleFragmenter(200));
		//highlighter_all.setTextFragmenter(new SimpleFragmenter(100));

		for (int i = 0; i < hits.length; i++) {
			Document doc = is.doc(hits[i].doc);
			//得分
			System.out.println(hits[i].score);
			
			System.out.println(doc.get("path"));
			
			TokenStream token = analyzer.tokenStream("contents", new StringReader(doc.get("contents")));
			 //String keyWorkOfContent = highlighter_abstract.getBestFragments(token, doc.get("contents"),250,"...");
			String keyWorkOfContent = highlighter_abstract.getBestFragment(token, doc.get("contents"));
			
			// System.out.println("contents:" + doc.get("contents"));
			 System.out.println("keyWorkOfContent:" + keyWorkOfContent);
			 System.out.println("================================================");
		}

		long end = new Date().getTime();

		System.out.println("Found " + hits.length + " document(s) (in " + (end - start) + " milliseconds) that matched query '" + q + "':");

	}

}
