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
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class SearchTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String indexFolder = "D://lucene//index";
		String q = "乱码";
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

		for (int i = 0; i < hits.length; i++) {
			Document doc = is.doc(hits[i].doc);
			//得分
			System.out.println(hits[i].score);
			
			System.out.println(doc.get("path"));
			//System.out.println(doc.get("contents"));

		}

		long end = new Date().getTime();

		System.out.println("Found " + hits.length + " document(s) (in " + (end - start) + " milliseconds) that matched query '" + q + "':");

	}

}
