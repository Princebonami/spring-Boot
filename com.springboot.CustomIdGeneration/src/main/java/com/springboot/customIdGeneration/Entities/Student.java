package com.springboot.customIdGeneration.Entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
	
//	@Id
//	@Column(name = "stu_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_ sql")
//	@GenericGenerator(name = "demo_sql",strategy = "com.springboot.customIdGeneration.Entities.StringPrefixedSequenceGenerator",parameters = {
//			
//			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
//			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "Emp_"),
//			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")
//	})
	@Id @GeneratedValue(generator="custom-uuid")
	@GenericGenerator(name="custom-uuid", strategy = "com.springboot.customIdGeneration.Entities.StringPrefixedSequenceGenerator")
	private String stuId;
	
	@Column(name = "stu_first_name")
	private String stuFirstName;
	
	@Column(name="stu_last_name")
	private String stuLastName;
	
	private String stream;
	
	
	

}
