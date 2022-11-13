package com.fse;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.fse.config.DynamoDBConfiguration;
import com.fse.repository.ProductRepository;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackageClasses = ProductRepository.class)
@Import(DynamoDBConfiguration.class)
public class EAuctionSellerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAuctionSellerServiceApplication.class, args);

	}

}
