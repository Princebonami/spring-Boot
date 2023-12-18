package com.springboot.customFinder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.customFinder.Entity.Student;
import java.util.List;


@Repository
public interface StuRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findBydepartment(String department);
	
	// FIND ON THE BABIS OF NAME STARTING IWTH P
	
	public List<Student> findByNameStartingWith(String prefix);
	
	
	//FIND THE DETAILS OF THE STUDENT HVAING ID LESS THAN 
	
	public List<Student> findByIdLessThan(int id);

}
