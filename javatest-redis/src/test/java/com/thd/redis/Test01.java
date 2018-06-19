package com.thd.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

public class Test01 extends TestCase {
	private Jedis jedis;

	@Before
	public void setUp() {
		System.out.println(" ------------ setUp() ------------");

		// 连接redis服务
		jedis = new Jedis("192.168.1.107", 6379);

		// 密码验证-如果你没有设置redis密码可不验证即可使用相关命令
		// jedis.auth("abcdefg");
	}

	@Test
	// 键值对存储
	public void test01() {
		// 简单的key-value 存储
		jedis.set("redis", "myredis");
		System.out.println(jedis.get("redis"));
	}

	@Test
	// 键值对存储
	public void test02() {
		// 简单的key-value 存储
		jedis.set("redis", "myredis");
		System.out.println(jedis.get("redis"));

		// 在原有值得基础上添加,如若之前没有该key，则导入该key
		// 之前已经设定了redis对应"myredis",此句执行便会使redis对应"myredisyourredis"
		jedis.append("redis", ",yourredis");
		jedis.append("content", "rabbit | ");
		System.out.println(jedis.get("redis"));
		System.out.println(jedis.get("content"));

	}

	@Test
	// 多个键值对存储
	public void test03() {

		// mset 是设置多个key-value值 参数（key1,value1,key2,value2,...,keyn,valuen）
		// mget 是获取多个key所对应的value值 参数（key1,key2,key3,...,keyn） 返回的是个list
		jedis.mset("name1", "yangw", "name2", "demon", "name3", "elena");
		System.out.println(jedis.mget("name1", "name2", "name3"));
	}

	@Test
	// map
	public void test04() {
		// map
		Map<String, String> user = new HashMap<String, String>();
		user.put("name", "devil13th");
		user.put("password", "123456");
		// map存入redis
		jedis.hmset("user", user);
		// mapkey个数
		System.out.println("user's key 个数:" + jedis.hlen("user"));
		// map中的所有键值
		System.out.println("user's key 集合:" + jedis.hkeys("user"));
		// map中的所有value
		System.out.println("user's value 集合：" + jedis.hvals("user"));
		// 取出map中的name字段值
		List<String> rsmap = jedis.hmget("user", "name", "password");
		System.out.println("user's name and password is :" + rsmap);
		// 删除map中的某一个键值 password
		jedis.hdel("user", "password");
		System.out.println("user's name and password is :"
				+ jedis.hmget("user", "name", "password"));
	}

	@Test
	// list
	public void test05() {
		jedis.del("listDemo");
		System.out.println(jedis.lrange("listDemo", 0, -1));
		jedis.lpush("listDemo", "A");
		jedis.lpush("listDemo", "B");
		jedis.lpush("listDemo", "C");
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("listDemo", 0, -1));
		System.out.println(jedis.lrange("listDemo", 0, 1));
	}

	@Test
	// set
	public void test06() {
		jedis.sadd("sname", "wobby");
		jedis.sadd("sname", "kings");
		jedis.sadd("sname", "demon");
		System.out.println(String.format("set num: %d", jedis.scard("sname")));
		System.out.println(String.format("all members: %s",
				jedis.smembers("sname")));
		System.out.println(String.format("is member: %B",
				jedis.sismember("sname", "wobby")));
		System.out.println(String.format("rand member: %s",
				jedis.srandmember("sname")));
		// 删除一个对象
		jedis.srem("sname", "demon");
		System.out.println(String.format("all members: %s",
				jedis.smembers("sname")));
	}

	@Test
	// 事务
	public void test07() {
		// redis的事务很简单，他主要目的是保障，一个client发起的事务中的命令可以连续的执行，而中间不会插入其他client的命令。
		long start = System.currentTimeMillis();
		Transaction tx = jedis.multi();
		for (int i = 0; i < 100000; i++) {
			tx.set("t" + i, "t" + i);
			// tx.del("t" + i);
		}
		List<Object> results = tx.exec();
		long end = System.currentTimeMillis();
		System.out.println("Transaction SET: " + ((end - start) / 1000.0)
				+ " seconds");
	}

	@Test
	// 管道
	public void test08() {
		// 有时，我们需要采用异步方式，一次发送多个指令，不同步等待其返回结果。这样可以取得非常好的执行效率。这就是管道
		Pipeline pipeline = jedis.pipelined();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			pipeline.set("p" + i, "p" + i);
			// pipeline.del("p" + i, "p" + i);
		}
		List<Object> results = pipeline.syncAndReturnAll();
		long end = System.currentTimeMillis();
		System.out.println("Pipelined SET: " + ((end - start) / 1000.0)
				+ " seconds");
	}

	@Test
	// 管道中使用事务
	public void test09() {
		long start = System.currentTimeMillis();
		Pipeline pipeline = jedis.pipelined();
		pipeline.multi();
		for (int i = 0; i < 100000; i++) {
			pipeline.set("" + i, "" + i);
		}
		pipeline.exec();
		List<Object> results = pipeline.syncAndReturnAll();
		long end = System.currentTimeMillis();
		System.out.println("Pipelined transaction: " + ((end - start) / 1000.0)
				+ " seconds");
	}

	@After
	public void tearDown() {
		System.out.println(" ------------ tearDown() ------------");
		jedis.disconnect();
		jedis.close();
	}
}
