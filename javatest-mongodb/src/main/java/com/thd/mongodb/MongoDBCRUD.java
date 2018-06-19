package com.thd.mongodb;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoDBCRUD {
	private Mongo mg = null;
	private DB db;
	private DBCollection users;

	@Before
	public void init() {
		try {
			mg = new Mongo();
			// mg = new Mongo("localhost", 27017);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取temp DB；如果默认没有创建，mongodb会自动创建
		db = mg.getDB("mymongo");
		
		// 获取users DBCollection；如果默认没有创建，mongodb会自动创建
		users = db.getCollection("myuser");
	}
	
	@Test
	public void showDBs(){
		//显示所有的数据库
		for (String name : mg.getDatabaseNames()) {
            System.out.println("dbName: " + name);
        }
		System.out.println("==================");
		DB db = mg.getDB("mymongo");
        //查询所有的聚集集合(数据库表)
        for (String name : db.getCollectionNames()) {
            System.out.println("collectionName: " + name);
        }
	}
	
	@Test
	public void save(){
		DBObject user = new BasicDBObject();
		user.put("name", "devil");
	    user.put("age", 24);
	    user.put("sex", "男");
	    user.put("addr", "北京西城");
	   users.save(user);
	   System.out.println("save finish");
	}
	
	@Test
	public void queryAll() {
	    print("查询users的所有数据：");
	    //db游标
	    DBCursor cur = users.find();
	    while (cur.hasNext()) {
	        DBObject obj = cur.next();
	        System.out.println(obj.get("_id")+":"+obj.get("name"));
	    }
	}
	
	
	@Test
	public void remove() {
	    queryAll();
	    String id = "51204707fbe6bf95a114376b";
	    print("删除id = " + id + "：" + users.remove(new BasicDBObject("_id", new ObjectId(id))).getN());
	   // print("remove age >= 24: " + users.remove(new BasicDBObject("age", new BasicDBObject("$gte", 24))).getN());
	}

	@After
	public void destory() {
		if (mg != null)
			mg.close();
		mg = null;
		db = null;
		users = null;
		System.gc();
	}

	public void print(Object o) {
		System.out.println(o);
	}
}
