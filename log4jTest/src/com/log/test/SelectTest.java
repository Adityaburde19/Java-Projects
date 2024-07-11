package com.log.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SelectTest {

	private static Logger logger = Logger.getLogger(SelectTest.class);
	static {
		try {
			// create layout obj
			SimpleLayout layout = new SimpleLayout();
			// create Appender object having layout obj
			ConsoleAppender appender = new ConsoleAppender(layout);
			// add appender obj to logger obj
			logger.addAppender(appender);
			// logger level to retrive log messages
//			logger.setLevel(Level.DEBUG); // default is debug
//			logger.setLevel(Level.OFF); // default is debug
			logger.setLevel(Level.ALL); // default is debug
			logger.info("com.log.test.SelectTest::log4j setup ready");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("com.log.test.SelectTest::Problem while setting the log4j");
		}
	}
	
	public static void main(String[] args) {
		logger.debug("com.log.test.SelectTest::start of main method");
		Connection con =null;
		Statement stm = null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.debug("com.log.test.SelectTest::JDBC driver driver class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tbl_iab_category_master?characterEncoding=UTF-8","root","vertoz@123");
			System.out.println("The connection is: "+con);
			logger.debug("com.log.test.SelectTest::connection is established");
			
			if(con!=null) {
				stm = con.createStatement();
				logger.debug("com.log.test.SelectTest::JDBC Statement obbject is created");	
			}
			
			if (stm != null){
				rs = stm.executeQuery("SELECT * FROM advertisement.advertisements");
				logger.debug("com.log.test.SelectTest::Sql query is send to DB s/w for execution and ResultSet obj is generated");
			}
			
			if(rs!=null) {
				while(rs.next()!= false) {
					System.out.println(rs.getString("ad_id")+" "+rs.getString("campaign_id"));
					logger.warn("com.log.test.SelectTest::The records are Resultset obj are retrived using getString(-) for all cols");
				}
				logger.debug("com.log.test.SelectTest::Resultset object is processed");
			}
		}catch(SQLException se) {
			se.printStackTrace();
			logger.error("com.log.test.SelectTest::Known DB Problem::"+se.getMessage()+"SQL error code"+ se.getErrorCode());
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("com.log.test.SelectTest::unKnown Problem::"+e.getMessage());
		}finally {
			logger.debug("com.log.test.SelectTest::closing JDBC objs");
			
			try {
				if(rs!=null) 
					rs.close();
					logger.debug("com.log.test.SelectTest::Resultset obj is closed");
				
			}catch(SQLException se) {
				se.printStackTrace();
				logger.error("com.log.test.SelectTest::Problem in closing ResultSet obj "+se.getMessage());
			}
			try {
				if(stm != null) 
					stm.close();
					logger.debug("com.log.test.SelectTest::Statement obj is closed");
				
			}catch(SQLException se) {
				se.printStackTrace();
				logger.error("com.log.test.SelectTest::Problem in closing Statement obj"+se.getMessage());
			}
			try {
				if(con!=null)
					con.close();
				logger.debug("com.log.test.SelectTest::Connection obj is closed");
			}catch(SQLException se) {
				se.printStackTrace();
				logger.error("com.log.test.SelectTest::Problem in Connection obj"+se.getMessage());
			}
		}
		logger.debug("com.log.test.SelectTest::End of main(-) method");
	}
	
}
