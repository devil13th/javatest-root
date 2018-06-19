package com.thd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
	
	//数据库链接地址
	private String url = "jdbc:mysql://localhost:3306/jdbctest";
	//数据库用户名
	private String uname = "root";
	//数据库密码
	private String upwd = "123456";
	//数据库链接对象
	private Connection conn;
	
	public UserServiceImpl(){}
	
	public UserServiceImpl(String uname,String upwd,String url){
		this.uname = uname;
		this.upwd = upwd;
		this.url = url;
	}
	
	/**
	 * 打开数据库链接
	 * @throws Exception
	 */
	public void openConn() throws Exception{
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(url, uname,upwd);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 关闭数据库链接
	 * @throws Exception
	 */
	public void closeConn() throws Exception{
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * @see com.thd.jdbc.UserService#save(com.thd.jdbc.User)
	 */
	public User save(User u) throws Exception{
		try{
			this.openConn();
			conn.setAutoCommit(false); 
			
			//执行sql语句的方式插入数据
//			String sql = "insert into userinfo(user_name,user_password,remark) values ('" + u.getUsername() + "','" + u.getPassword() + "','" + u.getRemark() + "')";
//			Statement stmt = conn.createStatement();
//			stmt.execute(sql);
			
			//使用带"?"的sql语句插入数据
			String sql = "insert into userinfo(user_name,user_password,remark) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3,u.getRemark());
			pstmt.executeUpdate();
			
			String idSql = " select id  from userinfo order by id desc limit 0,1";
			pstmt = conn.prepareStatement(idSql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				u.setId(rs.getInt(1));
			}
			conn.commit();
			this.closeConn();
			return u;
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}
	}
	
	public void delete(Integer id) throws Exception{
		try{
			this.openConn();
			conn.setAutoCommit(false); 
			
			//使用sql语句删除数据
//			String sql = "delete from userinfo where id = " + id;
//			Statement stmt = conn.createStatement();
//			stmt.execute(sql);
			
			//使用带"?"的sql语句删除数据
			String sql = "delete from userinfo where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.execute();
			//也可以用下面的方法进行删除
			//pstmt.executeUpdate();
			
			conn.commit();
			this.closeConn();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public User loadUser(Integer id) throws Exception{
		try{
			this.openConn();
			conn.setAutoCommit(false); 
			
			String sql = "select id,user_name,user_password,remark from userinfo where id = " + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			User u = null;
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setRemark(rs.getString(4));
			}
			conn.commit();
			this.closeConn();
			return u;
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public List<User> query(String username) throws Exception{
		try{
			List<User> l = new ArrayList<User>();
			this.openConn();
			conn.setAutoCommit(false); 
			
			String sql = "select id,user_name,user_password,remark from userinfo where user_name like ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + username + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				User u = new User();
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setRemark(rs.getString(4));
				l.add(u);
			}
			conn.commit();
			this.closeConn();
			return l;
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	

	public void update(User u) throws Exception{
		try{
			this.openConn();
			conn.setAutoCommit(false); 
			
			//执行sql语句的方式更新数据
//			String sql = "update  userinfo set user_name= '" + u.getUsername() + "' ,user_password = '" + u.getPassword() +"',remark = '" + u.getRemark() + "' where id = " + u.getId();
//			Statement stmt = conn.createStatement();
//			stmt.execute(sql);
			
			//使用带"?"的sql语句更新数据
			String sql = "update  userinfo set user_name= ? ,user_password = ?,remark = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3,u.getRemark());
			pstmt.setInt(4,u.getId());
			pstmt.executeUpdate();
			
			conn.commit();
			this.closeConn();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}

	}

}
