 package com.thinkconstructive.restdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinkconstructive.restdemo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudService;

@RestController
public class CloudController {
	 
	@Autowired
	private CloudService cloudService;
	
	
	@GetMapping("/cloudvendors")
	public List<CloudVendor> getCloudVendorDetails()
	{
		
			List<CloudVendor>  list= cloudService.getCloudVendorDetails();
			return list;	 
		 
	}
	
	@GetMapping("/cloudvendors/{vendorId}")
	public CloudVendor getCloudVendorById(@PathVariable("vendorId") int vendorId)
	{
		CloudVendor cloudVendor= cloudService.getCloudVendorById(vendorId);
		return cloudVendor;
	}
	
	@GetMapping("/cloudVendors/{name}")
	public List<CloudVendor> getVendorByName(@PathVariable("name") String name)
	{
		return cloudService.getVendorByName(name);
	}
	
	@PostMapping("/cloudvendors")
	public String addCloudVendor(@RequestBody CloudVendor cloudVendor)
	{
		String cloudVendor2=cloudService.addCloudVendor(cloudVendor);
		return cloudVendor2;
		    
	}
	
	@PutMapping("/cloudvendors/{vendorId}")
	public String updateById(@RequestBody CloudVendor cloudVendor, @PathVariable("vendorId") int vendorId)
	{
		
		String cloudVendor2=cloudService.updateById(cloudVendor, vendorId);
		return cloudVendor2;
			
	   
	}
	
	@DeleteMapping("/cloudvendors/{vendorId}")
	public String deleteById(@PathVariable("vendorId") int vendorId)
	{
		String cloudVendor2= cloudService.deleteById(vendorId);
		return cloudVendor2; 
	}

}
