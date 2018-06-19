package com.thd.spring.jdbctemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProductDaoImpl {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List query(String sql){
		return jdbcTemplate.queryForList(sql);
	}
	
	public void insert(){
		String sql="";
		for(int i = 0 , j = 100000 ; i < j ; i++){
			sql = "insert product(pro_id,pro_name,sort_id) values (" + i + ",'proName_" + i + "','sortId_" + i +"')";
			jdbcTemplate.execute(sql);
			System.out.println(i);
		}
		
		
	};
}
