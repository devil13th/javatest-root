package com.thd.spring.transaction.annotation.pojo;

import com.thd.spring.transaction.annotation.pojo.base.BaseProduct;



public class Product extends BaseProduct {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Product () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Product (java.lang.String proId) {
		super(proId);
	}

/*[CONSTRUCTOR MARKER END]*/


}