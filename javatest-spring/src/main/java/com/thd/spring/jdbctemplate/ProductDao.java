package com.thd.spring.jdbctemplate;

import java.util.List;

public interface ProductDao {
	public List query(String sql);
	public void insert();
}
