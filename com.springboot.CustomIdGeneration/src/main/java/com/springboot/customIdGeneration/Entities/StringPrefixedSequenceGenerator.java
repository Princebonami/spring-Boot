package com.springboot.customIdGeneration.Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.LongJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StringPrefixedSequenceGenerator extends SequenceStyleGenerator{
	
//	public static final String VALUE_PREFIX_PARAMETER="valuePrefix";
//	public static final String VALUE_PREFIX_DEFAULT="";
//	
	private String valuePrefix="Emp_";
	
//	public static final String NUMBER_FORMAT_PARAMETER= "numberFormat";
//	public static final String NUMBER_FORMAT_DEFAULT="%d";
	
//	private String numberFormat;

//	@Override
//	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
//		
//		super.configure((Type) LongJavaType.INSTANCE, parameters, serviceRegistry);
//		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,parameters,VALUE_PREFIX_DEFAULT);
//		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,parameters,NUMBER_FORMAT_DEFAULT);
//	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

//	public JdbcTemplate jdbcCall() {
//		return JdbcTemplate;
//	}
	
	
	@Override
	public String generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String lastId="";
		try {
			Class.forName("org.postgresql.Driver");
			
			String url="jdbc:postgresql://localhost:5432/studetails";
			String username="postgres";
			String password="postgres";
			Connection connection= DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			String squery= "select stu_id from student order by stu_id desc limit 1";
			ResultSet rs=statement.executeQuery(squery);
			while(rs.next())
			{
			   lastId=rs.getString("stu_id");
			}
//			System.out.println(lastId);
//			jdbcTemplate.query
			
//		    jdbcTemplate.query(squery, rs); 
//		    while(resultSet.next())
//		    {
//		       String stu_id= 	resultSet.getString("stu_id");
//		    }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(lastId);
		
		String[] arr= lastId.split("_");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		int last=Integer.parseInt(arr[1].trim()); // db
		
		return "Emp_" + (last+1);
	}
	

}
