package com.springboot.customIdGeneration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.customIdGeneration.Entities.Student;
import com.springboot.customIdGeneration.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentById(String id)
	{
	   Student student=studentRepository.findById(id).get();
	   return student;
	}
	
	public List<Student> getStudent()
	{
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student updateStudent(String id,Student student)
	{
		student.setStuId(id);
		return studentRepository.save(student);
	}
	public String deleteStudent(String id)
	{
		 studentRepository.deleteById(id);
		 return "Deleted Sucessfully";
	}


}
