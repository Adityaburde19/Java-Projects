package com.aditya.main; 

import java.util.*;

import com.aditya.service.Service;
import com.aditya.util.PropReader;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("========= The Cron Started on ==========" + new Date() + "==========" + System.currentTimeMillis());
		long time = System.currentTimeMillis();
		
//		String url = "jdbc:mysql://localhost:3306/advertisement?characterEncoding=UTF-8";
//		String usr = "root";
//		String password = "vertoz@123";
				
		
		PropReader.InitConfig();
		Service.executeService(args);
		
		
		
		System.out.println("========= Task completed at ========= " + new Date()+ " ========= " + System.currentTimeMillis() + " : " + (System.currentTimeMillis()-time));
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection connection = DriverManager.getConnection(url, usr, password);
//			
//			Statement statement1 = connection.createStatement();
//			Statement statement2 = connection.createStatement();
//			Statement statement3 = connection.createStatement();
//			
////			Jedis jedis = new Jedis("localhost", 6379);
//			
//			 Set<HostAndPort> jedisClusterNodes = new HashSet<>();
//	            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));
//	            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6378));
//	            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));
//	            JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
//	            
//	            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//	            JedisCluster jediCluster = new JedisCluster(jedisClusterNodes, jedisPoolConfig);
//			
//			ResultSet resultset1 = statement1.executeQuery("SELECT * FROM clients");
//			ResultSet resultset2 = statement2.executeQuery("SELECT * FROM campaigns");
//			ResultSet resultset3 = statement3.executeQuery("SELECT * FROM advertisements");
//			
//			
//			
//			Map <String, String> clients = new HashMap<> ();
//			clients.put(" client_id ", " 1 ");
//			clients.put(" client_name "," Client A ");
//			clients.put(" contact_person ", " Aditya Burde ");
//			clients.put(" conatct_email ", " aditya.burde@gamil.com ");
//			clients.put(" conatct_phone ", " 987-654-3210 ");
//			
//			System.out.println("client details are: " + clients);
//			
//			jedisCluster.hmset("clients", clients);
//			
////				while (resultset1.next()) {
////					int client_id = resultset1.getInt("client_id");
////					String client_name = resultset1.getString("client_name");
////					String contact_person = resultset1.getString("contact_person");
////					String contact_email = resultset1.getString("contact_email");
////					String contact_phone = resultset1.getString("contact_phone");
////					
////					System.out.println("ID: " + client_id + ", Name: " + client_name + ", contact person: " + contact_person + ", contact email: " + contact_email + ", contact phone: " + contact_phone);
////				}
//				
//				System.out.println("************************************************************************************************************************************************************************");
//				
//				
//				Map <String, String> campaigns = new HashMap<> ();
//				campaigns.put(" campaign_id ", " 1 ");
//				campaigns.put(" client_id "," 1 ");
//				campaigns.put(" campaign_name ", " Spring Sale ");
//				campaigns.put(" start_date ", " 2024-05-19 ");
//				campaigns.put(" end_date ", " 2024-08-18 ");
//				campaigns.put(" budget", " 10000.00 ");
//				
//				System.out.println("client details are: " + campaigns);
//				
//				jedisCluster.hmset("campaigns", campaigns);
//				
////				while (resultset2.next()) {
////					int campaign_id = resultset2.getInt("campaign_id");
////					int client_id = resultset2.getInt("client_id");
////					String campaign_name = resultset2.getString("campaign_name");
////					Date start_date = resultset2.getDate("start_date");
////					Date end_date = resultset2.getDate("end_date");
////					String budget = resultset2.getString("budget");
////					
////					System.out.println("campaign id: " + campaign_id + ", client id: " + client_id + ", campaign name: " + campaign_name + ", start_date: " + start_date + ", end date: " + end_date + ", budget: " + budget );
////				}
//				
//				System.out.println("************************************************************************************************************************************************************************");
//				
//				
//				Map <String, String> advertisements = new HashMap<> ();
//				advertisements.put(" ad_id ", " 1 ");
//				advertisements.put(" campaign_id "," 1 ");
//				advertisements.put(" ad_title ", " Special Discounts ");
//				advertisements.put(" ad_content ", " Huge discounts on selected items! ");
//				advertisements.put(" ad_type ", " Banner ");
//				advertisements.put(" ad_cost ", " 1500.00 ");
//				advertisements.put(" ad_status ", " Active ");
//				
//				System.out.println("client details are: " + advertisements);
//				
//				jedisCluster.hmset("advertisements", advertisements);
//				
////				while (resultset3.next()) {
////					int ad_id = resultset3.getInt("ad_id");
////					int campaign_id = resultset3.getInt("campaign_id");
////					String ad_title = resultset3.getString("ad_title");
////					String ad_content = resultset3.getString("ad_content");
////					String ad_type = resultset3.getString("ad_type");
////					String ad_cost = resultset3.getString("ad_cost");
////					String ad_status= resultset3.getString("ad_status");
////					
////					System.out.println("ad id: " + ad_id + ", campaign id: " + campaign_id + ", ad title: " + ad_title + ", ad content : " + ad_content  + ", ad type: " + ad_type + ", ad cost: " + ad_cost + ", ad_status: " + ad_status );
////				}
//				
////				resultset1.close();
////				resultset2.close();
////				resultset3.close();
////				statement1.close();
////				statement2.close();
////				statement3.close();
////				connection.close();
//				
//				 System.out.println("Connected to Redis Server!");
//
////			        // Perform Redis operations using 'jedis' object
////			        jedis.set("example_key", "example_value");
////			        System.out.println("Value for key 'example_key': " + jedis.get("example_key"));
//
//			        // Close the connection
//				 jedisCluster.close();
//				
//			}catch(ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//		}
//		
//		
//		
//
//		
//		 //Jedis jedis = new Jedis("localhost", 6379);
//		 
//			
//	}
		}

}


