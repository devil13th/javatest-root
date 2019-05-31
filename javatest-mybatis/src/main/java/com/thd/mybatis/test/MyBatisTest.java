package com.thd.mybatis.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.thd.mybatis.pojo.User;

public class MyBatisTest {
	// 指定全局配置文件
    private String resource = "conf/mybatis-config.xml";
    private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws Exception{
		//System.out.println(" ------------------- init ------------------ ");
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testselectOne(){
		 // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
        // 第二个参数：指定传入sql的参数：这里是用户id
        System.out.println(" =========== sqlSession.selectOne ============== ");
        User user = sqlSession.selectOne("MyMapper.selectUser", 1);
        System.out.println(user);
        sqlSession.close();
	}
	
	
	@Test
	public void testselectMap(){
		 // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(" =========== sqlSession.selectMap ============== ");
        Map m = sqlSession.selectOne("MyMapper.selectUserForMap", 1);
        System.out.println(m);
        sqlSession.close();
	}
	
	@Test
	public void testselectList(){
		 // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
		 System.out.println(" =========== sqlSession.selectList ============== ");
	     List l = sqlSession.selectList("queryUserAll");
	     System.out.println(l);
	     List l2 = sqlSession.selectList("queryUserAllForMap");
	     System.out.println(l2);
	     sqlSession.close();
	}
	
	@Test
	public void testqueryUserForCondition(){
		 // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map cdt = new HashMap();
        cdt.put("name", "张三");
        cdt.put("userName", "zs");
        List l3 = sqlSession.selectList("queryUserForCondition", cdt);
        System.out.println(l3);
	}
	
	
}
