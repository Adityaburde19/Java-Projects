package com.aditya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DbConnection {
	
	public static synchronized Connection getMySqlConnection() {

		String SQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

		String MYSQL_URL = Configuration.getInstance().getMysqlUrl();
		String USER = Configuration.getInstance().getMysqlUser();
		String PASS = Configuration.getInstance().getMysqlPass();
		
//		System.out.println("URL :"+MYSQL_URL);
//		System.out.println("USER :"+USER);
//		System.out.println("PASS :"+PASS);
		Connection conn = null;
		try {
			Class.forName(SQL_JDBC_DRIVER);
			conn = DriverManager.getConnection(MYSQL_URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}
	
	
	public static void closeConnection(Connection con, Object obj, ResultSet rs){

		try{
			if (rs != null)
				rs.close();

			if (obj instanceof PreparedStatement) {
				PreparedStatement pstmt = (PreparedStatement) obj;
				if (pstmt != null)
					pstmt.close();
			} else if (obj instanceof Statement) {
				Statement stmt = (Statement) obj;
				if (stmt != null) {
					stmt.close();
				}
			}

			if (con != null)
				con.close();

		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
