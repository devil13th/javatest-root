package com.thd.spring.transaction.annotation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thd.spring.transaction.annotation.dao.BaseDao;
import com.thd.spring.transaction.annotation.pojo.Product;
import com.thd.spring.transaction.annotation.pojo.Sort;
@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private BaseDao dao;
	@Autowired
	private SortService sortServiceImpl;
	public void saveProduct(Product pro) throws Exception{
		Sort s = new Sort();
		s.setSortName("分类");
		sortServiceImpl.saveSort(s);
		//dao.save(s);
		
		
		String insertSQL = "insert sort(sort_id,sort_name) values('" + new Date().getTime()+ "','2')";
		
		dao.executeSql(insertSQL);
		//此处抛出异常 查看sort是否保存成功
		//int a = 1/0;
		
		
		//getCurrentSession().flush() 后SQL可以查询到上面代码保存的记录，否则查不到
		dao.getSessionFactory().getCurrentSession().flush();
		
		String sql = "select * from sort";
		List l = dao.findBySql(sql);
		System.out.println(l);
		
		
		System.out.println("保存产品开始");
		this.dao.save(pro);
		System.out.println("保存产品完毕");
		
		/*
		 * 查看appContext-db.xml中92行的事务配置部分
         * 如果配置的rollback-for是Exception则 所有异常都会回滚 
		 * 如果配置的rollback-for是RuntimeException则只有出现RuntimeException类型的异常才会回顾
		 */
		//throw new Exception("sssss");
		//throw new RuntimeException("sssss");
	}
	
	public void deleteAllProduct(){
		String sql = "delete from product";
		this.dao.executeSql(sql);
		System.out.println("删除所有产品数据");
	}
	
	public void queryForUpdate() throws Exception{
		String sql = "select pro_name from product t where pro_id = '1' for update ";
		List l = this.dao.findBySql(sql);
		System.out.println("111");
		System.out.println(l);
	};

}
