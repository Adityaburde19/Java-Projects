package com.aditya.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.aditya.util.DbConnection;

public class AdvertisementSqlDao {
	
	public static Map<String,String> getAdvertiseProduct(){
		
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String,String> advertisingProduct = new HashMap<String,String>();
		try {
			
			String sql="SELECT * From advertisement.advertisements where campaign_id=1";
			con = DbConnection.getMySqlConnection();
			System.out.println("SQL "+sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
//				Map<String,String> domainName = new HashMap<String,String>();
				advertisingProduct.put("campaign_id", rs.getString("campaign_id"));
				advertisingProduct.put("ad_content",rs.getString("ad_content"));
				
//				System.out.println("get daomain name id: " +rs.getStr);
				System.out.println("campaign_id: " + advertisingProduct);
				System.out.println("ad_content: " + advertisingProduct);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbConnection.closeConnection(con, stmt, rs);
		}
		return advertisingProduct;
	}

		
}
	


