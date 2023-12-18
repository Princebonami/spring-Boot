package com.springboot.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.EmployeeManagement.Entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
