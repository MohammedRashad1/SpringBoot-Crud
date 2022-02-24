package com.ibs.springbootcrudtask.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibs.springbootcrudtask.dao.ProductRepository;
import com.ibs.springbootcrudtask.model.Product;

@DataJpaTest
public class ProductRepositoryTest {
	
	 @Autowired
	 private ProductRepository repository;
	 
	 @Test
	 public void testCreateProduct(){
		 
		 List<Product> list = new ArrayList<>();
		 Product product1 = new Product();
		 
		 product1.setId(1);
		 product1.setName("Mobile");
		 product1.setDescription("Android phones");
		 product1.setPrice(20000);
		 repository.save(product1);
		 
		 list.add(product1);
		 
		 assertEquals(1, list.size());
	 }
	 
	 @Test
	 public void getProductById() {
		 
		 Product product2 = new Product();
		 product2.setId(1001);
		 repository.save(product2);
		 
		 assertEquals(1001, product2.getId() );
		 
	 }

}
