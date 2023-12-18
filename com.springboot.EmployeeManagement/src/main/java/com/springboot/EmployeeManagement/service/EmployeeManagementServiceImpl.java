package com.springboot.EmployeeManagement.service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.springboot.EmployeeManagement.Entities.Employee;
import com.springboot.EmployeeManagement.Exception.NoSuchElementFoundException;
import com.springboot.EmployeeManagement.dao.EmployeeManagementRepo;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService1{
    
	@Autowired
	private EmployeeManagementRepo employeeManagementRepo;
	
	@Override
	public Employee getEmployeeById(Integer id)
	{
		if(employeeManagementRepo.findById(id).isEmpty())
		{
			throw new NoSuchElementFoundException();
		}
		 return employeeManagementRepo.findById(id).get();
	}
	
	@Override
	public  ResponseEntity<List<Employee>> getAll()
	{
	 List<Employee> list= employeeManagementRepo.findAll();
	 if(list.size()<=0)
	 {
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 }
	 return  ResponseEntity.of(Optional.of(list));
	}

	
	public Employee createUpdateEmployee(Employee employee)
	{
		if(employeeManagementRepo.findById(employee.getEmpId()).get()==null)
		{
			Employee employee2=  employeeManagementRepo.save(employee);
			return employee2;
		}
		else {
			Employee employee3=  employeeManagementRepo.save(employee);
			return employee3;
		}
		
	}
	

	
	@Override
	public void deleteById(Integer id)
	{
		 employeeManagementRepo.deleteById(id);
	}

//	@Override
//	public Employee updateEmployee(Integer id, Employee employee) {
//         
//		employee.setEmpId(id);
//		return employeeManagementRepo.save(employee);
//         
//	}

//	@Override
//	public Employee updateEMployee2(Integer id, Map<String, String> update) {
//		
//		Employee existingEmployee=employeeManagementRepo.findById(id).get();
//		
//		update.forEach((key ,value)->{
//		   Field field=  ReflectionUtils.findField(Employee.class, key);
//		   field.setAccessible(true);
//		   ReflectionUtils.setField(field, existingEmployee, value);
//		   
//			
//		});
//		return employeeManagementRepo.save(existingEmployee);
//	}


	
}
