package com.springboot.JunitTesting;

public class Calculator {
	
	public int doSum(int a,int b, int c)
	{
		return a+b+c;
	}
	public int doProduct(int a,int b)
	{
		return a*b;
	}
    public Boolean comapreTwoNums(int a,int b) {
    	return a==b;
    }
}
