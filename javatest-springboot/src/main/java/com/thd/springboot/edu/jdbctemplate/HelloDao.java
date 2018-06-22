package com.thd.springboot.edu.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class HelloDao {
	@Autowired  
    JdbcTemplate jdbcTemplate;  

    public int update() {  
        String sql = "update demo set name = ? where id = ?";  
        Object[] params = new Object[]{"张三",1};  
        return jdbcTemplate.update(sql, params);  
    }  

    public List queryForList() {  
        /*String sql = "select dic_id ,dic_name from sys_dic_pub where dic_id = ?";  
        Object[] params = new Object[]{1};  
        return jdbcTemplate.queryForList(sql, params);  */
    	String sql = "select dic_id ,dic_name from sys_dic_pub";  
        
        return jdbcTemplate.queryForList(sql); 
    }  
}
