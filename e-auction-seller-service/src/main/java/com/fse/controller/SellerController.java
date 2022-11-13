package com.fse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.entity.Product;
import com.fse.service.ProductService;

@RestController
@RequestMapping
public class SellerController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	/*@GetMapping("/show-bids/{productId}")
	public Product showBids(@PathVariable String productId) {
		return productRepository.getProductById(productId);
	}

	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable String productId) {
		return productRepository.deleteProductById(productId);

	}*/

}
