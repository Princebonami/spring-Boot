package com.springboot.crud1.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int galiNo;
	private String street;
	private String city;
	private String state;

}
