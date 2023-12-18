package com.springboot.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.EmployeeManagement.Entities.Employee;

@Repository
public interface  EmployeeManagementRepo extends JpaRepository<Employee,Integer> {
	
	public Employee findByempEmail(String empEmail);
    
	
//	@Query(value = "UPDATE employee_management.employee SET emp_salary = n first_name = m WHERE emp_id =: o")
//	public Employee updatedetails(@Param );
}
