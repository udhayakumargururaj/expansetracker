package com.tracker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(scanBasePackages="com.tracker",
exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ExpanseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpanseTrackerApplication.class, args);
	}

}

