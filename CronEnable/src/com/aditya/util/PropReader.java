package com.aditya.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class PropReader {
	private static final String DEVELOPMENT_CONFIGURATION = "/var/tomcat7/config_test_learning.properties";

	private static void setConfig(){

		Properties prop = new Properties();
		InputStream inputStream  = null;
		try{
			inputStream = new FileInputStream(DEVELOPMENT_CONFIGURATION);
			prop.load(inputStream);
			
			Configuration.getInstance().setMysqlUrl(prop.getProperty("DB_URL").trim());
			Configuration.getInstance().setMysqlPass(prop.getProperty("PASS").trim());
			Configuration.getInstance().setMysqlUser(prop.getProperty("USER").trim());
			
			Configuration.getInstance().setRedisServer(prop.getProperty("redis.server").trim());
			Configuration.getInstance().setRedisPort(prop.getProperty("redis.port").trim());

			 
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void InitConfig() {
		setConfig();
		getRedisConn();
	}
	
	private static void getRedisConn() {
		 String RedisServer =  Configuration.redisServer;
		 String RedisPort = Configuration.redisPort;
		 Constant.REDIS_CONNECTION = RedisServer+RedisPort;
		 
		 System.out.println("redisServer: " + RedisServer + " redisPort: " + RedisPort);
		
	}

}
