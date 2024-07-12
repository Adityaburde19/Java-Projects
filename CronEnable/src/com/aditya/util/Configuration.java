package com.aditya.util;

public class Configuration {
	
	private static Configuration instance = new Configuration();
	
	public static String redisServer;
	public static String redisPort;
	
	static public  String mysqlUrl;
	static public  String mysqlUser; 
	static public  String mysqlPass;
	
	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	

	public String getRedisServer() {
		return redisServer;
	}

	public void setRedisServer(String redisServer) {
		this.redisServer = redisServer;
	}
	
	public String getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(String redisPort) {
		this.redisPort = redisPort;
	}
	
	public String getMysqlUrl() {
		return mysqlUrl;
	}

	public void setMysqlUrl(String mysqlUrl) {
		this.mysqlUrl = mysqlUrl;
	}

	public String getMysqlUser() {
		return mysqlUser;
	}

	public void setMysqlUser(String mysqlUser) {
		this.mysqlUser = mysqlUser;
	}

	public String getMysqlPass() {
		return mysqlPass;
	}

	public void setMysqlPass(String mysqlPass) {
		this.mysqlPass = mysqlPass;
	}

}
