package com.aditya.dao;

import java.io.IOException;
import java.util.Map;

import com.aditya.util.Constant;
import com.aditya.util.RedisKey;

import redis.clients.jedis.Jedis;

public class RedisDao {
	
	public static void SetRedisConnection(Map<String, String> advertisingProducts) {
			
			Jedis jedis = null;
			
			try {
				 jedis = new Jedis(Constant.REDIS_CONNECTION);
				 System.out.println("jedis connection: " +Constant.REDIS_CONNECTION);
				 System.out.println("jedis connection is : " +jedis);
				 
//				 String Rediskey =RedisKey.CAMPAIGNS, RedisKey.CAMPAIGN_ID;
//				 System.out.println("key is: " + Rediskey);
				 
	//			 
				 for(Map.Entry<String, String> advertise : advertisingProducts.entrySet()){
					 System.out.println("advertsing details: " + advertisingProducts);
					 System.out.println("campaign id found: " + advertisingProducts.get("campaign_id"));
//					 System.out.println("key is: " + Rediskey);
					 jedis.set(RedisKey.CAMPAIGNS+RedisKey.CAMPAIGN_ID,advertisingProducts.get("campaign_id"));
			        	 System.out.println("value is: "+ RedisKey.CAMPAIGNS+RedisKey.CAMPAIGN_ID);
					}
//				 System.out.println("advertising products are: " + advertisingProducts);
//				 jedis.hmset(RedisKey.ADVERTISING_PRODUCT_DETAILS,advertisingProducts);
//				 System.out.println("setting connection: "+jedis);
//				 System.out.println("setting connection are: "+RedisKey.ADVERTISING_PRODUCT_DETAILS + advertisingProducts);
//				 
				 jedis.get("campaigns:campaign_id:");
				 System.out.println("getting details are: " + jedis);
				
			}catch(Exception e) {
				
			}
			
		}
	
//	public static void GetRedisConnectiondata() {
//	    Jedis jedis = null;
//	    try {
//	        jedis = new Jedis(Constant.REDIS_CONNECTION);
////	        Set<String> value = jedisCluster.smembers("Ownadx");
////	        Set<String> value1 = jedisCluster.smembers("Company");
//	        Map<String,String>  getDetails = jedis.hgetAll("Details:9");
//	        System.out.println("value: "+getDetails);
////	        System.out.println("value"+value1);
//	    } catch (Exception e) {
//		   e.printStackTrace();
//		}
//	    finally {
//	        if (jedis != null) {
//	            try {
//					jedis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//	        }
//	    }
//	}
}
