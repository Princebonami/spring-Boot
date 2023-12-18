package com.springboot.crud1.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.crud1.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	
	public List<Student> findBystudentName(String studentName);
}
