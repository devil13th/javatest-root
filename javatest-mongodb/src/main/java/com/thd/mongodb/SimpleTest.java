package com.thd.mongodb;

import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class SimpleTest {

	@Test
	public void test01() throws Exception {
		//创建了一个MongoDB的数据库连接对象，它默认连接到当前机器的localhost地址，端口是27017
		Mongo mg = new Mongo();
		
		// 查询所有的Database
		for (String name : mg.getDatabaseNames()) {
			System.out.println("dbName: " + name);
		}
		
		
		//获得了一个test的数据库，如果mongoDB中没有创建这个数据库也是可以正常运行的。
		//mongoDB可以在没有创建这个数据库的情况下，完成数据的添加操作。
		//当添加的时候，没有这个库，mongoDB会自动创建当前数据库。
		DB db = mg.getDB("test");
		
		//我们要获取一个“聚集集合DBCollection”，通过db对象的getCollection方法来完成
		// 查询所有的聚集集合
		for (String name : db.getCollectionNames()) {
			System.out.println("collectionName: " + name);
		}
		
		//获得了一个DBCollection，它相当于我们数据库的“表”
		DBCollection devil = db.getCollection("devil");
		
		// 查询所有的数据
		DBCursor cur = devil.find();
		while (cur.hasNext()) {
			System.out.println(cur.next());
		}
		
		System.out.println(cur.count());
		System.out.println(cur.getCursorId());
		System.out.println(JSON.serialize(cur));
		mg.close();
	}
}
