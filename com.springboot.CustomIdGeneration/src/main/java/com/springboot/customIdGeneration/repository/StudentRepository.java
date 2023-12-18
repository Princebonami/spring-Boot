package com.springboot.customIdGeneration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.customIdGeneration.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{
	
	

}
