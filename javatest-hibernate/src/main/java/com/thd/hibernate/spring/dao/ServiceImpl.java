package com.thd.hibernate.spring.dao;

import java.util.List;

public class ServiceImpl implements IService {
	private PubDao dao;
	
	
	public PubDao getDao() {
		return dao;
	}


	public void setDao(PubDao dao) {
		this.dao = dao;
	}


	public void saveUsr(Usr u) throws Exception{
		try{
			this.dao.save(u);
		}catch(Exception e){
			throw e;
		}
		
	};
	
	public List queryUsr(String nickname,String usr,String pwd) throws Exception{
		try{
			return this.dao.query(nickname,usr,pwd);
		}catch(Exception e){
			throw e;
		}
	};
}
