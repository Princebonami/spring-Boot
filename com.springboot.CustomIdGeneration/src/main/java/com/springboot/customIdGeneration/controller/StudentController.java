package com.springboot.customIdGeneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.customIdGeneration.Entities.Student;
import com.springboot.customIdGeneration.service.StudentService;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") String id)
	{
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student")
	public List<Student> getStudent()
	{
		return studentService.getStudent();
	}
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student)
	{
		return studentService.createStudent(student);
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") String id,@RequestBody Student Student)
	{
		return studentService.updateStudent(id,Student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") String id)
	{
		return studentService.deleteStudent(id);
	}

}
