package com.thd.hibernate.spring.dao;

import java.util.List;

public interface IService {
	public void saveUsr(Usr u) throws Exception;
	public List queryUsr(String nickname,String usr,String pwd) throws Exception;
}
