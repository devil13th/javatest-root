package com.thd.mybatis.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.thd.mybatis.pojo.User;

public class Example {
	public static void main(String[] args) throws Exception{
		// 指定全局配置文件
        String resource = "conf/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
        // 第二个参数：指定传入sql的参数：这里是用户id
        System.out.println(" =========== sqlSession.selectOne ============== ");
        User user = sqlSession.selectOne("MyMapper.selectUser", 1);
        System.out.println(user);
        System.out.println(" =========== sqlSession.selectMap ============== ");
        Map m = sqlSession.selectMap("MyMapper.selectUser", "1");
        System.out.println(m);
        
        System.out.println(" =========== sqlSession.selectList ============== ");
        List l = sqlSession.selectList("queryUserAll");
        System.out.println(l);
        List l2 = sqlSession.selectList("queryUserAllForMap");
        System.out.println(l2);
        
        Map cdt = new HashMap();
        cdt.put("name", "张三");
        cdt.put("userName", "zs");
        List l3 = sqlSession.selectList("queryUserForCondition", cdt);
        System.out.println(l3);
	}
}
