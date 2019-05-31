package com.thd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import junit.framework.TestCase;

import org.junit.Test;

public class JdbcUtilTest extends TestCase {
	@Test
	public void testGetConn() {
		Connection conn = JdbcUtil.getConn();
	}

	@Test
	public void testInsert() {
		Connection conn = JdbcUtil.getConn();
		try {
		
			conn.setAutoCommit(false);
		
			int i = 0;
			String sql = "insert into cash (name,money) values(?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, "devil13th");
				pstmt.setInt(2, 5);
				i = pstmt.executeUpdate();
				
				conn.commit();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
			}
			System.out.println(i);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn);
		}
	}

	@Test
	public void testUpdate() {
		Connection conn = JdbcUtil.getConn();
		int i = 0;
		String sql = "update cash set money = ? where name = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, 15);
			pstmt.setString(2, "devil13th");
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		JdbcUtil.closeConn(conn);
	}

	@Test
	public void testDelete() {
		Connection conn = JdbcUtil.getConn();
		int i = 0;
		String sql = "delete from cash where name = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, "devil13th");
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		JdbcUtil.closeConn(conn);
	}

	@Test
	public void testSelect() {
		Connection conn = JdbcUtil.getConn();
		String sql = "select name,money from cash";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.closeConn(conn);
	}
	
	
	@Test
	public void testBatchInsert() throws Exception{
		long startTime = System.currentTimeMillis();
		Connection conn = JdbcUtil.getConn();
		int ct = 0;
		String sql = "insert into cash (name,money) values(?,?)";
		PreparedStatement pstmt;
		
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		
		for(int i = 0;i<5000;i++){

			pstmt.setString(1,"name_" + i);
			pstmt.setInt(2, i);
			//PreparedStatement批处理方式一
			pstmt.addBatch();
			//System.out.println(i);
			if(i%100 == 0){
				pstmt.executeBatch();
				pstmt.clearBatch();
			}
		}
		pstmt.executeBatch();
		pstmt.clearBatch();
		conn.commit();
//		for(int x = 0 , y = r.length ; x < y ; x++){
//			System.out.println(r[x]);
//		}
		JdbcUtil.closeConn(conn);
		long endTime = System.currentTimeMillis();
		System.out.println( (endTime - startTime) / 1000);
	}
	
	
	@Test
	public void testBatchInsert2() throws Exception{
		long startTime = System.currentTimeMillis();
		Connection conn = JdbcUtil.getConn();
		int ct = 0;
		String sql = "INSERT INTO test_user (user_id,user_name,sex,age,birthday,mes,class_id) value(?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		
		for(int i = 0;i<100000;i++){

			pstmt.setString(1,"u_" + i);
			pstmt.setString(2, "user_" + i);
			pstmt.setString(3, "1");
			pstmt.setInt(4,i% 100);
			pstmt.setDate(5, new Date(System.currentTimeMillis()));
			pstmt.setString(6, "msg_" + i);
			pstmt.setString(7,String.valueOf(i%100));
			pstmt.addBatch();
			//System.out.println(i);
			if(i%500 == 0){
				pstmt.executeBatch();
				pstmt.clearBatch();
			}
		}
		pstmt.executeBatch();
		pstmt.clearBatch();
		conn.commit();
//		for(int x = 0 , y = r.length ; x < y ; x++){
//			System.out.println(r[x]);
//		}
		JdbcUtil.closeConn(conn);
		long endTime = System.currentTimeMillis();
		System.out.println( (endTime - startTime) / 1000);
	}
	
	
	
	
	
	@Test
	public void testTransaction() {
		Connection conn = JdbcUtil.getConn();
		try {
		
			conn.setAutoCommit(false);
		
			int i = 0;
			String sql = "insert into transaction_test (id,name,age) values(?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1,String.valueOf(UUID.randomUUID()).replace("-",""));
				pstmt.setString(2, "devil13th");
				pstmt.setInt(3, (int) (Math.random() * 100));
				i = pstmt.executeUpdate();
				
				int x = 1/0;
				
				conn.commit();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
			}
			System.out.println(i);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn);
		}
	}
	

}
