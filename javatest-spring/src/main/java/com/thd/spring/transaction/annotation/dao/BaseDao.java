package com.thd.spring.transaction.annotation.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * @description 保存对象
	 * @param obj 保存的对象
	 */
	public void save(Object obj) {
		sessionFactory.getCurrentSession().save(obj);
	};
	
	/**
	 * @description 更新对象
	 * @param obj 更新的对象
	 */
	public void update(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
	}
	
	/**
	 * @description 删除对象
	 * @param obj 删除的对象 对象要有主键
	 */
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}
	
	/**
	 * @description 根据id删除对象
	 * @param c 删除的对象类型
	 * @param id 删除的对象的主键
	 */
	public void delete(Class c,Serializable id){
		Object obj = findById(c,id);
		this.delete(obj);
	}
	
	/**
	 * @description 保存或更新对象
	 * @param obj 保存或更新的对象 有主键则是更新 没有主键则是保存
	 */
	public void saveOrUpdate(Object obj){
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}
	
	/**
	 * @description 根据id查找对象
	 * @param c 对象的类
	 * @param id 对象的id
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public Object findById(Class c,Serializable id){
		return sessionFactory.getCurrentSession().get(c, id);
	}
	
	/**
	 * @description sql基础查询
	 * @param sql sql语句
	 * @param params 条件的值,对应sql语句中的"?"
	 * @param currPage 当前页
	 * @param pageSize 每页显示条目数量
	 * @return
	 */
	public List<Map<String,Object>> findBySql(String sql,Object[] params,Integer currentPage ,Integer pageSize){
		if(currentPage !=null && pageSize != null && pageSize.compareTo(0)!=0 ){
			sql += " limit " + ((currentPage-1)*pageSize) + "," + pageSize ;
		}
		return this.jdbcTemplate.queryForList(sql, params);
	}
	
	
	
	/**
	 * @description 不带参数的sql全部记录查询
	 * @param sql sql语句
	 * @return
	 */
	public List<Map<String,Object>> findBySql(final String sql) {
		return this.findBySql(sql, null, 0, 0);
	}
	
	
	/**
	 * @description 带参数的sql全部记录查询
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> findBySql( String sql,final Object[] params) {
		return this.findBySql(sql, params, 0, 0);
	}
	
	/**
	 * 不带参数的sql分页查询
	 * @param sql sql语句
	 * @param currPage 当前页
	 * @param pageSize 每页显示条目数量
	 */
	public List<Map<String,Object>> findBySql( String sql,int currPage,int pageSize) {
		return this.findBySql(sql, null, currPage, pageSize);
	}
	
	/**
	 * @description 执行sql语句
	 * @param sql
	 */
	@SuppressWarnings("unchecked")
	public void executeSql( String sql) {
		this.jdbcTemplate.execute(sql);
	}
	
	
	/**
	 * @description 执行带"?"的sql语句
	 * @param sql sql语句
	 * @param params 条件的值,对应sql语句中的"?"
	 */
	@SuppressWarnings("unchecked")
	public void executeSql( String sql, Object[] params) {
		this.jdbcTemplate.update(sql, params);
	}
	
	public Object getOne(List<Object> l ){
		if( (l!=null) && !l.isEmpty()){
			if(l.get(0)!=null){
				return l.get(0);
			}else{
				return null;
			}			
		}else{
			return null;
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
