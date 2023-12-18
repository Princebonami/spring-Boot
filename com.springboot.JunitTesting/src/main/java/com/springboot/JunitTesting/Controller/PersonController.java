package com.springboot.JunitTesting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.JunitTesting.Entity.Person;
import com.springboot.JunitTesting.Service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/person/{name}")
	public List<Person> getByName(@PathVariable("name") String name)
	{
		return personService.getByName(name);
	}
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person)
	{
		return personService.addPerson(person);
	}

}
