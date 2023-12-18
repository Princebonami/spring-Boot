package com.springboot.crud1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud1.Entity.Student;
import com.springboot.crud1.Service.StudentService;

import jakarta.persistence.Entity;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.val;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{  
		List<Student> list=list= studentService.getAllStudent();
		return list;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable("studentId") int studentId )
	{
	  Student student=studentService.getStudentById(studentId);
	  return student;
	}
	
	@GetMapping("/student/{studentName}")
	public List<Student> getByName(@PathVariable("studentName") String studentName)  
	{
	   List<Student> list=studentService.getByName(studentName);
	   return list;
	}

	@PostMapping("/students")
	public String addStudent(@Valid @RequestBody Student student)
	{
		String content=studentService.addStudent(student);
		return content;
		
	}
	@PutMapping("/students/{studentId}")
	public String updateStudent(@Valid @RequestBody Student student,@PathVariable("studentId") Integer studentId)
	{
	  String context=studentService.updateStudent(student, studentId);
	  return context;
		
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteById(@PathVariable("studentId") int studentId)
	{
	   String content=studentService.deleteById(studentId);
	   return content;
	}

}
