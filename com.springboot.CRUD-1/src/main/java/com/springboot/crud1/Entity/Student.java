package com.springboot.crud1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.springboot.crud1.Entity.Address;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "STUDENT_ID")
	private int studentId;
	
	@Pattern(regexp = "^[a-z A-Z]*$",message = "Only Alphabets allowed [a-z A-Z] in your name ")
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	
	@Column(name="student_rollno")
	private int studentRollNo;
	
	
	@Email(message = "Invalid Email Address")
	@Column(name="student_email")
	private String studentEmail;
	
//	@Embedded
//	private Address address;
	
	
	
}
