package com.thd.spring.transaction.annotation.service;

import com.thd.spring.transaction.annotation.pojo.Product;

public interface ProductService {
	public void saveProduct(Product pro) throws Exception;
	public void deleteAllProduct();
	
	public void queryForUpdate() throws Exception;
}
