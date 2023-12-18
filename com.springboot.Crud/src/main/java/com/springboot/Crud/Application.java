package com.springboot.Crud;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.Crud.Entities.Employee;
import com.springboot.Crud.dao.EmployeeRepository;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ApplicationContext context=  SpringApplication.run(Application.class, args);
		
		EmployeeRepository employeeRepository= context.getBean(EmployeeRepository.class);
		
		
		// for single users
//		System.out.println("Enter the name of the Employee :");
//		String name=sc.nextLine();
//		System.out.println("Enter the price of the Employee ");
//		double salary=sc.nextDouble();
//		
//		Employee employee=new Employee();
//		employee.setName(name);
//		employee.setSalary(salary);
//		
//		Employee employee1=   employeeRepository.save(employee);
//		System.out.println(employee1);
//		System.out.println("The data base get saved into memory");
		
        // for number of employess if want to save values of all employess in database.
//		List<Employee> li =new ArrayList<Employee>();
//		System.out.println("Enter the number of elployess data you want to save :");
//		int num=sc.nextInt();
//		sc.nextLine();
//		for(int i=0;i<num;i++)
//		{
//			Employee emp=new Employee();
//			System.out.println("Enter the name of the employees :");
//			String name=sc.nextLine();
//			System.out.println("Enter the salary of the employee :");
//			double salary=sc.nextDouble();
//			sc.nextLine();
//			emp.setName(name);
//			emp.setSalary(salary);
//		   
//			li.add(emp);
//			
//			
//		}
//		
//		li.forEach(emp1->System.out.println(emp1));
//		
//		employeeRepository.saveAll(li);
//		System.out.println("databases saved successfully");
		
//		System.out.println("================================================================================================================================");
		
		// for update user details 
		// update the details of the employee on the basis of particular id 
		
//		System.out.println("Enter the id of the Employee which you want to update details:");
//		int id=sc.nextInt();
//		Optional<Employee> op= employeeRepository.findById(id);
//		
//		Employee empl=op.get();
//		System.out.println("Enter the number which you want to update i.e 1- for name 2- for salary :");
//		int num=sc.nextInt();
//		sc.nextLine();
//		switch(num)
//		{
//		case 1 :
//		{
//			System.out.println("Enter the updated name :");
//			String name=sc.nextLine();
//			empl.setName(name);
//			break;
//		}
//		case 2:
//		{
//			System.out.println("Enter the updated salary of the employee :");
//			double salary=sc.nextDouble();
//			empl.setSalary(salary);
//		}
//		}
//		
//		employeeRepository.save(empl);
//		System.out.println("The data gets updated successfully ");
//		
		
		
		// get all the data from database i.e take out all the data from database
		
		
//	     Iterable<Employee> it= employeeRepository.findAll();
//	     System.out.println("All data stored in the table are :");
//	     it.forEach(emp2->System.out.println(emp2));
		
		
		// delete particular records from the table 
		
//		System.out.println("Enter the id which you want to delete form the dataBase :");
//		int id=sc.nextInt();
//		employeeRepository.deleteById(id);
//		
//		System.out.println("the id" +id+" is deleted from the table");
		
		// delete on the basis of particular entity
		
//		System.out.println("Enter the id whihc you want to delete :");
//		int id=sc.nextInt();
//		Optional<Employee> op=employeeRepository.findById(id);
//		Employee emp=op.get();
//		employeeRepository.delete(emp);
//		System.out.println("The particulat id " +id+" is deleted from the table ");
		
		// if you want to delete whole table 
		
		employeeRepository.deleteAll();
		System.out.println("Everything from table gets deleted : i.e table gets empty");
		
		
		
		
		
		
		
	}

}
