package com.thd.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TableInfo {
	
	public static void main(String args[]) throws Exception{
		String url = "jdbc:mysql://localhost:3306/myblog";
		String uname = "root";
		String upwd = "123456";
		Connection conn;
		
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(url, uname,upwd);
		
		DatabaseMetaData mbmd = conn.getMetaData();
		ResultSet rs = mbmd.getTables(null, null, null, new String[] { "TABLE" });

		System.out.println(rs);
		while(rs.next()){
			System.out.println("===============================");
			System.out.println("表名"+rs.getString("TABLE_NAME"));
			ResultSet pkd = mbmd.getPrimaryKeys(null,null, rs.getString("TABLE_NAME"));
			System.out.print("主键" );
			while(pkd.next()){
				System.out.print(pkd.getString("COLUMN_NAME"));
			}
			System.out.println();
			ResultSet columnInfos = mbmd.getColumns(null, null, rs.getString(3), null);
			while(columnInfos.next()){
				System.out.println("字段：" + columnInfos.getString("COLUMN_NAME") + "类型：" + columnInfos.getString("DATA_TYPE") + "长度：" + columnInfos.getString("COLUMN_SIZE"));
			}
		}
		System.out.println("finish");
		conn.close();
	}
	
	
	
}
