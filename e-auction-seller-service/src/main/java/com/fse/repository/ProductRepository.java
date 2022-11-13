package com.fse.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fse.entity.Product;
import com.fse.entity.ProductIdentity;

@EnableScan
@Repository
public interface ProductRepository extends CrudRepository<Product, ProductIdentity> {
	
	
}
