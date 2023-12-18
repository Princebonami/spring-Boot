package com.springboot.crud2.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud2.model.product.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
