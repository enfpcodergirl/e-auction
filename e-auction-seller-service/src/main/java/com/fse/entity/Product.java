package com.fse.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@DynamoDBTable(tableName = "Product")
public class Product {

	@Id
	@Getter(value=AccessLevel.NONE)
	@Setter(value=AccessLevel.NONE)
	private ProductIdentity productIdentity=new ProductIdentity() ;
	
	@DynamoDBHashKey(attributeName = "productId")
	@DynamoDBAutoGeneratedKey
	public String getProductId() {
		return productIdentity.getProductId();
	}

	@DynamoDBRangeKey(attributeName = "bidId")
	public String getBidId() {
		return productIdentity.getBidId();
	}

	public void setProductId(String productId) {
		this.productIdentity.productId = productId;
	}

	public void setBidId(String bidId) {
		this.productIdentity.bidId = bidId;
	}

	@DynamoDBAttribute
	private String productName;

	@DynamoDBAttribute
	private String shortDesc;

	@DynamoDBAttribute
	private String detailedDesc;

	@DynamoDBAttribute
	private String category;

	@DynamoDBAttribute
	private BigDecimal price;

	@DynamoDBAttribute
	private Date bidEndDate;

	public Product(ProductIdentity productIdentity, String productName, String shortDesc, String detailedDesc,
			String category, BigDecimal price, Date bidEndDate) {
		super();
		this.productIdentity = productIdentity;
		this.productName = productName;
		this.shortDesc = shortDesc;
		this.detailedDesc = detailedDesc;
		this.category = category;
		this.price = price;
		this.bidEndDate = bidEndDate;
	}
	
	

	// @DynamoDBAttribute
	// private User user;

}
