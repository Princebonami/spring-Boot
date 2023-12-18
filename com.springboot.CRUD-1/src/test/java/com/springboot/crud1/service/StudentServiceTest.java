package com.springboot.crud1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.crud1.Entity.Student;
import com.springboot.crud1.Repository.StudentRepository;
import com.springboot.crud1.Service.StudentService;

@WebMvcTest(value = StudentServiceTest.class)
public class StudentServiceTest {
	
	@MockBean
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentService studentService;
	
	Student student1=new Student(1,"Prince",123,"prince14146@gmail.com");
	Student student2=new Student(2,"Prince",124,"prince14146@rediffmail.com");
	
	@Test
	public void getAllStudentifNodataPresent()
	{
		when(studentRepository.findAll()).thenReturn(Collections.emptyList());
		
		List<Student> list1=studentService.getAllStudent();
		
		assertTrue(list1.isEmpty());
	}
	
	@Test
	public void getAllStudentTest()
	{
		List<Student> list=Arrays.asList(student1,student2);
		when(studentRepository.findAll()).thenReturn(list);
		
		List<Student> list1=studentService.getAllStudent();
		
		for(int i=0;i<list.size();i++)
		{
			assertEquals(list.get(i).getStudentId(),list1.get(i).getStudentId());
			assertEquals(list.get(i).getStudentName(),list1.get(i).getStudentName());
			assertEquals(list.get(i).getStudentRollNo(),list1.get(i).getStudentRollNo());
			assertEquals(list.get(i).getStudentEmail(),list1.get(i).getStudentEmail());
			
		}
	}

}
