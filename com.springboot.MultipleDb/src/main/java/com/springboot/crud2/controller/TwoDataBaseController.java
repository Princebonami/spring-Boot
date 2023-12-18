package com.springboot.crud2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud2.model.product.Product;
import com.springboot.crud2.model.user.User;
import com.springboot.crud2.service.TwoDataBaseService;
@RestController
public class TwoDataBaseController {
	
	@Autowired
	private TwoDataBaseService twoDataBaseService;
	
	
	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product product)
	{
	 	String data= twoDataBaseService.addProduct(product);
	 	return data;
	 	
	}
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user)
	{
	  String data=twoDataBaseService.addUser(user);
	  return data;
		
	}

}
