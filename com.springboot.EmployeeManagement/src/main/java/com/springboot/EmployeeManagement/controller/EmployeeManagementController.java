package com.springboot.EmployeeManagement.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.EmployeeManagement.Entities.Employee;
import com.springboot.EmployeeManagement.service.EmployeeManagementServiceImpl;

import jakarta.validation.Valid;

@RestController
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeManagementServiceImpl employeeManagementService;
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id)
	{
		return  employeeManagementService.getEmployeeById(id);
		
	}
	
	@GetMapping("/employee")
	public  ResponseEntity<List<Employee>> getAll()
	{
		 ResponseEntity<List<Employee>> rep=employeeManagementService.getAll();
		  List<Employee> list=rep.getBody();
	    
	     return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping("/employee")
	public Employee createUpdateEmployee(@Valid @RequestBody Employee employee)
	{
	   	employee.setCreateDateTime(LocalDateTime.now());
	    return	employeeManagementService.createUpdateEmployee(employee);
	}
	
//	@PutMapping("/employee/{id}")
//	public Employee updateEmployee(@Valid @PathVariable("id") int id, @RequestBody Employee employee)
//	{
//	      employee.setCreateDateTime(LocalDateTime.now());
//	     return   employeeManagementService.updateEmployee(id, employee);
//	}
//	
//	@PatchMapping("/updateemployee/{id}")
//	public Employee updateEMployee2(@PathVariable("id") Integer id, @RequestBody Map<String,String> update)
//	{
//		System.out.println("update successfull");
//		return employeeManagementService.updateEMployee2(id, update);
//	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteById(@PathVariable("id") Integer id)
	{
		employeeManagementService.deleteById(id);
	}
}
