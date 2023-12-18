package com.thinkconstructive.restdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.thinkconstructive.restdemo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudRepository;

@Service
public class CloudService {
	
	@Autowired
	private CloudRepository cloudRepository;
	
	
	
	public List<CloudVendor> getCloudVendorDetails()
	{
	  List<CloudVendor> list=(List<CloudVendor>) cloudRepository.findAll();
	  return list;
	}
	
	public CloudVendor getCloudVendorById(int vendorId)   
	{
		if(cloudRepository.findById(vendorId).isEmpty())
		  throw new CloudVendorNotFoundException();
		
	   return cloudRepository.findById(vendorId).get();
	}
	public List<CloudVendor> getVendorByName(String name)
	{
		return cloudRepository.findByVendorName(name);
	}
	
	public String addCloudVendor(CloudVendor cloudVendor)
	{
		cloudRepository.save(cloudVendor);
		return "Created Successfully";
	}
	
	public String updateById(CloudVendor cloudVendor, int vendorId)
	{
		cloudVendor.setVendorId(vendorId);
		cloudRepository.save(cloudVendor);
		return "Updated Successfully";
	}
	public String deleteById(int vendorId)
	{
		cloudRepository.deleteById(vendorId);
		return "Deleted Successfully";
	}
}
