package com.tracker.DB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

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
	
	public static MongoDatabase init(){
//		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://admin:admin123@ds255924.mlab.com:55924/expansetracker"));
		MongoClient mongoClient = MongoClients.create("mongodb://admin:admin123@ds255924.mlab.com:55924/expansetracker");
		MongoDatabase database = mongoClient.getDatabase("expansetracker");
		return database;
	}
	
	
	
	/*public static void main(String[] args) {
		MongooConnect.getInstance().init();
	}*/

}
