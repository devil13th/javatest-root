package com.thd.spring.transaction.annotation.service;

import com.thd.spring.transaction.annotation.pojo.Sort;

public interface SortService {
	public void saveSort(Sort sort);
	public void deleteAllSort();
}
