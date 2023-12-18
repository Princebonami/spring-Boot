package com.springboot.JunitTesting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    
	private Calculator c=new Calculator();
	@Test
	void contextLoads() {
	}
	
	@Test
	
	void testSum()
	{
		// expected
		int expectedResult=23;
		
		// actual
	    int actualResult=c.doSum(12, 3, 8);
	    
	    assertThat(actualResult).isEqualTo(expectedResult);
	  
	  
	}
	
	@Test
	void testProduct()
	{
		// expected
		int expectedResult=6;
		
		// actual
		int actualResult=c.doProduct(3,2);
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	@Test
	void testCompare()
	{
		
		// actual Result
		
		Boolean actualResult= c.comapreTwoNums(10, 10);
		
		assertThat(actualResult).isTrue();
	}
	
	

}
