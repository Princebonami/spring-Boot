package com.thinkconstructive.restdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkconstructive.restdemo.model.CloudVendor;


@Repository
public interface CloudRepository extends JpaRepository<CloudVendor, Integer>{
	
      public List<CloudVendor> findByVendorName(String vendorName); 
}
