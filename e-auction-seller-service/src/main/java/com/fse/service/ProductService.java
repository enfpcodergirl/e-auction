package com.fse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.entity.Product;
import com.fse.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product saveProduct(Product product) {
		productRepo.save(product);
		return product;
	}


}
