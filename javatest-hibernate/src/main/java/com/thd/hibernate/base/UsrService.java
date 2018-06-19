package com.thd.hibernate.base;

import java.io.Serializable;
import java.util.List;

public interface UsrService {
	public void save(Test01 u);
	public List<Test01> queryAllUsr(int begin,int count);
	public List queryUsrByNickName(String usrName);
	public Test01 findTest01ById(Serializable id);
}
