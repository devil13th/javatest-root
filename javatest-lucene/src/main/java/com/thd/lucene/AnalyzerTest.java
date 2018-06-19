package com.thd.lucene;

import java.io.StringReader;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class AnalyzerTest {
	
	public static Analyzer[] list = new Analyzer[]{new StandardAnalyzer(Version.LUCENE_6_1_0),new IKAnalyzer()};
	
	public static void main(String[] args) throws Exception {
		
		for(Analyzer a : list){
			System.out.println(a);
			System.out.println("=======================");
			String s = "老婆好怀孕，母子平安心血来潮去了天安门";
			StringReader reader = new StringReader(s);
		    TokenStream ts = a.tokenStream(s, reader);
		    CharTermAttribute termAtt = ts.getAttribute(CharTermAttribute.class);
		    
//	      TypeAttribute typeAtt= ts.getAttribute(TypeAttribute.class);
//	      OffsetAttribute offsetAtt= ts.getAttribute(OffsetAttribute.class);
//	      PositionIncrementAttribute  posAtt= ts.getAttribute(PositionIncrementAttribute.class);
//	      System.out.println("termAtt\ttypeAtt\toffsetAtt\tposAtt");

		    System.out.println(ts);
		    while (ts.incrementToken()) 
	        {
//	            System.out.println(termAtt.toString()+"\t"+typeAtt.type()+"\t("+offsetAtt.startOffset()+","+offsetAtt.endOffset()+")\t"+posAtt.getPositionIncrement());
	            System.out.println(termAtt.toString());
	        }
		}
		
		
		


	}

}
