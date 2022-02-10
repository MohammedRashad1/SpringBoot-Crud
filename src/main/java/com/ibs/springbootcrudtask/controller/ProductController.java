package com.ibs.springbootcrudtask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ibs.springbootcrudtask.model.Product;
import com.ibs.springbootcrudtask.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product){
		return productService.createProduct(product);
	
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProduct(@RequestBody List<Product> products){
		return productService.createProducts(products);
	
	}
	
	@PutMapping("/updateProduct/{id}")
	public void updateTopic(@RequestBody Product product ,@PathVariable long id){
		productService.updateProduct(id,product);
	} 
	
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable long id){
		return productService.getProduct(id);
	}
	
	@RequestMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
	}

}
