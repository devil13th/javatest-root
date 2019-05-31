package com.thd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import junit.framework.TestCase;

import org.junit.Test;

public class JdbcTransactionTest extends TestCase {
	@Test
	public void testGetConn() {
		Connection conn = JdbcUtil.getConn();
	}


	
	
	@Test
	public void testTransaction() {
		Connection conn = JdbcUtil.getConn();
		try {
		
			conn.setAutoCommit(false);
		
			int i = 0;
			String sql = "insert into transaction_testa (id,name,age) values(?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1,String.valueOf(UUID.randomUUID()).replace("-",""));
				pstmt.setString(2, "devil13th");
				pstmt.setInt(3, (int) (Math.random() * 100));
				i = pstmt.executeUpdate();
				
				//int x = 1/0;
				
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
	public void testBatchExecute() {
		Connection conn = JdbcUtil.getConn();
		try {
		
			conn.setAutoCommit(false);
		
			String sqlA = "insert into transaction_testa (id,name,age) values(?,?,?)";
			String sqlB = "insert into transaction_testb (id,school,nickname) values(?,?,?)";
			PreparedStatement pstmtA = (PreparedStatement) conn.prepareStatement(sqlA);
			PreparedStatement pstmtB = (PreparedStatement) conn.prepareStatement(sqlB);
			
			try {
				
				for(int i = 0 , j = 1000 ; i < j ; i++){
					String rid = String.valueOf(UUID.randomUUID()).replace("-","");
					
					pstmtA.setString(1,rid);
					pstmtA.setString(2, "name_" + i);
					pstmtA.setInt(3, i%100);
					pstmtA.addBatch();
					
					pstmtB.setString(1,rid);
					pstmtB.setString(2, "school_" + i);
					pstmtB.setString(3, "nickname_" + i);
					pstmtB.addBatch();
					
				}
				
				int[] resultCountA = pstmtA.executeBatch();
				int[] resultCountB = pstmtB.executeBatch();
				
				System.out.println(resultCountA);
				System.out.println(resultCountB);
				conn.commit();
				pstmtA.close();
				pstmtB.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
			}
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn);
		}
	}
	
	
	@Test
	public void testClearData() {
		Connection conn = JdbcUtil.getConn();
		try {
		
			conn.setAutoCommit(false);
		
			String sqlA = "delete from transaction_testa";
			String sqlB = "delete from transaction_testb";
			PreparedStatement pstmtA = (PreparedStatement) conn.prepareStatement(sqlA);
			PreparedStatement pstmtB = (PreparedStatement) conn.prepareStatement(sqlB);
			
				
			int resultCountA = pstmtA.executeUpdate();
			int resultCountB = pstmtB.executeUpdate();
			
			System.out.println(resultCountA);
			System.out.println(resultCountB);
			conn.commit();
			pstmtA.close();
			pstmtB.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn);
		}
	}
	
	
	@Test
	public void testQuery() {
		Connection conn = JdbcUtil.getConn();
		try {
		
			conn.setAutoCommit(false);
			
			String sqlInsert = "insert into transaction_testa (id,name,age) values(?,?,?)";
			PreparedStatement pstmtInsert = (PreparedStatement) conn.prepareStatement(sqlInsert);
			String rid = String.valueOf(UUID.randomUUID()).replace("-","");
			
			pstmtInsert.setString(1,rid);
			pstmtInsert.setString(2, "name_");
			pstmtInsert.setInt(3, 3);
			pstmtInsert.executeUpdate();
			
			String sqlA = "select id,name,age from transaction_testa where id = ?";
			PreparedStatement pstmtA = (PreparedStatement) conn.prepareStatement(sqlA);
			pstmtA.setString(1, rid);
			
			ResultSet rs = pstmtA.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			
			
			conn.commit();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn);
		}
	}
}
