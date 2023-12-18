package com.springboot.crud2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.crud2.model.product.Product;
import com.springboot.crud2.model.user.User;
import com.springboot.crud2.product.repository.ProductRepo;
import com.springboot.crud2.user.repository.UserRepo;

@Component
public class TwoDataBaseService {

	@Autowired
	private  ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public String addProduct(Product product)
	{
	  productRepo.save(product);
	  return "Product Data saved Successfully";
	}
	public String addUser(User user)
	{
		 userRepo.save(user);
		 return "User Data Saved Successfully";
	}
	
}
