package com.thd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;
public class DataInitTest extends TestCase {
	@Test
	public void testGetConn() {
		Connection conn = JdbcUtil.getConn();
	}
	@Test
	public void testInsertTestClassData() throws Exception{
		long startTime = System.currentTimeMillis();
		Connection conn = JdbcUtil.getConn();
		int ct = 0;
		String sql = "INSERT INTO test_class(class_id,class_name,class_info,class_grade,class_no) value(?,?,?,?,?)";
		PreparedStatement pstmt;
		
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		
		for(int grade = 1; grade <=10;grade++){
			for(int no = 1;no < 10 ; no++){
			pstmt.setString(1,"class_" + grade + "_" + no);
			pstmt.setString(2, "班级_" + grade + "_" + no);
			pstmt.setString(3, "class_info_" + grade + "_" + no);
			pstmt.setInt(4,grade);
			pstmt.setInt(5,no);
			pstmt.addBatch();
			//System.out.println(i);
			
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
	public void testInsertTestUserData() throws Exception{
		long startTime = System.currentTimeMillis();
		Connection conn = JdbcUtil.getConn();
		int ct = 0;
		String sql = "INSERT INTO test_user (user_id,user_name,sex,age,birthday,mes,class_id) value(?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		
		int batchNo = 1000;
		for(int i = 0;i<1000000;i++){

			pstmt.setString(1,"u_" + i);
			pstmt.setString(2, "user_" + i);
			pstmt.setString(3, "1");
			pstmt.setInt(4,i% 100);
			pstmt.setDate(5, new Date(System.currentTimeMillis()));
			pstmt.setString(6, "msg_" + i);
			pstmt.setString(7, "class_" + (i/100000) + "_" + (i % 10));
			pstmt.addBatch();
			//System.out.println(i);
			if(i%batchNo == 0){
				pstmt.executeBatch();
				pstmt.clearBatch();
				System.out.println(i);
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
	
	
	
	/**
explain 
SELECT
	test_user.user_id,
	test_user.user_name,
	test_user.class_id,
	test_class.class_name
FROM
	(select * from test_user where test_user.user_id = 'u_1')  test_user
LEFT JOIN test_class ON test_user.class_id = test_class.class_id   
----------------------------------------------------------------
explain 
SELECT
	test_user.user_id,
	test_user.user_name,
	test_user.class_id,
	test_class.class_name
FROM
	  test_user
LEFT JOIN test_class ON test_user.class_id = test_class.class_id   
where test_user.user_name = 'user_1'
	 */
	
	
	
	
	
	@Test
	public void testInsertIndexTestData() throws Exception{
		long startTime = System.currentTimeMillis();
		Connection conn = JdbcUtil.getConn();
		//学校数组
		String[] schools = new String[]{"四中","八中","三十五中","三中","一五九中","清华","北大","清风小学"};
		//每个学校的班级数量
		int numberOfClass = 200;
		//每个班级学生数量
		int numberOfStudent = 1000;
		
		int ct = 0;
		PreparedStatement pstmtForSchool;
		PreparedStatement pstmtForClass;
		PreparedStatement pstmtForStudent;
		String insertSchoolDataSql = "insert into index_school(school_id,school_no,school_name,school_area) value (?,?,?,?)";
		String insertClassDataSql = " insert into index_class(class_id,class_no,class_name,class_grade,school_id) value (?,?,?,?,?)";
		String insertStudentDataSql = " insert into index_student(student_id,student_no,student_name,student_sex,student_birthday,class_id) value (?,?,?,?,?,?)";
		conn.setAutoCommit(false);
		pstmtForSchool = conn.prepareStatement(insertSchoolDataSql);
		pstmtForClass = conn.prepareStatement(insertClassDataSql);
		pstmtForStudent = conn.prepareStatement(insertStudentDataSql);
		
		for(int i = 0 , j = schools.length ;i  < j ; i++){

			System.out.println(i + " _ start ");
			pstmtForSchool.setString(1,"school_" + i);
			pstmtForSchool.setString(2, "school_" + i);
			pstmtForSchool.setString(3, schools[i]);
			pstmtForSchool.setString(4, "北京西城");
			pstmtForSchool.addBatch();
			for(int x = 0 , y = numberOfClass ; x < y ; x++){
				pstmtForClass.setString(1, "class_" + i + "_" + x);
				pstmtForClass.setString(2, "class_" + i + "_" + x);
				pstmtForClass.setString(3, "班级_" + i + "_" + x);
				pstmtForClass.setInt(4, (x%9+1));
				pstmtForClass.setString(5, "school_" + i);
				pstmtForClass.addBatch();
				for(int m = 0 , n = numberOfStudent ; m < n ; m++){
					ct++;
					pstmtForStudent.setString(1, "student_" + ct);
					pstmtForStudent.setString(2, "s_" + ct);
					pstmtForStudent.setString(3, Tool.getName());
					//pstmtForStudent.setString(3,"姓名_" + ct);
					pstmtForStudent.setInt(4, (ct % 2 + 1));
					pstmtForStudent.setDate(5, new Date(System.currentTimeMillis()));
					pstmtForStudent.setString(6, "class_" + i + "_" + x);
					pstmtForStudent.addBatch();
				}
				pstmtForStudent.executeBatch();
				pstmtForStudent.clearBatch();
				
				pstmtForClass.executeBatch();
				pstmtForClass.clearBatch();
				
				System.out.println(schools[i] + " _ " + "class_" + i + "_" + x);
			}
			
			pstmtForSchool.executeBatch();
			pstmtForSchool.clearBatch();
			
			conn.commit();

			System.out.println(i + " _ finish ");
		}
		
		
		JdbcUtil.closeConn(conn);
		long endTime = System.currentTimeMillis();
		System.out.println( (endTime - startTime) / 1000);
		
	}
	
	
	public static void main(String[] args) throws Exception{
		DataInitTest t = new DataInitTest();
		t.testInsertIndexTestData();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
