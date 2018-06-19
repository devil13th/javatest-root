package com.thd.jdbc;

import java.util.List;

public interface UserService {
	/**
	 * 插入数据
	 * @param u 要保存的数据对象(数据库字段对应的是User对象的各个属性)
	 * @return 保存记录的对象(已经存进id属性为数据库的主键)
	 */
	public User save(User u) throws Exception;
	
	/**
	 * 根据id(主键)查询某条数据
	 * @param id 主键
	 * @return 如果没有对应主键的记录则返回null 否则将记录的字段转换承User对象的属性返回User对象
	 */
	public User loadUser(Integer id) throws Exception;
	
	/**
	 * 根据用户名查询
	 * @param username 用户名
	 * @return User对象集合
	 */
	public List<User> query(String username) throws Exception;
	
	/**
	 * 根据id(主键)删除记录
	 * @param id 记录id(主键)
	 */
	public void delete(Integer id) throws Exception;
	
	/**
	 * 根据User.id(主键)更新对象
	 * @param u 更新的内容(数据库字段对应的是User对象的各个属性)
	 */
	public void update(User u) throws Exception;
	
}
