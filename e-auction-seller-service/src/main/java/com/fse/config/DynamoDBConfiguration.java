package com.fse.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

@Configuration
public class DynamoDBConfiguration {

	@Value("${aws.dynamodb.endpoint}")
	private String dynamodbEndpoint;

	@Value("${aws.region}")
	private String awsRegion;

	@Value("${aws.dynamodb.accessKey}")
	private String dynamodbAccessKey;

	@Value("${aws.dynamodb.secretKey}")
	private String dynamodbSecretKey;

	@Bean
	@Primary
	public DynamoDBMapperConfig dynamoDBMapperConfig() {
		return DynamoDBMapperConfig.DEFAULT;
	}

	@Bean
	@Primary
	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
		return new DynamoDBMapper(amazonDynamoDB, config);
	}

	@Bean
	@Primary
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbEndpoint, awsRegion))
				.withCredentials(
						new AWSStaticCredentialsProvider(new BasicAWSCredentials(dynamodbAccessKey, dynamodbSecretKey)))
				.build();
	}
}
