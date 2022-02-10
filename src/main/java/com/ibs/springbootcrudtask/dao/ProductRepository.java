package com.ibs.springbootcrudtask.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibs.springbootcrudtask.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
