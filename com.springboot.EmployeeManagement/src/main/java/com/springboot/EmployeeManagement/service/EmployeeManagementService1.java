package com.springboot.EmployeeManagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.EmployeeManagement.Entities.Employee;

public interface EmployeeManagementService1 {

	
	public Employee getEmployeeById(Integer id);
	public ResponseEntity<List<Employee>> getAll();
	//public Employee createUpdatEmployee(Employee employee);
	public void deleteById(Integer id);
//	public Employee updateEmployee(Integer id,Employee employee);
//	public Employee updateEMployee2(@PathVariable("id") Integer id, @RequestBody Map<String,String> update);
	
	public Employee createUpdateEmployee(Employee employee);
}
