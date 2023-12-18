package com.springboot.JunitTesting.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.JunitTesting.Entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {
	
	public List<Person> findByPersonName(String personName);	
	

}
