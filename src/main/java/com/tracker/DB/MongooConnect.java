package com.tracker.DB;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongooConnect {
	
	private static MongooConnect CONNECT = null;
	
	private MongooConnect(){
		
	}
	
	public static MongooConnect getInstance(){
		if(CONNECT == null) {
			CONNECT = new MongooConnect();
		}
		
		return CONNECT;
	}
	
	public static DB init(){
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://admin:admin123@ds255924.mlab.com:55924/expansetracker"));
		DB database = mongoClient.getDB("expansetracker");
		
		return database;
	}
	
	
	
	/*public static void main(String[] args) {
		MongooConnect.getInstance().init();
	}*/

}
