package com.springboot.customFinder;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.customFinder.Entity.Student;
import com.springboot.customFinder.Repository.StuRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ApplicationContext context=SpringApplication.run(Application.class, args);
		
		StuRepository repo=context.getBean(StuRepository.class);
		
//		Student student=new Student();
//	    System.out.println("Enter the name of the student :");
//	    String name=sc.nextLine();
//	    student.setName(name);
//	    System.out.println("Enter the department name of the student :");
//	    String dept_name=sc.nextLine();
//	    student.setDepartment(dept_name);
//	    
//	    repo.save(student);
//	    System.out.println("The data gets stored in the database");
		
		
		// if we want to get all the data from the database
		
//	   Iterable<Student> itr=repo.findAll();
//	   itr.forEach(stu->System.out.println(stu));
	   
	   // we can also get the data from the database on the basis of id
	   
//	   System.out.println("Enter the id of the student :");
//	   int id=sc.nextInt();
//	   Optional<Student> stuOptional = repo.findById(id);
//	   Student student=stuOptional.get();
//	   System.out.println(student);
//	    
		
		// take out the students having GeoInfomatics as their department.
		// here we have to create customFInderMethod
		
//		System.out.println("Enter the department name of the students :");
//		String dept_name1=sc.nextLine();
//		
//		List<Student> lis=repo.findBydepartment(dept_name1);
//		lis.forEach(li->System.out.println(li));
		
//		System.out.println("Enter the id from which you want less all details :");
//		int id=sc.nextInt();
//		List<Student> li=repo.findByIdLessThan(id);
//		li.forEach(stu->System.out.println(stu));
	}

}
