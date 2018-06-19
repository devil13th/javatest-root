package com.thd.spring.transaction.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thd.spring.transaction.annotation.dao.BaseDao;
import com.thd.spring.transaction.annotation.pojo.Sort;
@Component
public class SortServiceImpl implements SortService {
	@Autowired
	private BaseDao dao;
	@Autowired
	private ProductService productServiceImpl;
	public void saveSort(Sort sort) {
		System.out.println("保存分类开始");
		this.dao.save(sort);
		//this.dao.getSessionFactory().getCurrentSession().getTransaction().commit();
		
		System.out.println("保存分类完毕");
	}
	
	public void deleteAllSort(){
		String sql = "delete from sort";
		this.dao.executeSql(sql);
		System.out.println("删除所有分类数据");
	}

}
