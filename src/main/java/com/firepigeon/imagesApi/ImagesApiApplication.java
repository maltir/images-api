package com.firepigeon.imagesApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.firepigeon.imagesApi.repositories")
public class ImagesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImagesApiApplication.class, args);
	}

}
