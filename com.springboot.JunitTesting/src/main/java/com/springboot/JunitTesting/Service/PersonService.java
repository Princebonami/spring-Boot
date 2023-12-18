package com.springboot.JunitTesting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.JunitTesting.Entity.Person;
import com.springboot.JunitTesting.Repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo personRepo;
	
	public List<Person> getByName(String personName)
	{
		return personRepo.findByPersonName(personName);
	}

	public Person addPerson(Person person) {
		return personRepo.save(person);
	}

}
