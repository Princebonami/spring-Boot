package com.springboot.EmployeeManagement.Entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert 
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
    
	@NotNull(message = "firstName must not be null")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Invalid format Please provide valid first name")
	private String firstName;
	//@NotNull(message = "LastName must not be null")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Invalid format Please provide valid last name")
	private String lastName;
    
	@NotNull(message = "Age must not be null")
	@Pattern(regexp = "\\d+", message = "Invalid Age please provide valid age")
	private String empAge;
    
	@NotNull(message = "Salary must not be null")
	@Pattern(regexp = "\\d+", message = "Invalid salary please provide valid salary")
	private String empSalary;
    
	@NotNull(message = "empEmail must not be null")
	@Email(regexp = "^[A-Za-z+_.-]+@gmail\\.com$", message = "Invalid email please follow format (firstname.lastname@gmail.com")
	private String empEmail;

	private LocalDateTime createDateTime;

	@OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL)
	// @JoinColumn(name="ed_fk", referencedColumnName = "id")
	private List<Department> department;

}
