package com.aditya.service;

import java.util.HashMap;
import java.util.Map;

import com.aditya.dao.AdvertisementSqlDao;
import com.aditya.dao.RedisDao;
import com.aditya.util.Configuration;

public class Service {
	
	public static void executeService(String[] args){
		
		Map<String,String> advertisingProducts = new HashMap<>();
		AdvertisementSqlDao advertisementSqlDao= new AdvertisementSqlDao();
		RedisDao redisdao = new RedisDao();
		
		advertisingProducts = advertisementSqlDao.getAdvertiseProduct();
		System.out.println("details are: "+ advertisingProducts);
		
		RedisDao.SetRedisConnection(advertisingProducts);
		
	}
	
	

}
