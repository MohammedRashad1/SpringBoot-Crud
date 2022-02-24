package com.ibs.springbootcrudtask;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibs.springbootcrudtask.controller.ProductController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringBootCrudTaskApplicationTests {
	
	@Autowired
	private ProductController productController;

	@Test
	void contextLoads() {
		
		Assertions.assertThat(productController).isNotNull();
		
	}
	
	

}
