package com.ibs.springbootcrudtask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.springbootcrudtask.dao.ProductRepository;
import com.ibs.springbootcrudtask.exception.ResourceNotFoundException;
import com.ibs.springbootcrudtask.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//For saving or creating or adding single product
	public Product createProduct(Product product){
		return productRepository.save(product);
	}
	
	//For saving or creating or adding multiple products
	public List<Product> createProducts(List<Product> products){
		return productRepository.saveAll(products);
	}
	
	//For updating product in database
	
	public void updateProduct(long id, Product product){
//		productRepository.save(product);
		
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found to update with id :" + id));
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		
		productRepository.save(existingProduct);
	}
	
	
	//For getting all products from database
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		productRepository.findAll()
		.forEach(products::add);
		return products;
	}
	
	//For getting product based on id from database
	public Product getProduct(long id){
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
	}
	
	//For deleting product from database
	public void deleteProduct(Long id){
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		productRepository.delete(existingProduct);
		
	}
	

}
