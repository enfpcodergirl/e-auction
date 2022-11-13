package com.fse.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIdentity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@DynamoDBHashKey
	String productId;

	@DynamoDBRangeKey
	String bidId;

}
