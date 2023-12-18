package com.springboot.customFinder.Entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String department;
	
	public Student() {
		super();
	}

	public Student(int stu_id, String stu_name, String stu_department) {
		super();
		this.id = stu_id;
		this.name = stu_name;
		this.department = stu_department;
	}

	public int getId() {
		return id;
	}

	public void setId(int stu_id) {
		this.id = stu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String stu_name) {
		this.name = stu_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String stu_department) {
		this.department = stu_department;
	}

	@Override
	public String toString() {
		return "stu_id=" + id + ", stu_name=" + name + ", stu_department=" + department;
	}
	
	
	
	
	

}
