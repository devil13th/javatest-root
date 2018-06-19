package com.thd.hibernate.spring.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class PubDao  {
	private Logger log = Logger.getLogger(this.getClass());
	
	private SessionFactory sessionFactory;
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Object obj) throws Exception{
		sessionFactory.getCurrentSession().save(obj);
	};
	
	public List query( String nickname, String usr, String pwd){
		List condition = new ArrayList();
		StringBuilder sql = new StringBuilder("select id,usr,pwd,nickname from usr where 1=1");
		
		log.debug("=========" + nickname + "========");
		log.debug("=========" + usr + "========");
		log.debug("=========" + pwd + "========");
		
		
		if(nickname != null && !nickname.trim().equals("")){
			sql.append(" and nickname like ? ");
			condition.add(nickname);
		}
		if(usr != null && !usr.trim().equals("")){
			sql.append(" and usr like ? ");
			condition.add(usr);
		}
		if(pwd != null && !pwd.trim().equals("")){
			sql.append(" and pwd like ? ");
			condition.add(pwd);
		}
		return jdbcTemplate.queryForList(sql.toString(), condition.toArray());
	}
}
